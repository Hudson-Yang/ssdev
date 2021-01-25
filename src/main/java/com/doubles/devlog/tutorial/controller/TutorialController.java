package com.doubles.devlog.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doubles.devlog.HomeController;
import com.doubles.devlog.tutorial.vo.ProductVO;

@Controller
@RequestMapping(value="/tutorial")
public class TutorialController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
