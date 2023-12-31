<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

    <!-- Google Font --> 
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="../css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    
    <!-- xeicon -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<style>
.project{
	padding-top: 75px;
}
.scroll-to-top {
      position: fixed;
      bottom: 50px;
      right: 50px;
      background-color: #5a70e9;
      color: #fff;
      border: none;
      border-radius: 5px;
      padding: 15px 15px;
      cursor: pointer;
      text-decoration: none;
		text-align: center;
		border-radius: 50%;
		width: 50px;
		height: 50px;
		font-size: 15px;
    }
.body{
	width: 100%;
}
</style>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	<div class="res_submenu">
	  <a href="#" class="scroll-to-top" onclick="scrollToTop()"><i class="xi-angle-up"></i></a>
	</div>
	<script>
	  // 스크롤 최상단으로 이동하는 함수
	  function scrollToTop() {
	    document.body.scrollTop = 0;
	    document.documentElement.scrollTop = 0;
	  }
	
	  // 스크롤 위치에 따라 링크 보이기/숨기기
	  window.onscroll = function() {
	    var scrollLink = document.querySelector('.scroll-to-top');
	    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
	      scrollLink.style.display = 'block';
	    } else {
	      scrollLink.style.display = 'none';
	    }
	  };
	</script>
	<div class="project">
	<!-- home -->
	<jsp:include page="${main_jsp }"></jsp:include>
	</div>
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>

    <!-- Js Plugins -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.nice-select.min.js"></script>
    <script src="../js/jquery-ui.min.js"></script>
    <script src="../js/jquery.slicknav.js"></script>
    <script src="../js/mixitup.min.js"></script>
    <script src="../js/owl.carousel.min.js"></script>
    <script src="../js/main.js"></script>
</body>
</html>