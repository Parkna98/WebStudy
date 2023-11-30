package com.sist.view;
// 데이터 받아서 => doPost (수정,삭제,추가 등)
// 화면 UI 출력 => doGet 
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Servlet => Server + let
// let => 가벼운 프로그램 => Applet / Midlet => 저장되는 메모리를 최소화
/*
		서블릿 => 장점은 보안 => .java => .class
				 단점 : HTML작성이 복잡하다 (문자열)
				 	   => 수정시마다 컴파일해야 된다
				 => HTML을 사용하지는 않는다
				 => 자바와 HTML을 연결
				 => JSP + servlet
		JSP => 사용이 편리, 보안이 취약 => .jsp (그대로)
					=> 컴파일 없이 실행 => script
		M  V  C	
		Model
		View - JSP
		Controller - Servlet
		
		Spring => 처리 => 웹 => Servlet
		============================== 
		1. 페이징 (블록)
		2. Cookie
		3. Session
		4. 요청 = 응답
		
		HTML : 정적 (화면 UI)
			=> 서버로 데이터 전송
			   GET / POST / PUT / DELETE => RestFul
			    ㅣ	  ㅣ=> id,pwd,데이터가 많은 경우 => <form> (form태그 이외에는 나머지 다 get방식으로 생각)
			   URL?데이터
			   노출/주로 사용 => 단순 데이터 전송 (페이지/번호/검색어...)
			   => 전송이 없는 경우 : GET default
			   
			   javascript
			   ==========
			   ajax({
			   	type:POST
			   	url:...
			   	successful:function(result)
			   })
			   Vue,React
			   axios.get...then()
			   axios.post
		=================== CSS
 */
import java.util.*;
import com.sist.dao.*;
@WebServlet("/FoodListServlet")
public class FoodListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전송방식 (HTML,XML) => 브라우저에 통보
		response.setContentType("text/html;charset=UTF-8");
		// 2. 브라우저에서 읽어갈 메모리 위치를 확보
		// out에다 값주면 읽어간다 => out.write() 
		PrintWriter out=response.getWriter();
		// 3. 사용자의 요청값을 받는다
		String page=request.getParameter("page");
		if(page==null) 
			page="1";
		int curpage=Integer.parseInt(page);
		// 4. 데이터베이스 연동 => 요청한 데이터를 가지고 온다
		FoodDAO dao=FoodDAO.newInstance();
		List<FoodVO> list=dao.foodListData(curpage);
		int totalpage=dao.foodTotalPage();
		// 쿠기 읽기
		List<FoodVO> clist=new ArrayList<FoodVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				// 최신방문을 가장 앞으로
				if(cookies[i].getName().startsWith("food")) {
					String fno=cookies[i].getValue();
					FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
					clist.add(vo);
				}
			}
		}
		// 블록 나누기
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		// 1 => 현재페이지 => 1~10
		// 				==> (10-1)/10*10 = 0
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		// 10 
		if(endPage>totalpage)
			endPage=totalpage;
		// 5. 데이터를 HTML을 이용해서 출력
		out.write("<html>");
		out.write("<head>"); // CSS / JavaScript => 없는 경우에는 생략가능
		out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.write("<style type=text/css>");
		out.write(".container{margin-top:50px}");
		// margin:10px 10px 10px 10px
		// 		  top  right bottom left
		out.write(".row{margin:0px auto;width:900px}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>"); // 화면 UI
		out.write("<div class=container>");
		out.write("<div class=row>"); // 맛집이미지
		for(FoodVO vo:list) {
			out.write("<div class=\"col-md-3\">");
			out.write("<div class=\"thumbnail\">");
			out.write("<a href=FoodBeforeServlet?fno="+vo.getFno()+">");
			out.write("<img src="+vo.getPoster()+" alt=\"Lights\" style=\"width:100%\">");
			out.write("<div class=\"caption\">");
			out.write("<p>"+vo.getName()+"</p>");
			out.write("</div>");
			out.write("</a>");
			out.write("</div>");
			out.write("</div>");
		}
		out.write("</div>");
		out.write("<div class=row>"); // 페이지
		out.write("<div class=text-center>");
		out.write("<ul class=\"pagination\">");
		if(startPage>1) {
			out.write("<li><a href=FoodListServlet?page="+(startPage-1)+">&lt;</a></li>");
			// 11page ==> 이전 ==> 10
		}
		for(int i=startPage;i<=endPage;i++) {
			out.write("<li "+(i==curpage?"class=active":"")+"><a href=FoodListServlet?page="+i+">"+i+"</a></li>");
			// <li class=active><a>
		}
		if(endPage<totalpage) {
			out.write("<li><a href=FoodListServlet?page="+(endPage+1)+">&gt;</a></li>");
		}
		out.write("</ul>");
		out.write("</div>");
		out.write("</div>");
		out.write("<div class=row>"); // 쿠키(최근방문)
		if(clist.size()!=0) {
			for(FoodVO vo: clist) {
				out.write("<a href=FoodDetailServlet?fno="+vo.getFno()+">");
				out.write("<img src="+vo.getPoster()+" style=\"width:100px;height:100px;margin-top:10px;margin-left:5px\">");
				out.write("</a>");
			}
		}
		else {
			out.write("방문한 기록이 없습니다");
		}
		out.write("</div>");
		out.write("</div>");
		out.write("</body>");
		out.write("</html>");
	}

}
