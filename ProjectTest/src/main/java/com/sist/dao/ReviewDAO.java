package com.sist.dao;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;
import javax.naming.spi.DirStateFactory.Result;

public class ReviewDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static ReviewDAO dao;
	
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
	public static ReviewDAO newInstance() {
		if(dao==null)
			dao=new ReviewDAO();
		return dao;
	}
	// 1. 목록 
	// typeno => 1:stay 2:shop 3:hospital 4:funeral
	public List<ReviewVO> reviewListData(int typeno,int gno){
		List<ReviewVO> list=new ArrayList<ReviewVO>();
		try {
			getConnection();
			String sql="SELECT rno,id,name,msg,score,star,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') "
					+ "From review_test "
					+ "WHERE typeno=? AND gno=? "
					+ "ORDER BY rno DESC";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, typeno);
			ps.setInt(2, gno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ReviewVO vo=new ReviewVO();
				vo.setRno(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setMsg(rs.getString(4));
				vo.setScore(rs.getDouble(5));
				vo.setStar(rs.getString(6));
				vo.setDbday(rs.getString(7));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
	// 리뷰 작성
	public void reviewInsert(ReviewVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO review_test VALUES("
					+ "rt_rno_seq.nextval,?,?,?,?,?,SYSDATE,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getTypeno());
			ps.setInt(2, vo.getGno());
			ps.setString(3, vo.getId());
			ps.setString(4, vo.getName());
			ps.setString(5, vo.getMsg());
			ps.setDouble(6, vo.getScore());
			ps.setString(7, vo.getStar());
			ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
	// 삭제
	public void reviewDelete(int rno) {
		try {
			getConnection();
			String sql="DELETE FROM review_test "
					+ "WHERE rno="+rno;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
}
