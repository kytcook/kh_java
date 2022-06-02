package ex10;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class ChattingServerThread extends Thread {

	ChattingServer cs = null;
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	String chatName = null;
	String message;

	public ChattingServerThread(ChattingServer cs) {
		this.cs = cs;
		this.client = cs.socket;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			String msg = (String) ois.readObject();
			StringTokenizer st = new StringTokenizer(msg, "#");
			st.nextToken(); // 100
			chatName = st.nextToken();
			cs.logUI.append(cs.setTime()+" "+chatName + " 님이 입장하였습니다. IP"+client.getLocalAddress()+"\n");
			for (ChattingServerThread cst : cs.threadList) {
				// 이전에 입장해 있는 친구들 정보 받아내기
				// String currentName = tst.chatName;
				this.send(100 + "#" + cst.chatName);
			}
			
			// 현재 서버에 입장한 클라이언트 스레드 추가하기
			cs.threadList.add(this);
			cs.tf.setText("서버 ON : 현재 이용자는 "+cs.threadList.size()+"명 입니다.");
			this.broadCasting(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String msg = null;
		boolean isStop = false;
		try {
			run_start: while (!isStop) {
				msg = (String) ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;// 100|200|201|202|500
				if (msg != null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());// 100
				}
				switch (protocol) {
//				case 600: {
//					String id = st.nextToken();
//					String pw = st.nextToken();
//					if (cs.Login(id, pw) == true) {
//						oos.writeObject();
//					}
//				}
//					break;
				case 201: { // 채팅 주고 받기
					String nickName = st.nextToken();
					String message = st.nextToken();
					broadCasting(201 + "#" + nickName + "#" + message);
				}
					break;
				case 202: { // 닉네임 변경 - 미구현
					String nickName = st.nextToken();
					String afterName = st.nextToken();
					String message = st.nextToken();
					this.chatName = afterName;
					broadCasting(202 + "#" + nickName + "#" + afterName + "#" + message);
				}
					break;
				case 500: { // 나가기 버튼
					String nickName = st.nextToken();
					cs.threadList.remove(this);
					cs.logUI.append(cs.setTime()+" "+chatName+" 님이 퇴장하였습니다. IP"+client.getLocalAddress()+"\n");
					cs.tf.setText("서버 ON : 현재 이용자는 "+cs.threadList.size()+"명 입니다.");
					broadCasting(500 + "#" + nickName);
				}
					break run_start;
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 클라이언트에게 말하기 구현
	public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
	public void broadCasting(String msg) {
		for (ChattingServerThread cst : cs.threadList) {
			cst.send(msg);
		}
	}
}