package com.sist.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;

@WebServlet("/StayListServlet")
public class StayListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		//						 text/xml, text/plain...
		// HTML전송
		PrintWriter out=response.getWriter();
		//				---------------------- 접속한 클라이언트 브라우저
		StayDAO dao=StayDAO.newInstance(); // 한개만 생성해서 쓸것임
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int totalpage=dao.StayTotalPage();
		List<StayVO> list=dao.StayListData(curpage);
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=stylesheet href=Stay/table.css>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>숙박업체 목록</h1>");
		out.println("<table class=table_content width=800>");
		out.println("<tr>");
		out.println("<th width=10%>번호</th>");
		out.println("<th width=20%></th>");
		out.println("<th width=20%>업체명</th>");
		out.println("<th width=10%>업종</th>");
		out.println("<th width=40%>주소</th>");
		out.println("</tr>");
		for(StayVO vo:list) {
			out.println("<tr class=dataTr>");
			out.println("<td width=10%>"+vo.getStayno()+"</td>");
			out.println("<td width=20%><img src="+vo.getImage()+" width=60 hight=90></td>");
			out.println("<td width=20%><a href=StayDetailServlet?sno="+vo.getStayno()+">"+vo.getName()+"</a></td>");
//			out.println("<td width=20%>"+vo.getName()+"</td>");
			out.println("<td width=10%>"+vo.getType()+"</td>");
			out.println("<td width=40%>"+vo.getAddress()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<table class=table_content width=800>");
		out.println("<tr>");
		out.println("<td align=center>");
		out.println("<a href=\"StayListServlet?page="+(curpage>1?curpage-1:curpage)+"\">이전</a>");
		out.println(curpage+" page / ");
		out.println(totalpage+" pages");
		out.println("<a href=\"StayListServlet?page="+(curpage<totalpage?curpage+1:curpage)+"\">다음</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

		
	
}
