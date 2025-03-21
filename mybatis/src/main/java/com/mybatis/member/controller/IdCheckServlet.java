package com.mybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mybatis.member.service.MemberServiceImpl;

public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("checkId");
		/*
		MemberServiceImpl ms = new MemberServiceImpl();
		int result = ms.checkId(userId);
		*/
		int result = new MemberServiceImpl().checkId(userId);
		if(result > 0) {
			response.getWriter().print("idN");
		} else {
			response.getWriter().print("idY");
		}
	}
}
