package com.doubles.devlog.user.persistence;

import java.util.Date;

import com.doubles.devlog.user.domain.LoginDTO;
import com.doubles.devlog.user.domain.UserVO;

public interface UserDAO {
    
    // 회원가입 처리
    void register(UserVO userVO) throws Exception;
    
    // 로그인 처리
    UserVO login(LoginDTO loginDTO) throws Exception;
    
    // 로그인 유지 처리
    void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception;

    // 세션키 검증
    UserVO checkUserWithSessionKey(String value) throws Exception;
    
    // 글쓴이와 아이디 비교하여 프로필사진 찾기 
    UserVO findUserImg(String userId) throws Exception;
}