<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
window.onload=function;{
	func();
}
function func(){
	document.write()("func() Call..(1)")
	document.write()("func() Call..(2)")
	
}

function func() // 오버라이딩
{
	document.write("func() Call..(2)")
	}
</script>
<body>

</body>
</html>