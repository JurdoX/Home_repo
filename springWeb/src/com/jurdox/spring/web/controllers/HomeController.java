package com.jurdox.spring.web.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static Logger log = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String showHome() {
		log.info("showing homepage...");
		return "home";
	}
}
