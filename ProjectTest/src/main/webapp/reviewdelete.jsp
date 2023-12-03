<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
	String rno=request.getParameter("rno");
	String typeno=request.getParameter("typeno");
	String sno=request.getParameter("sno");
	ReviewDAO dao=ReviewDAO.newInstance();
	dao.reviewDelete(Integer.parseInt(rno));
	response.sendRedirect("staydetail.jsp?sno="+sno);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>