<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		이항연산자
		=> 산술연산자 (+,-,*,/,%)
		+ : 산술, 문자열 결합
		/ : 0으로 나눌 수 없다, 정수/정수 = 실수
							 =============
		% : 왼쪽부호가 남는다 
		   	-5 % -2 => -1
		   	5 % -2 => 1
			
		"10"+"20" => 1020
		"10"-"20" => -10 => 자바에서는 오류
		"10"*"20" => 200
		"10"/"20" => 0.5
		=> +외의 다른 산술연산시에 자동으로 parseInt   	
	
 --%>    
<%
	String a="홍길동";
	request.setAttribute("a", a);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	document.write((5/2)+"<br>")
	document.write("10"+"20"+"<br>");
	document.write(("10"-"20")+"<br>");
	document.write(("10"*"20")+"<br>");
	document.write(("10"/"20")+"<br>");
	document.write(("10"%"20")+"<br>");
	
	// 주의점
	/*
		undefined => 변수의 초기화가 안된 상태, 변수 선언이 없는 경우
					 ====================
				     자동 초기화 없음 => 값할당 해야함
				     
		NaN => 연산처리가 안된 상태
		Infinity : 0으로 나눌 수 없다
	*/
	
	let m='AB'; // char(x) String(o)
	let n=10;
	document.write("m+n="+(m+n)+"<br>") // A10
	document.write("m-n="+(m-n)+"<br>")
	document.write("m/n="+(n/0)+"<br>")
	let k;
	document.write("k="+k+"<br>")
	//document.write("h="+h+"<br>")
	let a="${a}"
	document.write("a="+a+"<br>")
	
}
</script>
</head>
<body>

</body>
</html>