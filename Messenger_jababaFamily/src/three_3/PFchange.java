package three_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PFchange extends JFrame implements ActionListener {
	/****************************************
	 * 				   선언부					*	
	 ****************************************/
	// 이미지 경로를 담는 변수 imgPath
	String imgPath		= "D:\\java_study\\workspace_java\\kh_javaAC\\Messenger_jababaFamily\\src\\img\\";	
	boolean box_toggle = false;
	
	JLabel jlb_changepw	= new JLabel("PW 변경");	
	JLabel jlb_repw 	= new JLabel("PW 확인");	
	JLabel jlb_nickname	= new JLabel("닉네임 변경");					// "[입력]" : 문자열을 화면에 그림
	
	JPasswordField 	jpf_changepw	= new JPasswordField("");		// 비밀번호 입력칸
	JPasswordField 	jpf_repw		= new JPasswordField("");		// 비밀번호 확인 입력칸
	JTextField 		jtf_nickname	= new JTextField("");			// 닉네임 텍스트필드
	JButton 		jbtn_update 	= new JButton(new ImageIcon(imgPath+"변경하기.png"));		// 업데이트 버튼
	JButton 		jlb_del 		= new JButton("아이디 삭제");		// 아이디 삭제 버튼
	JButton 		jbtn_ok 		= new JButton(new ImageIcon(imgPath+"버튼.png")); 	// 비번체크 버튼	
	// 폰트설정
	Font			jl_font 		= new Font("맑은고딕체", Font.BOLD, 17);	// 폰트를 파라미터 값(글씨체, 폰트굵기, 크기)으로  생성한다.
	
	/****************************************
	 * 				   생성자					*	
	 ****************************************/
	public PFchange() {
		initDisplay(); 
		}
	public PFchange() {
		initDisplay(); 
		}
	
	/* 배경이미지 */
	
	/****************************************
	 * 				   화면처리				*	
	 ****************************************/
	public void initDisplay() {
	    this.setLayout(null);
	    this.setTitle("꽉자바 ver.1");
	    this.setSize(450, 470);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    this.setLocation(600, 150);
	    this.addWindowListener(new WindowAdapter() { // 익명리스너
	   	 public void windowClosing(WindowEvent e) {
	            System.exit(0);
	   	 }});
	    jbtn_ok.addActionListener(this);
	    jbtn_update.addActionListener(this);
	    
	    
        // 비밀번호 확인버튼
        jbtn_ok.setBounds(355, 45, 28, 28);
        this.add(jbtn_ok);
        
        // 비밀번호 변경
        jlb_changepw.setBounds(40, 40, 130, 40);	// 비밀번호
        jlb_changepw.setFont(jl_font);
        this.add(jlb_changepw);
        jpf_changepw.setBounds(140, 40, 200, 40);	// 입력창
        jpf_changepw.setEnabled(box_toggle);	
        this.add(jpf_changepw);
        
        // 비밀번호 확인
        jlb_repw.setBounds(40, 100, 130, 40);	// 비밀번호
        jlb_repw.setFont(jl_font);
        this.add(jlb_repw);
        jpf_repw.setBounds(140, 100, 200, 40);	// 입력창
        jpf_repw.setEnabled(box_toggle);	
        this.add(jpf_repw);
        
        // 닉네임
        jlb_nickname.setBounds(40, 160, 130, 40);	
        jlb_nickname.setFont(jl_font);
        this.add(jlb_nickname);
        jtf_nickname.setBounds(140, 160, 200, 40);	
        jtf_nickname.setEnabled(box_toggle);	
        this.add(jtf_nickname);
        
        // 변경하기 버튼
        jbtn_update.setBounds(140, 280, 140, 40);
        jbtn_update.setEnabled(box_toggle);	
        this.add(jbtn_update);
        
        // 아이디 삭제 버튼
        jlb_del.setBounds(140, 350, 140, 40);
        jlb_del.setFont(jl_font);
        jlb_del.setBackground(new Color(158,9,9));
		jlb_del.setForeground(new Color(212,212,212));
		jlb_del.setEnabled(box_toggle);	
        this.add(jlb_del);
	}/////////////////[end of initDisplay]////////////////
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 중복확인 버튼
		if (obj == jbtn_ok) {						// '비밀번호체크 버튼' 눌리면
//			System.out.println("버튼눌림");
//			MemberDAO mDao = new MemberDAO();			// DAO 인스턴스화
//			String user_pw = jpf_pw.getText();			// user_pw에 입력한 값을 저장한다.
//			int result = mDao.signIn(user_id ,user_pw);	// 위에서 입력한 pw를 dao클래스의 아이디체크메소드 파라미터로 던져주고 반환받은 값을 result에 저장
//			if(result == -1) {							// 만약 result가 -1이면 중복된 아이디가 있다.
//				// Dao에 있는 메시지 출력
//			}else if(result == 1) {						// 사용가능한 아이디라면
				jbtn_ok.setEnabled(box_toggle);			// '중복체크버튼' 비활성화
				box_toggle = true;						
				jpf_changepw.setEnabled(box_toggle);		
				jpf_repw.setEnabled(box_toggle);			
				jbtn_update.setEnabled(box_toggle);		
				jlb_del.setEnabled(box_toggle);			
				}
				
		//	}
			else if (obj == jbtn_update) {			// '변경하기 버튼'이 눌리면
//			MemberDAO mDao = new MemberDAO();		// DAO 인스턴스화
//			String user_ID = jtf_id.getText();		// user_ID는 미리 입력받아져 있어야한다.
//			String user_pw = jpf_pw.getText();		// user_pw에 입력받은 텍스트를 넣음 
//			String user_nickname = jtf_nickname.getText();	// user_name에 입력받은 텍스트를 담음
//	    	int result = mDao.signUp(user_ID,user_pw,user_nickname); // 위에서 담은 3가지 변수값을 Dao클래스 아래 signUp메소드로 던져서 DB 대조후에 리턴값 받음
//	    	if(result == 1) {	//회원가입 성공				
    			new TalkClient();
    			dispose();
	    	}
		}
//	}
	
	public static void main(String[] args) {
		new PFchange();
	}

}/////////////////[end of class PFchange]////////////////
