package edu.asu.dv.rest.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.response.Tag;
import edu.asu.dv.model.response.UserResponse;
import edu.asu.dv.service.UserSimilarityService;

@CrossOrigin(maxAge = 3600)
@RestController
public class UserCategoryService {
	@Autowired
	private UserSimilarityService similarityService;

	@javax.annotation.Resource(name = "userNameProperties")
	private Map<String, String> properties;

	@SuppressWarnings("unchecked")
	@PostMapping(value = "users/{userid}/similarusers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> getUserDetails(@RequestBody String cat, @PathVariable("userid") String userid)
			throws DataLoadException {

		if (cat == null || cat.length() == 0 || cat.equals("{}")) {
			return null;
		}
		List<String> categories = new ArrayList<>();
		if (cat.length() > 0 || cat.contains(":")) {
			String x[] = cat.split(":");
			String y = x[1].replace("}", "").replace("[", "").replace("]", "").replace("\"", "");

			if (y.contains(",")) {
				String z[] = y.split(",");

				for (int i = 0; i < z.length; i++) {
					categories.add(z[i]);
				}
			} else {
				categories.add(y);
			}

			if (null == categories || categories.size() == 0) {
				categories = new ArrayList<String>();
				categories.add("Web-Development");
				categories.add("Backend-Technologies");
				categories.add("Database");
				categories.add("Others");

			}
			System.out.println(categories);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Access-Control-Allow-Origin", "*");
			UserResponse response = new UserResponse();

			response.setUserName(properties.get(userid));

			List<Tag> list = similarityService.getTagesBasedONCategories(categories, userid);
			LinkedHashSet<Tag> lsit = new LinkedHashSet<Tag>(list);

			List<Tag> li = new ArrayList<Tag>(lsit);

			response.setTags(li);

			response.setSimilarUsers(similarityService.getSimilarUsersBasedOnCategories(userid, categories));

			response.setCategories(similarityService.getCategoriesBasedOnCategory(userid, categories));
			
			response.setCourses(similarityService.getCoursesBasedonCategories(userid,lsit));

			response.setRecommendedCourses(similarityService.userRecommendedCoursePopulate().get(userid));

			return new ResponseEntity<UserResponse>(response, headers, HttpStatus.OK);
		}

		return null;
	}

}
