package com.mybatis.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.mybatis.board.service.BoardServiceImpl;
import com.mybatis.board.vo.Board;
import com.mybatis.common.template.Pagination;
import com.mybatis.common.vo.PageInfo;


public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 totalRecord :	현재 총 게시글의 갯수 (26) 
		 nowPage :		현재 페이지(즉, 사용자가 요청한 페이지)
		 numPerPage :	현재 페이지에 보여줄 게시글의 최대갯수  (5)
		 pagePerBlock :	페이지 하단에 보여질 페이징바의 페이지 최대갯수 (5)
		 
		 // 위의 4개를 가지고 값을 구함
		 totalPage : 	가장 마지막 페이지(총 페이지 수) => 6
		 startPage :	하단에 페이징바의 시작 페이지
		 endPage :		하단에 페이징바의 끝 페이지
		 */
		
		int totalRecord = new BoardServiceImpl().selectTotalRecord();
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		
		PageInfo pi = Pagination.getPageInfo(totalRecord, nowPage, 5, 2);
		ArrayList<Board> list = new BoardServiceImpl().selectList(pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
	}

}
