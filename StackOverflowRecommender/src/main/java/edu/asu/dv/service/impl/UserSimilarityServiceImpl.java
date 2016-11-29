package edu.asu.dv.service.impl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.Course;
import edu.asu.dv.model.Recommendation;
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

	@Resource(name = "categoryTagProperties")
	private Map<String, String> catProperties;

	@Autowired
	private CategoryTagMapper catMapper;

	private HashMap<String, List<String>> similarUserMap = null;

	private HashMap<String, List<Recommendation>> courseTagMap = null;

	private HashMap<String, List<Tag>> tagsUserMap = null;

	@PostConstruct
	public void init() throws DataLoadException, IOException {
		similarUserMap = findSimilarUsers(loader.loadUserData());
		courseTagMap = loader.loadCourseData();
	}

	@Override
	public List<Category> getCategories(String userid) {
		Map<String, Set<String>> tagCatMap = catMapper.getTagCategories();
		List<Tag> userTags = tagsUserMap.get(userid);

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
			curCat.setPercentage(Double.valueOf(df
					.format(((double) count / userTags.size()) * 100)));

			curCat.setTags(catTagMap.get(cat));
			userCategories.add(curCat);
		});

		return userCategories
				.parallelStream()
				.sorted((cat1, cat2) -> {
					return cat1.getPercentage() == cat2.getPercentage() ? 0
							: cat1.getPercentage() < cat2.getPercentage() ? 1
									: -1;
				}).collect(Collectors.toList());

	}

	@Override
	public List<SimilarUser> getSimilarUsers(String userid)
			throws DataLoadException {

		List<SimilarUser> similarUsers = new ArrayList<>();
		List<String> users = similarUserMap.get(userid);
		List<Tag> curUserTagDetail = tagsUserMap.get(userid);
		users.forEach(user -> {
			List<Tag> curUserTagDetail2 = tagsUserMap.get(user);
			int counter = 0;
			SimilarUser userWeight = new SimilarUser();
			for (Tag firstUserDetail : curUserTagDetail) {
				for (Tag secondUserDetail : curUserTagDetail2) {
					if (firstUserDetail.getName().equals(
							secondUserDetail.getName())) {
						counter += Math.min(firstUserDetail.getvalue(),
								secondUserDetail.getvalue());
					}
				}
			}
			userWeight.setUid(user);
			userWeight.setUserName(properties.get(user));
			userWeight.setvalue(counter);
			similarUsers.add(userWeight);
		});

		return similarUsers
				.parallelStream()
				.sorted((simuser1, simuser2) -> {
					return simuser1.getvalue() == simuser2.getvalue() ? 0
							: simuser1.getvalue() < simuser2.getvalue() ? 1
									: -1;

				}).collect(Collectors.toList());

	}

	@Override
	public List<Tag> getUserTags(String userName) {
		return tagsUserMap
				.get(userName)
				.parallelStream()
				.sorted((tag1, tag2) -> {
					return tag1.getvalue() == tag2.getvalue() ? 0 : tag1
							.getvalue() < tag2.getvalue() ? 1 : -1;
				}).collect(Collectors.toList());
	}

	private HashMap<String, List<String>> findSimilarUsers(
			HashMap<String, ArrayList<User>> userMap) {

		HashMap<String, List<String>> similarUserMap = new HashMap<String, List<String>>();
		tagsUserMap = new HashMap<String, List<Tag>>();
		HashMap<String, List<String>> tagUserString = new HashMap<>();
		Set<String> tagSet = new HashSet<String>();
		userMap.forEach((username, userObj) -> {
			List<Tag> tags = new ArrayList<>();
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

	// @Override
	// public List<Course> getCourses(String userid) {
	//
	// ArrayList<Recommendation> lsit = new ArrayList<Recommendation>();
	//
	// ArrayList<Course> Result = new ArrayList<Course>();
	//
	// Recommendation recommend = new Recommendation();
	// recommend.setId("2626");
	// recommend.setLanguage("en");
	// recommend.setName("Object Oriented Programming in Java");
	// recommend
	// .setPreviewLink("https://www.coursera.org/learn/object-oriented-java");
	// recommend.setShortName("ObjectOrientedProgramminginJava");
	//
	// Recommendation recommend1 = new Recommendation();
	// recommend1.setId("16");
	// recommend1.setLanguage("en");
	// recommend1.setName("Advanced Data Structures in Java");
	// recommend1
	// .setPreviewLink("https://www.coursera.org/learn/advanced-data-structures");
	// recommend1.setShortName("Advanced Data Structures in Java");
	//
	// Recommendation recommend2 = new Recommendation();
	// recommend2.setId("1775");
	// recommend2.setLanguage("en");
	// recommend2.setName("Java Programming: Principles of Software Design");
	// recommend2
	// .setPreviewLink("https://www.coursera.org/learn/java-programming-design-principles");
	// recommend2
	// .setShortName("Java Programming: Principles of Software Design");
	//
	// lsit.add(recommend);
	// lsit.add(recommend1);
	// lsit.add(recommend2);
	//
	// Course course = new Course("java", lsit);
	// Result.add(course);
	// ArrayList<Recommendation> pythonlsit = new ArrayList<Recommendation>();
	//
	// Recommendation pyrecommend = new Recommendation();
	// pyrecommend.setId("13");
	// pyrecommend.setLanguage("en");
	// pyrecommend.setName("Computer Science 101");
	// pyrecommend
	// .setPreviewLink("https://class.coursera.org/cs101/lecture/preview");
	// pyrecommend.setShortName("cs101");
	//
	// Recommendation pyrecommend1 = new Recommendation();
	// pyrecommend1.setId("1354");
	// pyrecommend1.setLanguage("en");
	// pyrecommend1.setName("Programming for Everybody (Python)");
	// pyrecommend1.setPreviewLink("");
	// pyrecommend1.setShortName("pythonlearn");
	//
	// Recommendation pyrecommend2 = new Recommendation();
	// pyrecommend2.setId("88");
	// pyrecommend2.setLanguage("en");
	// pyrecommend2
	// .setName("An Introduction to Interactive Programming in Python");
	// pyrecommend2.setPreviewLink("");
	// pyrecommend2.setShortName("interactivepython");
	//
	// pythonlsit.add(pyrecommend);
	// pythonlsit.add(pyrecommend1);
	// pythonlsit.add(pyrecommend2);
	//
	// Course pycourse = new Course("python", pythonlsit);
	// Result.add(pycourse);
	// return Result;
	// }

	// *******************Code related to
	// categories**********************************************

	public List<Tag> getTagesBasedONCategories(List<String> categories,
			String userid) {
		List<Tag> tagList = new ArrayList<Tag>();
		Set<String> tagSet = new HashSet<>();
		List<Tag> userTags = tagsUserMap.get(userid);
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
		return tagList
				.parallelStream()
				.sorted((cat1, cat2) -> {
					return cat1.getvalue() == cat2.getvalue() ? 0 : cat1
							.getvalue() < cat2.getvalue() ? 1 : -1;
				}).collect(Collectors.toList());
	}

	@Override
	public List<Category> getCategoriesBasedOnCategory(String userid,
			List<String> categories) {
		List<Category> result = new ArrayList<>();
		List<Category> list = getCategories(userid);
		for (String s : categories) {
			for (Category cat : list) {
				if (cat.getName().equalsIgnoreCase(s)) {
					result.add(cat);
				}
			}
		}
		return result
				.parallelStream()
				.sorted((cat1, cat2) -> {
					return cat1.getPercentage() == cat2.getPercentage() ? 0
							: cat1.getPercentage() < cat2.getPercentage() ? 1
									: -1;
				}).collect(Collectors.toList());
	}

	public List<SimilarUser> getSimilarUsersBasedOnCategories(String userid,
			List<String> categories) {
		List<Tag> mainUserTags = getTagesBasedONCategories(categories, userid);

		List<SimilarUser> result = new ArrayList<SimilarUser>();

		List<String> users = similarUserMap.get(userid);

		for (String user : users) {

			List<Tag> userTags = getTagesBasedONCategories(categories, user);
			int sum = 0;
			SimilarUser userWeight = new SimilarUser();
			for (Tag t1 : mainUserTags) {

				for (Tag t2 : userTags) {

					if (t1.getName().equalsIgnoreCase(t2.getName())
							&& !userid.equals(user)) {
						sum = sum + Math.min(t1.getvalue(), t2.getvalue());
					}

				}
			}
			userWeight.setUid(user);
			userWeight.setUserName(properties.get(user));
			userWeight.setvalue(sum);
			result.add(userWeight);

		}
		return result
				.parallelStream()
				.sorted((simuser1, simuser2) -> {
					return simuser1.getvalue() == simuser2.getvalue() ? 0
							: simuser1.getvalue() < simuser2.getvalue() ? 1
									: -1;

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
	public List<String> getCourses(String userid) {

		List<String> result = new ArrayList<String>();

		List<Tag> userTags = tagsUserMap.get(userid);
		TreeMap<Integer, List<Recommendation>> map = new TreeMap<>(
				Collections.reverseOrder());
		for (Tag tag : userTags) {

			if (courseTagMap.containsKey(tag.getName())) {
				List<Recommendation> list = courseTagMap.get(tag.getName());
				map.put(tag.getvalue(), list);
			}
		}

		for (Map.Entry<Integer, List<Recommendation>> entry : map.entrySet()) {

			for (Recommendation recommendation : entry.getValue()) {
				if (result.size() < 10) {
					result.add(recommendation.getName());

				}
			}
		}

		return result;
	}

	public List<String> updatedCourses(List<String> Courses, String userid) {

		List<String> result = new ArrayList<String>();

		List<String> list = getCourses(userid);

		for (String s : Courses) {
			if (result.size() < 10) {
				result.add(s);
			}
		}
		
		for (String s : list) {
			if (result.size() < 10) {
				result.add(s);
			}
		}

		return result;

	}

}
