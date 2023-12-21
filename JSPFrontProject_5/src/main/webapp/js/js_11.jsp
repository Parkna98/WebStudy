<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		브라우저 내장 객체
		==============
			window
			  ㅣ
		============================
		ㅣ		ㅣ		  ㅣ		   ㅣ
	document  location  history  frame
		ㅣ
	 ===================
	 ㅣ		ㅣ   ㅣ     ㅣ
	form   img   a    ...
	 ㅣ
	text, textarea, password...
		
	window : 브라우저 창 
			 => close(), scrollbar, open => ex) 오늘하루 안보기 (close,open)		
	
	document : HTML태그 (body)
	
	history : 웹 브라우저의 기록 정보
			  **back() => 이전
			  **forward() => 앞으로
			  go() => 음수 : 이전, 양수 : 이후
			  go(-2) => 이전을 두번
			  go(3)  => 이후를 3번
	
	location : 주소정보 (이동) => GET
		=> href
		location.href="URL"
		
		
		
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	let btn=document.querySelector("button")
	btn.addEventListener('click',()=>{
		window.open('js_10.jsp','jsp','width=450,height=500')
	})
}
</script>
</head>
<body>
  <button>클릭</button>
</body>
</html>