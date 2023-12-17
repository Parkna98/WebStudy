package com.sist.dao;
import com.sist.vo.*;
import com.sist.dbcp.*;

import java.util.*;
import java.sql.*;

public class SeoulDAO {
	private Connection conn; // DB연결 
	private PreparedStatement ps; // SQL문장 전송, 결과값 받기
	private static SeoulDAO dao;
	// dbcp 라이브러리
	private CreateDBCPConnection dbconn=new CreateDBCPConnection();
	
	public static SeoulDAO newInstance() {
		if(dao==null)
			dao=new SeoulDAO();
		return dao;
	}
	// 기능
	// 1. 명소 => seoul_location
	public List<SeoulVO> seoulLocationListData(int page,String tab){
		List<SeoulVO> list=new ArrayList<SeoulVO>();
		try {
			// 1. 연결
			conn=dbconn.getConnection();
			// 2. SQL문장 전송
			String sql="SELECT no,title,poster,num "
					+ "FROM (SELECT no,title,poster,rownum AS num "
					+ "FROM (SELECT no,title,poster "
					+ "FROM "+tab+" ORDER BY no ASC)) "
					+ "WHERE num between ? AND ?";
			// 3. 미리 전송
			ps=conn.prepareStatement(sql);
			// 4. 실행 요청 전에 ?에 값을 채운다
			int rowSize=12;
			int start=(page*rowSize)-(rowSize-1); // 오라클 1번
			int end=page*rowSize;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			// 5. 실행후에 결과값을 받는다
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SeoulVO vo=new SeoulVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	
	public int seoulLocationTotalPage(String tab) {
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM "+tab;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return total;
	}
	// 2. 자연 => seoul_nature
//	public List<NatureVO> seoulNatureListData(int page){
//		List<NatureVO> list=new ArrayList<NatureVO>();
//		try {
//			conn=dbconn.getConnection();
//			String sql="SELECT no,title,poster,num "
//					+ "FROM (SELECT no,title,poster,rownum AS num "
//					+ "FROM (SELECT no,title,poster "
//					+ "FROM seoul_nature ORDER BY no)) "
//					+ "WHERE num between ? AND ?";
//		}catch(Exception ex) {
//			ex.printStackTrace();
//		}finally {
//			dbconn.disConnection(conn, ps);
//		}
//		return list;
//	}
	// 3. 쇼핑 => seoul_shop
	
	
}
