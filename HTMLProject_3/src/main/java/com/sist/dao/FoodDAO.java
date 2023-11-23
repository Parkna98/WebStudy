package com.sist.dao;
import java.sql.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 싱글턴 방식 => static으로 dao생성
	// => 속도를 줄이는 방법
	private static FoodDAO dao; 
	// 드라이버 등록 => 한번만 생성 => 생성자
	public FoodDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {} 
	}
	// 오라클 연결
	// 실무에서는 DBCP로 오라클 연결해야함 (보안상의 이유)
	// DBCP => 웹
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
	// 싱글턴 패턴 => 메모리 공간을 한개만 생성
	// null일때 생성하고 생성된 한개로 쭉 쓴다 (static)
	public static FoodDAO newInstance() {
		// 라이브러리 => newInstance, getInstance() => 싱글턴
		if(dao==null) 
			dao=new FoodDAO();
		return dao;
		
	}
	// 기능 설정
	// => 목록(table) => 인라인뷰 => 페이지 설정
	public List<FoodVO> foodListData(int page){
		List<FoodVO> list=new ArrayList<FoodVO>();
		// FoodVO = ROW
		// https://www.menupan.com/
		// /restaurant/restimg/009/zzmenuimg/t16846914_z.jpg => 앞에 역슬래쉬 1개면 서버주소 붙여서 실행
		// (http:)//restaurant/restimg/009/zzmenuimg/t16846914_z.jpg => 앞에 역슬래쉬 2개면 그냥 실행 
		try {
			getConnection();
			// 페이지마다 데이터 읽기 
			int rowSize=20;
			// num BETWEEN ? AND ? => 1page 1~20
			//						  2page 21~40
			//							... 
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			String sql="SELECT fno,poster,name,type,address,num "
					+"FROM (SELECT fno,poster,name,type,address,rownum as num "
					+"FROM (SELECT /*+ INDEX_ASC(food_menu_house fh_fno_pk)*/fno,poster,name,type,address "
					+"FROM food_menu_house)) "
					+"WHERE num BETWEEN ? AND ?";
			// 실무에서는 위처럼 order by를 쓰지 않고 index_asc를 쓴다
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			// INDEX_ASC(테이블명 인덱스명,PK,UK), INDEX_DESC(), INDEX()
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setPoster("https://www.menupan.com"+rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setType(rs.getString(4));
				vo.setAddress(rs.getString(5));
				
				list.add(vo);
				// 직접구현 => 80%
				// 20% => 정보,이미지
			}
			rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	// 총 페이지 
	public int foodTotalPage() {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/20.0) FROM food_menu_house";
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
	// => 상세보기 (table)
}
