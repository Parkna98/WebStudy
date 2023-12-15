package com.sist.model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
import com.sist.controller.RequestMapping;
public class MainModel {
	
	@RequestMapping("main/main.do")
	public String main_main(HttpServletRequest request,HttpServletResponse response) {
		
		String fd=request.getParameter("fd");
		if(fd==null) {
			fd="가평";
		}
		StayDAO dao=StayDAO.newInstance();
		List<StayVO> sList=dao.stayAddressListData(fd);
		
		
		request.setAttribute("fd", fd);
		request.setAttribute("sList", sList);
		request.setAttribute("main_jsp", "../main/home.jsp");
		return "../main/main.jsp";
	}
}
