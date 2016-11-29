package edu.asu.dv.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.Recommendation;
import edu.asu.dv.model.response.UserResponse;
import edu.asu.dv.service.UserSimilarityService;

@CrossOrigin
@RestController
public class UserDetailService {

	@Autowired
	private UserSimilarityService similarityService;
	
	
	@javax.annotation.Resource(name = "userNameProperties")
	private Map<String, String> properties;


	@GetMapping(value = "/user/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> getUserDetails(@PathVariable("userid") String userid) throws DataLoadException {

		UserResponse response = new UserResponse();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		
		response.setUserName(properties.get(userid));

		response.setSimilarUsers(similarityService.getSimilarUsers(userid));

		response.setTags(similarityService.getUserTags(userid));

		response.setCategories(similarityService.getCategories(userid));
	
		response.setCourses(similarityService.getCourses(userid));
		
		response.setRecommendedCourses(similarityService.userRecommendedCoursePopulate().get(userid));
		return new ResponseEntity<UserResponse>(response, headers,HttpStatus.OK);

	}

}
