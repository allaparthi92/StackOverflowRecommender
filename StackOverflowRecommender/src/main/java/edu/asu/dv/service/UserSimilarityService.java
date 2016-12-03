package edu.asu.dv.service;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.CourseInput;
import edu.asu.dv.model.NetworkGraph;
import edu.asu.dv.model.Recommendation;
import edu.asu.dv.model.RecommendationCourse;
import edu.asu.dv.model.response.Category;
import edu.asu.dv.model.response.SimilarUser;
import edu.asu.dv.model.response.Tag;

public interface UserSimilarityService {
	List<SimilarUser> getSimilarUsers(String userid) throws DataLoadException;

	List<Tag> getUserTags(String userName);

	List<Category> getCategories(String userid);

	LinkedHashSet<Recommendation> getCourses(String userid);

	List<Category> getCategoriesBasedOnCategory(String userid,
			List<String> categories);

	List<Tag> getTagesBasedONCategories(List<String> categories, String userid);

	List<SimilarUser> getSimilarUsersBasedOnCategories(String userid,
			List<String> categories);

	HashMap<String, LinkedHashSet<Recommendation>> userCourseRecommendation();

	HashMap<String, Recommendation> populateIDCourseMap();

	HashMap<String, LinkedHashSet<Recommendation>> userRecommendedCoursePopulate();

	LinkedHashSet<Recommendation> updateRecommendedCourses(String userid,
			List<RecommendationCourse> recommendedCourses);

	HashMap<String, LinkedHashSet<Recommendation>> getCourseTagMap();

	LinkedHashSet<Recommendation> updateUserCourseMap(CourseInput courseInput,
			String userid);

	HashMap<String, LinkedHashSet<Recommendation>> getuserRecommendedCourseMap();

	NetworkGraph generateNetworkGraph() throws DataLoadException;

}
