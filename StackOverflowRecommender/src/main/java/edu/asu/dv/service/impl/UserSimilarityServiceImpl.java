package edu.asu.dv.service.impl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.Course;
import edu.asu.dv.model.CourseInput;
import edu.asu.dv.model.NetworkEdge;
import edu.asu.dv.model.NetworkGraph;
import edu.asu.dv.model.NetworkNode;
import edu.asu.dv.model.Recommendation;
import edu.asu.dv.model.RecommendationCourse;
import edu.asu.dv.model.User;
import edu.asu.dv.model.response.Category;
import edu.asu.dv.model.response.SimilarUser;
import edu.asu.dv.model.response.Tag;
import edu.asu.dv.service.UserSimilarityService;
import edu.asu.dv.util.CategoryTagMapper;
import edu.asu.dv.util.DataLoader;

@Service
public class UserSimilarityServiceImpl implements UserSimilarityService {

	@Autowired
	private DataLoader loader;

	@javax.annotation.Resource(name = "userNameProperties")
	private Map<String, String> properties;

	@javax.annotation.Resource(name = "recommededProperties")
	private Map<String, String> recommmedProperties;

	@Resource(name = "categoryTagProperties")
	private Map<String, String> catProperties;

	@Autowired
	private CategoryTagMapper catMapper;

	private HashMap<String, List<String>> similarUserMap = null;

	private HashMap<String, LinkedHashSet<Recommendation>> courseTagMap = null;

	private HashMap<String, Set<Tag>> tagsUserMap = null;

	private HashMap<String, LinkedHashSet<Recommendation>> userCourseMap = new HashMap<>();

	private HashMap<String, Recommendation> IDCourseMap = new HashMap<>();

	private HashMap<String, LinkedHashSet<Recommendation>> userRecommendedCourseMap = new HashMap<>();

	private HashMap<String, String> nodeMap = new HashMap<>();

	@PostConstruct
	public void init() throws DataLoadException, IOException {
		similarUserMap = findSimilarUsers(loader.loadUserData());
		courseTagMap = loader.loadCourseData();
		userCourseMap = userCourseRecommendation();
		IDCourseMap = populateIDCourseMap();
		userRecommendedCourseMap = userRecommendedCoursePopulate();
		nodeMap = loader.loadNodesWeight();
		TreeMap<String, Integer> x = new TreeMap<String, Integer>();
		for (Map.Entry<String, Set<Tag>> entry : tagsUserMap.entrySet()) {
			Set<Tag> list = entry.getValue();
			for (Tag tag : list) {
				x.put(tag.getName(), 1);
			}
		}
	}

	public HashMap<String, LinkedHashSet<Recommendation>> getCourseTagMap() {
		return courseTagMap;
	}

	public HashMap<String, LinkedHashSet<Recommendation>> getuserRecommendedCourseMap() {
		return userRecommendedCourseMap;
	}

	@Override
	public List<Category> getCategories(String userid) {
		Map<String, Set<String>> tagCatMap = catMapper.getTagCategories();
		Set<Tag> userTags = tagsUserMap.get(userid);

		Map<String, Integer> catTagCount = new HashMap<>();
		Map<String, Set<String>> catTagMap = new HashMap<>();

		userTags.forEach(userTag -> {
			Set<String> catSet = tagCatMap.get(userTag.getName());
			if (catSet == null) {
				catSet = new HashSet<>();
				catSet.add("Others");
			}
			catSet.forEach(cat -> {
				if (catTagCount.containsKey(cat)) {
					catTagMap.get(cat).add(userTag.getName());
					int count = catTagCount.get(cat);
					catTagCount.put(cat, count + 1);
				} else {
					Set<String> tagSet = new HashSet<>();
					tagSet.add(userTag.getName());
					catTagMap.put(cat, tagSet);
					catTagCount.put(cat, 1);
				}
			});
		});

		List<Category> userCategories = new ArrayList<>();
		catTagCount.forEach((cat, count) -> {
			Category curCat = new Category();
			curCat.setName(cat);

			DecimalFormat df = new DecimalFormat("#.##");
			curCat.setPercentage(Double.valueOf(df.format(((double) count / userTags.size()) * 100)));

			curCat.setTags(catTagMap.get(cat));
			userCategories.add(curCat);
		});

		return userCategories.parallelStream().sorted((cat1, cat2) -> {
			return cat1.getPercentage() == cat2.getPercentage() ? 0
					: cat1.getPercentage() < cat2.getPercentage() ? 1 : -1;
		}).collect(Collectors.toList());

	}

