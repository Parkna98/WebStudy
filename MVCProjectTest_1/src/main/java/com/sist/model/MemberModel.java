package com.sist.model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.MemberDAO;

public class MemberModel {
	@RequestMapping("member/join.do")
	public String member_join(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("main_jsp", "../member/jointest.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("member/idcheck.do")
	public String member_idcheck(HttpServletRequest request, HttpServletResponse response) {
		return "../member/idcheck.jsp";
	}
	
	@RequestMapping("member/idcheck_ok.do")
	public void member_idcheck_ok(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		MemberDAO dao=MemberDAO.newInstance();
		int count=dao.memberIdCheck(id);
		try {
			PrintWriter out=response.getWriter();
			out.write(String.valueOf(count));
		}catch(Exception ex) {}
	}
	
	@RequestMapping("member/postfind.do")
	public String member_postfind(HttpServletRequest request,
			  HttpServletResponse response) {
		return "../member/postfind.jsp";
	}
}
