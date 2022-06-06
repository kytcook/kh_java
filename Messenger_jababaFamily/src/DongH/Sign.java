package DongH;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sign extends JFrame{
	Event ev;
	/////////////////////////////////////////////////////
	/* 선언부 */
	/////////////////////////////////////////////////////
	String nickName="";												//
	String imgPath="C:\\java\\workspace_java\\project\\이미지\\";	// 이미지 경로를 문자열로..지정??
	JLabel jlb_id = new JLabel("아이디");								// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_pw = new JLabel("비밀번호");							// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_repw = new JLabel("비밀번호 재확인");					// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_name = new JLabel("이름");							// "[입력]" : 문자열을 화면에 그림
	JLabel jlb_number = new JLabel("전화번호");                       // "[입력]" : 문자열을 화면에 그림
	

	Font jl_font = new Font("휴먼매직체", Font.PLAIN, 17);				// ID와 PW의 (글씨체, 폰트굵기, 크기)를 파라미터 값으로 호출한다?
	JTextField jtf_id = new JTextField("");						
	JTextField jpf_pw = new JTextField("");				// PW는 숨겨진다
	JTextField jtf_repw = new JTextField("");			
	JTextField jtf_name = new JTextField("");						
	JTextField jtf_number = new JTextField("");	
	
    JButton jbtn_but = new JButton(
    		new ImageIcon(imgPath+"버튼.png")); //버튼
	
	 JButton jbtn_ok = new JButton(
	    		new ImageIcon(imgPath+"확인.png"));
	
	// JPanel에 쓰일 이미지아이콘
	ImageIcon ig = new ImageIcon(imgPath+"main.png");
	
	boolean      isIDCheck     =  false;
	boolean 		a		   =  true;
	int result;
	
	
	/////////////////////////////////////////////////////
	/* 생성자 */
	/////////////////////////////////////////////////////
	public Sign(Event ev){
		this.ev = ev;
		jbtn_ok.addActionListener(ev);
	}

	/////////////////////////////////////////////////////
	/* jpanal 오버라이드 */
	/////////////////////////////////////////////////////

	/* 배경이미지 */
	class mypana2 extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponents(g);
		}
	}

	/////////////////////////////////////////////////////
	/* 화면처리 */
	/////////////////////////////////////////////////////
	public void initDisplay(boolean b) {
		setContentPane(new mypana2());
		
		/* 버튼과 텍스트필드 구성 */
//		jbtn_ok.addActionListener(this);
//		jbtn_but.addActionListener(this);
		this.setLayout(null);
		this.setTitle("꽉자바패밀리 ver.1"); 							// 타이틀 제목
		this.setSize(400, 600);										// 로그인 창 사이즈 - 2개의 파라미터로 지정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(a);										// 창을 보여준다.
		this.setLocation(600, 150);									// 창이 처음 띄어지는 위치 - (800, 250)은 중앙
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// id 라인
		jlb_id.setBounds(65, 70, 80, 40);		
		jlb_id.setFont(jl_font);						
		jtf_id.setBounds(65, 100, 250, 40);
		this.add(jlb_id);						
		this.add(jtf_id);						

		// pw 라인
		jlb_pw.setBounds(65, 150, 80, 40);
		jlb_pw.setFont(jl_font);
		jpf_pw.setBounds(65, 183, 250, 40); // 모음유무에 따라 실제 값 차이는 없지만 시각적인 줄간격 오차가 나서 모음에는 3씩 추가
		this.add(jlb_pw);
		this.add(jpf_pw);
		
		// 비번 재확인
		jlb_repw.setBounds(65, 230, 150, 40);
		jlb_repw.setFont(jl_font);
//		jpf_repw.setBounds(65, 263, 250, 40);
		jtf_repw.setBounds(65, 263, 250, 40);
		this.add(jlb_repw);
//		this.add(jpf_repw);
		this.add(jtf_repw);
		
		// 이름
		jlb_name.setBounds(65, 310, 80, 40);
		jlb_name.setFont(jl_font);
		jtf_name.setBounds(65, 343, 250, 40);
		this.add(jlb_name);
		this.add(jtf_name);

		//가입하기 버튼
		jbtn_ok.setBounds(130, 465, 120, 40);
		this.add(jbtn_ok);
		
		//버튼
		jbtn_but.setBounds(320, 105, 25, 25);
		this.add(jbtn_but);  
	}
	
	public static void main(String[] args) {
		Sign s = new Sign(null);
	}

}
