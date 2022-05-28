package com.day18;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
// 듣고 말하기, 들은 것을 말하기
// 서버가 대화내용을 정해서 말하지 않는다.
public class TalkServerThread extends Thread {
	// 이 소켓은 null인데 oos, ois를 인스턴스화 할 수 있나요?
	Socket				 client = null;
	ObjectOutputStream 	 oos = null;
	ObjectInputStream 	 ois = null;
	String 				 nickName = null; // 
	TalkServer			 ts = null;
	// 파라미터에 선언된 객체는 TalkServer객체주소번지를 갖는다.
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		this.client = ts.client;
		try {
			// 서버측 컴터에 서버를 기동하기 위한 객체 생성하기 - 클라이언트의 접속만 받아준다.
			// 동시에 많은 유저가 접속하더라도 튕기지 않고 모두 안전하게 접속을 허용하기 위해서
			// 그 일만 전담하는 서버소켓이 있는 것임. - 클라이언트 측에는 필요없다.
			oos  = new ObjectOutputStream( client.getOutputStream( ));
			ois  = new ObjectInputStream( client.getInputStream( ));
			// 100#nickName
			String msg = (String)ois.readObject();
			StringTokenizer st = new StringTokenizer(msg, "#");
			st.nextToken(); //100
			nickName = st.nextToken();
			ts.jta_log.append(nickName+"님 입장하였습니다. \n");
			// 내가 들어오기 전에 이미 대화가 진행 중이라면...
			// 이전에 입장해 있는 친구들에게
			for(TalkServerThread tst : ts.globalList) {
				this.send(msg);
			}
			ts.globalList.add(this); //현재 동작하는 스레드 - this- 나는 누구? 스레드를 상속받았잖아
			// 현재 대화방에 있는 모든 사람들에게 메세지 보내기
			this.broadCasting(msg);
		} catch (Exception e) {
			
		}
	}

	// talkserverthred에서 듣기와 말하기를 구현한다.
	// collection
	// bector : 제한이 없다, 타입 모두 가능, Object
	// 현재 입장해 있는 친구들 모두에게 메시지 교환
	public void broadCasting(String msg) {
		// 개선된 for문
		for (TalkServerThread tst : ts.globalList) { // globalList는 벡터 Vector<>();
			tst.send(msg);
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
	
	@Override
	public void run() {
		String msg = "";
		boolean isStop = false;
		while(!isStop) {
			try {
				msg = (String)ois.readObject();
				ts.jta_log.append(msg);
				StringTokenizer st = null;
				int protocol = 0;
				if(msg != null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch (protocol) {
				// 200#토마토#스터디할거야?
				case 200: {
					String nickName = st.nextToken();
					String message = st.nextToken();
					broadCasting(200 + "#" + nickName + "#" + message);
				} break;
				} //// end of switch
			} catch (Exception e) {
				
			}
		}
		
	}// end of run()
}
//
//
//	// 이 소켓은 null인데 oos, ois를 인스턴스화 할 수 있나요? 아니아니
//	// 생성자는 외부의 클래스를 가져올 때 사용한다.
//	// 현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
//	public void broadCasting(String msg) {
//		for() {
//			
//		}
//	}
//}
