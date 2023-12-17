<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
	margin-top:50px;
}
.row{
	margin:0px auto;
	width:1024px;
}
.stayname{
	white-space: nowrap; /* 텍스트가 줄바꿈되지 않도록 함 */ 
	overflow: hidden; /* 초과된 텍스트를 감추기위해 오버플로우를 숨김 */
	text-overflow: ellipsis; /* 말줄임표 만드는 속성 */
}
</style>
</head>
<body>
<div class="row">
    <h1 class="text-center">전체 숙소</h1>
    <c:forEach var="vo" items="${list }">
    <div class="col-md-3">
    <div class="thumbnail">
      <a href="detail.do?sno=${vo.stayno }">
        <img src="${vo.image }" title="${vo.name }" style="width:100%">
        <div class="caption">
          <p class="stayname">${vo.name }</p>
        </div>
      </a>
    </div>
    </div>
    </c:forEach>
  </div>
  <div style="height:10px"></div>
  <div class="row">
  	<div class="text-center">
  	  <ul class="pagination">
  	  <%--
  	  		<!ENTITY lt "<">
  	  		<!ENTITY gt ">">
  	  		<!ENTITY nbsp " ">
  	  		=> &lt;&gt;&nbsp;
  	   --%>
  	   <c:if test="${startPage>1 }">
		  <li><a href="list.do?page=${startPage-1}">&lt;</a></li>
	   </c:if>
		  <c:forEach var="i" begin="${startPage }" end="${endPage }">
		  <li ${curpage==i?"class=active":"" }><a href="list.do?page=${i}">${i }</a></li>
		  </c:forEach>
	   <c:if test="${endPage<totalpage }">
		  <li><a href="list.do?page=${endPage+1}">&gt;</a></li>
	   </c:if>
	  </ul>
  	</div>
  </div>
</body>
</html>