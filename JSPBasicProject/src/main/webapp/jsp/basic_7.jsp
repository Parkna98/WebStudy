<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%--
	139page
		= 지시자
		  page : jsp파일에 대한 정보
		  	=> JSP의 시작점
		  	=> 1. contentType = 실행시 변경될 파일 형식
		  		  => 자바로 변경 : response.setContentType()
		  		  => html => text/html;charset=UTF-8
		  		  					   ============= 생략하면 한글 깨짐
		  		  					    default => charset=ISO-8859-1
		  		  	 xml => text/xml;charset=UTF-8
		  		  	 json => text/plain;charset=UTF-8
		  		  	 => 브라우저에 알려 준다
		  		  	 => page안에서 1번만 사용이 가능
		  		  	  
		  	   2. import = 외부 라이브러리 첨부
		  	   		=> java.lang, javax.http.servlet
		  	   		   ============================= 생략이 가능
		  	   		=> 사용형식 => 2가지 (콤마로 나열, 따로쓰기)
		  	   		   <%@ page import="java.util.*,java.io.*"%>
		  	   		   <%@ page import="111"%>	   
		  	   		   <%@ page import="222"%>	   
		  	   		
		  	   3. buffer = html을 저장하는 메모리 공간
		  	   		=> 8kb 
		  	   		=> html이 출력을 할때 용량 부족시에는 증가
		  	   		   buffer="16kb" => 출력스트림
		  	   		   
		  	   4. errorPage => 에러시에 호출되는 파일
		  	   		
		  taglib : 태그로 자바 기본 문법을 제공 => jstl/el
		  include : JSP안에 다른 JSP를 첨부
		  <%@ 지시자명 속성="값" 속성="값"%>
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