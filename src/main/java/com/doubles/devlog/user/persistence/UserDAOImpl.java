package com.doubles.devlog.user.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.doubles.devlog.user.domain.LoginDTO;
import com.doubles.devlog.user.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
    
    private static final String NAMESPACE = "com.doubles.devlog.mappers.user.userMapper";
    
    private final SqlSession sqlSession;

    @Inject
    public UserDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    // 회원가입처리
    @Override
    public void register(UserVO userVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".register", userVO);
    }
    
   // 로그인 처리
    @Override
    public UserVO login(LoginDTO loginDTO) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".login", loginDTO);
    }
    
    // 로그인 유지 처리
    @Override
    public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("sessionId", sessionId);
        paramMap.put("sessionLimit", sessionLimit);

        sqlSession.update(NAMESPACE + ".keepLogin", paramMap);
    }

    // 세션키 검증
    @Override
    public UserVO checkUserWithSessionKey(String value) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".checkUserWithSessionKey", value);
    }
}