package ajdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import oracle.DeptVO;

public class CRUDpt extends JFrame implements ActionListener {
	// 선언부
	
	// 북쪽에 들어갈 버트 4가지
	JPanel 	jp_north = new JPanel();
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	// 생성자
	
	public CRUDpt() {
		initDisplay();
		
	}
	
	public void deptInsert(DeptVO pdVO) {
	
	}
	
	public void deptUpdate(DeptVO pdVO ) {
		
	}
	
	public void deptDelete(int deptno) {
		
	}
	
	// 화면처리부
	public void initDisplay() {
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		this.add("North", jp_north);
		this.setTitle("부서관리시스템");
		this.setSize(700, 400);
		this.setVisible(true);
		
	}
	
	// 메인메소드
	public static void main(String[] args) {
		CRUDpt cp = new CRUDpt();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
