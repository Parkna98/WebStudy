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
	let i=0;
	$(function(){
		$('.ups').click(function(){
			$('.updates').hide();
			let a=$(this).attr('data-no');
			if(i==0){
				$('#'+a).show();
				$(this).text('취소');
				i=1
			}else{
				$('#'+a).hide();
				$(this).text('수정');
				i=0
			}
		})
	})
</script>
<title>Review</title>
</head>
<body>
	<div class=row>
	<table class=table>
	<tr>
	<td>
<%
	for(ReviewVO rvo:list){
%>
		<table class=table>
			<tr>
			<td class=text-left>
			<%="◑"+rvo.getName()+" ("+rvo.getDbday()+")" %>
			</td>
			<td class=text-right>
			<%
				if(rvo.getId().equals(id)){
			%>
				<span class="btn btn-xs btn-success ups" data-no=<%=rvo.getRno() %>>수정</span>&nbsp;
				<a href="reviewdelete.jsp?rno=<%=rvo.getRno() %>&typeno=<%=typeno %>&sno=<%=sno %>" class="btn btn-xs btn-danger">삭제</a>
			<%
				}
			%>
			</td>
			</tr>
			<tr>
			<td colspan=2>
			<pre style="white-space:pre-wrap;background-color:white;border:none"><%=rvo.getMsg() %></pre>
			</td>
			</tr>
		</table>
<%		
	}
%>
	</td>
	</tr>
	</table>
	<%
		if(id!=null){
	%>
		<form method="post" action="staydetail.jsp">
			<input type=hidden name=sno value=<%=sno %>>
			<input type=hidden name=typeno value=<%=typeno %>>
			<input type=text name=score>
			<input type=text name=star>
			<textarea name=msg rows=4 cols=60 style="float:left"></textarea>
			<input type=submit value="리뷰 쓰기" style="width:100px;height:89px;background:blue;color:white"> 
		</form>
	<%		
		}
	%>
	</div>
</body>
</html>