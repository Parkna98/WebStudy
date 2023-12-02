<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
	String sno=request.getParameter("sno");
	Cookie cookie=new Cookie("stay_"+sno,sno);
	//							키		  값  => map => 키가 중복되면 안됨 (중복되면 튕겨나감)
	// 저장위치
	cookie.setPath("/");
	// 저장기간
	cookie.setMaxAge(60*60*24); // 24시간저장 (초단위)
	// 클라이언트로 전송
	response.addCookie(cookie);
	// 상세보기로 이동해라
	response.sendRedirect("staydetail.jsp?sno="+sno);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>