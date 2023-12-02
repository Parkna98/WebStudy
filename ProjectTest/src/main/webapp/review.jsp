<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%	
	response.setContentType("text/html;charset=UTF-8");
	ReviewDAO rvdao=ReviewDAO.newInstance();
	String typeno="1";
	String sno=request.getParameter("sno");
	List<ReviewVO> list=rvdao.reviewListData(Integer.parseInt(typeno), Integer.parseInt(sno));
	session=request.getSession();
	String id=(String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$('.ups').click(function(){
			$('.updates').hide();
		})
	})
</script>
<title>Review</title>
</head>
<body>

</body>
</html>