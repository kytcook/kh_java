package jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {

	public static void main(String[] args) {
		// 물리적으로 떨어져 있는 오라클 서버와 연결통로,채널을(를) 만든다.
		// 테이블이름,패스워드,지역 등등 변수값만 바뀐다
		// 형태는 항상 같다.
		// 커넥션의 인스턴스화 -> 단독으로는 불가 -> 메소드 호출로 객체생성 가능하다.
		// getConnection(URL, userName, pw)
		Connection 			con	  = null; // Interface - 단독으로 인스턴스화 불가 A a = new A() X 
		// 오라클 서버에 sql문을 전달할 때 사용함.
		PreparedStatement 	pstmt = null;
		// 조회결과를 받아서 자바에서 출력할 때 오라클에 커서를 조작해야 함.
		// SELECT문을 오라클에게 전달해준다.
		// ? 데이터(멤버테이블, 멤버집합)가 오라클에 있기 때문에.
		ResultSet			rs	  = null;
		String sql = "SELECT deptno, dname, loc FROM dept";
		// 물리적으로 떨어져있기 때문에 반드시 예외처리가 와야한다.
		try {
			// 오라클 제조사가 제공하는 드라이버 클래스가 있어야 함.
			// 있는 위치는 D:\\oracle_App\\jdbc\\lib 아래에 ojdbc6.jar안에 있어요
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.11:1521:orcl","YURI","tiger");
			// 파라미터로 받은 select문을 전달
			pstmt = con.prepareStatement(sql);
			// 전달 된 select문에 대한 처리를 요청하고 커서 받아내기
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("deptno")+", "+rs.getString("loc"));
			}
			System.out.println(con+"생성 되었나요?");
		} catch (Exception e) {
			System.out.println("오라클 서버와 연결 통로 확보 실패");
			// stack메모리에 쌓인 에러 메시지에 대한 history정보 출력 해줌
			e.printStackTrace();
		}
		// 서버계정 ip
		// 아이디
		// pw        -> connection
		
		
	}

}
