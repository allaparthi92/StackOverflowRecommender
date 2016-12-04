package edu.asu.dv.rest.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.Recommendation;
import edu.asu.dv.model.RecommendationCourse;
import edu.asu.dv.service.UserSimilarityService;

@CrossOrigin(maxAge = 3600)
@RestController
public class UserRecommendationCourseService {

	@Autowired
	private UserSimilarityService similarityService;

	@javax.annotation.Resource(name = "userNameProperties")
	private Map<String, String> properties;

	@PostMapping(value = "/user/{userid}/addtorecommendation", consumes = MediaType.APPLICATION_JSON_VALUE)
	public LinkedHashSet<Recommendation> getUserDetails(@RequestBody List<RecommendationCourse> list,
			@PathVariable("userid") String userid) throws DataLoadException {
		{
			HttpHeaders headers = new HttpHeaders();
			headers.add("Access-Control-Allow-Origin", "*");
			// System.out.println(similarityService.updateRecommendedCourses(userid,
			// list));
			return similarityService.updateRecommendedCourses(userid, list);
		}
	}
}
