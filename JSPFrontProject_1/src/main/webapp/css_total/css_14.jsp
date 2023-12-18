<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	  	1. 선택자 => JavaScript
	  	2. 글자 관련
	  	3. margin / padding / border
	  	4. background
	  	5. position
	  		=> fixed
	  		=> relative
	  		=> 배치 => top/bottom/left/right
	  	6. overflow 
	  	=====================================
	  	CSS는 약간의 수정할줄 아는 정도
	  	
	  	HTML / CSS => 화면 UI
	  	JavaScript => UI 제어
	  	Java => 데이터 관리
	  			오라클 ==> 자바 ==> HTML/JavaScript
	  	오라클 => 데이터 저장 장소
	  	============== 통합 (Spring)
	  	Spring-Boot <==> Front
	  	=========== MSA
	  	
	  		
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
    margin: 0px;
    padding: 0px;
}
body{
  	width: 960px;
  	margin: 0px auto;
  	overflow: hidden;
}
#nav{
	width: 300px;
	float: left;
}
#section{
	width: 660px;
	float: right;
}
li{
	list-style: none;
}
@media screen and (max-width:768px){
	body{width: auto}
	#nav{width: auto;float: none}
	#section{width: auto;float: none}
}
</style>
</head>
<body>
  <div id="nav">
    <ul>
      <li>홈</li>
      <li>뉴스 1</li>
      <li>뉴스 2</li>
    </ul>
  </div>
  <div id="section">
  [스포츠조선 한동훈 기자] 토트넘 핫스퍼가 '브라질의 김민재' 유망주 수비수 모라투를 찍었다.
  영국 언론 '익스프레스'는 18일(한국시각) '토트넘이 유럽에서 가장 흥미로운 젊은 수비수를 1월에 영입하려고 한다고 알려졌다'라고 보도했다.
  익스프레스는 '토트넘은 1월 이적시장을 앞두고 벤피카 수비수 모라투 영입에 박차를 가하고 있다. 토트넘은 관심이 확고해지자 11월에만 스카우트를 네 차례 파견해 모라투의 경기를 모니터링했다'라고 설명했다.
  모라투는 2001년 브라질 태생이다. 자국 리그를 그쳐 2019년부터 포르투갈 벤피카에서 뛰었다. 키 192cm에 몸무게 88kg로 김민재(바이에른 뮌헨)와 신체조건이 비슷하며 빌드업 능력도 갖췄다. 지난 여름 이적시장서 김민재와 함께 많은 유럽 클럽들의 관심을 받았다.
  토트넘은 센터백 보강이 시급하다. 주전 수비수 크리스티안 로메로와 미키 반더벤을 백업할 요원이 없다. 로메로는 플레이가 거칠어 카드를 받는 경우가 잦아 시한폭탄이다. 반더벤은 지난달 열린 첼시와 프리미어리그 11라운드에 부상을 당해 최소 2월까지 결장이다.
  </div>
</body>
</html>