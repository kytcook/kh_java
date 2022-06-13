package ajdbc.crud;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import oracle.DeptVO;
// 단일 상속의 단점을 보완하기 위해서 인터페이스를 제공하고 있다.
// 인터페이스는 다중 처리 가능하다.
public class CRUDDept extends JFrame implements ActionListener, MouseListener {
	// 선언부c
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
	
	// 서로 의존관계에 있다. - 의존성 주입(인스턴스화 - 싱글톤패턴), 객체 주입법, annotation
	// 중앙에 들어갈 버튼
	String 				cols[] 		= { "부서번호", "부서명", "지역" };
	String 				data[][] 	= new String[0][3];
	DefaultTableModel 	dtm 		= new DefaultTableModel(data, cols);
	JTable 				jtb 		= new JTable(dtm); //
	JScrollPane 		jsp 		= new JScrollPane(jtb);
	
	// 남쪽에 들어갈 버튼
	// 테이블의 로우에 바운딩하기 - UI 솔루션 기본 제공
	JPanel 				jp_south 	= new JPanel(); // 디폴트레이아웃 : FlowLAyout
	JTextField 			jtf_deptno 	= new JTextField("", 15);
	JTextField 			jtf_dname 	= new JTextField("", 15);
	JTextField 			jtf_loc 	= new JTextField("", 15);
	
	// 생성자
	public CRUDDept() {
		// 이벤트 소소와 이벤트 핸들러 매핑하기
		// 내가 이벤트 처리를 담당하는 핸들러 클래스이다.
		// ActionListener al = new CRUDDept();
		// 선언부와 생성부의 클래스이름 다르다.
		// 다형성을 누릴 수 있다.
		// 클래스 사이의 결합도를 낮출 수 있어서 단위 테스트가 가능한 구조가 된다.
		// 생성부의 이름으로 생성된다는 것.
		// 이벤트발생을 듣는다
		jbtn_sel.addActionListener(this);
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jtb.addMouseListener(this); // 06.13 
		initDisplay();
	}

