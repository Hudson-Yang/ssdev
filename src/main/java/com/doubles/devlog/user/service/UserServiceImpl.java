package com.doubles.devlog.user.service;

import java.util.Date;

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
    
    @Override
    public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
        userDAO.keepLogin(userId, sessionId, sessionLimit);
    }

    @Override
    public UserVO checkLoginBefore(String value) throws Exception {
        return userDAO.checkUserWithSessionKey(value);
    }
    
    // 게시글 작성자와 유저 검색
    @Override
    public UserVO findUserImg(String userId) throws Exception{
    	return userDAO.findUserImg(userId);
    }
    
}