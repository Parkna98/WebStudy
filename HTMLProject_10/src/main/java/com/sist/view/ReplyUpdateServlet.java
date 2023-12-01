package com.sist.view;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;

@WebServlet("/ReplyUpdateServlet")
public class ReplyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// rno, gno, typeno, msg
			// 한글 => 디코딩
		try {
			// 전송 => 자바 => %EC%9E... (인코딩)
			// 수신 => %EC%9E... => 자바 (디코딩)
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		String rno=request.getParameter("rno");
		String gno=request.getParameter("gno");
		String tno=request.getParameter("typeno");
		String msg=request.getParameter("msg");
		
		// DAO => 수정 
		ReplyDAO dao=ReplyDAO.newInstancce();
		dao.replyUpdate(Integer.parseInt(rno), msg);
		// 화면 => Detail로 이동
		response.sendRedirect("MainServlet?mode=5&no="+gno+"&type="+tno);
	}

}
