package com.mybatis.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.mybatis.board.service.BoardService;
import com.mybatis.board.service.BoardServiceImpl;

public class BoardSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		
		// keyField와 keyWord 2개를 모두 담으려면 vo에 bean을 만들어 넣어서 넘겨주던지
		// 2개를 모두 담을 수 있는 컬렉션에 담던지 해야됨
		// HashMap을 이용하여 저장
		HashMap<String, String> map = new HashMap<>();
		map.put("keyField", keyField);
		map.put("keyWord", keyWord);
		
		BoardService bService = new BoardServiceImpl();
		// 페이지 처리를 위해 검색조건에 맞는 모든 게시글의 총 갯수
		int searchCount = bService.selectSearchCount(map);
	}

}
