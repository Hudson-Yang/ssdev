package com.doubles.devlog.tutorial.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.doubles.devlog.tutorial.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Inject
    SqlSession sqlSession;

    private static final String NAMESPACE = "com.doubles.mappers.memberMapper";

    @Override
    public String getTime() {
        return sqlSession.selectOne(NAMESPACE + ".getTime");
    }

    @Override
    public void insertMember(MemberVO memberVO) {
        sqlSession.insert(NAMESPACE + ".insertMember", memberVO);
    }

    @Override
    public MemberVO readMember(String userid) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".selectMember", userid);
    }

    @Override
    public MemberVO readWithPW(String userid, String userpw) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userid", userid);
        paramMap.put("userpw", userpw);
        return sqlSession.selectOne(NAMESPACE + ".readWithPW", paramMap);
    }

}