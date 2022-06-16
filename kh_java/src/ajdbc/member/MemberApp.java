package ajdbc.member;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.oracle.DBConnectionMgr;

// 생성자를 사용함으로써 코드를 줄여준다.
// JFrame jf = new JFrame();
// jf.setTitle("자바실습")
// JFrame jf = new JFrame("자바실습");

public class MemberApp extends JFrame implements ActionListener, MouseListener {
	/****************************
	 * 			 선언부           *
	 ****************************/
	////////////////////DB연동 ///////////////////////
	// 오라클 서버와 연동하기 위한 서버들 드라이버 클래스
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 물리적으로 떨어진 오라클 서버와 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청 / 쿼리문을 오라클서버에게 전달
	ResultSet 			rs 		= null;// 조회경우 커서를 조작 필요
	//////////////////// DB연동 ///////////////////////

	JPanel		jp_north	= new JPanel ();
	JButton		jbtn_sel	= new JButton("조회");
	JButton		jbtn_ins	= new JButton("입력");// 멤버앱에서 입력버튼이 눌렸을 때 멤버쉽 화면이 열리고 싶다
	JButton		jbtn_upd	= new JButton("수정");
	JButton		jbtn_del	= new JButton("삭제");
	String cols[] 	= {"번호","아이디","이름","주소"}; 				//JTable의 헤더에 들어갈 1차 배열
	String data[][] = new String[0][4]; 						// 데이터가 들어갈 2차 배열, 바디부분에 들어갈
	DefaultTableModel dtm	= new DefaultTableModel(data,cols);	// 테이블 구조를 가지고 있는 디폴트테이블모델
	JTable			  jtb	= new JTable(dtm);
	Font			  font	= new Font("돋움체",Font.BOLD,18);
	JScrollPane		  jsp	= new JScrollPane(jtb);
	
	// 로그인이 빈번하게 일어난다.
	// 메소드가 호출되는 위치로 창이 켜지는 타이밍을 제어 - 메모리에 띄어둔다:setVisible false->true 어떤게 좋은가.
	// this(MemberApp)을 가리킨다.
	// >
	MemberShip		  ms	= new MemberShip(this);// ()과 (this)의 차이
	
	/****************************
	 * 			 생성자           *
	 ****************************/
	public MemberApp() {
		// 이벤트 소스와 이벤트 처리 클래스를 매핑하는 코드
		jbtn_sel.addActionListener(this);// 조회버튼이 눌렸을 때 이벤트 핸들러
		jbtn_ins.addActionListener(this);// 입력버튼이 눌렸을 때 이벤트 핸들러
		jbtn_upd.addActionListener(this);// 수정버튼이 눌렸을 때 이벤트 핸들러
		jbtn_del.addActionListener(this);// 삭제버튼이 눌렸을 때 이벤트 핸들러
		initDisplay();
		refreshData();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
			if	(obj == jbtn_sel) {// 버튼에 대한 주소번지
			System.out.println("전체조회 호출 성공");
			refreshData();
		}
		else if (obj == jbtn_ins) {
			System.out.println("입력 호출 성공");
			ms.initDisplay();// 어쩌다가 initDisplay는 생성자에서 여기까지 왔나?
		}
		else if (obj == jbtn_upd) {
			System.out.println("수정 호출 성공");
		}
		else if (obj == jbtn_del) {
			System.out.println("삭제 호출 성공");
		}

	}
	
	
	/* 리프레시 데이터 */
	public void refreshData() {
		List<Map<String,Object>> memList	 = new ArrayList<>();// 리스트는 속도가 느리다. 인덱스값에 따라서 정리가 가능하다. 맵은 속도가 빠르다
		StringBuilder 			 sql		 = new StringBuilder();
		sql.append(" SELECT mem_no, mem_id, mem_pw       ");
	    sql.append(" ,mem_name, mem_zipcode, mem_address ");
	    sql.append(" FROM member                         ");
	    sql.append(" ORDER BY mem_no desc                ");
	    try {
			con 	= dbMgr.getConnection();
			pstmt 	= con.prepareStatement(sql.toString());
			rs		= pstmt.executeQuery();
			Map<String, Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();//인스턴스화
				rmap.put("mem_no", rs.getInt("mem_no"));
				rmap.put("mem_id", rs.getString("mem_id"));
				rmap.put("mem_name", rs.getString("mem_name"));
				rmap.put("mem_address", rs.getString("mem_address"));
				memList.add(rmap);
			}
			// 이 구문이 없으면 조회버튼 클릭마다 같은 자료가 중복으로 쌓이게 된다.
			// insert here
			System.out.println(memList);
			// 기존에 조회된 결과 즉 목록 삭제하기
			while(dtm.getRowCount() > 0) {//0보다 크다면 : 테이블 안에 정보가 남아있다
				dtm.removeRow(0);// 0번째를 삭제해준다.
			}
			// Iterator는 자료구조가 갖고 있는 정보의 유무를 체크하는데 메소드를 제공하고 있다.
			Iterator<Map<String,Object>>iter = memList.iterator();
			Object keys[] = null;
			while(iter.hasNext()) {// hasNext라는 메소드를 지원하는 iterater
				Map<String, Object> data = iter.next();
				keys = data.keySet().toArray();
				Vector<Object> oneRow = new Vector<>();
				oneRow.add(data.get(keys[2]));
				oneRow.add(data.get(keys[1]));
				oneRow.add(data.get(keys[0]));
				oneRow.add(data.get(keys[3]));
				dtm.addRow(oneRow);
			}
			System.out.println(memList);
		} catch (SQLException se) {
			System.out.println("[[query]]" + sql.toString());// 오라클 토드의 에러를 확인
			System.out.println(se.toString());// 에러의 더 구체적인 메시지를 확인한다
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 묵시적으로 닫아준다, 사용한 자원 반납은 생성된 역순으로 한다.
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
	}
	public void initDisplay() {
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jbtn_sel.setBackground(new Color(158, 9, 9)); 		// 배경색 지정
		jbtn_sel.setForeground(new Color(50, 212 , 212));	// 글자색 지정
		jp_north.add(jbtn_sel);
		jbtn_ins.setBackground(new Color(7, 84, 170));
		jbtn_ins.setForeground(new Color(212, 212, 212));
		jp_north.add(jbtn_ins);
		jbtn_upd.setBackground(new Color(19, 99, 57));
		jbtn_upd.setForeground(new Color(212, 212, 212));
		jp_north.add(jbtn_upd);
		jbtn_del.setBackground(new Color(80, 24, 60));
		jbtn_del.setForeground(new Color(212, 212, 212));
		jp_north.add(jbtn_del);
		this.add("North", jp_north);
		this.add("Center",jsp);
		this.setTitle("회원관리시스템 Ver1.0");
		this.setSize(600, 400);
		this.setVisible(true);
		
		
		this.add("Center", jsp);
		this.add("North", jp_north);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {

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

	

	public static void main(String[] args) {
		new MemberApp();

	}

}
