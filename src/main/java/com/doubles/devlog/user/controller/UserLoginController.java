package com.doubles.devlog.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doubles.devlog.article.controller.ArticleController;
import com.doubles.devlog.user.domain.LoginDTO;
import com.doubles.devlog.user.domain.UserVO;
import com.doubles.devlog.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final UserService userService;

    @Inject
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    // 로그인 페이지
    @GetMapping(value = "/login")
    public String loginGET(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
    	
    	logger.info("login..");
    	
        return "/user/login";
    }

    // 로그인 처리
    @PostMapping(value = "/loginPost")
    public void loginPOST(LoginDTO loginDTO, HttpSession httpSession, Model model) throws Exception {
    	
    	logger.info("loginPost..");

        UserVO userVO = userService.login(loginDTO);

        if (userVO == null || !BCrypt.checkpw(loginDTO.getUserPw(), userVO.getUserPw())) {
            return;
        }

        model.addAttribute("user", userVO);
        
    }
    
}