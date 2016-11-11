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
import edu.asu.dv.service.UserSimilarityService;
import edu.asu.dv.util.DataLoader;

@Service
public class UserSimilarityServiceImpl implements UserSimilarityService {

	@Autowired
	private DataLoader loader;

	private HashMap<String, List<String>> similarUserMap = null;

	@PostConstruct
	public void init() throws DataLoadException, IOException {
		similarUserMap = findSimilarUsers(loader.loadUserData());
	}

	@Override
	public List<String> getSimilarUsers(String userid) throws DataLoadException {

		return similarUserMap.get(userid);
	}

	private HashMap<String, List<String>> findSimilarUsers(HashMap<String, ArrayList<User>> userMap) {

		HashMap<String, List<String>> similarUserMap = new HashMap<String, List<String>>();
		HashMap<String, List<String>> tagsUserMap = new HashMap<String, List<String>>();

		userMap.forEach((x, y) -> {
			List<String> tags = new ArrayList<>();
			y.forEach(z -> tags.add(z.getTag_name()));
			tagsUserMap.put(x, tags);
		});

		tagsUserMap.forEach((x, y) -> {
			tagsUserMap.forEach((a, b) -> {
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
