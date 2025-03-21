package com.mybatis.board.service;

import java.util.ArrayList;

import com.mybatis.board.vo.Board;
import com.mybatis.board.vo.Reply;
import com.mybatis.common.vo.PageInfo;

public interface BoardService {
	// 게시판 리스트 조회
	int selectTotalRecord();
	ArrayList<Board> selectList(PageInfo pi);
	
	// 게시판 상세조회
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);
	ArrayList<Reply> selectReplyList(int boardNo);
}
