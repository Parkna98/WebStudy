<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		EL	 => 출력
			 => ${request.getAttribute()} => 변수명이 아니고 키명이다
			 		${name}
			 	  ====================== 주로 약식출력
			 	${session.getAttribute()}  
			 	  
		JSTL => 제어문 / URL / 변환 / String메소드 호출
		==== core / format(fmt) / function(fn) 
		==== JSP는 데이터베이스 연동하는 곳이 아니라 => 전송받은 데이터만 출력한다 (View)
			 => 보안문제가 있기때문에 출력만 한다
			 => 자바와 혼합하게 되면 퍼블리셔에서 어려움을 겪는다
			 =====core=======
			 <c:forEach>
			 <c:forTokens>
			 <c:if>
			 <c:choose>
			 <c:set>
			 <c:out>
			 =====format=======
			 <fmt:formatDate>
			 <fmt:formatNumber>
			 =====functions====
			 ${fn:String메소드}
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>