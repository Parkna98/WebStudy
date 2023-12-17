package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import com.sist.dao.StayDAO;
import com.sist.vo.StayVO;

public class StayModel implements Model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String page=request.getParameter("page");
		if(page==null) 
			page="1";
		
		
		StayDAO dao=StayDAO.newInstance();
		int curpage=Integer.parseInt(page);
		int totalpage=dao.StayTotalPage();
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		List<StayVO> list=dao.StayListData(curpage);
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
	
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		return "stay/list.jsp";
	}

}
