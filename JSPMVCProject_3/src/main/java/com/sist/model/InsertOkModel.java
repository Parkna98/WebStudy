package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertOkModel implements Model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "게시판 데이터 추가 완료");
		return "board/insert_ok.jsp";
	}

}
