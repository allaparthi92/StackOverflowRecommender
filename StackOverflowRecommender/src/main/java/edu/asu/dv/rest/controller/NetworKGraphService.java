package edu.asu.dv.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.asu.dv.exception.DataLoadException;
import edu.asu.dv.model.NetworkGraph;
import edu.asu.dv.service.UserSimilarityService;

@CrossOrigin
@RestController
public class NetworKGraphService {

	@Autowired
	private UserSimilarityService similarityService;
	
	
	@GetMapping(value = "/networkgraph", produces = MediaType.APPLICATION_JSON_VALUE)
	public NetworkGraph getUserDetails() throws DataLoadException {
		
		return similarityService.generateNetworkGraph();

	}

}
