package com.doubles.devlog.home.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doubles.devlog.article.service.ArticleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private final ArticleService articleService;
	
	@Inject
    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }
	
	@RequestMapping(value = "/")
	public String home(Model model) throws Exception {
		logger.info("home() called");
		System.out.println(articleService.latestArticles());
		model.addAttribute("latestArticles",articleService.latestArticles());
		return "home";
	}
	
	
	
	
}
