package com.doubles.devlog.user.service;

import com.doubles.devlog.user.domain.LoginDTO;
import com.doubles.devlog.user.domain.UserVO;

public interface UserService {
    
    // 회원 가입 처리
    void register(UserVO userVO) throws Exception;
    
    UserVO login(LoginDTO loginDTO) throws Exception;
    
}