package ex_memorycost_actionListner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginView extends JFrame {
	// 선언부. 객체들 선언
	JPanel loginPanel;
	JLabel idLabel;
	JLabel pwLabel;
	JTextField idText;
	JPasswordField pwText;
	JButton loginBtn;
	JButton idpwSearchBtn;
	
	// 생성자.
	public LoginView() {
		this.setTitle("Sign-Up");
		loginPanel = new JPanel(new GridLayout(3, 2));
		idLabel = new JLabel("아이디 ");	//판넬에 들어갈 정보들
		pwLabel = new JLabel("비밀번호 ");
		idText = new JTextField();
		pwText = new JPasswordField();
		loginBtn = new JButton("로그인");
		idpwSearchBtn = new JButton("회원가입"); 

		
		// 판넬
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

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idText.getText().trim();// trim : 공백을 없애준다.
				String pw = pwText.getText().trim();
				if (e.getSource() == loginBtn) {
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
		
		idpwSearchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == idpwSearchBtn) {
					new SignUpView();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new LoginView();
	}
}
