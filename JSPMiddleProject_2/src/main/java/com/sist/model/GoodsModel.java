package com.sist.model;
import java.security.spec.EncodedKeySpec;
// 요청받아서 => 요청 처리후에 결과값을 request/session에 담아서 JSP로 보내주는 역할
/*
 		request
		JSP => Model => DAO
			<=		 <=
		request => 결과값을 추가해서 전송
				   setAttribute()
		=============================> Call By Reference
 */
/*
		JSP : 요청 <a> <form> => GET/POST
		=> 요청 처리 결과를 받아서 출력만 담당 => 출력만 담당 (View)
		
		Java
		 웹에서 전송하는 내용 => JSP/Servlet (일반 자바는 사용 할 수 없다)
		  	 request			request
		 JSP ======= Controller ======= Model <========> DAO
		 				ㅣ		request에 담는다
		 			JSP를 forward
		 	   요청 => 해당 Model찾기
		 = Controller : HTML/JAVA => 연결하는 역할(Servlet)
		 = Model : 요청처리 => request/session에 담아서 전송
		 = DAO : 오라클 연동
		 = VO : 오라클에서 데이터를 읽기 => Record(Row)
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.vo.*;
import com.sist.dao.*;
public class GoodsModel {
	public void goodsListData(HttpServletRequest request) {
		// type, page => jsp의 <% %>
		String type=request.getParameter("type");
		if(type==null)
			type="1";
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		// 페이지 지정
		int curpage=Integer.parseInt(page);
		// 페이지에 해당되는 목록
		GoodsDAO dao=new GoodsDAO();
		List<GoodsVO> list=dao.goodsListData(curpage, Integer.parseInt(type));
		int totalpage=dao.goodsTotalPage(Integer.parseInt(type));
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		// JSP에서 출력할 데이터 전송
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("type", type);
	}
	
	public void goodsDetailData(HttpServletRequest request) {
		// 요청값을 받는다
		String table=request.getParameter("table"); // 테이블 번호
		String no=request.getParameter("no"); // 상품 번호
		String type=request.getParameter("type"); // 화면 변경
		// 요청에 해당되는 데이터베이스 값 읽기
		GoodsDAO dao=new GoodsDAO();
		GoodsVO vo=dao.goodsDetailData(Integer.parseInt(table), Integer.parseInt(no));
		// request에 담아 준다
		request.setAttribute("vo", vo);
		request.setAttribute("type", table);
		// =======> detail.jsp
	}
}






