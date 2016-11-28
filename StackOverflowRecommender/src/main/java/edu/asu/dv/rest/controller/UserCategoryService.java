package edu.asu.dv.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.response.UserResponse;
import edu.asu.dv.service.UserSimilarityService;

@RestController
public class UserCategoryService {
	@Autowired
	private UserSimilarityService similarityService;

	@javax.annotation.Resource(name = "userNameProperties")
	private Map<String, String> properties;
	
	@PostMapping(value = "users/{userid}/similarusers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> getUserDetails(
			@RequestBody List<String> categories,
			@PathVariable("userid") String userid) throws DataLoadException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		UserResponse response = new UserResponse();

		response.setUserName(properties.get(userid));

		response.setTags(similarityService.getTagesBasedONCategories(
				categories, userid));

		response.setSimilarUsers(similarityService
				.getSimilarUsersBasedOnCategories(userid, categories));

		response.setCategories(similarityService.getCategoriesBasedOnCategory(
				userid, categories));
		response.setCourses(similarityService.getCourses(userid));

		return new ResponseEntity<UserResponse>(response,headers, HttpStatus.OK);

	}

}
