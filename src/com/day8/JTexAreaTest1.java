package com.day8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTexAreaTest1 extends JFrame implements ActionListener {
	JPanel jp_center = new JPanel ();// 속지
	//JPanel jp_south = new JPanel ();
	JTextArea jta_display = new JTextArea();
	// JTextField 에 오늘 스터디할까 엔터 쳤을 때 JTextField에는 문자열을 지우고
	// JTextArrea에는 방금 입력한 메세지를 출력해 본다.
	JTextField jf_msg = new JTextField ();
	
	public void initDisplay () {
		jf_msg.addActionListener(this);
		jta_display.setBackground(Color.orange);
		jp_center.setBackground(Color.orange);
		//jp_south.setBackground(Color.green);
		jf_msg.setBackground(Color.cyan);
		this.add("Center", jp_center);
		this.add("Center", jta_display);
		//this.add("South", jp_south);
		this.setSize(320, 400);
		this.setVisible(true); //false이면 비활성화/메모리에는 올라와있지만 (ex-전화가 오면 영상이 끊긴다)
		
		
	}
	
	public static void main(String[] args) {
		JTexAreaTest1 jtt = new JTexAreaTest1();
		jtt.initDisplay();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jf_msg) {
			jta_display.append(jf_msg.getText()+"\n");
			jf_msg.setText("");
		}
	}

}