	@Override
	public List<SimilarUser> getSimilarUsers(String userid) throws DataLoadException {

		List<SimilarUser> similarUsers = new ArrayList<>();
		List<String> users = similarUserMap.get(userid);
		Set<Tag> curUserTagDetail = tagsUserMap.get(userid);
		users.forEach(user -> {
			Set<Tag> curUserTagDetail2 = tagsUserMap.get(user);
			int counter = 0;
			SimilarUser userWeight = new SimilarUser();
			for (Tag firstUserDetail : curUserTagDetail) {
				for (Tag secondUserDetail : curUserTagDetail2) {
					if (firstUserDetail.getName().equals(secondUserDetail.getName())) {
						counter += Math.min(firstUserDetail.getvalue(), secondUserDetail.getvalue());
					}
				}
			}
			userWeight.setUid(user);
			userWeight.setName(properties.get(user));
			userWeight.setvalue(counter);
			similarUsers.add(userWeight);
		});

		return similarUsers.parallelStream().sorted((simuser1, simuser2) -> {
			return simuser1.getvalue() == simuser2.getvalue() ? 0 : simuser1.getvalue() < simuser2.getvalue() ? 1 : -1;

		}).collect(Collectors.toList());

	}

	@Override
	public List<Tag> getUserTags(String userName) {
		return tagsUserMap.get(userName).parallelStream().sorted((tag1, tag2) -> {
			return tag1.getvalue() == tag2.getvalue() ? 0 : tag1.getvalue() < tag2.getvalue() ? 1 : -1;
		}).collect(Collectors.toList());
	}

	private HashMap<String, List<String>> findSimilarUsers(HashMap<String, ArrayList<User>> userMap) {

		HashMap<String, List<String>> similarUserMap = new HashMap<String, List<String>>();
		tagsUserMap = new HashMap<String, Set<Tag>>();
		HashMap<String, List<String>> tagUserString = new HashMap<>();
		Set<String> tagSet = new HashSet<String>();
		userMap.forEach((username, userObj) -> {
			Set<Tag> tags = new HashSet<>();
			List<String> tagString = new ArrayList<>();
			userObj.forEach(z -> {
				tagString.add(z.getTag_name());
				if (z.getQuestion_count() > 10) {
					Tag temp = new Tag();
					temp.setName(z.getTag_name());
					temp.setvalue(z.getQuestion_count());
					tags.add(temp);
					tagSet.add(z.getTag_name());
				}
			});
			tagUserString.put(username, tagString);
			tagsUserMap.put(username, tags);
		});
		// System.out.println(tagSet.size());

		tagUserString.forEach((x, y) -> {
			tagUserString.forEach((a, b) -> {
				if (!x.equals(a)) {
					List<String> list = new ArrayList<>(y);
					list.retainAll(b);
					if (list.size() > 5) {
						if (similarUserMap.containsKey(x)) {
							similarUserMap.get(x).add(a);
						} else {
							List<String> similarUser = new ArrayList<>();
							similarUser.add(a);
							similarUserMap.put(x, similarUser);
						}
					}
				}
			});
		});
		return similarUserMap;

	}

	public List<Course> getCoursesList(String userid) {
		ArrayList<Course> result = new ArrayList<Course>();

		return result;
	}

	// *******************Code related to
	// categories**********************************************

