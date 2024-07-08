package com.hello.hellospring.common.daos;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hello.hellospring.common.bean.MemberBean;

@Mapper
public interface MemberDao {
	
	// 1건 조회 R
	public MemberBean selectMember(MemberBean mBean);
	
	// 여러 건 조회 R
	public List<MemberBean> selectMemberList(MemberBean bean);
	
	// 검색 조회 R
	public List<MemberBean> selectMemberSearch(MemberBean bean);
	
	// 1건 입력 int인 것은 결과 row 수 확인려고 함. C
	public int insertMember(MemberBean bean);
	
	// 1건 수정 U
	public int updateMember(MemberBean bean);
	
	// 1건 삭제 D
	public int deleteMember(MemberBean bean);
}
