<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		355page 이벤트 
		=============
		자주 사용하는 이벤트 (사용자에 의해서 발생)
		많이 사용되는 이벤트 
		================
		 onload : 브라우저가 HTML문서를 읽어서 화면에 출력되었을 때
		 => window.onload=function(){처리}
		 onclick : 클릭을 했을때 => 버튼 / a / h1...
		 onkeyup(검색), onkeydown : 키보드를 누르고 뗐을때, 눌렀을때
		 onmouseover, onmouseout : 마우스커서를 갖다 댔을때, 다시 뺐을때
		 onsubmit => 데이터를 전송할때
		 onchange => select태그에서 선택이 된 경우
		 
		
		이벤트 처리 방법
		 ***1) 인라인 이벤트 모델 ==> 태그안에서 처리
		 	   <button onclick="함수()">
		 2) 고전 이벤트 모델
		 3) 표준 이벤트 모델
		 ***4) 이벤트 리스너 사용 ==> JQuery는 모두 이벤트 리스너 사용   
				 
		 
		 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function show(){
	alert("button click")
}
</script>
</head>
<body>
  <button onclick="show()">클릭(인라인)</button>
</body>
</html>