package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.*;
import java.io.*;
public class DataBoardDAO {
	private static SqlSessionFactory ssf;
	static {
		// xml => parse
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// => 단순 (1. JOIN, 2. 동적쿼리)
	// 목록 출력
	/*
	 * <select id="databoardListData" resultType="DataBoardVO" parameterType="hashmap">
		  <!-- setter로 변환되기때문에 함수는 as로 변수명으로 반드시 나와야한다 -->
		    SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num
		    FROM (SELECT no,subject,name,regdate,hit,rownum as num
		    FROM (SELECT no,subject,name,regdate,hit
		    FROM project_databoard))
		    WHERE num BETWEEN #{start} AND #{end}
  		</select>
	 */
	public static List<DataBoardVO> databoardListData(Map map){
		
		SqlSession session=null;
		List<DataBoardVO> list=new ArrayList<DataBoardVO>();
		try {
			session=ssf.openSession();
			list=session.selectList("databoardListData",map);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null){
				session.close();
			}
		}
		return list;
	}
	
	public static int databoardRowCount() {
		
		SqlSession session=null;
		int count=0;
		try {
			// getConnection
			session=ssf.openSession();
			count=session.selectOne("databoardRowCount");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null)
				session.close(); // 반환 => disConnection()
			// => Connection/PreparedStatement
		}
		return count;
	}
	
	public static void databoardInsert(DataBoardVO vo) {
		
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.insert("databoardInsert",vo);
			session.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		// true => commit을 사용 (빈칸이면 false)
	}
	
	public static DataBoardVO databoardDetailData(int no) {
		DataBoardVO vo=new DataBoardVO();
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.update("hitIncrement",no);
			vo=session.selectOne("databoardDetailData",no);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return vo;
	}
	
	public static DataBoardVO databoardFileInfoData(int no) {
		DataBoardVO vo=new DataBoardVO();
		SqlSession session=null;
		try {
			session=ssf.openSession();
			vo=session.selectOne("databoardFileInfoData",no);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return vo;
	}
	
	public static String databoardDelete(int no,String pwd) {
		String res="no";
		SqlSession session=ssf.openSession(true);
		String db_pwd=session.selectOne("databoardDelete",no);
		if(db_pwd.equals(pwd)) {
			res="yes";
			session.delete("databoardDelete",no);
		}
		return res;
	}
	
	public static DataBoardVO databoardUpdateData(int no) {
		SqlSession session=ssf.openSession();
		DataBoardVO vo=session.selectOne("databoardDetailData",no);
		session.close();
		return vo;
	}
	
	public static String databoardUpdate(DataBoardVO vo) {
		String res="no";
		SqlSession session=ssf.openSession(true);
		String db_pwd=session.selectOne("databoardGetPassword",vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			res="yes";
			session.update("databoardUpdate",vo);
		}
		session.close();
		return res;
	}
	
}
