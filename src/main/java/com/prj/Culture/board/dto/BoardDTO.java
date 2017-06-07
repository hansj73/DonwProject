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
}
