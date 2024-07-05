package com.hello.HelloSpring.common.bean;

import lombok.Data;

@Data
public class MemberBean {
	private String memberNo;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String birthdate;
	private String hp;
	private String addr;
	private String last_login_dt;
	private String reg_dt;
}