	public List<Tag> getTagesBasedONCategories(List<String> categories, String userid) {
		List<Tag> tagList = new ArrayList<Tag>();
		Set<String> tagSet = new HashSet<>();
		Set<Tag> userTags = tagsUserMap.get(userid);
		for (String category : categories) {
			String tagS = catProperties.get(category);
			String tagsArray[] = tagS.split(",");
			for (int i = 0; i < tagsArray.length; i++) {
				tagSet.add(tagsArray[i]);
			}
			for (String str : tagSet) {
				for (Tag tag : userTags) {
					if (tag.getName().equalsIgnoreCase(str)) {
						tagList.add(tag);
					}
				}
			}
		}
		return tagList.parallelStream().sorted((cat1, cat2) -> {
			return cat1.getvalue() == cat2.getvalue() ? 0 : cat1.getvalue() < cat2.getvalue() ? 1 : -1;
		}).collect(Collectors.toList());
	}

	@Override
	public List<Category> getCategoriesBasedOnCategory(String userid, List<String> categories) {
		List<Category> result = new ArrayList<>();
		List<Category> list = getCategories(userid);
		for (String s : categories) {
			for (Category cat : list) {
				if (cat.getName().equalsIgnoreCase(s)) {
					result.add(cat);
				}
			}
		}
		return result.parallelStream().sorted((cat1, cat2) -> {
			return cat1.getPercentage() == cat2.getPercentage() ? 0
					: cat1.getPercentage() < cat2.getPercentage() ? 1 : -1;
		}).collect(Collectors.toList());
	}

	public List<SimilarUser> getSimilarUsersBasedOnCategories(String userid, List<String> categories) {
		List<Tag> mainUserTags = getTagesBasedONCategories(categories, userid);

		List<SimilarUser> result = new ArrayList<SimilarUser>();

		List<String> users = similarUserMap.get(userid);

		for (String user : users) {

			List<Tag> userTags = getTagesBasedONCategories(categories, user);
			int sum = 0;
			SimilarUser userWeight = new SimilarUser();
			for (Tag t1 : mainUserTags) {

				for (Tag t2 : userTags) {

					if (t1.getName().equalsIgnoreCase(t2.getName()) && !userid.equals(user)) {
						sum = sum + Math.min(t1.getvalue(), t2.getvalue());
					}

				}
			}
			userWeight.setUid(user);
			userWeight.setName(properties.get(user));
			userWeight.setvalue(sum);
			result.add(userWeight);

		}
		return result.parallelStream().sorted((simuser1, simuser2) -> {
			return simuser1.getvalue() == simuser2.getvalue() ? 0 : simuser1.getvalue() < simuser2.getvalue() ? 1 : -1;

		}).collect(Collectors.toList());
	}

	// public List<Category> getCategoriesBasedOnCategory(String userid,
	// List<String> categories) {
	// Map<String, Set<String>> tagCatMap = new HashMap<>();
	//
	// catProperties.forEach((cat, tags) -> {
	//
	// if (categories.contains(cat)) {
	// List<String> tagArrList = Arrays.asList(tags.split(","));
	// tagArrList.forEach(tag -> {
	// tag = tag.trim();
	// if (tagCatMap.containsKey(tag)) {
	// tagCatMap.get(tag).add(cat);
	// } else {
	// Set<String> catSet = new HashSet<>();
	// catSet.add(cat);
	// tagCatMap.put(tag, catSet);
	// }
	// });
	// }
	// });
	//
	// List<Tag> userTags = tagsUserMap.get(userid);
	//
	// Map<String, Integer> catTagCount = new HashMap<>();
	// Map<String, Set<String>> catTagMap = new HashMap<>();
	//
	// userTags.forEach(userTag -> {
	// Set<String> catSet = tagCatMap.get(userTag.getName());
	// if (catSet == null) {
	// catSet = new HashSet<>();
	// catSet.add("Others");
	// }
	// catSet.forEach(cat -> {
	// if (catTagCount.containsKey(cat)) {
	// catTagMap.get(cat).add(userTag.getName());
	// int count = catTagCount.get(cat);
	// catTagCount.put(cat, count + 1);
	// } else {
	// Set<String> tagSet = new HashSet<>();
	// tagSet.add(userTag.getName());
	// catTagMap.put(cat, tagSet);
	// catTagCount.put(cat, 1);
	// }
	// });
	// });
	//
	// List<Category> userCategories = new ArrayList<>();
	// catTagCount.forEach((cat, count) -> {
	// Category curCat = new Category();
	// curCat.setName(cat);
	//
	// DecimalFormat df = new DecimalFormat("#.##");
	// curCat.setPercentage(Double.valueOf(df
	// .format(((double) count / userTags.size()) * 100)));
	//
	// curCat.setTags(catTagMap.get(cat));
	// userCategories.add(curCat);
	// });
	//
	// return userCategories
	// .parallelStream()
	// .sorted((cat1, cat2) -> {
	// return cat1.getPercentage() == cat2.getPercentage() ? 0
	// : cat1.getPercentage() < cat2.getPercentage() ? 1
	// : -1;
	// }).collect(Collectors.toList());
	//
	// }

