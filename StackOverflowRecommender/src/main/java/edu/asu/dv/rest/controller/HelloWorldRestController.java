package edu.asu.dv.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

	@GetMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@GetMapping("/hello/{player}")
	public String message(@PathVariable String player) {// REST Endpoint.
		return player;
	}
}