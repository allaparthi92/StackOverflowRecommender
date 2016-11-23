package controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";

	@RequestMapping(value = "/hello")
	public ModelAndView welcome() {

		ModelAndView model = new ModelAndView("index");
		return model;

	}
	
	@RequestMapping(value = "/bhanu")
	public ModelAndView welcome1() {

		ModelAndView model = new ModelAndView("index");
		// model.addAttribute("message", "Welcome");
		// model.addAttribute("counter", ++counter);
		// logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return model;

	}
	
	

}