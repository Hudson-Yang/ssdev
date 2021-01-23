package com.doubles.devlog.article.service;

import java.util.List;

import com.doubles.devlog.article.domain.ArticleVO;

public interface ArticleService {

    void create(ArticleVO articleVO) throws Exception;

    ArticleVO read(Integer articleNo) throws Exception;

    void update(ArticleVO articleVO) throws Exception;

    void delete(Integer articleNo) throws Exception;

    List<ArticleVO> listAll() throws Exception;

}