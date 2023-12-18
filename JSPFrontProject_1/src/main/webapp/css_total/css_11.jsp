<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
	width: 1700px;
	height: 800px;
	border:1px solid red;
}
.h{
	width: 1700px;
	height: 200px;
	background-color: cyan;
	float: left;
}
.f{
  	width: 1700px;
  	height: 200px;
  	background-color: gray;
  	clear: both;
}
.aside1{
	width: 300px;
	height: 400px;
	background-color: green;
	float: left;
}
.aside2{
	width: 300px;
	height: 400px;
	background-color: yellow;
	float: left;
}
.section{
	width: 1100px;
	height: 400px;
	background-color: magenta;
	float: left;
}
</style>
</head>
<body>
 <div class="container">
    <div class="h"></div>
    <div class="aside1"></div>
    <div class="section"></div>
    <div class="aside2"></div>
    <div class="f"></div>
  </div>
</body>
</html>