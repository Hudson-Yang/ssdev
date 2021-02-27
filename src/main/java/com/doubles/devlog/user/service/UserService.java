package com.doubles.devlog.user.service;

import java.util.Date;

import com.doubles.devlog.user.domain.LoginDTO;
import com.doubles.devlog.user.domain.UserVO;

public interface UserService {
    
    // 회원 가입 처리
    void register(UserVO userVO) throws Exception;
    
    UserVO login(LoginDTO loginDTO) throws Exception;
    
    void keepLogin(String userId, String sessionId, Date next) throws Exception;

    UserVO checkLoginBefore(String value) throws Exception;
    
    UserVO findUserImg(String userId) throws Exception;
    
}