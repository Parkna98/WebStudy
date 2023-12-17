package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;

public class MainModel {
  @RequestMapping("main/main.do")
  public String main_main(HttpServletRequest request, HttpServletResponse response) {
	  request.setAttribute("main_jsp", "../main/home.jsp");
	  return "../main/main.jsp";
  }
}
/*	
		jsp에서 uri(.do)값 controller(DispatcherServlet)가 받음 
	 	controller에서 requestmapping을 통해 모델에서 같은 .do값을 갖고있는 메소드를 호출
	 	메소드의 request,response값 가지고 return에 있는 jsp로 이동
	 	(값없으면 Ajax이용)
		
		1. DispatcherServlet
			=> WEB-INF => application에 있는 클래스명을 읽는다
			=> 대기
			=> init은 서버구동시 한번만 수행
			
		2. 사용자 접속 : service()
			=> 사용자가 URL전송
				main/main.do
			=> 전체 XML에 등록된 Model을 읽어서 
			   => @RequestMapping을 찾아서 메소드를 호출
			   => 메소드를 호출하는 방법이므로
			      @RequestMapping의 값을 메소드마다 모두 다르게 줘야함
			      => 다르게 주기위해 폴더명/파일명으로 통일 => 중복없음
 */
