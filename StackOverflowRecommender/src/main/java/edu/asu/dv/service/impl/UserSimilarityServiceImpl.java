package edu.asu.dv.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.User;
import edu.asu.dv.model.response.DetailMap;
import edu.asu.dv.service.UserSimilarityService;
import edu.asu.dv.util.DataLoader;

@Service
public class UserSimilarityServiceImpl implements UserSimilarityService {

	@Autowired
	private DataLoader loader;

	private HashMap<String, List<String>> similarUserMap = null;

	private HashMap<String, List<DetailMap>> tagsUserMap = null;

	@PostConstruct
	public void init() throws DataLoadException, IOException {
		similarUserMap = findSimilarUsers(loader.loadUserData());
	}

	@Override
	public List<DetailMap> getSimilarUsers(String userid) throws DataLoadException {

		List<DetailMap> similarUsers = new ArrayList<>();
		List<String> users = similarUserMap.get(userid);
		List<DetailMap> curUserTagDetail = tagsUserMap.get(userid);
		users.forEach(user -> {

			List<DetailMap> curUserTagDetail2 = tagsUserMap.get(user);
			int counter = 0;
			DetailMap userWeight = new DetailMap();
			for (DetailMap firstUserDetail : curUserTagDetail) {
				for (DetailMap secondUserDetail : curUserTagDetail2) {
					if (firstUserDetail.getName().equals(secondUserDetail.getName())) {
						counter += Math.min(Integer.parseInt(firstUserDetail.getValue()),
								Integer.parseInt(secondUserDetail.getValue()));
					}
				}
			}
			userWeight.setName(user);
			userWeight.setValue(String.valueOf(counter));
			similarUsers.add(userWeight);
		});
		return similarUsers;
	}

	@Override
	public List<DetailMap> getUserTags(String userName) {
		return tagsUserMap.get(userName);
	}

	private HashMap<String, List<String>> findSimilarUsers(HashMap<String, ArrayList<User>> userMap) {

		HashMap<String, List<String>> similarUserMap = new HashMap<String, List<String>>();
		tagsUserMap = new HashMap<String, List<DetailMap>>();
		HashMap<String, List<String>> tagUserString = new HashMap<>();

		userMap.forEach((username, userObj) -> {
			List<DetailMap> tags = new ArrayList<>();
			List<String> tagString = new ArrayList<>();
			userObj.forEach(z -> {
				tagString.add(z.getTag_name());
				DetailMap temp = new DetailMap();
				temp.setName(z.getTag_name());
				temp.setValue(String.valueOf(z.getQuestion_count()));
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
