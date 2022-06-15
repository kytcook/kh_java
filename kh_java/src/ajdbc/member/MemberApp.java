package ajdbc.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MemberApp extends JFrame implements ActionListener, MouseListener {
	JPanel		jp_center		= new JPanel();
	JLabel		jlb_aw			= new JLabel("전체조회");
	
	JScrollPane jsp				= new JScrollPane(jp_center); //패널을 파라미터로 얹혀준다?
	JPanel		jp_south		= new JPanel ();
	
	public MemberApp() {
		initDisplay();
	}
//	public int memberInsert(MemberVO pmVO) {
//		
//	}
	
	public void initDisplay() {
		jlb_aw.setBounds(20, 100, 100, 20);
		jp_center.add(jlb_aw);
		
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setTitle("전체조회");
		this.setSize(600, 500);
		this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MemberApp();

	}

}
