<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function() {
	// $('div > h1+span').css("color","red")  
	 $('div > h1~span').css("color","red")
	// + : 인접한 태그 하나
	// ~ : 해당 태그 모두
})
</script>
</head>
<body>
  <div>
    <h1>Hello Jquery!!</h1>
    <span>Hello Selector1</span>
    <span>Hello Selector1</span>
  </div>
</body>
</html>