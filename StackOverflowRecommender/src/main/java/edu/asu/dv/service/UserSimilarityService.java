package edu.asu.dv.service;

import java.util.List;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.Course;
import edu.asu.dv.model.response.Category;
import edu.asu.dv.model.response.SimilarUser;
import edu.asu.dv.model.response.Tag;

public interface UserSimilarityService {
	List<SimilarUser> getSimilarUsers(String userid) throws DataLoadException;

	List<Tag> getUserTags(String userName);

	List<Category> getCategories(String userid);

	List<Course> getCourses(String userid);

	List<Category> getCategoriesBasedOnCategory(String userid,
			List<String> categories);
	List<Tag> getTagesBasedONCategories(List<String> categories,
			String userid);
	List<SimilarUser> getSimilarUsersBasedOnCategories(String userid,
			List<String> categories) ;
}
