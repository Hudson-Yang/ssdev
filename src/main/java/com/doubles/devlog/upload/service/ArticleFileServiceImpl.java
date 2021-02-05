package com.doubles.devlog.upload.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doubles.devlog.article.persistence.ArticleDAO;
import com.doubles.devlog.upload.persistence.ArticleFileDAO;

@Service
public class ArticleFileServiceImpl implements ArticleFileService {

	private final ArticleDAO articleDAO;
    private final ArticleFileDAO articleFileDAO;

    @Inject
    public ArticleFileServiceImpl(ArticleDAO articleDAO, ArticleFileDAO articleFileDAO) {
    	this.articleDAO = articleDAO;
        this.articleFileDAO = articleFileDAO;
    }

    @Override
    public List<String> getArticleFiles(Integer articleNo) throws Exception {
        return articleFileDAO.getArticleFiles(articleNo);
    }

    @Transactional
    @Override
    public void deleteFile(String fileName, Integer articleNo) throws Exception {
        articleFileDAO.deleteFile(fileName);
        articleDAO.delete(articleNo);
    }
}
