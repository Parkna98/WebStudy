<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		연산자 
		1) 단항연산자
			= 증감연산자 (++,--)
			= 부정연산자 (!)
		2) 형변환 연산자
			= 숫자변환 : Number(문자), parseInt(문자열)
			= 문자열변환 : String(10) => "10" 
			= Boolean : Boolean(숫자) 
						=> Boolean(1) : true / Boolean(2) : false
		3) 이항연산자
			= 산술연산자 : + , - , / , * , %
						== 문자열결합으로 사용가능
						
			= 비교연산자 : === , !== , < , > , <= , >=    ==> 결과값 : boolean
						(==,!= 혼용 => 경고)
						*** 문자열도 비교 가능 
						
			= 논리연산자 : &&, ||
			
			= 대입연산자 : =, +=, -=
			
		4) 삼항연산자 : (조건)?값1:값2
					  true  => 값1
					  false => 값2
			
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 292page 연산자
window.onload=function(){
	// 단항연산자 (++,--,!)
	let a=10;
	let b=a++; // 후치 연산자 => 대입 => 증가
	document.write("a="+a)
	document.write("<br>")
	document.write("b="+b+"<br>")
	
	a=10;
	b=++a;
	document.write("a="+a)
	document.write("<br>")
	document.write("b="+b+"<br>")
	
	let c=false;
	c=!c;
	document.write("c="+c+"<br>")
	
	let d=1;
	d=!d;
	document.write("d="+d+"<br>")
	// 0이 아닌 모든 수는 true => 0이거나 0.0이면 false
	document.write("<hr>")
	
	// 형변환
	let e="10"
	document.write("e="+typeof e+"<br>")
	document.write("e="+typeof Number(e)+"<br>")
	document.write("e="+typeof parseInt(e)+"<br>")
	document.write("e="+typeof Boolean(e)+","+Boolean(e)+"<br>")
	/*
		자바와 다른점
		= 숫자 => 문자열, Boolean으로 변경이 가능
					   ===============
		= 변수에는 데이터형을 사용하지 않는다 (let,const) => typeof
		= 모든 숫자는 true/false로 변경이 가능하다 (0,0.0)
	*/
}
</script>
</head>
<body>

</body>
</html>