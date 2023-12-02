<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.sql.*,com.sist.dao.*"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	MemberDAO dao=MemberDAO.newInstance();
	MemberVO vo=dao.memberLogin(id, pwd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
</head>
<body>
<%
	if(vo.getMsg().equals("OK")){
		session=request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("name", vo.getName());
		response.sendRedirect("mainpage.jsp");
	}
	else if(vo.getMsg().equals("NOID")){
%>
		<script>
		alert("아이디가 존재하지 않습니다.");
		history.back();
		</script>
<%		
	}else if(vo.getMsg().equals("NOPWD")){
%>
		<script>
		alert("비밀번호가 일치하지 않습니다.");
		history.back();
		</script>
<%		
	}
%>
</body>
</html>