package ex_memorycost_actionListner;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ChatView extends JFrame {
	ChattingClient cc;
	JFrame jf2; // 채팅창
	JTextField tf; // 입력칸
	JTextArea ta; // 대화칸
	JLabel jlb1, jlb2; // 라벨
	JPanel jp1, jp2; // 판넬
	JButton jbt; // 종료버튼
	String nickName = null;// 닉네임 등록
	
	JPanel jp_second = new JPanel();
	JPanel jp_second_south = new JPanel();
	JButton jbtn_change = new JButton("대화명변경");
	JButton jbtn_exit = new JButton("나가기");
//	JButton jbtn_one = new JButton("1:1");
//	JButton jbtn_font = new JButton("글자색");
	
	String cols[] = { "대화명" };
	String data[][] = new String[0][1];
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	JPanel jp_first = new JPanel();
	JPanel jp_first_south = new JPanel();
	JTextField jtf_msg = new JTextField(20);// south속지 center
	JButton jbtn_send = new JButton("전송");// south속지 east
	JTextArea jta_display = null;
	JScrollPane jsp_display = null;
	
	public ChatView() {
		this.setResizable(false);
		this.setLayout(new GridLayout(1,2));
		jp_second.setLayout(new BorderLayout());
		jp_second.add("Center",jsp);
		jp_second_south.setLayout(new GridLayout(1,1));
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_exit);
//		jp_second_south.add(jbtn_one);
//		jp_second_south.add(jbtn_font);
		jp_second.add("South",jp_second_south);
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jbtn_send);

		jta_display = new JTextArea();
		jta_display.setLineWrap(true);
		jta_display.setOpaque(false);
		Font font = new Font("돋움",Font.BOLD,16);
		jta_display.setFont(font);
		jsp_display = new JScrollPane(jta_display);		
		jp_first.add("Center",jsp_display);
		jp_first.add("South",jp_first_south);
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName);
		this.setSize(800, 550);
		this.setVisible(true);

//		jtf_msg.addActionListener();
//		jbtn_change.addActionListener();
//		jbtn_exit.addActionListener();
	}


}
