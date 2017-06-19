package com.prj.Culture.board.dto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
		
	    private int seq;
	    private String writer;
	    private String title;
	    private String content;
	    private String pwd;
	    private int hit;
	    private Date regdate;
	    private MultipartFile upload;
	    private String filename;
	    private String oldFileName;
	    private String realname;
	    
	    /** 이전글 / 다음글 ***/
	    private int next_seq;
	    private String next_title;
	    private int pre_seq;
	    private String pre_title;
	    
	    
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq = seq;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
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
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public int getHit() {
			return hit;
		}
		public void setHit(int hit) {
			this.hit = hit;
		}
		public Date getRegdate() {
			return regdate;
		}
		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}
		public MultipartFile getUpload() {
			return upload;
		}
		public void setUpload(MultipartFile upload) {
			this.upload = upload;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		public String getOldFileName() {
			return oldFileName;
		}
		public void setOldFileName(String oldFileName) {
			this.oldFileName = oldFileName;
		}
		public String getRealname() {
			return realname;
		}
		public void setRealname(String realname) {
			this.realname = realname;
		}
		public int getNext_seq() {
			return next_seq;
		}
		public void setNext_seq(int next_seq) {
			this.next_seq = next_seq;
		}
		public String getNext_title() {
			return next_title;
		}
		public void setNext_title(String next_title) {
			this.next_title = next_title;
		}
		public int getPre_seq() {
			return pre_seq;
		}
		public void setPre_seq(int pre_seq) {
			this.pre_seq = pre_seq;
		}
		public String getPre_title() {
			return pre_title;
		}
		public void setPre_title(String pre_title) {
			this.pre_title = pre_title;
		}
}
