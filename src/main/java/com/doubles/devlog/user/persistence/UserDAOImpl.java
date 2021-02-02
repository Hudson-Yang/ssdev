package com.doubles.devlog.user.persistence;

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
}