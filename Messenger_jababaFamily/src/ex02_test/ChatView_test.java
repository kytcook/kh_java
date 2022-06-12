package ex02_test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

// 채팅창 화면
public class ChatView_test {
	//////////////// 통신과 관련한 전역변수 추가 시작//////////////
	Socket 				socket	 = null;
	ObjectOutputStream 	oos		 = null;// 말 하고 싶을 때
	ObjectInputStream 	ois		 = null;// 듣기 할 때
	String 				nickName = null;// 닉네임 등록
	
	//////////////// 통신과 관련한 전역변수 추가 끝 //////////////
	JPanel		jp_second		= new JPanel();
	JPanel	 	jp_second_south	= new JPanel();
	JButton 	jbtn_one 		= new JButton("1:1");
	JButton 	jbtn_change 	= new JButton("대화명변경");
	JButton 	jbtn_font 		= new JButton("글자색");
	JButton 	jbtn_exit 		= new JButton("나가기");
	String 		cols[] 			= { "대화명" };
	String 		data[][] 		= new String[0][1];
	DefaultTableModel dtm 		= new DefaultTableModel(data, cols);
	JTable 		jtb				= new JTable(dtm);
	JScrollPane jsp 			= new JScrollPane(jtb);
	JPanel 		jp_first 		= new JPanel();
	JPanel 		jp_first_south 	= new JPanel();
	JTextField 	jtf_msg 		= new JTextField(20);// south속지 center
	JButton 	jbtn_send 		= new JButton("전송");// south속지 east
	JTextArea 	jta_display 	= null;
	JScrollPane jsp_display 	= null;
	// 배경 이미지에 사용될 객체 선언-JTextArea에 페인팅
	Image back = null;

	public ChatView_test() {

		jtf_msg.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_exit.addActionListener(this);
	}

	public void initDisplay() {
		// 사용자의 닉네임 받기
//		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		// ChattingRoom
		this.setLayout(new GridLayout(1, 2));
		jp_second.setLayout(new BorderLayout());
		jp_second.add("Center", jsp);
		jp_second_south.setLayout(new GridLayout(2, 2));
		jp_second_south.add(jbtn_one);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_font);
		jp_second_south.add(jbtn_exit);
		jp_second.add("South", jp_second_south);
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center", jtf_msg);
		jp_first_south.add("East", jbtn_send);
		back = getToolkit().getImage("src\\chat\\step1\\accountmain.png");
		jta_display = new JTextArea() {
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g) {
				g.drawImage(back, 0, 0, this);
				Point p = jsp_display.getViewport().getViewPosition();
				g.drawImage(back, p.x, p.y, null);
				paintComponent(g);
			}
		};
		jta_display.setLineWrap(true);
		jta_display.setOpaque(false);
		Font font = new Font("돋움", Font.BOLD, 16);
		jta_display.setFont(font);
		jsp_display = new JScrollPane(jta_display);
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_first_south);
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName);
		this.setSize(800, 550);
		this.setVisible(true);
	}

}
