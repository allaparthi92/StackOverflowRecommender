package edu.asu.dv.util;

import java.util.Map;
import java.util.Set;

public interface CategoryTagMapper {
	Map<String, Set<String>> getTagCategories();
}
