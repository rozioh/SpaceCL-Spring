package com.hello.hellospring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.hellospring.common.bean.AddressBean;
import com.hello.hellospring.common.bean.MemberTestBean;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

	@RequestMapping(value = "/firstHello", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> firstHello(String name) throws Exception{
		
		System.out.println("name = " + name);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		MemberTestBean memberBean = new MemberTestBean();
		if(name != null) {
			memberBean.setName(name);
		}
		memberBean.setName("John");
		memberBean.setAge(20);
		memberBean.setStudent(true);
		
		AddressBean addrBean = new AddressBean();
		addrBean.setCity("서울");
		addrBean.setStreet("금천구");
		memberBean.setAddress(addrBean);
		
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("python");
		list.add("java script");
		memberBean.setLanguages(list);
		
		// 최종적으로 map에 넣어준다.
		map.put("memberBean", memberBean);
		
		return map;
		
	}
}
