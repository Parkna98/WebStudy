package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.StayDAO;
import com.sist.vo.StayVO;

public class DetailModel implements Model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String sno=request.getParameter("sno");
		
		StayDAO dao=StayDAO.newInstance();
		StayVO vo=dao.stayDetail(Integer.parseInt(sno));

		request.setAttribute("vo", vo);
		
		return "stay/detail.jsp";
	}

}
