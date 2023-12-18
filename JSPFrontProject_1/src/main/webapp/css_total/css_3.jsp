<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div.wrap{
	width: 1800px;
	height: 900px;
	border: 1px solid green;
	position: absolute;
}
img{
	width: 300px;
	height: 450px;
	position: absolute;
}
.a{
	top: 0px;
	left: 0px;
}
.b{
	top: 0px;
	right: 0px;
}
.c{
	bottom: 0px;
	left: 0px;
}
.d{
	bottom: 0px;
	right: 0px;
}
.e{
	left: 750px;
	top: 225px;
}
</style>
</head>
<body>
  <h1>Absolute 배치</h1>
  <div class="wrap">
    <img src="../image/m1.jpg" class="a">
    <img src="../image/m2.jpg" class="b">
    <img src="../image/m3.jpg" class="c">
    <img src="../image/m4.jpg" class="d">
    <img src="../image/m5.jpg" class="e">
  </div>
</body>
</html>