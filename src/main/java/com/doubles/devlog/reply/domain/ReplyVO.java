package com.doubles.devlog.reply.domain;

import java.util.Date;

import com.doubles.devlog.user.domain.UserVO;

public class ReplyVO {

	private Integer replyNo;
	private Integer ArticleNo;
	private String replyText;
	private String replyWriter;
	private Date regDate;
	private Date updateDate;
	
	private UserVO userVO;
	
	public Integer getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(Integer replyNo) {
		this.replyNo = replyNo;
	}
	public Integer getArticleNo() {
		return ArticleNo;
	}
	public void setArticleNo(Integer articleNo) {
		ArticleNo = articleNo;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", ArticleNo=" + ArticleNo + ", replyText=" + replyText
				+ ", replyWriter=" + replyWriter + ", regDate=" + regDate + ", updateDate=" + updateDate + ", userVO="
				+ userVO + "]";
	}

}
