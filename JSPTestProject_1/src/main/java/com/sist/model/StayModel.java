package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
import com.sist.vo.stayVO;

public class StayModel {
	public void StayListData(HttpServletRequest request) {
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		StayDAO dao=new StayDAO();
		List<stayVO> list=dao.StayListData(curpage);
		int totalpage=dao.StayTotalPage();
		
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalpage", totalpage);
	}
}
