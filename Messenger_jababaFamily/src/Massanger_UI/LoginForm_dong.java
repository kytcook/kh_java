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
public class LoginForm_dong extends JFrame implements ActionListener {
    /////////////////////////////////////////////////////
    /* 선언부 */
    /////////////////////////////////////////////////////
//	ChattingClient tcv = null;
    String nickName="";
//    ChatDao chatDao = new ChatDao();
    String imgPath="C:\\Users\\kytco\\OneDrive\\문서\\카카오톡 받은 파일\\꽉자바파일모음\\회의\\20220526_데이터모델링\\";
//    ChatMemberVO cmvo = null;
    JLabel jlb_id = new JLabel("아이디");
    JLabel jlb_pw = new JLabel("패스워드");
    Font jl_font = new Font("맑은고딕체", Font.BOLD, 14);
    JTextField jtf_id = new JTextField("엔터빵");
    JPasswordField jpf_pw = new JPasswordField("123");
    JButton jbtn_login = new JButton(
            new ImageIcon(imgPath+"카톡로그인.jpg"));
    JButton jbtn_join = new JButton(
    		new ImageIcon(imgPath+"카톡회원가입.jpg"));
    // JPanel에 쓰일 이미지아이콘
    ImageIcon ig = new ImageIcon(imgPath+"카톡로그인(2).jpg");
    /////////////////////////////////////////////////////
    /* 생성자 */
    /////////////////////////////////////////////////////
    public LoginForm_dong(){
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
        this.setTitle("꽉자바 ver.1");
        this.setSize(350, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(600, 150);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // id 라인
        jlb_id.setBounds(45, 200, 80, 40);
        jlb_id.setFont(jl_font);
        this.add(jlb_id);
        
        //아이디 입력창
        jtf_id.setBounds(110, 200, 185, 40);
        this.add(jtf_id);
        
        // pw 라인
        jlb_pw.setBounds(45, 240, 80, 40);
        jlb_pw.setFont(jl_font);
        this.add(jlb_pw);
        
        //pw 입력창
        jpf_pw.setBounds(110, 240, 185, 40);
        this.add(jpf_pw);
        
        // 로그인 버튼 라인
        jbtn_login.setBounds(175, 285, 120, 40);
        this.add(jbtn_login);
        
        // 회원가입 버튼 라인
        jbtn_join.setBounds(45, 285, 120, 40);
        this.add(jbtn_join);        
    }
    public static void main(String[] args) throws Exception {
        new LoginForm_dong();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jbtn_join) {
        	JOIN_dong join = new JOIN_dong();
        	join.initDisplay();
        } 
        else if (obj == jbtn_login) {
        	System.out.println("로그인");
        }
    }
}