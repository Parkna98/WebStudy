<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
		순서
		1. 요청받기 (메뉴에서 요청하면 어떤 .do로 갈껀지 작성)
		2. application에 추가
		3. model에 @RequestMapping(~.do)설정하고 메소드작성 (request.setAttribute()해주고 return "../main/main.jsp"
		4. 전달받은 jsp에서 출력
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	location.href="main/main.do"
</script>
</head>
<body>

</body>
</html>