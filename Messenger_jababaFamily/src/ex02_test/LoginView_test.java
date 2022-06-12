package ex02_test;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ex_memorycost_actionListner.ChatView;

// 로그인 화면
public class LoginView_test extends JFrame {
	TalkClient_test cc;
	/////////////////////////////////////////////////////
	/* 선언부 */
	/////////////////////////////////////////////////////
//		TalkClientVer2 tcv = null;
	String 			nickName 	 = "";
//		ChatDao chatDao = new ChatDao();
//		ChatMemberVO cmvo = null;
	JLabel 			jlb_id 	 	 = new JLabel("아이디"); // "[입력]" : 문자열을 화면에 그림
	JLabel 			jlb_pw 	 	 = new JLabel("비밀번호"); // "[입력]" : 문자열을 화면에 그림
	Font 			jl_font  	 = new Font("맑은고딕체", Font.BOLD, 13); // ID와 PW의 (글씨체, 폰트굵기, 크기)를 파라미터 값으로 호출한다?
	JTextField 		jtf_id 	 	 = new JTextField("테스트중!"); // ID의 입력박스에 test 가 기본으로 입력되어 있다.
	JPasswordField 	jpf_pw 	 	 = new JPasswordField("123"); // PW의 입력박스에 123 이 기본으로 입력되어 있다.
	String 			imgPath	 	 = "D:\\\\java_study\\\\workspace_java\\\\kh_javaAC\\\\project1.3\\\\img\\"; // 이미지 경로를 문자열로..지정??
	JButton 		jbtn_login 	 = new JButton(new ImageIcon(imgPath + "로그인2.png")); // 3번째 박스에 로그인이미지 : 이미지 경로 + 이미지파일이름
	JButton	  		jbtn_join	 = new JButton(new ImageIcon(imgPath + "카톡회원가입.jpg")); // 4번째 박스에 회원가입이미지
	ImageIcon ig = new ImageIcon(imgPath + "둥이.png"); // 배경이미지파일 경로지정
	// ↑
  /* ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\confirm.png"));
	 JPanel에 쓰일 이미지아이콘
	 ImageIcon ig = new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\main.png"); 	*/

	/////////////////////////////////////////////////////
	/* 생성자 */
	/////////////////////////////////////////////////////
	public LoginView_test() {
		
		/////////////////////////////////////////////////////
		/* jpanal 오버라이드 */
		/////////////////////////////////////////////////////
		/* 배경이미지 */
		class mypanal extends JPanel {
			public void paintComponent(Graphics g) {
				g.drawImage(ig.getImage(), 0, 0, null); // 배경이미지의 위치 (가로, 세로, null = ?)
				setOpaque(false);
				super.paintComponents(g);
			}
		}
		setContentPane(new mypanal());

		/* 버튼과 텍스트필드 구성 */
		this.setLayout(null);
		this.setTitle("꽉자바패밀리 ver.1"); // 타이틀 제목
		this.setSize(427, 443); // 로그인 창 사이즈 - 2개의 파라미터로 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); // 창을 보여준다.
		this.setLocation(600, 150); // 창이 처음 띄어지는 위치 - (800, 250)은 중앙
		this.addWindowListener(new WindowAdapter() { // -> ??????
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});
		// id 라인
		jlb_id.setBounds(45, 200, 80, 40);
		jlb_id.setFont(jl_font); // 아이디 폰트값 호출 메소드
		this.add(jlb_id);
		
		// 아이디 입력창
		jtf_id.setBounds(110, 200, 185, 40);
		this.add(jtf_id);

		// pw 라인
		jlb_pw.setBounds(45, 240, 80, 40);
		jlb_pw.setFont(jl_font);
		this.add(jlb_pw);
		
		// pw 입력창
		jpf_pw.setBounds(110, 240, 185, 40);
		this.add(jpf_pw);

		// 로그인 버튼 라인 - 중앙 3번 째 박스
		jbtn_login.setBounds(175, 285, 120, 40);
		this.add(jbtn_login);

		// 회원가입 버튼 라인 - 중앙 맨 아래박스
		jbtn_join.setBounds(45, 285, 120, 40);
		this.add(jbtn_join);

		jbtn_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String id = jtf_id.getText().trim();// trim : 공백을 없애준다.
			String pw = jpf_pw.getText().trim();
			if (e.getSource() == jbtn_login) {
				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "FAIL!", JOptionPane.DEFAULT_OPTION);
				}else if (id.equals("test") && pw.equals("123")) {
					JOptionPane.showMessageDialog(null, "로그인 성공!", "SUCCESS", JOptionPane.DEFAULT_OPTION);
					new ChatView();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀립니다.", "SUCCESS", JOptionPane.DEFAULT_OPTION);
					}
				}
			}
			
		});

		jbtn_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == jbtn_join) {
					new SignupView_test();
					dispose();
//					setVisible(false);
				} 
			}
		});

	}/////////////////////////////////////////////////////////// [end of constructor]


//	public static void main(String[] args) throws Exception {
//		new LoginView_test();
//	}/////////////////////////////////////////////////////////// [end of main]
}/////////////////////////////////////////////////////////////// [end of class LoginView_test]

/*  
 * 익명클래스 - 익명리스너 *
 * 
 * 로그인뷰에서 가입뷰로 넘어갈때 이전 창 닫기
 	ㅇ회원가입창과 로그인창 dispose()
 		dispose()는 현재의 프레임들만 닫힘 - 현재창을 종료하고 새로운 창으로 넘어가고 싶다
 		System.exit()은 JVM자체가 종료되어 프로그램이 종료 - 웱
 		-> 가입창에 넘어가기 전에 입력한 값들을 없애지 않고 유지하고 싶다. / setVisible(true/false)로는 안 될까?
 * 
 */
