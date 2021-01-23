package com.doubles.devlog.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doubles.devlog.article.domain.ArticleVO;
import com.doubles.devlog.article.persistence.ArticleDAO;
import com.doubles.devlog.tutorial.vo.ProductVO;

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
	
	@GetMapping(value = "/voidm")
	public void voidMapping() {
		logger.info("voidMapping() called");
	}
	
	@GetMapping(value = "/stringm")
	public String stringMapping(@ModelAttribute("msg") String msg) {
		logger.info("stringMapping() called");
		
		return "result";
	}
	
	@GetMapping(value = "/modelm")
	public String modelMapping(Model model) {
		
		ProductVO product = new ProductVO("desktop",10000);
		logger.info("modelMapping() called");
		model.addAttribute(product);
		
		return "product-detail";
	}
	
	@GetMapping(value = "/redirectm")
	public String redirectMapping(RedirectAttributes redirectAttributes) {
		
		logger.info("redirectMapping() called");
		redirectAttributes.addAttribute("msg","Redirect가 넘어옴");
		
		
		return "redirect:/redirectr";
	}
	
	@GetMapping(value = "/redirectr")
	public void redirectResult(@ModelAttribute String msg) {
		logger.info("redirectResult() called"+msg);
	}
	
	@RequestMapping(value = "/jsonm")
	@ResponseBody
	public ProductVO jsonMapping() {
		
		ProductVO productVO = new ProductVO("laptop", 5000);
		
		return productVO;
		
	}
	
	
}
