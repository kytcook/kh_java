package JDBC_test;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import JDBC_test.LoginForm_Study1.mypanal;

public class LoginForm_Study1 extends JFrame implements ActionListener {
	/////////////////////////////////////////////////////
	/* 선언부 */
	/////////////////////////////////////////////////////
//	TalkClientVer2 tcv = null;
	String nickName="";												//
//	ChatDao chatDao = new ChatDao();
	String imgPath="C:\\Java\\dev_javaB\\dev_java\\src\\image\\";	// 이미지 경로를 문자열로..지정??
//	ChatMemberVO cmvo = null;
	JLabel jlb_id = new JLabel("ID");								// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_pw = new JLabel("비밀번호");							// "[입력]" : 문자열을 화면에 그림
	

	Font jl_font = new Font("휴먼매직체", Font.BOLD, 17);				// ID와 PW의 (글씨체, 폰트굵기, 크기)를 파라미터 값으로 호출한다?
	JTextField jtf_id = new JTextField("test");						// ID의 입력박스에 test 가 기본으로 입력되어 있다.
	JPasswordField jpf_pw = new JPasswordField("123");				// PW의 입력박스에 123 이 기본으로 입력되어 있다.

	JButton jbtn_login = new JButton(
			new ImageIcon(imgPath+"login.png"));		// ?? 이미지 경로 + 
			//new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\login.png"));
	JButton jbtn_join = new JButton(
			new ImageIcon(imgPath+"confirm.png"));
			//new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\co   nfirm.png"));

	// JPanel에 쓰일 이미지아이콘
	ImageIcon ig = new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\main.png");
//	ImageIcon ig = new ImageIcon(imgPath+"main.PNG");

	/////////////////////////////////////////////////////
	/* 생성자 */
	/////////////////////////////////////////////////////
	public LoginForm_Study1(){
		initDisplay();
	}

	/////////////////////////////////////////////////////
	/* jpanal 오버라이드 */
	/////////////////////////////////////////////////////

	/* 배경이미지 */
	class mypanal extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponents(g);
		}
	}

	/////////////////////////////////////////////////////
	/* 화면처리 */
	/////////////////////////////////////////////////////
	public void initDisplay() {
		setContentPane(new mypanal());
		
		/* 버튼과 텍스트필드 구성 */
		jbtn_join.addActionListener(this);
		jbtn_login.addActionListener(this);
		this.setLayout(null);
		this.setTitle("꽉자바패밀리 ver.1"); 							// 타이틀 제목
		this.setSize(400, 600);										// 로그인 창 사이즈 - 2개의 파라미터로 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);										// 창을 보여준다.
		this.setLocation(800, 250);									// 창이 처음 띄어지는 위치 - (800, 250)은 중앙
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// id 라인
		/* [아이디]의 위치 : (	값에 따른 이동 				값↑	  			 값↓
		  					첫 번째 파라미터 - 가로 위치 :	우   			 좌
		 				   ,두 번째 파라미터 - 세로 위치 : 	아래			 	 위
		 				   ,세 번째 파라미터 - ??? 위치 : 	?			 	 변화 // 42이하로 내려가면 변하긴 하는데 뭔지 모르겠음
		 				   ,네 번째 파라미터 - 박스인가? : 	아래				 위  // 값을 낮춰서 일정값(20) 이하로 내려가면 "아이디"가 위부터 짤림		   */				
		jlb_id.setBounds(45, 200, 80, 40);		
		jlb_id.setFont(jl_font);				// 아이디 폰트값 호출 메소드			
		/* [아이디 입력란]의 위치 : ( 값에 따른 이동				값↑				 값↓
		 					첫 번째 파라미터 - 가로 위치 		: 	우		 	 	 좌
		 					두 번째 파라미터 - 세로 위치		:	아래				 위
		 					세 번째 파라미터 - 박스 가로길이 	:	오른쪽 늘어남		 오른쪽 줄어듦
		 					네 번째 파라미터 - 박스 세로길이 	:  	아래로 늘어남		 아래쪽 줄어듦							 */
		jtf_id.setBounds(110, 200, 185, 40);
		this.add(jlb_id);						//
		this.add(jtf_id);						//

		// pw 라인
		jlb_pw.setBounds(45, 240, 80, 40);
		jlb_pw.setFont(jl_font);
		jpf_pw.setBounds(110, 240, 185, 40);
		this.add(jlb_pw);
		this.add(jpf_pw);

		// 로그인 버튼 라인
		jbtn_login.setBounds(175, 285, 120, 40);
		this.add(jbtn_login);

		// 회원가입 버튼 라인
		jbtn_join.setBounds(45, 285, 120, 40);
		this.add(jbtn_join);		
	}

	public static void main(String[] args) throws Exception {
		new LoginForm_Study1();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_join) {

		} 
		else if (obj == jbtn_login) {

		}
	}
}