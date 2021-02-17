package com.doubles.devlog.article.service;

import java.util.List;

import com.doubles.devlog.article.domain.ArticleVO;
import com.doubles.devlog.commons.paging.Criteria;
import com.doubles.devlog.commons.paging.SearchCriteria;
import com.doubles.devlog.user.domain.LoginDTO;
import com.doubles.devlog.user.domain.UserVO;

public interface ArticleService {

    void create(ArticleVO articleVO) throws Exception;

    ArticleVO read(Integer articleNo) throws Exception;

    void update(ArticleVO articleVO) throws Exception;

    void delete(Integer articleNo) throws Exception;

    List<ArticleVO> listAll() throws Exception;
    
    List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
    
    int countArticles(Criteria criteria) throws Exception;
    
    List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception;

    int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;    
}