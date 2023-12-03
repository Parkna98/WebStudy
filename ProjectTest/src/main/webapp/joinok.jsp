<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.sql.*,com.sist.dao.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	String name=request.getParameter("name");
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String msg="";
	MemberDAO dao=MemberDAO.newInstance();
	MemberVO vo=new MemberVO();
	vo.setId(id);
	vo.setPwd(pwd);
	vo.setName(name);
	vo.setMsg(msg);
	dao.memberInsert(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	response.sendRedirect("login.jsp");
%>
</body>
</html>