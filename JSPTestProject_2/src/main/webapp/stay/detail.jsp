<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top:50px;
}
.row{
	margin:0px auto;
	width:800px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h1 class="text-center">상세보기</h1>
      <table class="table">
      	<tr>
          <td colspan="4" class="text-center" valign="top" height="200">
            <img src="${vo.image }" width=100% height=450>
          </td>
        </tr>
        <tr>
          <td>
          <img src="${vo.sub1 }" width=200px>
          </td>
          <td>
          <img src="${vo.sub2 }" width=200px>
          </td>
          <td>
          <img src="${vo.sub3 }" width=200px>
          </td>
          <td>
          <img src="${vo.sub4 }" width=200px>
          </td>
        </tr>
        <tr>
          <th width=20% class="text-center success">유형</th>
          <td width=30% class="text-center">${vo.type }</td>
          <th width=20% class="text-center success">숙소명</th>
          <td width=30% class="text-center">${vo.name }</td>
        </tr>
        <tr>
          <th width=20% class="text-center success">가격</th>
          <td width=30% class="text-center">${vo.price }</td>
          <th width=20% class="text-center success">주소</th>
          <td width=30% class="text-center">${vo.detailaddr }</td>
        </tr>
        <tr>
          <th width=20% class="text-center success">기본정보</th>
          <td colspan="3">${vo.basic }</td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
            <a href="list.do" class="btn btn-sm btn-success">목록</a>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>