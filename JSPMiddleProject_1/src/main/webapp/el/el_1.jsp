<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<%
	SawonVO vo=new SawonVO();
	vo.setName("홍길동");
	vo.setDept("개발부");
	// ${} => request, session
	request.setAttribute("vo",vo); // JSP로 데이터를 추가해서 전송
	session.setAttribute("vo", vo);
	// 제한이 없다 
	SawonVO svo=(SawonVO)request.getAttribute("vo");
%>

<%--
		화면 출력 = 태그형 프로그램 제작 (자바 최소화)
		<%= %> => ${}, <c:out value=""/>
				  === $는 Jquery 라이브러리
		let a=${name} => Jquery로 인식 => <c:out> 으로 출력
		
		${출력물} => 자바의 변수가 아니다
		 ====== request, session
		request.setAttribute("name","홍길동")
		
		<%=request.getAttribute("name") %>
		${name}
		 ====== 키 
		 
		=> getParameter() => ?... GET/POST 
		   setAttribute() => request에 기존에 있는 데이터외에 다른데이터를 추가해서 전송
		   					 데이터베이스...
		=> 새로 추가된 데이터를 읽어서 출력
		
		=> param => getParameter("name")
		   ${param.name} => 키명을 일치시킨다
		   
		1) 연산자
			산술연산자 ( + , - , * , /(div) , %(mod) )
					  => +는 순수하게 산술만 가능 (문자열결합X) => 문자열 결합은 +=
					  => null값은 0으로 인식
					  => "5" + 1 = 6
					  	 === 자동적으로 Integer.parseInt("5")
					  	 / => 정수/정수 = 실수
					  	 
			비교연산자 : if(조건문) => 숫자 / 문자 / 날짜 => equals는 없고 모두 ==으로 비교
					   <c:if test="${vo.getId()==sessionScope.id}">
					   == (eq) ${1==1} ${1 eq 1}
					   != (ne) ${1!=2} ${1 ne 2}
					   <  (lt) 
					   >  (gt)
					   <= (le)
					   >= (ge)
					   
			논리연산자 : 조건문
					   && (and)
					   || (or) 
					   !  (not)
					   
			삼항연산자 : 페이지 ${curpage>1?curpage-1:curpage}
							${curpage<totalpage?curpage+1:curpage}
			=======================================================
			${requestScope.name} => request.getAttribute("name") => 변수명이아니라 키값!!
						  ====== 키
			${sessionScope.id} => session.getAttribute("id") 
			 			  ==== 키
		      => request, session 저장시에 Map형식으로 저장
		      	 ================ 키, 값
		      예) session.setAttribute("admin","1")
		      		=> session.getAttribute("admin","1")
		      		=> ${sessionScope.admin}
		      		
		      	 request.setAttribute("id","hong");
		      	 		 ============ getParameter()로 받을 수 없다 => Tomcat이 넘겨준값 getParamter로 (${param.name})
		      	    => request.getAttribute("id")
		      	    => ${requestScope.id}
		      	    => ${id} => requestScope는 생략이 가능
		      	 
		      	 ?id=admin&pwd=1234
		      	    => request.getParameter("id")  => admin
		      	       request.getParameter("pwd") => 1234
		      	    => ${param.id} => admin
		      	       ${param.pwd} => 1234
		      	 
		      	 	bean => vo
		      	 => class Sawon
		      	 	{
		      	 		private int sabun;
		      	 		private String name;
		      	 		
		      	 		=> getter/setter
		      	 		   getSabun(), setSabun(int sabun)
		      	 		   getName(), setName(String name)
		      	 	}   
		      	    
		      	    Sawon vo=new Sawon();
		      	    vo.setSabun(1); ===> getSabun()
		      	    vo.setName("홍길동"); ===> getName()
		      	    
		      	    request.setAttribute("vo",vo) => 해당 JSP로 요청값 전송
		      	    => Sawon vo=(Sawon)request.getAttribute("vo");
		      	    			==================================
		      	    			${vo.getName()} => ${vo.name} => getName()을 호출하는 뜻
		      	    			${vo.getSabun()} => ${vo.sabun}
		      
		     Model => 자바
		     ===== DAO/VO/... 자바로 코딩하는 모든 파일
		     	   ====== 한개로 만들 수 있다 	       			
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : <%= svo.getName() %><br>
부서 : <%= svo.getDept() %>
<h1>EL</h1>
이름 : ${vo.name },${vo.getName() }<br>
부서 : ${vo.dept },${vo.getDept() }<br>
이름 : ${sessionScope.vo.name },${sessionScope.vo.getName() }<br>
부서 : ${sessionScope.vo.dept },${sessionScope.vo.getDept() }<br>
<%-- 키가 같으면 requsetScope가 우선순위 --%>
</body>
</html>