	/**************************************************
	 * 부서 등록 구현
	 * VO(Value Object) - 오라클 타입과 자바타입비교 - 컬럼명과 VO전변과 Map의 키값은 반드시 일치해야 한다.
	 * @param pdVO - 사용자가 입력한 부서번호, 부서명, 지역을 받는다. - 복합데이터 클래스
	 * @return int - 1: 등록성공 0:등록실패 
	 * INSERT INTO dept(deptno, dname, loc)
	          VALUES(71,'개발1팀','서귀포'); - 내가 설계한 것과 DB의 값이 잘 일치하는지 확인하기 위해 복사붙여둔다
	 **************************************************/
	public int deptInsert(DeptVO pdVO) {
		System.out.println("deptInsert 호출 성공");
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(?,?,?)");
		// 물리적으로 떨어져 있는 오라클 서버와 통신
		// 반드시 예외처리를 해야한다.
		// 사용한 자원 반납 처리 - 명시적으로 한다.
		// 생성된 역순으로 반납한다. 문을 열고 들어온 순서대로 다시 닫으면서 나간다.
		// 왜 생성한 역순인가? - 의존관계에 있다. Connection, PreparedStatement, ResultSet - 자바성능 튜닝 가이드
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			// 중간에 어떤 코드가 끼어들더라도, 코드에 대한 변경을 최소하한다.
			// 동적쿼리를 처리하는 PreparedStatment에서 ? 자리에 필요한 파라미터를 적용하는데
			// 테이블 설계가 바뀌거나 컬럼이 추가되는 경우를 예측하여 최소한의 코드 변경이 되도록 변수를 사용해 본다.
			// ? 자리는 1부터이므로 ++i 로 시작한다.
			// 만일 1로 초기화 했다면 i++로 하면 될 것이다.
			int i = 0; 
			pstmt.setInt(++i, pdVO.getDeptno());
			pstmt.setString(++i, pdVO.getDname());
			pstmt.setString(++i, pdVO.getLoc());
			// selecet인 경우 커서를 리턴받고, insert, update, delete 인 경우는 int리턴 받음
			result = pstmt.executeUpdate(); // 성공됐을 때 리턴값이 int
			// 오라클 서버에서 입력 처리를 성공했을 때 1을 돌려 받는다.
			if (result == 1) {
				deptSelectAll();
				// 입력 성공 후에 화면에 대한 초기화 - 사용자의 편의성 제공
				setDeptno(0);
				setDname("");
				setLoc("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con); // 자원반납하는 부분도 따로 빼둠?
		}
		return result;
	}

	/**************************************************
	 * 부서 수정 구현
	 * 
	 * @param pdVO - 사용자가 수정한 부서번호, 부서명, 지역을 받는다. - 복합데이터 클래스
	 * @return int - 1: 등록성공 0:등록실패 
	 * UPDATE dept SET dname = '개발2팀' ,loc = '거제도'    
	    WHERE deptno = 71;
	 **************************************************/
	public int deptUpdate(DeptVO pdVO) {
		System.out.println("deptUpdate 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE dept          ");
		sql.append("   SET dname = ?,    ");
		sql.append("		loc =  ?      ");
		sql.append(" WHERE deptno = 71;  ");
		int result = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 1;
			pstmt.setString(i++, pdVO.getDname());
			pstmt.setString(i++, pdVO.getLoc());
			pstmt.setInt(i++, pdVO.getDeptno());
			if (result == 1) {
				JOptionPane.showMessageDialog(this, "데이터가 수정되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
				deptSelectAll(); // 새로고침 처리 메소드 호출하기 - 메소드 재사용성 - 반복되는 코드를 줄여 준다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		
		return result;
	}

	/**************************************************
	 * 부서 삭제 구현
	 * 
	 * @param deptno(int) - 사용자가 선택한 부서번호
	 * @return int - 1: 등록성공 0:등록실패 DELETE FROM dept WHERE deptno = 71
	 **************************************************/
	public int deptDelete(int deptno) { // pk를 받는다.
		System.out.println("deptUpdate 호출 성공" + deptno);
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM dept WHERE deptno = ?");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, deptno); // 하나라서 상수 1로 처리한다.
			result = pstmt.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(this, "데이터가 삭제되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
				// 삭제된 후에 화면 갱신처리하기 - 동기화 처리 진행됨
				// 입력, 수정, 삭제에서 반복적으로 호출 될 수 있다. - 메소드로 코드를 줄여준다.
				// List<VO>, List<Map> 맵에 대한 이해
				deptSelectAll(); // 새로고침 처리 메소드 호출하기 - 메소드 재사용성 - 반복되는 코드를 줄여 준다.
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
	 * @return List<Map<String,Object>> 
	 * SELECT deptno, dname, loc 
	  	 FROM dept
	 *****************************************/
	public List<Map<String, Object>> deptSelectAll() {
		System.out.println("deptSelectAll 호출 성공");
//		List<Map<String,Object>> deptList = null;
		List<Map<String, Object>> deptList	 = new ArrayList<>();
		StringBuilder 			  sql		 = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept"); // 전체를 줘야해서 where절이 없는 상태이다.
		try {
			con		= dbMgr.getConnection();
			pstmt 	= con.prepareStatement(sql.toString());
			rs 		= pstmt.executeQuery();
			Map<String, Object> rmap = null;
			
			while (rs.next()) {
				rmap = new HashMap<>();// 같은 이름의 변ㅅ누이지만 서로 다른 주소번지를 갖는다.
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
				deptList.add(rmap);// 순서가 정해진다. 기본정렬은 오라클에서 하는 것이 빠르다. - 자바에서는 View를 보는정도로 구상
			}
			
//			System.out.println(deptList);// 단위테스트때문에 달아둔 것이므로 없애도 된다.
			// 기존에 조회된 결과 즉 목록을 삭제하기
			// 자료구조가 존재하는지
			while (dtm.getRowCount() > 0) {// 여러번 조회를 누르더라도 뒤에 내용이 삭제되므로 검색된 로우의 수만큼 출력시킨다.
				dtm.removeRow(0);// 파라미터에 0을 주어서 테이블의 인덱스가 바뀌는 문제를 해결함.
			}
			// Iterator는 자료구조가 갖고 있는 정보의 유무를 체크하는데 필요한 메소드를 제공하고 있다.
			Iterator<Map<String, Object>> iter = deptList.iterator();// 컬렉션프레임워크안에 유틸패키지를 지원하는 클래스 iterator
			Object keys[] = null;
			while (iter.hasNext()) {
				Map<String, Object> data = iter.next();
				keys = data.keySet().toArray();
				Vector<Object> oneRow = new Vector<>();
				oneRow.add(data.get(keys[2]));// 키값이 랜덤. 순서는 확인할 수 없다.
				oneRow.add(data.get(keys[1]));// 키값이 랜덤. 순서는 확인할 수 없다.
				oneRow.add(data.get(keys[0]));// 키값이 랜덤. 순서는 확인할 수 없다.
				// 데이터 셋인 DefaultTableModel에 조회 결과 담기. - 반복처리함 => 10, 20, 30, 40
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
	 * @return DeptVO 
	 * SELECT deptno, dname, loc FROM dept
	    WHERE deptno = ?
	 *****************************************/
	public DeptVO deptSelectDetail(int deptno) {
		System.out.println("deptSelectDetail 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept  ");
	    sql.append("WHERE deptno = ?                                             ");
		DeptVO rdVO = null;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rdVO = new DeptVO();
				rdVO.setDeptno(rs.getInt("deptno"));
				rdVO.setDname(rs.getString("dname"));
				rdVO.setLoc(rs.getString("loc"));
			}
			if(rdVO !=null) {
				setDeptno(rdVO.getDeptno());
				setDname(rdVO.getDname());
				setLoc(rdVO.getLoc());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
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
			String deptno	= getDeptno();
			String dname	= getDname();
			String loc 		= getLoc();
//			System.out.println(deptno + ", " + dname + ", " + loc);
			DeptVO pdVO		= new DeptVO();
			pdVO.setDeptno(Integer.parseInt(deptno));
			pdVO.setDname(dname);
			pdVO.setLoc(loc);
			deptInsert(pdVO);
		}
		// 수정할거야? - 수정버튼을 누르기 - 이벤트처리
		else if (obj == jbtn_upd) {
			System.out.println("수정 호출 성공");
			String deptno	= getDeptno();
			String dname	= getDname();
			String loc 		= getLoc();
			DeptVO pdVO		= new DeptVO();
			pdVO.setDeptno(Integer.parseInt(deptno));
			pdVO.setDname(dname);
			pdVO.setLoc(loc);
			deptUpdate(pdVO);

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
				// 삭제된 후에 화면 갱신하기 - 동기화 처리 진행됨
				// 입력, 수정, 삭제에서 반복적으로 호출 될 수 있다.
				// List<VO>, List<Map>
				deptDelete(deptno); // 새로고침 처리 메소드 호출하기 - 메소드 재사용성 - 반복되는 코드를 줄여준다.
			}

		}
	}///////////////////////////////////////// [end of actionPerformed]
		// 각 컬럼의 값들을 설정하거나 읽어오는 getter/setter메소드
		// 나중에 이벤트 처리가 반복되므로 메서드로 묶어서 사용한다.
	public String getDeptno() { return jtf_deptno.getText(); }
	public void setDeptno(int deptno) { jtf_deptno.setText(String.valueOf(deptno)); }

	public String getDname() { return jtf_deptno.getText(); }
	public void setDname(String dname) { jtf_dname.setText(dname); }

	public String getLoc() { return jtf_loc.getText(); }
	public void setLoc(String loc) { jtf_loc.setText(loc); }

	@Override
	public void mouseClicked(MouseEvent e) {
		int index[] = jtb.getSelectedRows();
		// 테이블의 데이터를 선택하지 않은 경우
		if(index.length == 0) {
			JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하시오.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int udeptno = 0; // 업데이트 하고자하는 deptno를 적는다
		udeptno = Integer.parseInt(dtm.getValueAt(index[0], 0).toString());
		deptSelectDetail(udeptno);
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}