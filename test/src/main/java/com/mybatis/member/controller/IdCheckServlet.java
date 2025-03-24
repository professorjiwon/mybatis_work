package com.mybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mybatis.member.service.MemberServiceimpl;


public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("checkId");
		int result = new MemberServiceimpl().checkId(userId);
		
		if(result == 1) {
			response.getWriter().print("idN");
		} else {
			response.getWriter().print("idY");
		}
	}

}
