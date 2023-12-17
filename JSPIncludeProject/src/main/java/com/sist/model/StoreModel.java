package com.sist.model;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

/*
		DAO => 오라클 연결
		Model => 요청을 받아서 => 처리 => 결과값을 request에 모아두는 것 
		Controller => model에서 모아둔 request를 JSP로 전송
 */
public class StoreModel {
	@RequestMapping("store/all.do")
	public String store_all(HttpServletRequest request, HttpServletResponse response) {

		// all.jsp => 데이터베이스 결과값을 전송 (request)
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		// DB연동
		GoodsDAO dao=GoodsDAO.newInstance();
		List<GoodsVO> list=dao.goodsAllListData(curpage);
		int totalpage=dao.goodsAllTotalPage();
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		
		// 쿠키 데이터 전송
		Cookie[] cookies=request.getCookies();
		List<GoodsVO> cList=new ArrayList<GoodsVO>();
		
		if(cookies!=null) {
			for(int i=cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("goods")) {
					String no=cookies[i].getValue();
					GoodsVO vo=dao.goodsCookieData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		// 쿠키 데이터 + Nav바 고정
		
		// 요청 => .do
		// include => .jsp
		request.setAttribute("cList", cList);
		request.setAttribute("count", cList.size());
		request.setAttribute("store_jsp", "../store/all.jsp");
		request.setAttribute("main_jsp", "../store/store_main.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("store/best.do")
	public String store_best(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("store_jsp", "../store/best.jsp");
		request.setAttribute("main_jsp", "../store/store_main.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("store/sp.do")
	public String store_sp(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("store_jsp", "../store/special.jsp");
		request.setAttribute("main_jsp", "../store/store_main.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("store/new.do")
	public String store_new(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("store_jsp", "../store/new.jsp");
		request.setAttribute("main_jsp", "../store/store_main.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("store/detail.do")
	public String store_detail(HttpServletRequest request, HttpServletResponse response) {
		
		// 사용자 => no
		String no=request.getParameter("no");
		GoodsDAO dao=GoodsDAO.newInstance();
		GoodsVO vo=dao.goodsAllDetailData(Integer.parseInt(no));
		String price=vo.getGoods_price();
		vo.setPrice(price);
		// 30,000원 => 30000
		price=price.replaceAll("[^0-9]", "");
		// [가-힣] : 한글 전체  ^:제외하고 
		// [^A-Za-z] : 영어를 제외하고
		// ${store_jsp} => request.getAttribute("store_jsp","abc")
		
		request.setAttribute("vo", vo);
		request.setAttribute("store_jsp", "../store/detail.jsp");
		request.setAttribute("main_jsp", "../store/store_main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("store/detail_before.do")
	public String store_detail_before(HttpServletRequest request, HttpServletResponse response) {
		
		// response는 한번의 기능을 수행할 수 있어서 detail과 쿠키보내는것을 따로 만듬
		
		// 쿠키를 띄우기위해 before.do를 만들어서 sendRedirect방식으로 이동
		// jsp가 아니라 .do로 줘야지 request값설정한 .do메소드를 거쳐서 결국 jsp로 들어옴
		// include는 jsp, sendRedirect는 .do
		// => forward는 request값이 공유되기때문에 .jsp로 이동
		// => Redirect는 request값이 없어지기때문에 다시 받으러 .do로 이동 그이후에 request받아서 .jsp로 이동
		
		String no=request.getParameter("no");
		Cookie cookie=new Cookie("goods_"+no, no);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		// 브라우저로 전송
		response.addCookie(cookie);
		return "redirect:../store/detail.do?no="+no;
	}
}



