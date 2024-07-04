package com.hello.HelloSpring.bean;

import java.util.List;

import lombok.Data;

@Data
public class MemberBean {
	
	private String name;
	private int age;
	private boolean isStudent;
	// 객체
	private AddressBean address;
	private List<String> languages;
}
