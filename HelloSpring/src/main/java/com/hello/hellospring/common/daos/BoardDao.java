package com.hello.hellospring.common.daos;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hello.hellospring.common.bean.BoardBean;

@Mapper
public interface BoardDao {
	
	// 1건 삭제 D
	public int deleteBoardFromMemberNo(BoardBean boardBean);

	//1건 조회
	public BoardBean selectBoard(BoardBean bean);
	
	//여러건 조회
	public List<BoardBean> selectBoardList(BoardBean bean);
	
	//전체 글의 갯수 조회
	public int selectBoardListCount(BoardBean bean);
	
	//1건 입력
	public int insertBoard(BoardBean bean);
	
	//1건 수정
	public int updateBoard(BoardBean bean);
	
	//1건 삭제
	public int deleteBoard(BoardBean bean);
	
}
