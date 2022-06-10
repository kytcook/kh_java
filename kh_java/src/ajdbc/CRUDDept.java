package ajdbc.crud;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import jdbc.oracle.DBConnectionMgr;
import oracle.vo.DeptVO;

public class CRUDDept extends JFrame implements ActionListener {
	// 선언부
	//////////////////// DB연동 ///////////////////////
	// 오라클 서버와 연동하기 위한 서버들 드라이버 클래스
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 물리적으로 떨어진 오라클 서버와 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs 		= null;// 조회경우 커서를 조작 필요
	//////////////////// DB연동 ///////////////////////

	// 북쪽에 들어갈 버튼 4가지
	// JFrame의 디폴트 레이아웃은 BorderLayout
	JPanel 				jp_north = new JPanel();// 디폴트레이아웃 : FlowLAyout
	JButton 			jbtn_sel = new JButton("조회");
	JButton 			jbtn_ins = new JButton("입력");
	JButton 			jbtn_upd = new JButton("수정");
	JButton 			jbtn_del = new JButton("삭제");

	// 중앙에 들어갈 버튼
	String 				cols[] 		= { "부서번호", "부서명", "지역" };
	String 				data[][] 	= new String[0][3];
	DefaultTableModel 	dtm 		= new DefaultTableModel(data, cols);
	JTable 				jtb 		= new JTable(dtm); //
	JScrollPane 		jsp 		= new JScrollPane(jtb);

	// 남쪽에 들어갈 버튼
	JPanel 				jp_south 	= new JPanel(); // 디폴트레이아웃 : FlowLAyout
	JTextField 			jtf_deptno 	= new JTextField("", 20);
	JTextField 			jtf_dname 	= new JTextField("", 20);
	JTextField 			jtf_loc 	= new JTextField("", 20);

	// 생성자
	public CRUDDept() {
		// 이벤트발생을 듣는다
		jbtn_sel.addActionListener(this);
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		initDisplay();
	}

