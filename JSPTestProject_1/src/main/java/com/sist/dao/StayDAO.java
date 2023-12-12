package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
import com.sist.dbcp.*;

public class StayDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDBCPConnection dbconn=new CreateDBCPConnection();
	private final int ROW_SIZE=12;
	
	// 목록출력
	public List<stayVO> StayListData(int page){
		List<stayVO> list=new ArrayList<stayVO>();
		try {
			conn=dbconn.getConnection();
			// num BETWEEN ? AND ? => 1page 1~20
			//						  2page 21~40
			//							... 
			int start=(ROW_SIZE*page)-(ROW_SIZE-1);
			int end=ROW_SIZE*page;
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
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				stayVO vo=new stayVO();
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
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	public int StayTotalPage() {
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/"+ROW_SIZE+") FROM stayinfo";
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
}
