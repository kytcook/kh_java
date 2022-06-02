package ex10;

import java.awt.*;
import javax.swing.*;

public class LoginView extends JFrame {
	ChattingClient cc;
	JPanel loginPanel;
	JLabel idLabel;
	JLabel pwLabel;
	JTextField idText;
	JPasswordField pwText;
	JButton loginBtn;
	JButton idpwSearchBtn;

	public LoginView(ChattingClient cc) {
		this.cc = cc;
		this.setTitle("Sign-Up");
		loginPanel = new JPanel(new GridLayout(3, 2));
		idLabel = new JLabel("아이디 ");
		pwLabel = new JLabel("비밀번호 ");
		idText = new JTextField();
		pwText = new JPasswordField();
		loginBtn = new JButton("로그인");
		idpwSearchBtn = new JButton("회원가입");

		this.setContentPane(loginPanel);
		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		loginPanel.add(idpwSearchBtn);
		loginPanel.add(loginBtn);

		this.setSize(350, 150);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginBtn.addActionListener(cc);
		idpwSearchBtn.addActionListener(cc);
	}
}
