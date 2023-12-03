<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String gno=request.getParameter("sno");
	String typeno=request.getParameter("typeno");
	String msg=request.getParameter("msg");
	String score=request.getParameter("score");
	Double sco=Double.parseDouble(score);
	String star=request.getParameter("star");
	
	session=request.getSession();
	String id=(String)session.getAttribute("id");
	String name=(String)session.getAttribute("name");
	
	ReviewVO vo=new ReviewVO();
	vo.setId(id);
	vo.setName(name);
	vo.setMsg(msg);
	vo.setGno(Integer.parseInt(gno));
	vo.setTypeno(Integer.parseInt(typeno));
	vo.setScore(sco);
	vo.setStar(star);
	
	// DAO 연동
	ReviewDAO dao=ReviewDAO.newInstance();
	dao.reviewInsert(vo);
	
	// 화면이동
	response.sendRedirect("staydetail.jsp?sno="+gno);
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