	/**************************************************
	 * 부서 등록 구현
	 * 
	 * @param pdVO - 사용자가 입력한 부서번호, 부서명, 지역을 받는다. - 복합데이터 클래스
	 * @return int - 1: 등록성공 0:등록실패 INSERT INTO dept(deptno, dname, loc)
	 *         VALUES(71,'개발1팀','서귀포'); - 내가 설계한 것과 DB의 값이 잘 일치하는지 확인하기 위해 복사붙여둔다
	 **************************************************/
	public int deptInsert(DeptVO pdVO) {
		System.out.println("deptInsert 호출 성공");
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(?,?,?)");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setInt(++i, pdVO.getDeptno());
			pstmt.setString(++i, pdVO.getDname());
			pstmt.setString(++i, pdVO.getLoc());
			result = pstmt.executeUpdate();
			if (result == 1) {
				setDeptno("");
				setDname("");
				setLoc("");
				deptSelectAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		return result;
	}

	/**************************************************
	 * 부서 수정 구현
	 * 
	 * @param pdVO - 사용자가 수정한 부서번호, 부서명, 지역을 받는다. - 복합데이터 클래스
	 * @return int - 1: 등록성공 0:등록실패 UPDATE dept SET dname = '개발2팀' ,loc = '거제도'
	 *         WHERE deptno = 71;
	 **************************************************/
	public int deptUpdate(DeptVO pdVO) {
		System.out.println("deptUpdate 호출 성공");
		int result = 0;

		return result;
	}

	/**************************************************
	 * 부서 삭제 구현
	 * 
	 * @param deptno(int) - 사용자가 선택한 부서번호
	 * @return int - 1: 등록성공 0:등록실패 DELETE FROM dept WHERE deptno = 71
	 **************************************************/
	public int deptDelete(int deptno) {
		System.out.println("deptUpdate 호출 성공" + deptno);
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM dept WHERE deptno = ?");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(this, "데이터가 삭제되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
				deptSelectAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		return result;
	}

	/****************************************
	 * 부서 목록 전체 조회 구현(새로고침시 재사용 위해서)
	 * 
	 * @return List<Map<String,Object>> SELECT deptno, dname, loc FROM dept
	 *****************************************/
	public List<Map<String, Object>> deptSelectAll() {
		System.out.println("deptSelectAll 호출 성공");
//		List<Map<String,Object>> deptList = null;
		List<Map<String, Object>> deptList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Map<String, Object> rmap = null;
			while (rs.next()) {
				rmap = new HashMap<>();
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
				deptList.add(rmap);
			}
//			System.out.println(deptList);// 단위테스트때문에 달아둔 것이므로 없애도 된다.
			// 자료구조가 존재하는지
			while (dtm.getRowCount() > 0) {// 여러번 조회를 누르더라도 뒤에 내용이 삭제되므로 검색된 로우의 수만큼 출력시킨다.
				dtm.removeRow(0);
			}
			Iterator<Map<String, Object>> iter = deptList.iterator();// 컬렉션프레임워크안에 유틸패키지를 지원하는 클래스 iterator
			Object keys[] = null;
			while (iter.hasNext()) {
				Map<String, Object> data = iter.next();
				keys = data.keySet().toArray();
				Vector<Object> oneRow = new Vector<>();
				oneRow.add(data.get(keys[2]));// 키값이 랜덤. 순서는 확인할 수 없다.
				oneRow.add(data.get(keys[1]));// 키값이 랜덤. 순서는 확인할 수 없다.
				oneRow.add(data.get(keys[0]));// 키값이 랜덤. 순서는 확인할 수 없다.
				dtm.addRow(oneRow);
//				System.out.println(keys[2]);
//				System.out.println(keys[1]);
//				System.out.println(keys[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();// 스택영역에 쌓여있는 에러 메시지를 순차적으로 출력해주는 메소드
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return deptList;
	}

	/****************************************
	 * 부서 상세 조회 구현(새로고침시 재사용 위해서)
	 * 
	 * @param deptno(int)
	 * @return DeptVO SELECT deptno, dname, loc FROM dept WHERE deptno = ?
	 *****************************************/
	public DeptVO deptSelectDetail(int deptno) {
		System.out.println("deptSelectDetail 호출 성공");
		DeptVO rdVO = null;
		return rdVO;
	}

	// 화면처리부
	public void initDisplay() {
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		jp_south.add(jtf_deptno);
		jp_south.add(jtf_dname);
		jp_south.add(jtf_loc);
		this.add("North", jp_north);
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setTitle("부서관리시스템");
		this.setSize(700, 400);
		this.setVisible(true);

	}

	// 메인메소드
	public static void main(String[] args) {
		CRUDDept a = new CRUDDept();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 너 조회 누른거야? - 조회버튼을 누르기 - 이벤트처리
		if (obj == jbtn_sel) {
			System.out.println("전체조회 호출 성공");
			deptSelectAll();
		}
		// 입력하고 싶니? - 입력버튼을 누르기 - 이벤트처리
		else if (obj == jbtn_ins) {
			System.out.println("입력 호출 성공");
			String deptno = getDeptno();
			String dname = getDname();
			String loc = getLoc();
//			System.out.println(deptno + ", " + dname + ", " + loc);

			DeptVO pdVO = new DeptVO();
			pdVO.setDeptno(Integer.parseInt(deptno));
			pdVO.setDname(dname);
			pdVO.setLoc(loc);
			deptInsert(pdVO);
		}
		// 수정할거야? - 수정버튼을 누르기 - 이벤트처리
		else if (obj == jbtn_upd) {
			System.out.println("수정 호출 성공");

		}
		// 삭제를 원해? - 삭제버튼을 누르기 - 이벤트처리
		// view -> action(=delete) -> action(select all) -> view
		else if (obj == jbtn_del) {
			System.out.println("삭제 호출 성공");
			int index[] = jtb.getSelectedRows();
			if (index.length == 0) {
				JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요....", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				Integer deptno = (Integer) dtm.getValueAt(index[0], 0);
				System.out.println("사용자가 선택한 부서번호 " + deptno);
				deptDelete(deptno);
			}

		}
	}///////////////////////////////////////// [end of actionPerformed]
		// 각 컬럼의 값들을 설정하거나 읽어오는 getter/setter메소드
		// 나중에 이벤트 처리가 반복되므로 메서드로 묶어서 사용한다.

	public String getDeptno() {
		return jtf_deptno.getText();
	}

	public void setDeptno(String deptno) {
		jtf_deptno.setText(deptno);
	}

	public String getDname() {
		return jtf_deptno.getText();
	}

	public void setDname(String dname) {
		jtf_dname.setText(dname);
	}

	public String getLoc() {
		return jtf_loc.getText();
	}

	public void setLoc(String loc) {
		jtf_loc.setText(loc);
	}
}
