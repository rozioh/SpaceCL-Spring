package com.hello.hellospring.common.bean;

import lombok.Data;

@Data
public class BoardBean {
	private String boardNo;
	private String title;
	private String contents;
	private String secretYn;
	private String count;
	private String memberNo;
	private String regDt;
	private String memberName;
	private Integer page;
	private String search;
}
