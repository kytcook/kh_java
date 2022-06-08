package ex10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ChattingClient extends JFrame implements ActionListener {
	
	private final String ip = "127.0.0.1";	// ->27
	public String getIp() {
		return ip;
	}

	LoginView lv; // 1. 로그인
	SignUpView sv; // 1-2. 아이디 없을시 회원가입
	ChatView cv; // 2. 채팅
	
	ChatDAO dao;
	Socket socket; // 소켓
	ObjectOutputStream oos = null;	// 말 하고 싶을 때
	ObjectInputStream ois = null;	// 듣기 할 때 -> 31
	
	public ChattingClient() {			// ChattingClient 생성자 -> 16
		dao = new ChatDAO();			// ChatDAO 인스턴스화		
		lv = new LoginView(this);		// LoginView 인스턴스화
		sv = new SignUpView(this);		// SignUpView 인스턴스화
		cv = new ChatView(this);		// ChatView 인스턴스화
	}
	
	public void init() {
		try {		// 예외발생 소캣
			socket = new Socket(ip, 5000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(100 + "#" + cv.nickName);
			ChattingClientThread cct = new ChattingClientThread(this);
			cct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		/****************Chat******************/
		if (obj == cv.tf) {
			String msg = cv.tf.getText();
			if (msg == null || msg.length() == 0) {
				JOptionPane.showMessageDialog(cv.jf2, "내용을 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					oos.writeObject(201 + "#" + cv.nickName + "#" + msg);
					cv.tf.setText("");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}else if (obj == cv.jbt) {
			try {
				oos.writeObject(500 + "#" + cv.nickName);
				// 자바가상머신과 연결고리 끊기
				System.exit(0);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
		/****************Login******************/
		if (obj == lv.loginBtn) {
			String id = lv.idText.getText().trim();
			String pw = lv.pwText.getText().trim();
			String[] list = dao.idLogin(id, pw);
			if (id.length() == 0 || pw.length() == 0) {
				JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "FAIL!", JOptionPane.DEFAULT_OPTION);
			} else if (list[0] == "1") {
				JOptionPane.showMessageDialog(this, "로그인 성공!", "SUCCESS", JOptionPane.DEFAULT_OPTION);
				cv.nickName = list[1];
				cv.view();
				init();
				lv.dispose();
			} else if (list[0] == "2") {
				JOptionPane.showMessageDialog(this, "비밀번호를 다시 입력 해주세요", "FAIL!", JOptionPane.DEFAULT_OPTION);
			} else if (list[0] == "3") {
				JOptionPane.showMessageDialog(this, "존재하지 않는 아이디 입니다.", "FAIL!", JOptionPane.DEFAULT_OPTION);
			}
		}else if (obj == lv.idpwSearchBtn) {
			sv.view();
		}

		/****************SignUp******************/
		if (obj == sv.rButton) {
			String id2 = sv.tId.getText().trim();
			String pwd = sv.tPassword.getText().trim();
			String name = sv.tName.getText().trim();
			if (dao.signUp(id2,pwd,name) == 1) {
				JOptionPane.showMessageDialog(this, "등록성공!", "SUCCESS", JOptionPane.DEFAULT_OPTION);
				sv.dispose();
			}else if (dao.signUp(id2,pwd,name) == 2) {
				JOptionPane.showMessageDialog(this, "존재하는 아이디입니다.", "FAIL!", JOptionPane.DEFAULT_OPTION);
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);		//?
		new ChattingClient();								// ChattingClient메소드호출 -> 30
	}

}
