package ajaStudy01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionMgr {
	//선언문
	Connection con = null;					
	PreparedStatement pstmt = null;			// 연결 PreparedStatement : 한번에 불러와서 다 가지고 있다가 하나씩- Statement : 하나씩 불러와서 전달
	ResultSet rs = null;					// 커서 : 테이블 내의 컬럼에서 하나씩하나씩 내려간다.
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl11";
	public static final String user = "scott";
	public static final String pw = "tiger";
	
	public Connection getConnection()	// 오라클과 자바의 연결
	{
		try { // 썼을 때 안되는 이유를 알아야 하니까 - 에러를 잡아야한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,pw); // 위의 값들을 받아서 연결을 시도하겠다.
		} catch (Exception e) { 
			e.printStackTrace(); // 빨간색 줄 보여주는거
			System.out.println(); 
		}
		return con;
	}
	public static void freeConnection(ResultSet rs, PreparedStatement pstmt, Connection con){
		try { // 연결을 끊겠다. 
			if(rs !=null) rs.close();			// 실행이 되고 있다면, rs를 닫아라.
			if(pstmt !=null) pstmt.close();		// pstmt 실행중이면, 닫아라.
			if(con !=null) con.close(); 		// con도 실행중이면 닫아라.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void freeConnection(PreparedStatement pstmt, Connection con){
		try {
			if(pstmt !=null) pstmt.close();
			if(con !=null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

