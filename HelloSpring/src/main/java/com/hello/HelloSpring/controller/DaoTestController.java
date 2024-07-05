package com.hello.hellospring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.hellospring.common.bean.MemberBean;
import com.hello.hellospring.common.daos.MemberDao;

@Controller
public class DaoTestController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value = "/selectMember", method = {RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> selectMember(MemberBean bean) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		MemberBean resBean = memberDao.selectMember(bean);
		if(resBean != null) {
			map.put("memberBean", resBean);
		}else { // 해당 멤버가 존재하지 않을 때
			map.put("memberBean", "존재하지 않는 id 멤버 입니다.");
		}
		
		return map;
	}
	
	@RequestMapping(value = "/selectMemberList", method = {RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> selectMemberList(MemberBean bean) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MemberBean> memberList= memberDao.selectMemberList(bean);
		map.put("memberList", memberList);
		
		return map;
	}
	
	@RequestMapping(value = "/selectMemberSearch", method = {RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> selectMemberSearch(MemberBean bean) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MemberBean> memberSearch= memberDao.selectMemberSearch(bean);
		map.put("memberSearch", memberSearch);
		
		return map;
	}
	
}
