package edu.asu.dv.service.impl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.dv.exception.DataLoadException;
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

	@Autowired
	private CategoryTagMapper catMapper;

	private HashMap<String, List<String>> similarUserMap = null;

	private HashMap<String, List<Tag>> tagsUserMap = null;

	@PostConstruct
	public void init() throws DataLoadException, IOException {
		similarUserMap = findSimilarUsers(loader.loadUserData());
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
			curCat.setPercentage(Double.valueOf(df.format((count / 30.0) * 100)));

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
		List<Tag> curUserTagDetail = tagsUserMap.get(userid);
		users.forEach(user -> {

			List<Tag> curUserTagDetail2 = tagsUserMap.get(user);
			int counter = 0;
			SimilarUser userWeight = new SimilarUser();
			for (Tag firstUserDetail : curUserTagDetail) {
				for (Tag secondUserDetail : curUserTagDetail2) {
					if (firstUserDetail.getName().equals(secondUserDetail.getName())) {
						counter += Math.min(firstUserDetail.getCount(), secondUserDetail.getCount());
					}
				}
			}
			userWeight.setUid(user);
			userWeight.setWeight(counter);
			similarUsers.add(userWeight);
		});

		return similarUsers.parallelStream().sorted((simuser1, simuser2) -> {
			return simuser1.getWeight() == simuser2.getWeight() ? 0
					: simuser1.getWeight() < simuser2.getWeight() ? 1 : -1;

		}).collect(Collectors.toList());

	}

	@Override
	public List<Tag> getUserTags(String userName) {
		return tagsUserMap.get(userName).parallelStream().sorted((tag1, tag2) -> {
			return tag1.getCount() == tag2.getCount() ? 0 : tag1.getCount() < tag2.getCount() ? 1 : -1;
		}).collect(Collectors.toList());
	}

	private HashMap<String, List<String>> findSimilarUsers(HashMap<String, ArrayList<User>> userMap) {

		HashMap<String, List<String>> similarUserMap = new HashMap<String, List<String>>();
		tagsUserMap = new HashMap<String, List<Tag>>();
		HashMap<String, List<String>> tagUserString = new HashMap<>();

		userMap.forEach((username, userObj) -> {
			List<Tag> tags = new ArrayList<>();
			List<String> tagString = new ArrayList<>();
			userObj.forEach(z -> {
				tagString.add(z.getTag_name());
				Tag temp = new Tag();
				temp.setName(z.getTag_name());
				temp.setCount(z.getQuestion_count());
				tags.add(temp);
			});
			tagUserString.put(username, tagString);
			tagsUserMap.put(username, tags);
		});

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

}
