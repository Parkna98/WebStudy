package com.sist.dao;
import java.util.*;
import java.sql.*;

public class StayDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.102:1521:XE";
	private static StayDAO dao;
	public StayDAO() {
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
	public static StayDAO newInstance() {
		// 라이브러리 => newInstance, getInstance() => 싱글턴
		if(dao==null) 
			dao=new StayDAO();
		return dao;
	}
	public List<StayVO> StayListData(int page){
		List<StayVO> list=new ArrayList<StayVO>();
		// FoodVO = ROW
		// https://www.menupan.com/
		// /restaurant/restimg/009/zzmenuimg/t16846914_z.jpg => 앞에 역슬래쉬 1개면 서버주소 붙여서 실행
		// (http:)//restaurant/restimg/009/zzmenuimg/t16846914_z.jpg => 앞에 역슬래쉬 2개면 그냥 실행 
		try {
			getConnection();
			// 페이지마다 데이터 읽기 
			int rowSize=12;
			// num BETWEEN ? AND ? => 1page 1~20
			//						  2page 21~40
			//							... 
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			String sql="SELECT stay_no,stype,sname,score,address,price,mainimage,num "
					+ "FROM STAYIMAGE,(SELECT stay_no,stype,sname,score,address,price,rownum as num "
					+ "FROM (SELECT /*+ INDEX_ASC(stayinfo stayinfo_stay_no_pk)*/stay_no,stype,sname,score,address,price,mainimage "
					+ "FROM stayinfo,STAYIMAGE WHERE STAYIMAGE.SINO=stayinfo.STAY_NO)) "
					+ "WHERE (STAYIMAGE.SINO=STAY_NO) "
					+ "AND (num BETWEEN ? AND ?)";
			// 실무에서는 위처럼 order by를 쓰지 않고 index_asc를 쓴다
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			// INDEX_ASC(테이블명 인덱스명,PK,UK), INDEX_DESC(), INDEX()
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				StayVO vo=new StayVO();
				vo.setStayno(rs.getInt(1));
				vo.setType(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setScore(rs.getDouble(4));
				vo.setAddress(rs.getString(5));
				vo.setPrice(rs.getInt(6));
				vo.setImage(rs.getString(7));
				
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
	// 상세보기
	public StayVO StayDetailData(int sno){
		StayVO sdvo=new StayVO();
		// FoodVO = ROW
		// https://www.menupan.com/
		// /restaurant/restimg/009/zzmenuimg/t16846914_z.jpg => 앞에 역슬래쉬 1개면 서버주소 붙여서 실행
		// (http:)//restaurant/restimg/009/zzmenuimg/t16846914_z.jpg => 앞에 역슬래쉬 2개면 그냥 실행 
		try {
			getConnection();
			String sql="SELECT stype,sname,score,address,detail_address,price,review_count,around,basic,petinfo,other,mainimage,sub1,sub2,sub3,sub4 FROM stayinfo,STAYDETAIL,stayimage "
					+ "WHERE stay_no=sdno AND stay_no=sino AND stay_no=?";
			// 실무에서는 위처럼 order by를 쓰지 않고 index_asc를 쓴다
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sno);
			// INDEX_ASC(테이블명 인덱스명,PK,UK), INDEX_DESC(), INDEX()
			ResultSet rs=ps.executeQuery();
			rs.next();
				
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
				sdvo.setSub1(rs.getString(13));
				sdvo.setSub2(rs.getString(14));
				sdvo.setSub3(rs.getString(15));
				sdvo.setSub4(rs.getString(16));

				// 직접구현 => 80%
				// 20% => 정보,이미지
			
				rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return sdvo;
	}
	// 룸 목록
	public List<RoomVO> RoomListData(int stno){
		List<RoomVO> list=new ArrayList<RoomVO>();
		try {
			getConnection();
			String sql="SELECT rno,roomno,room_image,room_name,room_price,stayno FROM roominfo "
					+ "WHERE stayno="+stno+" ORDER BY rno";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RoomVO vo=new RoomVO();
				vo.setRno(rs.getInt(1));
				vo.setRoomno(rs.getInt(2));
				vo.setImage(rs.getString(3));
				vo.setName(rs.getString(4));
				vo.setPrice(rs.getInt(5));
				vo.setStayno(rs.getInt(6));
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
	// 총 페이지 
	public int StayTotalPage() {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM stayinfo";
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
