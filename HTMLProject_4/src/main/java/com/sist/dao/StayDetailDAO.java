package com.sist.dao;
import java.util.*;
import java.sql.*;

public class StayDetailDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.102:1521:XE";
	private static StayDetailDAO dao;
	public StayDetailDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {} 
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	// 오라클 닫기
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	public static StayDetailDAO newInstance() {
		// 라이브러리 => newInstance, getInstance() => 싱글턴
		if(dao==null) 
			dao=new StayDetailDAO();
		return dao;
	}
	public StayDetailVO StayDetailData(int sno){
		StayDetailVO sdvo=new StayDetailVO();
		// FoodVO = ROW
		// https://www.menupan.com/
		// /restaurant/restimg/009/zzmenuimg/t16846914_z.jpg => 앞에 역슬래쉬 1개면 서버주소 붙여서 실행
		// (http:)//restaurant/restimg/009/zzmenuimg/t16846914_z.jpg => 앞에 역슬래쉬 2개면 그냥 실행 
		try {
			getConnection();
			String sql="SELECT stype,sname,score,address,detail_address,price,review_count,around,basic,petinfo,other,mainimage FROM stayinfo,STAYDETAIL,stayimage "
					+ "WHERE stay_no=sdno AND stay_no=sino AND stay_no="+sno;
			// 실무에서는 위처럼 order by를 쓰지 않고 index_asc를 쓴다
			ps=conn.prepareStatement(sql);
			// INDEX_ASC(테이블명 인덱스명,PK,UK), INDEX_DESC(), INDEX()
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				sdvo.setType(rs.getString(1));
				sdvo.setName(rs.getString(2));
				sdvo.setScore(rs.getDouble(3));
				sdvo.setAddress(rs.getString(4));
				sdvo.setDetailaddr(rs.getString(5));
				sdvo.setPrice(rs.getInt(6));
				sdvo.setRevcount(rs.getInt(7));
				sdvo.setAround(rs.getString(8));
				sdvo.setBasic(rs.getString(9));
				sdvo.setPetinfo(rs.getString(10));
				sdvo.setOther(rs.getString(11));
				sdvo.setImage(rs.getString(12));

				// 직접구현 => 80%
				// 20% => 정보,이미지
			}
			rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return sdvo;
	}
	// 총 페이지 
	public int StayTotalPage() {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/20.0) FROM stayinfo";
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
}
