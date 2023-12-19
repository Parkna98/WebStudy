<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>CodePen - Simple HTML/CSS Contact Form</title>
  <link rel="stylesheet" href="../css/join.css">
<style type="text/css">
</style>
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">  
  <form id="contact" action="" method="post">
    <h3>회원가입</h3>
    <h4>아래 양식을 작성해주세요</h4>
    <fieldset>
      <input class="writeid" placeholder="ID 입력" type="text" tabindex="1" style="float:left;" required autofocus>
      <button class="idch" name="idcheck" type="button" id="contact-check" style="float: left">중복체크</button>
    </fieldset>
    <fieldset>
      <input placeholder="비밀번호 입력" type="password" tabindex="2" required>
    </fieldset>
    <fieldset>
      <input placeholder="비밀번호 재입력" type="password" tabindex="3" required>
    </fieldset>
    <fieldset>
      <input placeholder="이름 입력" type="text" tabindex="2" required>
    </fieldset>
    <fieldset>
      <input type="radio" tabindex="2">남자
      <input type="radio" tabindex="2">여자
    </fieldset>
    <fieldset>
      <input placeholder="생년월일 입력" type="date" tabindex="2" required>
    </fieldset>
    <fieldset>
      <input placeholder="이메일" type="text" tabindex="2">
    </fieldset>
    <fieldset>
      <input placeholder="우편번호" type="text" tabindex="3" required>
    </fieldset>
    <fieldset>
      <input placeholder="주소" type="text" tabindex="3" required>
    </fieldset>
    <fieldset>
      <input placeholder="상세주소" type="text" tabindex="3">
    </fieldset>
    <fieldset>
      <input placeholder="전화번호" type="text" tabindex="3">
    </fieldset>
    <fieldset>
      <textarea placeholder="당신의 반려동물을 소개해주세요." tabindex="5" required></textarea>
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending" style="float: left">회원가입</button>
      <button class="can" name="cancel" type="button" id="contact-cancel" style="float: left;" >취소</button>
    </fieldset>
  </form>
</div>
<!-- partial -->
  
</body>
</html>
