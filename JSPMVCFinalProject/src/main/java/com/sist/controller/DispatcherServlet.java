package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

/*
		XML파싱
		Annotation => 클래스 찾기 => 메소드 찾기
		=> MVC동작
			1. 요청 (JSP) => <a>,<form>
				=> DispatcherServlet(Controller) => Spring의 Controller이름 (이미 만들어져 있음)
				=> @WebServlet("*.do")
							   ======= list.do, insert.do
							   		   ====		====== 구분문자
						ㅣ서버에서 받을 수 있는 부분
						  => URL,URI => 서버연결을 주소란
						  => URI를 이용해서 => Model찾기
						  
			2. DispatcherServlet (Controller)
			   = 역할
			       => 요청받기 (브라우저 => JSP/Servlet)
			       			  JSP =====> View(화면출력)
			       			  Servlet => 연결(자바/HTML)
			       			  			 ============= (보안 => 자바는 보낼때 .class파일로 보냄) (컴파일된 파일) 
			       			  			 
			       => 분리된 Java를 찾는다 ===> 연결
			       					request/session
			3. MVC목적
				1) 보안 (JSP => 배포(소스코드를 통으로 전송) => 유지보수하려면 .class파일로 소스가 보이지않게)
				2) 여러명이 동시 개발
				   Front - Back (자바/HTML)
				3) JSP의 단점 : 확장성, 재사용, 변경
				   ========= 사이트 제작시 버린다
				4) 신규사원 확장
				
				=> MVVM / MVVP
				
			4. 소프트웨어 => 회귀
			==================
			
			5. 동작
							 request
				JSP(링크,버튼) ======= DispatcherServlet
										==> Model(DAO와 연동)
											=====
											request에 결과값 담기
											=> setAttribute()
						DispatcherServlet <== 
						 => request 필요하다 => request를 JSP로 전송
						  		=> JSP로 request를 전송 메소드 
						  		=> forward(request,response) (주로 select => forward로 화면이동)
						 => request 필요없다 => 화면만 이동 => redirect
						 		=> 화면만 변경하는 메소드
						 		=> sendRedirect(파일명)
						 		=> 회원가입, 로그인확인, 글쓰기 (주로 insert,update,delete => sendredirect)
						 		
				=> DispatcherServlet => 고정한다 => .jar
					
				1. 설정 파일
					Spring : application-context.xml
						     application-datasource.xml
						     application-security.xml
						     => 태그 속성을 Spring에서 제공하는 것만 사용이 가능
						     => DTD파일을 제공받아서 태그확인가능
				
				
 */
import java.util.*;
import java.net.*;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> clsList=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		// 1. XML의 경로 읽기 => XML안에 클래스 등록 => 고정시키기위해서 XML을 사용
		try {
			URL url=this.getClass().getClassLoader().getResource(".");
			File file=new File(url.toURI());
			System.out.println(file.getPath());
			String path=file.getPath();
			path=path.replace("\\", file.separator);
			// window => \\ ,  Mac => /
			path=path.substring(0,path.lastIndexOf(File.separator));
			// C:\webDev\webStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPMVCFinalProject\WEB-INF\classes
			// WEB-INF/xml파일명 에 저장하기위해 맨뒤의 \를 찾아서 그뒤를 짜르고 xml파일명 붙여서 저장
			// System.out.println(path);
			path=path+File.separator+"application.xml";
			
			// XML 파싱 => xml안에서 필요한 데이터 추출
			// 1. 파서기 생성
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			// 2. XML을 전송
			Document doc=db.parse(new File(path));
			// 3. root태그 읽기 => 테이블
			Element root=doc.getDocumentElement();
			// <beans> ==> FROM 테이블명
			// 4. root밑에 있는 태그를 모아서 데이터 추출
			NodeList list=root.getElementsByTagName("bean");
			for(int i=0;i<list.getLength();i++) {
				Element bean=(Element)list.item(i);
				String id=bean.getAttribute("id");
				String cls=bean.getAttribute("class");
			//	System.out.println(id+":"+cls);
				
				clsList.add(cls);
			}
		}catch(Exception ex) {}
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		// http://localhost/JSPMVCFinalProject/board/list.do
		//			        ================================ URI
		// 					================== ContextPath
		// => /board/list.do 
		// => board/list.do
		uri=uri.substring(request.getContextPath().length()+1);
		try {
			for(String cls:clsList) {
				Class clsName=Class.forName(cls);
				// 클래스 정보 읽기
				/*
					메소드 전체 / 멤버변수 / 생성자 확인
				 */
				Object obj=clsName.getDeclaredConstructor().newInstance();
				// 클래스 정보를 이용해서 메모리 할당
				// => 리플렉션
				Method[] methods=clsName.getDeclaredMethods();
				// 				 클래스에 선언된 모든 메소드를 가지고 온다
				for(Method m:methods) {
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					// 메소드 위에 선언된 @RequestMapping을 가지고 온다
					// => m(메소드) => 위에 저장되어 있는 Annotation을 가지고 온다
					// 저장된 객체읽어올때
					/*
					 * 	A a=new A() => a
					 *  A a=a.getClass()
					 *  A a=A.class
					 *  
					 *  public void aaa(int a,int b)
					 *  
					 */
					if(rm.value().equals(uri)) {
						String jsp=(String)m.invoke(obj, request, response);
						// m이란 메소드 호출한다 => invoke(객체,매개변수....) 
						//  		=> 매개변수가 일치해야하기때문에 Model의 매개변수는 request와 response를 꼭 쓴다
						// 이름으로 메모리할당하고 이름으로 호출가능 ==> invoke
						if(jsp==null) // method가 void라는 뜻 => ajax 
						{
							return;
						}
						else if(jsp.startsWith("redirect:")) {
							// return "redirect:list.do"
							jsp=jsp.substring(jsp.indexOf(":")+1);
							response.sendRedirect(jsp);
						}
						else {
							RequestDispatcher rd=request.getRequestDispatcher(jsp);
							rd.forward(request, response);
						}
						return;
					}
				}
			}
		}catch(Exception ex) {}
	}

}
