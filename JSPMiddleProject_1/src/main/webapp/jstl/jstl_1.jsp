<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>&lt;c:forTokens&gt;=> StringTokenizer</h1>
  <%-- var => st.nextToken() --%>
  <%-- items:짜를대상 delims:구분자 var:지역변수 --%>
  <c:forTokens items="m1,m2,m3,m4,m5,m6,m7" delims="," var="image">
    <img src="${image }.jpg" width="150" height="200">
  </c:forTokens>
  
  <%-- step="1" (1씩증가) 1인경우 생략가능! --%>
  <h1>&lt;c:if&gt;</h1>
  <c:forEach var="i" begin="1" end="10">
  <%-- 조건문 test안에 조건문넣으면됨 --%>
  <%-- 문자도 가능 --%>
 	<c:if test="${i%2==0 }">
 	  ${i += "짝" }&nbsp;
 	</c:if>
 	<c:if test="${i%2!=0 }">
 	  ${i+="홀" }&nbsp;
 	</c:if>
  </c:forEach>
</body>
</html>