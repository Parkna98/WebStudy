package com.sist.dao;
// 회원, 로그인
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;
import javax.naming.spi.DirStateFactory.Result;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static MemberDAO dao;
	
	// 타입 번호주기위한 테이블 생성 => 0번은 안쓰기때문에 맨앞 공백 (임의로 생성 => all : 1번 , special : 2번...)
	public void getConnection() {
		try {
			Context init=new InitialContext();
			Context c=(Context)init.lookup("java://comp/env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		}catch(Exception ex) {}
	}
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	public static MemberDAO newInstancce() {
		if(dao==null)
			dao=new MemberDAO();
		return dao;
	}
	
	// 기능처리
	public MemberVO memberLogin(String id,String pwd) {
		MemberVO vo=new MemberVO();
		try {
			// 1. 주소값 얻어오기
			getConnection();
			// 2. SQL문장 전송
			String sql="SELECT COUNT(*) FROM member_servlet "
					+ "WHERE id=?";
			/*
			  		로그인 처리
			  		1. id의 존재여부 확인 => COUNT() => 0, 1
			 		2. id(x) => 종료 => NO ID
			 		3. id(o) => pwd 확인 
			 				 => pwd(x) => 종료 => no pwd
			 				 => pwd(o) => 종료 => ok => 화면 이동 (MainServlet)
			 				 ===========================
			 				 	개인 정보중에 프로그램 종료시까지 
			 				 	유지해야되는 데이터를 세션에 저장
			 				 	    			 === 모든 서블릿/JSP 필요시마다 사용이가능
			 				 	    			 === 전역변수
			 				 	세션 / 쿠키 ==> 저장공간
			 				 		   ㅣ브라우저(로컬)에 저장 (보안 취약)
			 				 	 ㅣ서버에 저장 (보안)
			 				 	 	1) 저장
			 				 	 	2) 수정
			 				 	 	3) 일부 정보 삭제
			 				 	 	4) 모든 정보 삭제
			 				 	 	5) 저장 기간 설정
			 */
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			if(count==0) { // ID가 없는 상태
				vo.setMsg("NOID");
			}
			else {	// ID가 있는 상태
				sql="SELECT pwd,name FROM member_servlet "
						+ "WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				rs.close();
				if(db_pwd.equals(pwd)) {
					vo.setMsg("OK");
					vo.setName(name);
				}
				else {
					vo.setMsg("NOPWD");
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		
		return vo;
	}
}
