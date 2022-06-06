package DongH;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;



public class Event implements ActionListener {
	Login1 lg; 
	Sign sg;
	ChatView cv;
	TalkClientThread2 tt;
	public Event() {
		lg = new Login1(this);
		sg = new Sign(this);
		cv = new ChatView(this);
	}
	public static void main(String[] args) {
		Event ev = new Event();
	}

	// 로그인
	@Override
	public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        boolean a = true;
        if (obj == lg.jbtn_join) {
			sg.initDisplay(a);
        } 
        else if (obj == lg.jbtn_login) {
        	String id = lg.jtf_id.getText();
        	String pw = lg.jpf_pw.getText();
        	System.out.println("로그인");
        	if(id.equals("test")&& pw.equals("1234")) {
        		cv.initDisplay();
        	}
        }
//        // 회원가입
	        if (obj == sg.jbtn_ok) {
	        	sg.a=false;
	        	sg.initDisplay(a);
	        } 
	        else if (obj == sg.jbtn_but) {
				System.out.println("중복이 확인되었습니다.");
				String user_id = sg.jtf_id.getText();
				
				// 입력한 아이디가 존재하는거야?
				if(sg.result == 1) {
					// 입력한 아이디는 사용 못해
					// 다시 입력해야 된다.
					sg.jtf_id.setText("");
					JOptionPane.showMessageDialog(sg
							, "입력한 아이디는 사용할 수 없습니다."
							, "Error"
							, JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 입력한 아이디가 없는데?
				else if(sg.result == 0) {
					// 입력한 아이디를 사용할 수 있어
					JOptionPane.showMessageDialog(cv
							, "입력한 아이디는 사용할 수 있습니다."
							, "INFO"
							, JOptionPane.INFORMATION_MESSAGE);
					sg.jtf_id.setEditable(false);
					sg.jbtn_but.setEnabled(false);
					sg.isIDCheck = true;
					sg.jbtn_ok.setEnabled(sg.isIDCheck);
				}
	        }
	// 채팅클라이언트
		String msg = cv.jtf_msg.getText();
		if(cv.jtf_msg==obj) {
			try {
				cv.oos.writeObject(201
						   +"#"+cv.nickName
						   +"#"+msg);
				cv.jtf_msg.setText("");
			} catch (Exception e1) {
			}
		
		if(cv.jbtn_exit==obj) {
			try {
				cv.oos.writeObject(500+"#"+this.cv.nickName);
				//자바가상머신과 연결고리 끊기
				System.exit(0);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		else if(cv.jbtn_change == obj) {
			String afterName = JOptionPane.showInputDialog("변경할 대화명을 입력하세요.");
			if(afterName == null || afterName.trim().length()<1) {
				JOptionPane.showMessageDialog(cv
				, "변경할 대화명을 입력하세요"
				, "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			try {
				cv.oos.writeObject(202
						   +"#"+cv.nickName
						   +"#"+afterName
						   +"#"+cv.nickName+"의 대화명이 "+afterName+"으로 변경되었습니다.");
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}}
	}
	//소켓 관련 초기화
	public void init() {
		try {
			//서버측의 ip주소 작성하기
			cv.socket = new Socket("127.0.0.1",3002);
			cv.oos = new ObjectOutputStream(cv.socket.getOutputStream());
			cv.ois = new ObjectInputStream(cv.socket.getInputStream());
			//initDisplay에서 닉네임이 결정된 후 init메소드가 호출되므로
			//서버에게 내가 입장한 사실을 알린다.(말하기)
			cv.oos.writeObject(100+"#"+cv.nickName);
			//서버에 말을 한 후 들을 준비를 한다.
			TalkClientThread2 tct = new TalkClientThread2(cv);
			tct.start();
		} catch (Exception e) {
			//예외가 발생했을 때 직접적인 원인되는 클래스명 출력하기
			System.out.println(e.toString());
		}
	}
	

}
