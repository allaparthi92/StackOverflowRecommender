package edu.asu.dv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.asu.dv.model.User;

public class UserSimilarityService {

	public HashMap<String, List<String>> findSimilarUsers(
			HashMap<String, ArrayList<User>> userMap) {

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
