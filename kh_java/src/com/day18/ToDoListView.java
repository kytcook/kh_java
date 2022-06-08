package com.day18;
import java.awt.FlowLayout;
import java.awt.Font;

// java.lang이 아닌 모든 패키지는 JVM이 접근할 수 없다.
// 반드시 import를 별도로 해야 한다.
import javax.swing.JFrame;

public class ToDoListView extends JFrame {
	javax.swing.JLabel jlb_timer = new javax.swing.JLabel("현재시간 : ");
	Font f = new Font("돋음체", Font.BOLD, 30); // 
	public ToDoListView() {
		// 화면을 그리는 메소드를 디폴트 생성자에서 호출해보기 - 표현력을 키운다. 위치를 다양하게 표현하기
		// 생성자 안에서 호출할 때는 인스턴스화가 필요 없다.
		// 직접 호출이 가능하다.
		initDisplay(); // 생성자에서 메소드를 호출한다
		// 객체주입
		TimeClient tc = new TimeClient(jlb_timer);
		tc.start();// run()호출이 된다. - Thread검색 start()
	}
	public void initDisplay() {
		jlb_timer.setFont(f);
		this.setTitle("TODO Ver1.0");
		this.setLayout(new FlowLayout());
		// 보더레이아웃은 동서남북 플로우레이아웃은 중앙에서 양쪽으로 배치가 일어남
		this.add("North", jlb_timer); 
		this.setSize(500, 300);
		this.setVisible(true);
	}
	// 타임클라이언트를 메소드를 호출하세요 런
	public static void main(String[] args) {
		ToDoListView tv = new ToDoListView();
		// tv.initDisplay();
		
	}

}
