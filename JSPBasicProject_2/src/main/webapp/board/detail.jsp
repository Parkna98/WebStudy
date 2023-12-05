<%@page import="com.sist.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String no=request.getParameter("no");
	BoardDAO dao=BoardDAO.newInstance();
	BoardVO vo=dao.boardDetail(Integer.parseInt(no));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<img id="main" src="https://i0.wp.com/aikidonews.co.kr/wp-content/uploads/2017/03/QA-e1488530256249.jpg?resize=500%2C269" width="700" height="130" >		
		<table class="table_content" width="800">
			<tr>
				<th width=20%>이름</th>
				<td width=80%><%=vo.getName() %>
				</td>
			</tr>
			<tr>
				<th width=20%>제목</th>
				<td width=80%><%=vo.getSubject() %>
				</td>
			</tr>
			<tr>
				<th width=20%>내용</th>
				<td width=80%><%=vo.getContent()%>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>