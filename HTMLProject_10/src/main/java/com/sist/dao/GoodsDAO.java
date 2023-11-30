package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	private static GoodsDAO dao;
	// 타입 번호주기위한 테이블 생성 => 0번은 안쓰기때문에 맨앞 공백 (임의로 생성 => all : 1번 , special : 2번...)
	private String[] tables= {"","goods_all","goods_special","goods_best","goods_new"};
	private final int ROW=12;
	
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
	public static GoodsDAO newInstancce() {
		if(dao==null)
			dao=new GoodsDAO();
		return dao;
	}
	public List<GoodsVO> goodsListData(int page,int type){
		List<GoodsVO> list=new ArrayList<GoodsVO>();
		try {
			getConnection();
			String sql="SELECT no,goods_name,goods_poster,num "
					+ "FROM (SELECT no,goods_name,goods_poster,rownum as num "
					+ "FROM (SELECT no,goods_name,goods_poster "
					+ "FROM "+tables[type]+" ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			// ps.setString(1,"goods_all") ==> 'goods_all' 처럼 자동으로 ''붙어서 오류남 => ?로 처리하지말고 저렇게 문장안에 +로 추가함
			ps=conn.prepareStatement(sql);
			int start=(page*ROW)-(ROW-1);
			int end=page*ROW;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				GoodsVO vo=new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3));
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
	public int goodsTotalPage(int type) {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(count(*)/"+ROW+") FROM "+tables[type];
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return total;
	}
	// 상세보기
	public GoodsVO goodsDetailData(int no,int type) {
		GoodsVO vo=new GoodsVO();
		try {
			getConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}
}
