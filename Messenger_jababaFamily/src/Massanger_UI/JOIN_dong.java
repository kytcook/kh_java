package Massanger_UI;

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

public class JOIN_dong extends JFrame implements ActionListener {
	/////////////////////////////////////////////////////
	/* 선언부 */
	/////////////////////////////////////////////////////
//	TalkClientVer2 tcv = null;
	String nickName="";												//
//	ChatDao chatDao = new ChatDao();
	String imgPath="C:\\Users\\kytco\\OneDrive\\문서\\카카오톡 받은 파일\\꽉자바파일모음\\회의\\20220526_데이터모델링\\";	// 이미지 경로를 문자열로..지정??
//	ChatMemberVO cmvo = null;
	JLabel jlb_id = new JLabel("아이디");								// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_pw = new JLabel("비밀번호");							// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_repw = new JLabel("비밀번호 재확인");					// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_name = new JLabel("이름");							// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_number = new JLabel("전화번호");                       // "[입력]" : 문자열을 화면에 그림
	

	Font jl_font = new Font("휴먼매직체", Font.PLAIN, 17);				// ID와 PW의 (글씨체, 폰트굵기, 크기)를 파라미터 값으로 호출한다?
	JTextField jtf_id = new JTextField(" ID를 입력하세요");						
	JTextField jpf_pw = new JTextField(" 비밀번호를 입력하세요");				// PW는 숨겨진다
	JTextField jtf_repw = new JTextField(" 비밀번호를 재입력하세요");			
	JTextField jtf_name = new JTextField(" 이름을 입력하세요");						
	JTextField jtf_number = new JTextField(" 전화번호를 입력하세요");						
	
	 JButton jbtn_ok = new JButton(
	    		new ImageIcon(imgPath+"확인.png"));
	
	// JPanel에 쓰일 이미지아이콘
//	ImageIcon ig = new ImageIcon(imgPath+"main.png");

	/////////////////////////////////////////////////////
	/* 생성자 */
	/////////////////////////////////////////////////////
	public JOIN_dong(){
		initDisplay();
		jbtn_ok.addActionListener(this);
	}

	/////////////////////////////////////////////////////
	/* jpanal 오버라이드 */
	/////////////////////////////////////////////////////

	/* 배경이미지 */
//	class mypanal extends JPanel {
//		public void paintComponent(Graphics g) {
//			g.drawImage(ig.getImage(), 0, 0, null);
//			setOpaque(false);
//			super.paintComponents(g);
//		}
//	}

	/////////////////////////////////////////////////////
	/* 화면처리 */
	/////////////////////////////////////////////////////
	public void initDisplay() {
//		setContentPane(new mypanal());
		
		/* 버튼과 텍스트필드 구성 */
		jbtn_ok.addActionListener(this);
		this.setLayout(null);
		this.setTitle("꽉자바패밀리 ver.1"); 							// 타이틀 제목
		this.setSize(400, 600);										// 로그인 창 사이즈 - 2개의 파라미터로 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);										// 창을 보여준다.
		this.setLocation(600, 150);									// 창이 처음 띄어지는 위치 - (800, 250)은 중앙
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// id 라인
		jlb_id.setBounds(65, 40, 80, 40);		
		jlb_id.setFont(jl_font);						
		jtf_id.setBounds(65, 70, 250, 40);
		this.add(jlb_id);						
		this.add(jtf_id);						

		// pw 라인
		jlb_pw.setBounds(65, 120, 80, 40);
		jlb_pw.setFont(jl_font);
		jpf_pw.setBounds(65, 153, 250, 40); // 모음유무에 따라 실제 값 차이는 없지만 시각적인 줄간격 오차가 나서 모음에는 3씩 추가
		this.add(jlb_pw);
		this.add(jpf_pw);
		
		// 비번 재확인
		jlb_repw.setBounds(65, 200, 150, 40);
		jlb_repw.setFont(jl_font);
		jtf_repw.setBounds(65, 233, 250, 40);
		this.add(jlb_repw);
		this.add(jtf_repw);
		
		// 이름
		jlb_name.setBounds(65, 280, 80, 40);
		jlb_name.setFont(jl_font);
		jtf_name.setBounds(65, 313, 250, 40);
		this.add(jlb_name);
		this.add(jtf_name);

		// 전화번호
		jlb_number.setBounds(65, 360, 80, 40);
		jlb_number.setFont(jl_font);
		jtf_number.setBounds(65, 393, 250, 40);
		this.add(jlb_number);
		this.add(jtf_number);

		//가입하기 버튼
		jbtn_ok.setBounds(130, 465, 120, 40);
		this.add(jbtn_ok);  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 Object obj = e.getSource();
	        if (obj == jbtn_ok) {
	        	LoginForm LG = new LoginForm();
	        	LG.initDisplay();
	        	
	        } 
//	        else if (obj == jbtn_ok) {
//	        	System.out.println("로그인");
//	        }
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object obj = e.getSource();
//		if (obj == jbtn_join) {
//
//		} 
//		else if (obj == jbtn_login) {
//
//		}
//	}
}
/*
 * 로그인과 회원가입 버튼에 이미지 파일을 넣지 않고 코드만으로 만들 수 있을까?//
 * 창의 크기변화에 유동적으로 반응하는 화면 구현?
 * ID 입력란에 입력을 하면 "입력하세요"문자 자동으로 사라지게 하기 (==PW, REPW, NAME)
 * 모음유무에 따라 실제 값 차이는 없지만 시각적인 줄간격 오차가 나는듯 하다. 좀 더 깔끔한 숫자or글씨체??
 * JPasswordField는 자동으로 입력된 문자열을 숨겨주는(* 처리한다) 기능이 있는 듯 하다.
 	- 숨김기능과 보여주기 기능의 전환기능을 넣기?
 * 아직 버튼클릭에 대한 이벤트 처리가 없다 + 머름 / 어찌하나..?	
 */