<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
		자바스크립트의 핵심
		===============
		=> 객체모델 : 태그를 읽어 오는 방법
					document.querySelector(CSS선택자) => Jquery : $() 
					document.getElementById()
		=> 내장객체 : String, Math, Date => 함수
		=> 브라우저 내장 객체 : window, document, history, location
		=======================================================
		 =====> 라이브러리로 변경 => Jquery => 동적 (Ajax)
		
		단일값 저장 => let 변수명=값 (값에 따라 자동으로 데이터형이 결정)
		다중값 저장 
		=========
			1. 배열 [] => 자바와 다른점 : 데이터형이 혼합이 가능
						 ["",10,"",10.5,{}] => 데이터형이 한개 (let)
						 
			2. 객체 {} => {키:값,키:값,...}
					      ==   == 
					      ㅣ    ㅣ
					      -------> 자바에서는 멤버변수 => JSON => JSONP
					      -------> 동기/비동기
			3. 
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	/*
		let a=10;
		a="aaa"
		a=[]
		a={}
	*/
	let arr=["홍길동",20,'A',"영업",3500]
	console.log(arr)
	console.log("arr="+typeof arr)
	for(let data of arr){
		document.write(data+"<br>")
	}
	/* arr.map((component)=>{
		document.write(data+"<br>")
	}) */
	arr.forEach((name)=>{
		document.write(name+"&nbsp;")
	})
	
	
	document.write("<h3>객체 표현법:(JSON)</h3>")
	//{변수:값,변수:값,변수:값......}
	let sawon={sabun:1,name:"홍길동",dept:"개발부",pay:3500}
	
	document.write("사번:"+sawon.sabun+"<br>")
	document.write("이름:"+sawon.name+"<br>")
	document.write("부서:"+sawon.dept+"<br>")
	document.write("급여:"+sawon.pay+"<br>")
	document.write("<hr>");
	
	document.write("<h3>객체 표현법(JSON)2</h3>")
	document.write("사번:"+sawon['sabun']+"<br>")
	document.write("이름:"+sawon['name']+"<br>")
	document.write("부서:"+sawon['dept']+"<br>")
	document.write("급여:"+sawon['pay']+"<br>")
	document.write("<hr>");
	
	/* document.write("<h3>객체 표현법(JSON)3</h3>")
	document.write("사번:"+sawon[0]+"<br>")
	document.write("이름:"+sawon[1]+"<br>")
	document.write("부서:"+sawon[2]+"<br>")
	document.write("급여:"+sawon[3]+"<br>")
	document.write("<hr>"); */

	document.write("<h3>객체 표현법(JSON)3</h3>")
	for(let key in sawon){
		document.write(key+":"+sawon[key]+"<br>")
	}
	
	
	
	
	/*
		class sawon
		{
			int sabun;
			String name,dept;
			int pay;
		}
		Sawon s=new Sawon();
		s.sabun=1
		s.name="홍길동"
		s.dept="개발부"
		s.pay=3500
	*/
	
	
	
	
	// => function도 배열에 첨부가능 => function자체도 하나의 변수로 취급
	/*
		function func_name(){
			
		}
	
		let func_name=function(){}
		let func_name=()=>{}
		
		function aaa(){}
		function bbb(callback){
			
		}
		
		bbb(aaa) => $.ajax()
	*/
}
</script>
</head>
<body>

</body>
</html>