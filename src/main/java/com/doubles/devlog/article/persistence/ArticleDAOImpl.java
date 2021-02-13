package com.doubles.devlog.article.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.doubles.devlog.article.domain.ArticleVO;
import com.doubles.devlog.commons.paging.Criteria;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

    private static final String NAMESPACE = "com.doubles.devlog.mappers.article.ArticleMapper";

    private final SqlSession sqlSession;

    @Inject
    public ArticleDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(ArticleVO articleVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".create", articleVO);
    }

    @Override
    public ArticleVO read(Integer articleNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".read", articleNo);
    }

    @Override
    public void update(ArticleVO articleVO) throws Exception {
        sqlSession.update(NAMESPACE + ".update", articleVO);
    }

    @Override
    public void delete(Integer articleNo) throws Exception {
        sqlSession.delete(NAMESPACE + ".delete", articleNo);
    }

    @Override
    public List<ArticleVO> listAll() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listAll");
    }
    
    @Override
    public List<ArticleVO> listPaging(int page) throws Exception {
    	
    	// 0이 넘어오지 않게
        if (page <= 0) {
            page = 1;
        }
        page = (page - 1) * 10;

        return sqlSession.selectList(NAMESPACE + ".listPaging", page);
    }
    
    @Override
    public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
    }
    
    @Override
    public int countArticles(Criteria criteria) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".countArticles", criteria);
    }
    
    @Override
    public List<ArticleVO> listSearch(Criteria criteria) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listSearch", criteria);
    }

    @Override
    public int countSearchedArticles(Criteria criteria) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".countSearchedArticles", criteria);
    }
    
    @Override
    public void updateReplyCnt(Integer articleNo, int amount) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("articleNo", articleNo);
        paramMap.put("amount", amount);

        sqlSession.update(NAMESPACE + ".updateReplyCnt", paramMap);
    }

    @Override
    public void updateViewCnt(Integer articleNo) throws Exception {
        sqlSession.update(NAMESPACE + ".updateViewCnt", articleNo);
    }
}