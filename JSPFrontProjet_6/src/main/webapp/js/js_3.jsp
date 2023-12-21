<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		내장 객체
		=======
			String 객체
				=> 자바와 유사
					1) substring(), substr()
					2) trim() 
					3) replace
					4) split()
					5) charAt()
					6) indexOf()
					7) lastIndexOf()
					8) slice() 
					
			Math 객체
			   	=> random()
			   	=> round()
			   	
			Array 객체
				=> push()
				=> pop()
				=> reverse
				=> sort
				=> slice()
			
			Date 객체
				=> get()
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* window.onload=function(){

		let str="Hello JavaScript";  ==> 보편적
		let str=new String("Hello JavaScript");
	
	let str=" Hello JavaScript ";
	document.write("문자갯수:"+str.length+"<br>")
	str=str.trim();
	document.write("문자갯수(trim):"+str.length)
	
} */
window.onload=function(){
	// 문자열의 갯수 => 문자열.length
	let btn=document.querySelector("#btn")
	btn.addEventListener('click',function(){
		let fd=document.querySelector('#fd')
		if(fd.value.trim()==""){
			alert("검색어 입력!")
			fd.focus()
			return
		}
		alert("검색어 입력 완료")
	})
}
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 350px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <input type="text" id="fd" name="fd" size=0 class=input-sm>
      <input id=btn type="button" value="검색" class="btn-sm btn-danger"> 
    </div>
  </div>
</body>
</html>