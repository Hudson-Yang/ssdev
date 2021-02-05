package com.doubles.devlog.upload.persistence;

import java.util.List;

import com.doubles.devlog.upload.domain.ArticleFileVO;

public interface ArticleFileDAO {

    // 파일 추가
    void addFile(String fileName) throws Exception;
    
    // 파일 목록
    List<String> getArticleFiles(Integer articleNo) throws Exception;

    // 파일 삭제
    void deleteFile(String fileName) throws Exception;

    // 파일 전체 삭제
    void deleteFiles(Integer articleNo) throws Exception;

    // 파일 수정
    void replaceFile(String fileName, Integer articleNo) throws Exception;

    // 파일 갯수 갱신
    void updateFileCnt(Integer articleNo) throws Exception;
    
}  