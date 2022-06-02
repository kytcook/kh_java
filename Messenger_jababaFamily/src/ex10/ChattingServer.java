package ex10;

import java.awt.BorderLayout;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import java.time.*;


public class ChattingServer extends JFrame implements Runnable {
	
	ChatDAO dao;
	ChattingServerThread cst = null;
	List<ChattingServerThread> threadList; // 각각의 클라이언트들과 통신을 담당해줄 스레드를 담아줄 어레이 리스트
	ServerSocket serversocket = null; // 서버용 소켓 ip주소와 port번호로 서버를 열어두면 클라이언트가 접속한다
	Socket socket; // .accept()으로 접속한 클라이언트들의 요청을 받음
	JTextArea logUI = new JTextArea();// UI 채팅창
	JTextField tf = new JTextField(); // UI 하단 입력창

	public ChattingServer() {
		setTitle("다중 채팅 서버"); // UI 상단 제목
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X눌러서 창을 끌때 프로세스까지 종료되게해줌
		add(new JScrollPane(logUI)); // UI에 스크롤 기능을 제공
		tf.setEditable(false); // JTextField에 입력이 안되게 막아줌
		add(tf, BorderLayout.SOUTH); // tf 입력칸 UI 최하단에 두게해줌
		setSize(500, 500); // 서버 로그창
		setVisible(true); // UI on/of 기능 보이게 해줌
	}

	public static void main(String[] args) {
		ChattingServer cs = new ChattingServer();
		Thread th = new Thread(cs);
		th.start();
	}

	@Override
	public void run() {
		// 서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기
		threadList = new Vector<>();
		boolean isStop = false;
		try {
			serversocket = new ServerSocket(5000);
			logUI.append(setTime()+" SERVER ON ...\n");
			System.out.println("SEVER ON ...");
			tf.setText("서버 ON : 현재 이용자는 "+threadList.size()+"명 입니다.");
			while (!isStop) {
				socket = serversocket.accept();
//				logUI.append("client info:" + socket + "\n");
				ChattingServerThread cst = new ChattingServerThread(this);
				cst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public String setTime() {
		LocalDateTime now = LocalDateTime.now();
		
		//년,일,월
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();

		//시,분,초
		int hour = now.getHour();        
        int minute = now.getMinute();        
        int second = now.getSecond();
        
        String yyyymmdd = year+"-"+
        				  (month < 10 ? "0"+month:""+month)+"-"+
        				  (day < 10 ? "0"+day:""+day);

        String time = (hour < 10 ? "0"+hour:""+hour)+":"+
					  (minute < 10 ? "0"+minute:""+minute)+":"+
					  (second < 10 ? "0"+second:""+second);
       
        return "["+yyyymmdd+"] ["+time+"]";
	}	
}
