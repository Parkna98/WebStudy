<%@page import="com.sist.model.SawonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
		JSTL
		==== Java Standard Tag Library
		<% %> => 태그형으로 제작
		 =================================================================================
		  = 1. 변수 선언	=> int a=10; 
		  		=> <c:set var="a" value="10"/>
		  		
		    2. 제어문 
		    	for(int i=0;i<10;i++){}
		    	=> <c:forEach var="i" begin="1" end="10" step="1">
		    	for(SawonVO vo:list)
		    	=> <c:forEach var="vo" items="list" varStatus="in">
		    										=============== 인덱스번호를 하나씩 가져온다
		    										=> 번호출력 / 다른 List
		    										
		    	StringTokenizer st=new StringTokenizer(value,delim);
		    	while(st.hasMoreTokens()){}
		    	=> <c:forTokens var="" value="" delim="">
		    	
		    	=> <c:if> 조건문
		    	   <c:if test="${}">
		    	   		 ========== 조건문
		    	   => if(test)
		    	   => 단점 => else문장이 없다
		    	   			============== 사용자 정의 (회사마다 다름)
		    	=> 다중 조건문 (switch) => XML로 제작
		    		   XML
		    		   ===
		    		    1. 태그나 속성 => 대문자 구분
		    		    2. 속성값 => ""
		    		    3. 계층구조 => 여는태그 / 닫는태그 일치
		    		    	=> <jsp:include>
		    	   <c:choose>
		    	   	 <c:when test="조건문">출력</c:when>
		    	   	 <c:when test="조건문">출력</c:when>
		    	   	 <c:when test="조건문">출력</c:when>
		    	   	 <c:when test="조건문">출력</c:when>
		    	   	 <c:otherwise>default</c:otherwise>
		    	   </c:choose>
		    	   	 
		    3. 화면 이동
		    	<c:redirect url=""/>
		    	=> response.sendRedirect(url)
		    4. 화면 출력
		    	<%= %>
		    	<c:out value=""> => Jquery => $
		    	${} => import가 동일하게 있으면 오류 발생
		 core==================================================================================
		    5. 날짜 변환 / 숫자 변환
		       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd")
		       <fmt:formatDate value="" pattern="yyyy-MM-dd">
		       => 오라클에서 => TO_CHAR(regdate,'YYYY-MM-DD')
		       DecimalFormat d=new DecimalFormat("###,###");
		       <fmt:formatNumber value="" type="currency">
		 format================================================================================
		    6. 메소드 호출
		 functions=============================================================================
 --%>
<%
		// JSTL => 출력은 EL
		List<String> nList=new ArrayList<String>();
		nList.add("홍길동");
		nList.add("이순신");
		nList.add("강감찬");
		nList.add("심청이");
		nList.add("박문수");
		
		List<String> sList=new ArrayList<String>();
		sList.add("남자");
		sList.add("남자");
		sList.add("남자");
		sList.add("여자");
		sList.add("남자");
		
		request.setAttribute("nList", nList);
%>
<c:set var="sList" value="<%=sList %>"/>
<!-- c:set은 일반 변수가 아니라 request.setAttribute(var,value) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>이름</h1>
  <ul>
    <%-- for(String name:nList --%>
    <c:forEach var="name" items="${nList }">
      <li>${name }</li>
    </c:forEach>
  </ul>
  <h1>성별</h1>
  <ul>
  	<c:forEach var="sex" items="${sList }">
  	  <li>${sex }</li>
  	</c:forEach>
  </ul>
  <h1>이름(성별)</h1>
  <ul>
    <%-- 여러개의 리스트를 같이 출력할때 varStatus를 사용해서 인덱스번호 이용해서 출력 0번부터 시작!! (배열에 사용) --%>
    <%-- 예약날짜 설정할때 사용함 => 예약가능날짜 + 선택날짜 ? --%>
    <%-- .index로 사용 --%>
    <c:forEach var="name" items="${nList }" varStatus="s">
      <li>${s.index+1 }.${name }(${sList[s.index] })</li>
    </c:forEach>
  </ul>
</body>
</html>