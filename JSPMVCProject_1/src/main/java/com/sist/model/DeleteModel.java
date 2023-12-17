package com.sist.model;

import javax.servlet.http.HttpServletRequest;
// 요청을 받아서 처리한 결과값 전송
public class DeleteModel {
	public String execute(HttpServletRequest request) {
		request.setAttribute("msg", "게시판 삭제");
		return "delete.jsp"; // request를 받아서 출력
	}
}
