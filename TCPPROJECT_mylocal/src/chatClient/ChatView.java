package chatClient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ChatView extends JFrame implements ActionListener {

	
	JTextField jtf_name = new JTextField("대화명을 입력하세요",20);
	JButton jbtn_search = new JButton("찾기");
	String zdos[] = {"닉네임"};
	JComboBox jcb = new JComboBox(zdos);

	JPanel jp_first 			=	new JPanel();
	JPanel jp_first_south 		= 	new JPanel();
	JPanel jp_first_east		= 	new JPanel();
	
	JPanel jp_second 			= 	new JPanel();
	JPanel jp_second_north      =   new JPanel();
	JPanel jp_second_south 		= 	new JPanel();
	
	JButton jbtn_whisper 		= 	new JButton("1:1");
	JButton jbtn_change 		= 	new JButton("회원수정");
	JButton jbtn_exit 			= 	new JButton("나가기");
	JButton jbtn_send 			= 	new JButton("전송");
	JButton jbtn_emoticon 		= 	new JButton("이모티콘");
	JTextField jtf_msg 			=	new JTextField(20);
	JTextArea jta_display 		= 	null; // 채팅창 배경
	JScrollPane jsp_display		= 	null; // 채팅창
	TalkClient tc 				= 	null;
	Image back					= 	null;
	String nickName			    = 	null;
	
	String cols[] = {"접속자"};
	String data[][] = new String[0][1];
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb);
	JSplitPane jspp = new JSplitPane(SwingConstants.VERTICAL, jp_first,jp_second);
	
	//추가
	LoginView lv = null;
	///////////////////////////////////
	String myid = null;			 //
	//↑								 //
	public ChatView(LoginView lv) {	 //
		this.myid = lv.myid;		 //
		System.out.println("아이디넘어감 : "+  myid);	 //
	}								 //
	///////////////////////////////////
	
	// ChatView가 실행되면서 동시에 TalkClienThread가 생성되고
	// run()메소드로 쓰레드가 실행됩니다.
	public ChatView(TalkClient tc) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.tc = tc;
		this.nickName =tc.nickName;
		TalkClientThread tct = new TalkClientThread(this);
		tct.start();
		initDisplay(true);
	}
	
	public void initDisplay(boolean is) {
		/////////////////////////배경 이미지/////////////////////////////
		back = getToolkit().getImage("C:\\java\\workspace_java\\이미지\\채팅창 배경.png");
		jta_display = new JTextArea() {
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g) {
				g.drawImage(back, 0, 0, this);
				Point p = jsp_display.getViewport().getViewPosition();
				g.drawImage(back, p.x, p.y, null);
				paintComponent(g);
			}
		};
		jp_second_north.setLayout(new BorderLayout());
		jp_second_north.add("West",jcb);
		jp_second_north.add("Center",jtf_name);
		jp_second_north.add("East",jbtn_search);
		
		jp_second_south.setLayout(new GridLayout(1,3));
		jp_second_south.add(jbtn_whisper); // 1대1 대화
		jp_second_south.add(jbtn_change); //회원정보 수정
		jp_second_south.add(jbtn_exit);	// 나가기
		
		jp_first_south.setLayout(new BorderLayout());
		jp_first_east.setLayout(new GridLayout(1,2));
		jp_first_east.add(jbtn_emoticon);
		jp_first_east.add(jbtn_send);
		jp_first_south.add("Center",jtf_msg);
		jp_first_south.add("East",jp_first_east);
		jspp.setPreferredSize(new Dimension(400,200));
//		jspp.setOrientation(SwingConstants.VERTICAL);
		jp_first.setLayout(new BorderLayout());
		jp_second.setLayout(new BorderLayout());
		jsp_display = new JScrollPane(jta_display);	
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_first_south);
		jp_second.add("North", jp_second_north);
		jp_second.add("Center", jsp);
		jp_second.add("South", jp_second_south);
		
		jta_display.setLineWrap(true);
		jta_display.setOpaque(false);
		Font font = new Font("나눔고딕", Font.BOLD, 15);
		jta_display.setFont(font);
		this.add(jspp);
		this.setTitle(nickName);
		this.setSize(800, 550);
		this.setVisible(is);
		this.setLocation(600, 150);
		setResizable(false); // 창이 가운데 나오도록
		
		///////// 이벤트 처리 ////////////
		jtf_msg.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_exit.addActionListener(this);
	}

	public String getMsg() {
		String msg = jtf_msg.getText();
		jtf_msg.setText("");
		return msg;
	}
	
	public void successMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Success!", JOptionPane.INFORMATION_MESSAGE);
	}
	public void errorMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error!", JOptionPane.ERROR_MESSAGE);
	}
	
	// UI와 서버의 작업 분담을 위해 UI쪽에서는 서버에서 작성한 메소드 호출만 하도록 작성
	// 여기서 프로토콜 알고 던져줄 수 있지만 그렇게 되면 통신에 문제가 생겼을 때
	// UI와 서버 둘 다 확인 해야하기 때문에 msg와 관련된 파라미터만 TalkClient(컨트롤러 역할)에게 넘겨준다
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		// GROUP_MESSAGE
		if (jtf_msg == obj) {
		String msg = jtf_msg.getText();
		tc.groupMsg(msg);
		jtf_msg.setText("");
		
		// ROOM_OUT
		} else if (jbtn_exit == obj) {
		tc.roomOut();
		System.exit(0);
		
		// NICKNAME_CHANGE
		} else if (jbtn_change == obj) {
			/////////////////////////////////////////////
			lv = new LoginView();
			System.out.println(myid); // null이 찍힌다.
			changeView_02 cv = new changeView_02(this);////
			cv.initDisplay();                          //
			/////////////////////////////////////////////
			}
		}
	}////////////////////// end of class

