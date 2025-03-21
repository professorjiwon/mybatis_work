package com.mybatis.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.board.vo.Board;
import com.mybatis.common.vo.PageInfo;

public class BoardDao {

	public int selectTotalRecord(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectTotalRecord");
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		// 마이바티스에서 페이징처리를 위해 RowBounds라는 클래스 제공
		/*
		 * offset : 몇개의 게시글을 건너뛰고 조회할 건인지에 대한 값
		 * limit : 조회할 숫자
		 ex) numPerPage : 5
		 					  offset	limit
		 nowPage : 1	1~5		0		  5    = 0   
		 nowPage : 2	6~10	5		  5	   = 5	
		 nowPage : 3	11~15	10		  5    = 10
		 nowPage : 4	16~19   15		  4			
		 */
		
		int limit = pi.getNumPerPage();
		int offset = (pi.getNowPage()-1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		/*
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
		return list;
		*/
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}

}






