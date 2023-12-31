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
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
/*
	table
		=> table-hover : tr => mouseover => 색상이 변경
		   table-bordered : 테두리 
		   table-striped : 한줄씩 변경
		=> td/th 
		   정렬 => text-left / text-center / text-right
*/
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr class="danger">
          <th>이름</th>
          <th>주소</th>
          <th>전화</th>
        </tr>
        <tr>
          <td>홍길동</td>
          <td>서울</td>
          <td>010-1111-1111</td>
        </tr>
        <tr>
          <td>홍길동</td>
          <td>서울</td>
          <td>010-1111-1111</td>
        </tr>
      </table>
      <table class="table table-hover">
        <tr class="success">
          <th>이름</th>
          <th>주소</th>
          <th>전화</th>
        </tr>
        <tr>
          <td>홍길동</td>
          <td>서울</td>
          <td>010-1111-1111</td>
        </tr>
        <tr>
          <td>홍길동</td>
          <td>서울</td>
          <td>010-1111-1111</td>
        </tr>
      </table>
      <table class="table table-hover">
        <tr class="info">
          <th>이름</th>
          <th>주소</th>
          <th>전화</th>
        </tr>
        <tr>
          <td>홍길동</td>
          <td>서울</td>
          <td>010-1111-1111</td>
        </tr>
        <tr>
          <td>홍길동</td>
          <td>서울</td>
          <td>010-1111-1111</td>
        </tr>
      </table>
      <table class="table table-bordered">
        <tr class="info">
          <th>이름</th>
          <th>주소</th>
          <th>전화</th>
        </tr>
        <tr>
          <td>홍길동</td>
          <td>서울</td>
          <td>010-1111-1111</td>
        </tr>
        <tr>
          <td>홍길동</td>
          <td>서울</td>
          <td>010-1111-1111</td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>