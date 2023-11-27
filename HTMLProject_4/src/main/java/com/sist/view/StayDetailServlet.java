package com.sist.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import com.sist.dao.*;

@WebServlet("/StayDetailServlet")
public class StayDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String sno=request.getParameter("sno");
		StayDAO dao=StayDAO.newInstance();
		StayDetailVO vo=dao.StayDetailData(Integer.parseInt(sno));
		List<RoomVO> rlist=dao.RoomListData(Integer.parseInt(sno));
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=stylesheet href=Stay/table.css>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<table class=table_content width=800>");
		out.println("<tr>");
		out.println("<td width=30% align=center>");
		out.println("<img src="+vo.getImage()+" style=\"width:100%\">");
		out.println("</td>");
		out.println("<td width=70%><h3>"+vo.getName()+"</h3></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th width=15%>유형");
		out.println("</th>");
		out.println("<td width=55%>"+vo.getType());
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=15%>주소");
		out.println("</th>");
		out.println("<td width=55%>"+vo.getAddress());
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=15%>상세주소");
		out.println("</th>");
		out.println("<td width=55%>"+vo.getDetailaddr());
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=15%>평점");
		out.println("</th>");
		out.println("<td width=55%>"+vo.getScore());
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th width=15%>주변정보");
		out.println("</th>");
		out.println("<td width=55%>"+vo.getAround());
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=15%>기타정보");
		out.println("</th>");
		out.println("<td width=55%>"+vo.getOther());
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=15%>기본정보");
		out.println("</th>");
		out.println("<td width=55%>"+vo.getBasic());
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</table>");
		
		out.println("<table class=table_content width=800>");
		out.println("<tr>");
		out.println("<th width=15%>번호</th>");
		out.println("<th width=40%></th>");
		out.println("<th width=20%>방이름</th>");
		out.println("<th width=25%>가격</th>");
		out.println("</tr>");
		for(RoomVO rvo:rlist) {
			out.println("<tr class=dataTr>");
			out.println("<td width=15%>"+rvo.getRoomno()+"</td>");
			out.println("<td width=40%><img src="+rvo.getImage()+" width=60 hight=90></td>");
			out.println("<td width=20%>"+rvo.getName()+"</td>");
			out.println("<td width=25%>"+rvo.getPrice()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	}


}
