package com.doubles.devlog.user.controller;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.doubles.devlog.article.controller.ArticleController;
import com.doubles.devlog.user.domain.UserVO;
import com.doubles.devlog.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserRegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final UserService userService;

    @Inject
    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 페이지
    @GetMapping(value = "/register")
    public String registerGET() throws Exception {
        return "/user/register";
    }

    // 회원가입 처리
    @PostMapping(value = "/register")
    public String registerPOST(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception {
    	
    	logger.info("register...");
    	
        String hashedPw = BCrypt.hashpw(userVO.getUserPw(), BCrypt.gensalt());
        userVO.setUserPw(hashedPw);
        userService.register(userVO);
        redirectAttributes.addFlashAttribute("msg", "REGISTERED");

        return "redirect:/user/login";
    }
    
}