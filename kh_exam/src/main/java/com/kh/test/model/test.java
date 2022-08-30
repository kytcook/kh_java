package com.kh.test.model;

public class test {
/************************ 선언부 ************************/
	private int seq = 0;
	private String writer = null;
	private String title = null;
	private String content = null;
	private int regdate = 0;
/************************ 선언부 ************************/
	
/************************ 생성자 ************************/
// 기본생성자
	public test() {

	}
// 오버로딩(?)	
	public test(int seq, String writer, String title, String content, int regdate) {
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}
/************************ 생성자 ************************/
	
/******************* Getter & Setter ******************/
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

	public int getRegdate() {
		return regdate;
	}

	public void setRegdate(int regdate) {
		this.regdate = regdate;
	}
/******************* Getter & Setter ******************/
	
}///////////////////////end of class test