	// ********************Course Related
	// services*****************************************//

	@Override
	public LinkedHashSet<Recommendation> getCourses(String userid) {

		LinkedHashSet<Recommendation> result = new LinkedHashSet<Recommendation>();

		Set<Tag> userTags = tagsUserMap.get(userid);
		TreeMap<Integer, Set<Recommendation>> map = new TreeMap<>(Collections.reverseOrder());
		for (Tag tag : userTags) {

			if (courseTagMap.containsKey(tag.getName())) {
				Set<Recommendation> list = courseTagMap.get(tag.getName());
				map.put(tag.getvalue(), list);
			}
		}

		for (Map.Entry<Integer, Set<Recommendation>> entry : map.entrySet()) {

			for (Recommendation recommendation : entry.getValue()) {
				if (result.size() < 10) {
					result.add(recommendation);

				}
			}
		}

		return result;

	}

	public HashMap<String, Recommendation> populateIDCourseMap() {

		for (Entry<String, LinkedHashSet<Recommendation>> entry : courseTagMap.entrySet()) {

			for (Recommendation reco : entry.getValue()) {
				if (reco != null) {
					String x = reco.getId();
					IDCourseMap.put(x, reco);
				}
			}
		}
		return IDCourseMap;

	}

	public HashMap<String, LinkedHashSet<Recommendation>> userCourseRecommendation() {

		for (Entry<String, Set<Tag>> entry : tagsUserMap.entrySet()) {

			Set<Tag> list = entry.getValue();

			LinkedHashSet<Recommendation> mainLi = new LinkedHashSet<>();
			for (Tag tag : list) {
				if (courseTagMap.containsKey(tag.getName())) {
					LinkedHashSet<Recommendation> li = courseTagMap.get(tag.getName());
					if (li != null) {
						mainLi.addAll(li);
					}
				}
			}

			userCourseMap.put(entry.getKey(), mainLi);

		}

		return userCourseMap;

	}

	public LinkedHashSet<Recommendation> updateRecommendedCourses(String userid,
			List<RecommendationCourse> recommendedCourses) {
		userRecommendedCourseMap = userRecommendedCoursePopulate();

		for (RecommendationCourse cor : recommendedCourses) {

			if (cor.getValue().equals("false")) {
				LinkedHashSet<Recommendation> li = userRecommendedCourseMap.get(userid);
				if (li != null) {
					Recommendation cour = IDCourseMap.get(cor.getId());
					li.remove(cour);
					userRecommendedCourseMap.put(userid, li);
				}
			} else {
				LinkedHashSet<Recommendation> li = userRecommendedCourseMap.get(userid);
				if (li != null) {
					Recommendation cour = IDCourseMap.get(cor.getId());
					li.add(cour);
					userRecommendedCourseMap.put(userid, li);
				}

			}
		}

		return userRecommendedCourseMap.get(userid);

	}

	public HashMap<String, LinkedHashSet<Recommendation>> userRecommendedCoursePopulate() {

		for (Entry<String, String> entry : recommmedProperties.entrySet()) {
			LinkedHashSet<Recommendation> list = new LinkedHashSet<Recommendation>();
			String x[] = entry.getValue().split(",");
			for (int i = 0; i < x.length; i++) {
				Recommendation rec = IDCourseMap.get(x[i]);
				list.add(rec);
			}
			userRecommendedCourseMap.put(entry.getKey(), list);
		}
		return userRecommendedCourseMap;

	}

