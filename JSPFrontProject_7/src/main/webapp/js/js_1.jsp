<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		내장객체
		1) 브라우저 내장객체
			window : 브라우저 창을 제어
					  => open, close
			document : 화면 (HTML의 태그) => body
						=> querySelector()
						=> write
			history : 기록정보 
						=> back(), go() => 이전화면 이동
			location : 화면 이동 정보
						=> href 
			 
		2) 내장객체
			= Number()
			= parseInt()
			= String()    
			=============> 형변환
			*** 웹의 단점 : 모든 데이터가 문자열로 되어 있다 
			
			String / Date / Array
			============== 특별한 경우가 아니면 => 자바에서 처리된다
			= 서버에서 데이터 읽기 => ajax / axios
										====== vue/react 
										
			String => 유효성 검사 (오라클 => Primary Key, NOT NULL)
			====== 
				***1. length => 입력된 문자의 갯수 => 비밀번호
				2. charAt(number) 
						 ======== 문자열 번호 (0)
						 Hello 
						 01234 ==> charAt(4) => 'o'
				3. indexOf() => 해당 문자열 찾기 
				   indexOf('찾는 문자열',fromIndex)
				   => Number (return) => -1 : 존재하지 않는 경우
				4. lastIndexOf('찾는 문자열',fromIndex)
				   ====================== 서제스트(자동 완성기)
				   => 자음으로 찾기 => PROCEDURE
				5. replace => 변경
				   replace('변경될 문자열','변경할 문자열')
				***6. split(String, 구분문자) => []
				7. substring() => 문자를 자를때 사용
				   substring(number, number)
				   		  시작문자번호  끝나는문자번호(포함X) 
				8. substr(number, number)
						시작문자번호  짜를문자갯수  (1,4) => 1번부터 4개짜르기 (1,2,3,4)
				9. trim()
					=> 좌우 공백 제거 => 입력여부확인    
			
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*
		1. 변수 (let(지역변수, 전역변수), const(상수=자바에서 데이터를 받는 경우)) 
		2. 연산자 => (+,비교연산자,대입(=,+=))
		3. 제어문
			if ==> if~else
			일반 for for(let i=0;i<=10;i++)
					for(let data of 배열)
					=======================
					==> map, forEach로 대체가능
					배열.map(function(읽을 데이터){})
					=> 배열.map((읽을 데이터)=>{})
					=> map대신 forEach
		
		4. 함수
			= 내장 함수 : 형변환, JSON변환
						Number(), parseInt()
						String()
						***JSON.parse()
							오라클 => 자바 => 자바스크립트
									List => []
									VO   => {}
									================= JSON아니고 String으로 보내준상태(java는 JSON 데이터형이 없기때문에 String으로)
												==> String을 받아서 JSON.parse()로 변환해야한다
									JSON => 자바스크립트의 객체 표현법 => .json
									====
									  => 기존에는 XML을 사용(무겁고,파싱이힘듬) => 대체 JSON
									  
									Vue <==> Spring
									React <==> Spring-Boot
						
			= 사용자 정의 함수 : 
				=> 선언적 함수
					function func_name(매개변수...)
					{
						
					}
				=> 익명의 함수 => 함수안에 함수 선언 => 이벤트 등록
					let func_name=function(){}
					let func_name=()=>{}
				
				=> 주의점 매개변수는 데이터형을 사용하지 않는다
						 리턴형도 선언하지 않는다
						 (name,addr)
				
			= 객체 모델 선택
			  자바스크립트에서 태그를 객체로 
			   				속성을 멤버변수로 취급
			  => document.querySelector(CSS선택자)
			  	 ====================== $(CSS선택자) => JQuery
			  => document.getElementById(id명)
			  => 태그를 제어하는 프로그램
			  	 =================== DOM프로그램 (VueJS, AJAX ...) (Document Object Program)
			  => createElement : 태그생성
			  	 createTextNode : 태그와 태그사이에 값을 설정
			  	 <a>()</a>
			  => appendChild()
			  
			  => 태그를 읽어서 값을 설정
			     <td>   </td>
			     	  ㅣ  ========> innerHTML (태그도 가능) / textContent (문자열만가능)
			     <embed src="|"> => 동영상
			     			setAttribute => getAttribute
			   	 class="" => active => addClass, removeClass (클릭한거add(활성화) 다른거remove, 다른거다시선택하면 기존거 remove 선택한거 add )
			   	 
			= 이벤트 
				일반 방식
					=> function aaa(){}
					   <button onclick="aaa()"></button>
				고전적인 방식
					let button=document.querySelector("")
					button.onclick=function(){}
				리스너 이용방식
				 	let button=document.querySelector()
				 	button.addEventListener('click',function(){})
				 	=> Jquery
				 	   $('button').click(function(){})
				 	   $('button').on('click',function(){})
 */
window.onload=function(){
	
}
</script>
</head>
<body>

</body>
</html>