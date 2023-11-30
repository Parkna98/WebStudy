package com.sist.view;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;

@WebServlet("/GoodsDetailServlet")
public class GoodsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); // DEFAULT => ISO-8859_1
		// 클라이언트가 보낸 데이터 받기
		PrintWriter out=response.getWriter();
		// mode => 화면 변경
		// no, type => DetailServlet
		String no=request.getParameter("no");
		String type=request.getParameter("type");
		// DAO 연동
		GoodsDAO dao=GoodsDAO.newInstancce();
		GoodsVO vo=dao.goodsDetailData(Integer.parseInt(no), Integer.parseInt(type));
		// 화면출력
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel=\"stylesheet\" href=\"css/style.css\">");
		out.write("</head>");
		out.write("<body>");
		String html="<div class=\"container\">"
				+ "		<div class=\"row\">"
				+ "			<table class=\"table\">"
				+ "				<tr>"
				+ "					<td width=\"35%\" align=\"center\" rowspan=\"9\">"
				+ "						<img src="+vo.getPoster()+" id=\"image\">"
				+ "					</td>"
				+ "					<td width=\"65%\" align=\"center\">"
				+ "						<span id=\"title\">"
				+ vo.getName()
				+ "						</span>"
				+ "					</td>"
				+ "				</tr>"
				+ "				<tr>"
				+ "					<td width=\"65%\">"
				+ "						<span id=\"sub\">"+vo.getSub()+"</span>"
				+ "					</td>"
				+ "				</tr>"
				+ "				<tr>"
				+ "					<td width=\"65%\">"
				+ "						<span id=\"percent\">"+vo.getDiscount()+"</span>&nbsp;"
				+ "						<span id=\"price\">"+vo.getPrice()+"</span>"
				+ "						<p>"
				+ "							<del id=\"psub\">9,900원</del>"
				+ "						</p>						"
				+ "					</td>"
				+ "				</tr>"
				+ "				<tr>"
				+ "					<td width=\"65%\">"
				+ "						<span id=\"label\">첫구매할인가</span>"
				+ "						<span id=\"price2\">"+vo.getPrice()+"</span>"
				+ "					</td>"
				+ "				</tr>"
				+ "				<tr>"
				+ "					<td width=\"65%\">"
				+ "						<span id=\"star\">★★☆☆☆</span>&nbsp;"
				+ "						<span id=\"bold\">4.5</span>"
				+ "						<span id=\"count\">(1)</span>"
				+ "					</td>"
				+ "				</tr>"
				+ "				<tr>"
				+ "					<td width=\"65%\">"
				+ "						<img src=\"https://recipe1.ezmember.co.kr/img/mobile/icon_delivery3.png\">"
				+ "						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "						<span id=\"delivery\">"+vo.getDelivery()+"</span>"
				+ "					</td>"
				+ "				</tr>"
				+ "				<tr>"
				+ "					<td width=\"65%\">"
				+ "						<select id=\"sel\">"
				+ "							<option>[선택]옵션 선택</option>"
				+ "						</select>"
				+ "					</td>"
				+ "				</tr>"
				+ "				<tr>"
				+ "					<td width=\"65%\">"
				+ "						<input type=\"button\" value=\"장바구니\" id=\"cart\">"
				+ "						<input type=\"button\" value=\"바로구매\" id=\"buy\">"
				+ "					</td>"
				+ "				</tr>"
				+ "			</table>"
				+ "		</div>"
				+ "	</div>";
		out.write(html);
		out.write("</body>");
		out.write("</html>");
		// => head, style, script => 닫기를 하지 않으면 흰색화면만 출력
 	}

}
