<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.btn').click(function(){
		let no=$(this).attr("value")
		// alert(no)
		$.ajax({
			type:'get',
			url:'ajax_recv.jsp',
			data:{"no":no},
			success:function(html){
				$('img').attr("src",html)				
			}
		})
	})
})
</script>
</head>
<body>
  <input type="button" value="1" class="btn"> 
  <input type="button" value="2" class="btn"> 
  <input type="button" value="3" class="btn"> 
  <input type="button" value="4" class="btn"> 
  <input type="button" value="5" class="btn"> 
  <input type="button" value="6" class="btn"> 
  <input type="button" value="7" class="btn">
  <center>
    <img src="../image/m1.jpg" width="300" height="350">
  </center>
</body>
</html>