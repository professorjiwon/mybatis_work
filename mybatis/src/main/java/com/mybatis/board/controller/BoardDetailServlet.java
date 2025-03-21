package com.mybatis.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 조회수 증가 시키기
		
		// 조회수 증가가 잘 되었으면 검색하여 boardDetailView.jsp로 가져가기
		
		request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);
	}

}
