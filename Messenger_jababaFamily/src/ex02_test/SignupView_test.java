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


public class SignupView_test extends JFrame {
	/////////////////////////////////////////////////////
	/* 선언부 */
	/////////////////////////////////////////////////////
//	TalkClientVer2 tcv = null;
//	ChatDao chatDao = new ChatDao();
//	ChatMemberVO cmvo = null;
	// 민준이형
	LoginDao logindao;
	boolean isIDCheck = false;
	//////////////////////////
	
	String nickName		="";												
	String imgPath		="D:\\\\java_study\\\\workspace_java\\\\kh_javaAC\\\\project1.3\\\\img\\";	// 이미지 경로를 문자열로..지정??
	JLabel jlb_id	 	= new JLabel("아이디");			// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_pw		= new JLabel("비밀번호");			
	JLabel jlb_repw		= new JLabel("비밀번호 재확인");		
	JLabel jlb_name		= new JLabel("이름");				
//	JLabel jlb_number	= new JLabel("전화번호");    

	Font	   		jl_font		 = new Font("휴먼매직체", Font.PLAIN, 17);						// ID와 PW의 (글씨체, 폰트굵기, 크기)를 파라미터 값으로 호출한다?
	JTextField		jtf_id 		 = new JTextField("");						
	JPasswordField 	jpf_pw 		 = new JPasswordField("");					// PW는 숨겨진다
	JPasswordField 	jpf_repw = new JPasswordField("");			
//	JTextField 		jtf_repw 	 = new JTextField(" 비밀번호를 재입력하세요");			
	JTextField 		jtf_name 	 = new JTextField("");	
//	JTextField 		jtf_number 	 = new JTextField(" 전화번호를 입력하세요");
	
	JButton 		jbtn_idcheck = new JButton(new ImageIcon(imgPath+"/버튼.png"));
	JButton    		jbtn_ok 	 = new JButton(new ImageIcon(imgPath+"/가입하기.png"));		// ?? 이미지 경로 + 
	// JPanel에 쓰일 이미지아이콘
	//ImageIcon ig = new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\main.png");
	ImageIcon ig = new ImageIcon(imgPath + "/main4.png");

	/////////////////////////////////////////////////////
	/* 생성자 */
	/////////////////////////////////////////////////////
	public SignupView_test(){
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
//		jbtn_join.addActionListener(this);
		this.setLayout(null);
		this.setTitle("꽉자바패밀리 ver.1"); 							// 타이틀 제목
		this.setSize(350, 600);										// 로그인 창 사이즈 - 2개의 파라미터로 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);										// 창을 보여준다.
		this.setLocation(600, 150);									// 창이 처음 띄어지는 위치 - (800, 250)은 중앙
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// 아이디체크박스
		jbtn_idcheck.setBounds(255, 138, 25, 25);
		this.add(jbtn_idcheck);
		
		// id 라인
		jlb_id.setBounds(40, 100, 80, 40);		
		jlb_id.setFont(jl_font);						
		this.add(jlb_id);
		
		// id 입력창
		jtf_id.setBounds(40, 130, 260, 40);
		this.add(jtf_id);						

		// pw 라인
		jlb_pw.setBounds(40, 180, 80, 40);
		jlb_pw.setFont(jl_font);
		this.add(jlb_pw);
		
		// pw 입력창
		jpf_pw.setBounds(40, 213, 260, 40); // 모음유무에 따라 실제 값 차이는 없지만 시각적인 줄간격 오차가 나서 모음에는 3씩 추가
		this.add(jpf_pw);
		
		// 비번 재확인
		jlb_repw.setBounds(40, 260, 150, 40);
		jlb_repw.setFont(jl_font);
		this.add(jlb_repw);
		
		// 비번 재확인 입력창
		jpf_repw.setBounds(40, 293, 260, 40);
		this.add(jpf_repw);
		
		// 이름 라인
		jlb_name.setBounds(40, 340, 80, 40);
		jlb_name.setFont(jl_font);
		this.add(jlb_name);
		
		// 이름 입력창
		jtf_name.setBounds(40, 373, 260, 40);
		this.add(jtf_name);
		
		// 전화번호
//		jlb_number.setBounds(40, 360, 80, 40);
//		jlb_number.setFont(jl_font);
//		jtf_number.setBounds(40, 393, 250, 40);
//		this.add(jlb_number);
//		this.add(jtf_number);

		// 가입완료
		jbtn_ok.setBounds(105, 465, 120, 40);
		this.add(jbtn_ok); 

//		//종궉이
//		jbtn_ok.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Object obj = e.getSource();
//				if (obj == jbtn_ok) {
//					JOptionPane.showMessageDialog(null, "가입성공!", "SUCCESS", JOptionPane.DEFAULT_OPTION);
//					dispose();
//					LoginView_test LG = new LoginView_test();
////					LoginView_test.setVisible(true);
////				} else if (obj == jbtn_login) {
////
//				}
//			
//			} 
//		});
	
		jbtn_idcheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jbtn_idcheck == e.getSource()) {
					System.out.println("중복검사 버튼 눌러짐"); // 단위테스트용
					String user_id = jtf_id.getText();
					logindao = new LoginDao();
					int result = logindao.idCheck(user_id); // id 중복체크 메소드(Dao)
					// 입력아이디 사용 가능(중복없음) = 1
					if (result == 1) {
						// 입력 아이디 사용가능
						// 입력한 아이디는 사용 못해
						// 다시 입력해야 된다.
						JOptionPane.showMessageDialog(null, "입력한 아이디는 사용할 수 있습니다.", "INFO", JOptionPane.INFORMATION_MESSAGE);
						jtf_id.setEditable(false);
						jbtn_idcheck.setEnabled(false);
						isIDCheck = true;
						jbtn_ok.setEnabled(isIDCheck);
						return;
						
					}
					// 입력아이디 사용 불가(중복있음) = -1
					else if (result == -1) {
						jtf_id.setText("");
						JOptionPane.showMessageDialog(null, "입력하신 아이디는 이미 존재하는 아이디입니다.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} // 회원가입 버튼 이벤트 처리
				if (jbtn_ok == e.getSource()) {
					System.out.println("회원가입 버튼 눌러짐"); // 단위테스트용
					
					// 중복검사 버튼이 눌러졌는 지 체크하는 조건문 추가해야함
					// 모든 텍스트 필드들이 공백이 아닐때만 회원가입 처리(나중에 db에서 반환값 던져서 처리할 것)		
					if (!(jtf_id.getText().equals("")) && !(jpf_pw.getText().equals("")) && !(jpf_repw.getText().equals(""))
							&& !(jtf_name.getText().equals(""))) {
						
						// 비밀번호 중복검사
						if (jpf_pw.getText().equals(jpf_repw.getText())) {
							String user_id = jtf_id.getText();
							String user_pw = jpf_pw.getText();
							String user_name = jtf_name.getText();
							logindao = new LoginDao();
							logindao.signup(user_id, user_pw, user_name);
							JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!", "INFO", JOptionPane.INFORMATION_MESSAGE);
							new LoginView_test();
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "입력한 비밀번호가 다릅니다. 다시 작성해 주세요", "Error",
									JOptionPane.ERROR_MESSAGE);
							return;
							}
						} 
					
					else {
						JOptionPane.showMessageDialog(null, "모든 입력창에 값을 입력해 주세요.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				
				}
			}
		});
	}
}	