	public LinkedHashSet<Recommendation> updateUserCourseMap(CourseInput courseInput, String userid) {

		if (courseInput.getTags().size() == 0 && courseInput.getUsers().size() == 0) {
			LinkedHashSet<Recommendation> li = userCourseMap.get(userid);
			return li;
		}
		if (courseInput.getUsers().size() == 0) {
			LinkedHashSet<Recommendation> Mainlist = new LinkedHashSet<>();
			LinkedHashSet<Recommendation> result = new LinkedHashSet<>();
			for (String str : courseInput.getTags()) {
				LinkedHashSet<Recommendation> list = courseTagMap.get(str);
				if (list != null) {
					Mainlist.addAll(list);
				}

			}
			for (Recommendation s : Mainlist) {
				if (result.size() < 10) {
					result.add(s);
				}
			}
			return Mainlist;
		} else if (courseInput.getTags().size() == 0) {

			LinkedHashSet<Recommendation> Mainlist = new LinkedHashSet<>();
			LinkedHashSet<Recommendation> result = new LinkedHashSet<>();
			for (String str : courseInput.getUsers()) {
				LinkedHashSet<Recommendation> list = userRecommendedCourseMap.get(str);
				if (list != null) {
					Mainlist.addAll(list);
				}
			}
			for (Recommendation s : Mainlist) {
				if (result.size() < 10) {
					result.add(s);
				}
			}
			return Mainlist;
		} else {

			LinkedHashSet<Recommendation> Mainlist = new LinkedHashSet<>();
			LinkedHashSet<Recommendation> result = new LinkedHashSet<>();
			for (String str : courseInput.getUsers()) {
				LinkedHashSet<Recommendation> list = userRecommendedCourseMap.get(str);
				if (list != null) {
					Mainlist.addAll(list);
				}
			}
			for (String str : courseInput.getTags()) {
				LinkedHashSet<Recommendation> list = courseTagMap.get(str);
				if (list != null) {
					Mainlist.addAll(list);
				}
			}

			for (Recommendation s : Mainlist) {
				if (result.size() < 10) {
					result.add(s);
				}
			}

			return Mainlist;

		}

	}

	// **************************************Network Graph
	// Service*******************************//

	public NetworkGraph generateNetworkGraph() throws DataLoadException {

		NetworkGraph networkGraph = new NetworkGraph();
		List<NetworkNode> nodesList = new ArrayList<NetworkNode>();
		Set<NetworkEdge> edgesList = new HashSet<NetworkEdge>();
		for (Map.Entry<String, String> entry : nodeMap.entrySet()) {
			NetworkNode node = new NetworkNode();

			node.setNode(entry.getKey());

			node.setValue(entry.getValue());

			nodesList.add(node);

			List<SimilarUser> similarUserList = getSimilarUsers(entry.getKey());

			for (SimilarUser user : similarUserList) {

				NetworkEdge networkEdge = new NetworkEdge();

				networkEdge.setNode1(entry.getKey());

				networkEdge.setNode2(user.getUid());

				networkEdge.setValue(String.valueOf(user.getvalue()));

				edgesList.add(networkEdge);
			}

		}
		nodesList = nodesList.parallelStream().sorted((cat1, cat2) -> {
			return Integer.valueOf(cat1.getValue()) == Integer.valueOf(cat2.getValue()) ? 0
					: Integer.valueOf(cat1.getValue()) < Integer.valueOf(cat2.getValue()) ? 1 : -1;
		}).collect(Collectors.toList());
		List<NetworkEdge> li = new ArrayList<NetworkEdge>();
		for (NetworkEdge edge : edgesList) {
			li.add(edge);
		}

		li = li.parallelStream().sorted((cat1, cat2) -> {
			return Integer.valueOf(cat1.getValue()) == Integer.valueOf(cat2.getValue()) ? 0
					: Integer.valueOf(cat1.getValue()) < Integer.valueOf(cat2.getValue()) ? 1 : -1;
		}).collect(Collectors.toList());

		List<NetworkEdge> list1 = new ArrayList<NetworkEdge>();
		for (int i = 0; i < li.size(); i = i + 2) {
			list1.add(li.get(i));
		}
		networkGraph.setEdges(list1);
		networkGraph.setNodes(nodesList);
		return networkGraph;

	}

}
