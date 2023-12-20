<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// main 
/*	
	1. 자바 : main()
	2. 자바스크립트 : window.onload=function() 
	3. Jquery : $(function(){})
	4. VueJs : mounted()
	5. React : componentDidMounted()
	
	ES5 ==> ES6
	변수 => 자동지정변수
	var 	let  =======> 사용범위 (지역변수 => 메모리 해제)
	
	=> 변수 선언 => let / const
	   	let => 지역변수
	   	const => 상수
	   	=> 자동 지정 변수 => jquery / vue / react
	   	   let i=10 ==> i:int
	   	   let i=10.5 ==> i:double
	   	   ------------------------ ==> i:Number:숫자형
	   	   let i='A' => i:char
	   	   let i="A" => i:String
	   	   ------------------------ ==> i:String:문자형
	   	   let i=true => i:Boolean
	   	   ------------------------ i:Boolean:논리형
	   	   let i={name:"홍길동",sex:"남자"}
	   	   ------------------------------ i:Object:객체형
	   	   								  => JSON(*****)
	   	   								  => ~VO
	   	   let i=[1,2,3,4,5]
	   	   ------------------ i:Array
	   	   형변환 
	   	     숫자변환 => Number("10") => 10
	   	     		   parseInt("10") => 10
	   	     문자변환 => String(10) = "10"
	   	     		   Math.round(10.5)
	   	     		   => String, Date, Math ...
	   	     논리형 => Boolean(1) => true
	   	       	      Boolean(0) => false
	   	       	      => 0,0.0이 아닌 수는 모두 true
	   	     =====================================
	   	     연산자
	   	       + : 산술, 문자열 결합
	   	           "10"+"20" => "1020"
	   	           "10"-"20" => -10
	   	           ---------- parseInt("10")-parseInt("20")
	   	       / : 정수/정수 = 실수
	   	       ==, === / !=, !== : 혼용
	   	          => 3개짜리(===,!==) 권장 
	   	          
	   	      연산처리시 변수 선언
	   	      = undefined : 변수의 초기화 (X), 변수 선언이 안된 상태
	   	      = NaN : 연산 처리가 안된 상태
	   	      		  'A'-1 = NaN
	   	      		  ------
	   	      		  금액 : 1000
	   	      		  <select>
	   	                <option value="1">1개</option>
	   	                <option>2개</option>
	   	                <option>3개</option>
	   	          	  </select>
	   	          	  => 1000*2개 => NaN
	   	          	  
	   	      = Infinity : 0으로 나눈 경우    10/0
	   	      => let i=
	   	      	 let name=''
				 ===> Jqeury : 충돌 => $	   	          	  
	   	          	  
	   	오라클 =========== 데이터 읽기(자바) ============ HTML/JavaScript
	   	=====										  => EL/JSTL 적용가능
	    데이터 공유
	   	
 */
window.onload=function(){
	console.log("a="+a) // undfined
	// var => 단점 : 메모리 누수 
	if(1){
		let a=10;
		console.log("if:a="+a);
	}
	console.log("if밖 => a="+a);
}
</script>
</head>
<body>

</body>
</html>