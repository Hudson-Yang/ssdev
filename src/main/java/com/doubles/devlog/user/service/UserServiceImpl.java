package com.doubles.devlog.user.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.doubles.devlog.user.domain.LoginDTO;
import com.doubles.devlog.user.domain.UserVO;
import com.doubles.devlog.user.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Inject
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    // 회원 가입 처리
    @Override
    public void register(UserVO userVO) throws Exception {
        userDAO.register(userVO);
    }
    
    @Override
    public UserVO login(LoginDTO loginDTO) throws Exception {
        return userDAO.login(loginDTO);
    }
    
}