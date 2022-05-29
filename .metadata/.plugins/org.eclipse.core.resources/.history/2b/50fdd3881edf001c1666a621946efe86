package jdbc.oracle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

// 이벤트 처리를 위한 implements를 위한 인터페이스 -> 혼자서는 못쓰는 추상클래스 -> 구현체 클래스
public class DeptManager extends JFrame implements ActionListener{
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	// oci방식과 thin 드라이버 방식 / thin -> 서버를 여러개 두는 멀티티어 환경에서는 thin 드라이버 방식을 권장
	public static final String _URL = "jdbc:oracle:thin:@192.168.40.3:1521:orcl11";
	public static final String _USER = "scott";
	public static final String _PW = "tiger";
	Connection 			con	  = null; // Interface - 단독으로 인스턴스화 불가 A a = new A() X 
	PreparedStatement 	pstmt = null;
	ResultSet			rs	  = null;
	String sql = "SELECT deptno, dname, loc FROM dept";
	JButton jbtn_select = new JButton("조회");
	public DeptManager() {
		// 토막상식 : 객체지향 모르면 리액트 hook - 지금은 주류를 이루고 있다.
		// 이벤트 처리를 담당하는 핸들러 클래스의 주소번지
		// 내 안에 actionPerformed 메소드가 재정의 되어있다면 this
		jbtn_select.addActionListener(this);
		initDisplay();
	}
	public List<Map<String,Object>> getDeptList(){
		List<Map<String,Object>> deptList = null;
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL,_USER,_PW);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			deptList = new ArrayList<>();
			Map<String, Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
				deptList.add(rmap);
			}
			System.out.println(con+"생성 되었나요?");
		} catch (Exception e) {
			System.out.println("오라클 서버와 연결 통로 확보 실패");
			e.printStackTrace();
		}

		return deptList;
	}
	public void initDisplay () {
		this.add("North", jbtn_select);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		
		
	}
	
	//조회버튼이 셀렉트이다. 더 이상 미정이 아니다.
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtn_select) {
			List<Map<String,Object>>deptList = getDeptList();
			for(int i = 0; i < deptList.size(); i++) {
				Map<String,Object> rmap = deptList.get(i);
				System.out.println(rmap.get("deptno"));
				
			}
		}
		
	}

}
