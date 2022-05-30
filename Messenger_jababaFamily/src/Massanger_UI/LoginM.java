package Massanger_UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

public class LoginM extends JFrame implements ActionListener{
   
   JLabel jlb_id = new JLabel("아이디");
   JLabel jlb_pw = new JLabel("패스워드");
   JPasswordField jpf_pw = new JPasswordField("123");
   Font jl_font = new Font("나눔고딕", Font.BOLD, 17);
   JTextField jtf_id = new JTextField("test");
   String imgPath = "./image/"; // 이미지 경로(소스파일 안에)
   ImageIcon ic = new ImageIcon(imgPath + "main.jpg");
   ImagePanel panel = new ImagePanel(ic.getImage()); 
   Image img = new ImageIcon("./image/main.jpg").getImage(); 
   
   JButton jbtn_login = new JButton();
   JButton jbtn_join = new JButton();
   
   
   
   
   public LoginM(){
      setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
      setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
      initDisplay();
   }
   
   class mypanal extends JPanel {
         
      public void paintComponent(Graphics g) {
         g.drawImage(ic.getImage(), 0, 0, null);  //( 이미지, x시작위치, y시작위치, null)
         setOpaque(false);
         super.paintComponents(g);
      }
   }
   
   
   public void initDisplay() {
      setContentPane(new mypanal());
      
      /* 버튼과 텍스트필드 구성 */
      jbtn_join.addActionListener(this);
      jbtn_login.addActionListener(this);
      this.setLayout(null);
      this.setTitle("자바채팅 ver.1");
      this.setSize(350, 600);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      this.setLocation(800, 250);
      setResizable(false); // 사이즈 변경 못하도록(추가)
      
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);   
         }
      });
      // id 라인
      jlb_id.setBounds(45, 200, 80, 40);
      jlb_id.setFont(jl_font);
      jtf_id.setBounds(110, 200, 185, 40);
      this.add(jlb_id);
      this.add(jtf_id);
      
      // pw 라인
      jlb_pw.setBounds(35, 240, 80, 40);
      jlb_pw.setFont(jl_font);
      jpf_pw.setBounds(110, 240, 185, 40);
      this.add(jlb_pw);
      this.add(jpf_pw);
      
       // 회원가입 버튼
      jbtn_join.setBounds(175, 285, 120, 40);
      this.add(jbtn_login);
      jbtn_join.setIcon(new ImageIcon(imgPath + "join.jpg"));
      jbtn_join.setPressedIcon(new ImageIcon(imgPath + "join.jpg"));
      
      // 로그인 버튼
      jbtn_login.setBounds(45, 285, 120, 40);
      this.add(jbtn_join);
      jbtn_login.setIcon(new ImageIcon(imgPath + "login.jpg"));
      jbtn_login.setPressedIcon(new ImageIcon(imgPath + "login.jpg"));
      
      this.add(panel); // 패널 추가
      this.pack(); // 패널크기 자동(추가)
      
      
   }
   
   

   public static void main(String[] args) {
      LoginM lo = new LoginM();
      
   }



   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      
   }

}