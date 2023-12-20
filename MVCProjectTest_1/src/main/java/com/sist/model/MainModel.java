package com.sist.model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
import com.sist.controller.RequestMapping;
public class MainModel {
	
	@RequestMapping("main/main.do")
	public String main_main(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("main_jsp", "../main/home.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("main/staylisthome.do")
	public void main_staylisthome(HttpServletRequest request,HttpServletResponse response) {
		String fd=request.getParameter("fd");
		if(fd==null) {
			fd="가평";
		}
		StayDAO dao=StayDAO.newInstance();
		List<StayVO> sList=dao.stayAddressListData(fd);
		try
		{
			PrintWriter out=response.getWriter();
			out.println(sList);
		}catch(Exception ex) {}
	}
}
