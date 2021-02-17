package com.doubles.devlog.article.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.doubles.devlog.article.domain.ArticleVO;
import com.doubles.devlog.article.persistence.ArticleDAO;
import com.doubles.devlog.commons.paging.Criteria;
import com.doubles.devlog.commons.paging.SearchCriteria;
import com.doubles.devlog.upload.domain.ArticleFileVO;
import com.doubles.devlog.upload.persistence.ArticleFileDAO;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDAO articleDAO;
    private final ArticleFileDAO articleFileDAO;

    @Inject
    public ArticleServiceImpl(ArticleDAO articleDAO,ArticleFileDAO articleFileDAO) {
        this.articleDAO = articleDAO;
        this.articleFileDAO = articleFileDAO;
    }

    @Override
    public void create(ArticleVO articleVO) throws Exception {
        articleDAO.create(articleVO);
        String[] files = articleVO.getFiles();
        int articleNo = articleVO.getArticleNo();
        
        ArticleFileVO articleFileVO;
        
        if (files == null)
            return;

        // 게시글 첨부파일 입력처리
        for (int i=0 ; i<files.length ; i++) {
        	articleFileVO = new ArticleFileVO();
        	articleFileVO.setArticleNo(articleNo);
        	articleFileVO.setFileName(files[i]);
            articleFileDAO.addFile(articleFileVO);
        }
    }
    
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public ArticleVO read(Integer articleNo) throws Exception {
    	articleDAO.updateViewCnt(articleNo);
        return articleDAO.read(articleNo);
    }

    @Transactional
    @Override
    public void update(ArticleVO articleVO) throws Exception {
        Integer articleNo = articleVO.getArticleNo();
        String[] files = articleVO.getFiles();

        articleDAO.update(articleVO);
        articleFileDAO.deleteFiles(articleNo);

        if (files == null)
            return;
        for (String fileName : files)
            articleFileDAO.replaceFile(fileName, articleNo);
    }

    @Override
    public void delete(Integer articleNo) throws Exception {
        articleDAO.delete(articleNo);
    }

    @Override
    public List<ArticleVO> listAll() throws Exception {
        return articleDAO.listAll();
    }
    
    @Override
    public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
        return articleDAO.listCriteria(criteria);
    }
    
    @Override
    public int countArticles(Criteria criteria) throws Exception {
        return articleDAO.countArticles(criteria);
    }
    
    @Override
    public List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception {
        return articleDAO.listSearch(searchCriteria);
    }

    @Override
    public int countSearchedArticles(SearchCriteria searchCriteria) throws Exception {
        return articleDAO.countSearchedArticles(searchCriteria);
    }
    
}