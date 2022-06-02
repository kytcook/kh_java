package ex10;

import java.awt.BorderLayout;
import javax.swing.*;

public class ChatView extends JFrame {
	ChattingClient cc;
	JFrame jf2; // 채팅창
	JTextField tf; // 입력칸
	JTextArea ta; // 대화칸
	JLabel jlb1, jlb2; // 라벨
	JPanel jp1, jp2; // 판넬
	JButton jbt; // 종료버튼
	String nickName = null;// 닉네임 등록

	public ChatView(ChattingClient cc) {
		this.cc = cc;
	}

	public void view() {

		jf2 = new JFrame("채팅 클라이언트");
		jp1 = new JPanel();
		jp1.setLayout(new BorderLayout()); // 위치 레이아웃
		tf = new JTextField(30); // 30글자 제한
		jbt = new JButton("종료"); // 종료버튼
		jp1.add(jbt, BorderLayout.EAST);
		jp1.add(tf, BorderLayout.CENTER);

		// 위쪽 판넬
		jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		jlb1 = new JLabel("닉네임 : [" + nickName + "]");
		jlb2 = new JLabel("서버 IP 주소 : " + cc.getIp());
		jp2.add(jlb1, BorderLayout.CENTER);
		jp2.add(jlb2, BorderLayout.EAST);

		ta = new JTextArea("", 10, 50);
		JScrollPane jsp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jf2.add(jp1, BorderLayout.SOUTH);
		jf2.add(jp2, BorderLayout.NORTH);
		jf2.add(jsp, BorderLayout.CENTER);

		ta.setEditable(false);
		jf2.pack();
		jf2.setResizable(false);
		jf2.setVisible(true);
		tf.addActionListener(cc);
		jbt.addActionListener(cc);

	}

}
