package edu.asu.dv.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldRestController {

	@RequestMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping("/hello/{player}")
	public String message(@PathVariable String player) {// REST Endpoint.
		return player;
	}
}