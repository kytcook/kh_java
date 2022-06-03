package jdbc.oracle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpSumList extends JFrame implements ActionListener {
	JButton jbtn_select = new JButton("조회");
	String headers[] = { "부서명", "CLERK", "MANAGER", "ETC", "DEPT", "DEPT_SAL" };
	String data[][] = new String[0][5];
	// 데이타셋 포맷을 나타냄
	DefaultTableModel dtm = new DefaultTableModel(data, headers);
	JTable jtb = new JTable(dtm);
	// 스크롤바(속지) - 글이 많아졌을 때 스크롤바
	JScrollPane jsp = new JScrollPane(jtb);
	// 물리적으로 떨어져 있는 오라클 서버에 연결통로 확보
	Connection con = null;
	// 개발자가 작성한 select문 전달하고 오라클 서버에 처리 요청
	PreparedStatement pstmt = null;
	// 오라클 서버에서 조회한 결과를 반환해 주면 커서 조작하기
	ResultSet rs = null;
	DBConnectionMgr dbmgr = new DBConnectionMgr();

	public EmpSumList() {
		jbtn_select.addActionListener(this); // actionperformed가 내 안에 있다.
		initDisplay();
	}

	// List<맵타입<스트링과 오브젝트 키값을 갖는>>
	public List<Map<String, Object>> getEmpSumList() {
		System.out.println("getEmpSumList 호출 성공");
		List<Map<String, Object>> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();

		sql.append(" 	SELECT                                                                   ");
		sql.append("        decode(b.rno,'1',a.dname,'총계')DNAME                                 ");
		sql.append("       ,SUM(clerk) clerk                                                     ");
		sql.append("       ,SUM(manager) manager                                                 ");
		sql.append("       ,sum(etc) etc                                                         ");
		sql.append("       ,sum(dept_sal) dept_sal                                               ");
		sql.append("   FROM     (                                                                ");
		sql.append("          SELECT DEPT.DNAME                                                  ");
		sql.append("                ,sum(decode(job, 'CLERK', sal)) CLERK                        ");
		sql.append("                ,sum(decode(job, 'MANAGER', sal)) MANAGER                    ");
		sql.append("                ,sum(decode(job, 'CLERK',NULL,'MANAGER',NULL, sal)) ETC      ");
		sql.append("                ,sum(sal) DEPT_SAL                                           ");
		sql.append("            FROM emp, dept                                                   ");
		sql.append("           WHERE emp.deptno = dept.deptno                                    ");
		sql.append("          GROUP BY DEPT.DNAME                                                ");
		sql.append("            )a,                                                              ");
		sql.append("            (                                                                ");
		sql.append("               SELECT rownum rno FROM dept --==>DEPT는 경우의 수가 4가지이니      ");
		sql.append("               WHERE rownum <3 --==>ROWNUM 작다 작거나 같다만 가능          		 ");
		sql.append("             )b                                                              ");
		sql.append(" GROUP BY decode(b.rno,'1',a.dname,'총계')                                    ");
		sql.append(" ORDER BY decode(b.rno,'1',a.dname,'총계')                                 ");

		try {
			con = dbmgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Map<String, Object> rmap = null;
			while (rs.next()) {
				rmap = new HashMap<>();
				rmap.put("dname", rs.getString(1));
				rmap.put("clerk", rs.getDouble(1));
				rmap.put("manager", rs.getDouble(1));
				rmap.put("etc", rs.getDouble(1));
				rmap.put("dept_sal", rs.getDouble(1));
				list.add(rmap);
			}
			System.out.println(list);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}

	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		this.add("North", jbtn_select);
		// 포개진다? 속지? 무야
		this.add("Center", jsp);
		this.setSize(500, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new EmpSumList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트가 감지된 컴포넌트의 주소번지, 힙 스택
		Object obj = e.getSource();
		if (jbtn_select == obj) {
			System.out.println("조회버튼 누른거야!?");
			getEmpSumList();
		}

	}
}
