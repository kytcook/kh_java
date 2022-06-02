package ex10;

import java.util.StringTokenizer;

public class ChattingClientThread extends Thread {
	ChattingClient cc = null;
	public ChattingClientThread(ChattingClient cc) {
		this.cc = cc;
	}
	
	public void run() {
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg = "";//100#apple
				msg = (String)cc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;//100|200|201|202|500
				if(msg !=null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());//100
				}
				switch(protocol) {
					case 100:{//100#apple
						String nickName = st.nextToken();
						cc.cv.ta.append(nickName+"님이 입장하였습니다.\n");
//						Vector<String> v = new Vector<>();
//						v.add(nickName);
//						cc.dtm.addRow(v);
					}break;
//					case 600:{
//						
//					}break;
					case 201:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						cc.cv.ta.append("["+nickName+"]"+message+"\n");
						cc.cv.ta.setCaretPosition
						(cc.cv.ta.getDocument().getLength());					
					}break;
					case 202:{
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String message = st.nextToken();
//						테이블에 대화명 변경하기
//						for(int i=0;i<cc.dtm.getRowCount();i++) {
//							String imsi = (String)cc.dtm.getValueAt(i, 0);
//							if(nickName.equals(imsi)) {
//								cc.dtm.setValueAt(afterName, i, 0);
//								break;
//							}
//						}
//						채팅창에 타이틀바에도 대화명을 변경처리 한다 - 닉네임 변경 미구현
//						if(nickName.equals(cc.nickName)) {
//							cc.setTitle(afterName+"님의 대화창");
//							cc.nickName = afterName;
//						}
						cc.cv.ta.append(message+"\n");
					}break;
					case 500:{
						String nickName = st.nextToken();
						cc.cv.ta.append(nickName+"님이 퇴장 하였습니다.\n");
						cc.cv.ta.setCaretPosition
						(cc.cv.ta.getDocument().getLength());
//						for(int i=0;i<cc.dtm.getRowCount();i++) {
//							String n =(String)cc.dtm.getValueAt(i, 0);
//							if(n.equals(nickName)) {
//								cc.dtm.removeRow(i);
//							}
//						}
					}break;
				}////////////end of switch
			} catch (Exception e) {
				// TODO: handle exception
			}
		}////////////////////end of while
	}////////////////////////end of run
}
