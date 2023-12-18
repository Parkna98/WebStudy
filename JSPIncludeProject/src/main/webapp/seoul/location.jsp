<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.location{
	white-space: nowrap; /* 텍스트가 줄바꿈되지 않도록 함 */ 
	overflow: hidden; /* 초과된 텍스트를 감추기위해 오버플로우를 숨김 */
	text-overflow: ellipsis; /* 말줄임표 만드는 속성 */
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <c:forEach var="vo" items="${list }">
         <div class="col-md-4">
    		<div class="thumbnail">
      			<a href="#">
        			<img src="${vo.poster }" style="width:300px; height:200px">
        			<div class="caption">
         			 	<p class="location">${vo.title }</p>
        			</div>
     			</a>
    		</div>
  		</div>
      </c:forEach>
    </div>
    <div style="height:20px"></div>
    <div class="row">
      <div class="text-center">
        <a href="../seoul/location.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
        ${curpage } page / ${totalpage } pages
        <a href="../seoul/location.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-danger">다음</a>
      </div>
    </div>
  </div>
</body>
</html>