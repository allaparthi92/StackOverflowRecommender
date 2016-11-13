package edu.asu.dv.util.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import edu.asu.dv.util.CategoryTagMapper;

@Component
public class CategoryTagMapperImpl implements CategoryTagMapper {

	@Resource(name = "categoryTagProperties")
	private Map<String, String> properties;

	@Override
	public Map<String, Set<String>> getTagCategories() {
		Map<String, Set<String>> tagCategoryMap = new HashMap<>();

		properties.forEach((cat, tags) -> {
			List<String> tagArrList = Arrays.asList(tags.split(","));
			tagArrList.forEach(tag -> {
				tag = tag.trim();
				if (tagCategoryMap.containsKey(tag)) {
					tagCategoryMap.get(tag).add(cat);
				} else {
					Set<String> catSet = new HashSet<>();
					catSet.add(cat);
					tagCategoryMap.put(tag, catSet);
				}
			});
		});

		return tagCategoryMap;

	}

}
