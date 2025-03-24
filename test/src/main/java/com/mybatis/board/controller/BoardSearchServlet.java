package com.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mybatis.board.service.BoardService;
import com.mybatis.board.service.BoardServiceimpl;
import com.mybatis.board.vo.Board;
import com.mybatis.common.template.Pagination;
import com.mybatis.common.vo.PageInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		
		// keyField와 keyWord 2개를 모두 담으려면 vo에 bean을 만들어 넣어서 넘겨주던지
		// 2개를 모두 담을 수 있는 컬렉션에 담던지 해야됨
		// HashMap을 이용하여 저장
		HashMap<String, String> map = new HashMap<>();
		map.put("keyField", keyField); // keyField 키값에 keyField로 받은 값을 넣는다
		map.put("keyWord", keyWord);
		
		BoardService bService = new BoardServiceimpl();
		
		//페이지 처리를 위해 검색 조건에 맞는 모든 게시글의 총 갯수
		int searchCount = bService.selectSearchCount(map);
		
		PageInfo pi = Pagination.getPageInfo(searchCount, nowPage, 5, 2);
		ArrayList<Board> list = bService.selectSearchList(map, pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.setAttribute("keyField", keyField);
		request.setAttribute("keyWord", keyWord);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
	}
}