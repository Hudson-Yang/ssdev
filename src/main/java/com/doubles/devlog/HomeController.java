package com.doubles.devlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/")
	public String home(Model model) throws Exception {
		model.addAttribute("getit","더블에스 블로그 보고 공부하는 프로젝트");
		logger.info("home() called");
		return "home";
	}
	
	
	
	
}
