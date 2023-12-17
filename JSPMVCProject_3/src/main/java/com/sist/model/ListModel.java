package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class ListModel implements Model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 1. 사용자의 요청값 받기
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		BoardDAO dao=BoardDAO.newInstance();
		List<BoardVO> list=dao.boardListData(curpage);
		int totalpage=dao.boardTotalPage();
		
		// 2. jsp로 전송할 값 설정
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		
		return "board/list.jsp";
	}

}
