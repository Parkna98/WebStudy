<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.a{
	width: 100px;
	height: 100px;
	position: relative;
}
.a:nth-child(1) {
	background-color: red;
	left: 10px;
	top: 10px;
	z-index:12;
}
.a:nth-child(2) {
	background-color: blue;
	right: -50px;
	top: -50px;
	z-index:10;
}
.a:nth-child(3) {
	background-color: green;
	right: -90px;
	top: -90px;
	z-index:13;
}
</style>
</head>
<body>
  <div class="a"></div>
  <div class="a"></div>
  <div class="a"></div>
</body>
</html>