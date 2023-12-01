package com.sist.view;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import com.sist.dao.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.write("<!DOCTYPE html>");
		// doctype html => 5버전 => 아이디,비번 입력안할경우 못넘어가게 => 유효성 처리 
		// doctype을 쓰지 않으면 4버전이 default => 유효성검사가 안됨
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.write("<style>");
		out.write(".container{margin-top:50px}");
		out.write(".row{margin:0px auto;width;300px}");
		out.write("h3{text-align:center}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div class=container>");
		out.write("<div class=row>");
		out.write("<form method=post action=LoginServlet>");
		// 로그인 서블릿의 post을 호출한다 (받은 값을 로그인서블릿의 post로 보내서 처리할거임)
		out.write("<table class=table>");
		
		out.write("<tr>");
		out.write("<th width:20% class=\"text-center danger\">ID</th>");
		out.write("<td width:80%>");
		out.write("<input type=text name=id size=15 required>");
		out.write("</td>");
		out.write("</tr>");
		
		out.write("<tr>");
		out.write("<th width:20% class=\"text-center danger\">PW</th>");
		out.write("<td width:80%>");
		out.write("<input type=password name=pwd size=15 required>");
		out.write("</td>");
		out.write("</tr>");
		
		out.write("<tr>");
		out.write("<td colspan=2 class=text-center>");
		out.write("<input type=submit value=로그인 class=\"btn btn-sm btn-primary\">");
		out.write("</td>");
		out.write("</tr>");
			
		
		out.write("</table>");
		out.write("</div>");
		out.write("</div>");
		out.write("</body>");
		out.write("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get에서 받은 id,비번으로 로그인 처리, 회원가입 처리...
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		// 1. 전송값을 받는다
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		// input에 입력된 값을 request로 받음 (받을때는 name의 값을 적어준다)
		// 사용자가 보내준값은 request에 다있음 => tomcat이 request에 있는 값을 호출한다
		// 2. DAO연동
		MemberDAO dao=MemberDAO.newInstancce();
		MemberVO vo=dao.memberLogin(id, pwd);
		if(vo.getMsg().equals("OK")) {
			// 화면 이동 
			HttpSession session=request.getSession();
			// 사용자가 가지고 있다 (브라우저마다 한개씩 생성)
			/*
				session : 서버에 저장
						  => 저장시에 Object로 저장이 가능
						  ** 쿠키는 단점이 문자열만 저장이 가능
						  ** 장바구니 => session
						  =====================
			 */
			session.setAttribute("id", id);
			session.setAttribute("name", vo.getName());
			// Map방식 => 키가 중복되면 안된다 => 중복되면 덮어쓴다
			// 회원수정 => 이름 변경 = session에 다시 저장
			// session.setMaxInactiveInterval(0)
			// 저장기간의 디폴트 => 1800 => 30분
			/*
					1. setAttribute() => 세션에 저장
					2. getAttribute() => 세션에 저장된 값 읽기
					3. removeAttribute(키) => 키만 삭제
					4. invalidate() => 전체 삭제 => 로그아웃
					5. isNew() => 저장된것이 처음인가
					6. setMaxinactiveInterval() : 기간설정
						=> 기본 디폴트가 30분 (초단위 저장 => 1800초)
					7. getId() => session생성시마다 자동 생성
						=> 클라이언트마다 1개만 가지고 있다
						=> 채팅
					================================= session 주요메소드
			 */
			response.sendRedirect("MainServlet");
		}
		// ES5 => ES6 => ; 생략가능
		// 지금쓰는 버전은 ES5라 ; 생략불가
		else if(vo.getMsg().equals("NOID")) {
			out.write("<script>");
			out.write("alert(\"아이디가 존재하지 않습니다.\");");
			out.write("history.back();");
			out.write("</script>");
		}
		else if(vo.getMsg().equals("NOPWD")) {
			out.write("<script>");
			out.write("alert(\"비밀번호가 틀립니다.\");");
			out.write("history.back();");
			out.write("</script>");
			
		}
	}

}
