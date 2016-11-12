package edu.asu.dv.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.response.UserResponse;
import edu.asu.dv.service.UserSimilarityService;

@RestController
public class UserDetailService {

	@Autowired
	private UserSimilarityService similarityService;

	@GetMapping(value = "/user/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> getUserDetails(@PathVariable("userid") String userid) throws DataLoadException {

		UserResponse response = new UserResponse();

		response.setSimilarUsers(similarityService.getSimilarUsers(userid));

		response.setTags(similarityService.getUserTags(userid));

		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);

	}

}
