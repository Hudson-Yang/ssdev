package com.doubles.devlog.article.domain;

import java.util.Date;

public class ArticleVO {

    private Integer articleNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    
	public Integer getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		System.out.println("ArticleVO에서 찍어본 세터 씨스아웃:"+articleNo);
		this.articleNo = articleNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	private int viewCnt;
	
	@Override
	public String toString() {
		return "ArticleVO [articleNo=" + articleNo + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}

}