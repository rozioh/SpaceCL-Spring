package com.hello.hellospring.common.daos;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hello.hellospring.common.bean.MemberBean;

@Mapper
public interface MemberDao {
	
	// 1건 조회
	public MemberBean selectMember(MemberBean mBean);
	
	// 여러 건 조회
	public List<MemberBean> selectMemberList(MemberBean bean);
	
	// 검색 조회
	public List<MemberBean> selectMemberSearch(MemberBean bean);
}
