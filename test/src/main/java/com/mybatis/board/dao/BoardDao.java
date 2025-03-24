package com.mybatis.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.board.vo.Board;
import com.mybatis.board.vo.Reply;
import com.mybatis.common.vo.PageInfo;

public class BoardDao {

	public int selectTotalRecord(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectTotalRecord");
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		// 마이바티스에서 페이징처리를 위해 RowBounds라는 클래스 제공
		/*
		 * offset :  몇개의 게시글을 건너뛰고 조회할 것인지에 대한 값
		 * limit : 조회할 숫자
		 ex) numPerPage : 5
		 	      페이지	게시글  offset limit(몇개 가져올것인지)
		 nowPage : 1    1~5번    0     5개
		 nowPage : 2    6~10번   5     5개
		 nowPage : 3    11~15번  10    5개
		 nowPage : 4    16~19번  15    4개
		*/
		
		int limit = pi.getNumPerPage();
		int offset = (pi.getNowPage()-1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		/*
		 * ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
		 * return list;
		 */
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}

	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}

	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}

	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}

	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int limit =	pi.getNumPerPage();
		int offset = (pi.getNowPage()-1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}

}
