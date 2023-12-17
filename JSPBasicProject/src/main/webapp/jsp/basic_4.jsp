<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sist.dao.*" %>
<%--
	1. 데이터 읽기
		1) import를 설정 (콤마로 나열, 낱개로 쓰기)
		   <%@ import="java.util.*,com.sist.dao.*"%>
		   	
		   <%@ import="java.util.*"%>
		   <%@ import="com.sist.dao.*"%>
		   
	2. html의 해당위치에 <% %> => for
		=> 데이터 출력은 <%= %>
		=> 중심이 View (화면 출력)
		
	3. 
--%>
<%
	EmpDAO dao=EmpDAO.newInstance();
	List<EmpVO> list=dao.empListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/table.css">
<style type="text/css">
	.container{
		margin-top: 50px;
		width:100%;
		margin: 0px auto;
	}
	h1{
		text-align: center;
	}
	.row,.table-content{
		width:800px;
		margin: 0px auto; /* 가운데 정렬 */
	}
</style>
</head>
<body>
   <div class="container">
	<div class="row">
	<h1>사원 목록</h1>
	<table class="table_content" width=800>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직위</th>
			<th>입사일</th>
			<th>급여</th>
		</tr>
		<%--
			<% 자바 소스 %> : 메소드 안에 들어가는 자바소스
							모든 소스는 자바 문법을 사용한다
							명령문; (;을 사용한다)
			<%= 출력물 %> : out.println(~~~~) ~~에 들어가는 소스 => ;을 사용하지 않는다
			= 자바 / HTML을 구분
			= 모든 소스는 _jspService()안에 첨부 => 톰캣이 자동 처리
			  WAS => 톰캣 => JSP/Servlet 엔진 (JSP와 Servlet을 번역해주고 java로 변환 (클래스파일) ) 
			  형상관리 => GIT
		--%>
		<%
			for(EmpVO vo:list){
		%>
				<tr class="dataTr">
					<td class="text-center"><%=vo.getEmpno() %></td>
					<td class="text-center"><%=vo.getEname() %></td>
					<td class="text-center"><%=vo.getJob() %></td>
					<td class="text-center"><%=vo.getHiredate().toString() %></td>
					<td class="text-center"><%=vo.getSal() %></td>
				</tr>
		<%		
			}
		%>
	</table>
	</div>
	</div>
</body>
</html>




