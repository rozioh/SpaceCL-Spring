package com.hello.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hello.hellospring.common.bean.BoardBean;
import com.hello.hellospring.common.bean.MemberBean;
import com.hello.hellospring.common.daos.BoardDao;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	/**
	 * 해당 멤버의 모든 게시글 삭제
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	public int deleteBoard(MemberBean memberBean) throws Exception {
		
		BoardBean boardBean = new BoardBean();
		boardBean.setMemberNo( memberBean.getMemberNo() );
		
		int delBoardRow = boardDao.deleteBoardFromMemberNo(boardBean);
		
		if(delBoardRow > 0) {
			return 1;
		}else {
			throw new Exception("보드 테이블의 게시글이 삭제되지 않았습니다.");
		}
	}
	
	public int insertBoard(BoardBean bean) throws Exception{
		
		int insertBoardRow = boardDao.insertBoard(bean);
		
		if(insertBoardRow > 0) {
			return 1;
		}else {
			throw new Exception("게시글 등록이 되지 않았습니다.");
		}
	}
	
	public int updateBoard(BoardBean bean) {
		return boardDao.updateBoard(bean);
	}
	
	public int deleteBoard(BoardBean bean) {
		return boardDao.deleteBoard(bean);
	}

	public BoardBean selectBoard(BoardBean bean) {
		return boardDao.selectBoard(bean);
	}

	public List<BoardBean> selecetBoardList(BoardBean bean) {
		return boardDao.selectBoardList(bean);
	}
}
