package com.day14;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog_1 extends JDialog {
	/**
	 * 디폴트생성자는 생략 가능하다. - JVM이 해준다 - 넌 개발자가 아니잖아? 그런데 왜 가능할까?
	 	- 자동으로 해준다. 언제?: 인스턴스화를 했을 때 - 어디서?(main_1클래스 23번 라인에서)
	 * Dialog_1 dialog = null; // 11번과 12번 같이볼 것.(11번은 선언)
	   dialog = new Dialog_1(); // 12번 : 생성 - 메모리에 로딩
	   Dialog_1 dialog = new Dialog_1(); 한번에 일어난다  
	 * 디폴트생성자는 파라미터가 없다 
	 */
	public void initDisplay() { // 화면을 그려주는 메소드 구현이다. (서브창이다 - 자녀창이다.)
       this.setTitle("  메인 서브창");
       this.setSize(300, 400);
       this.setVisible(true);
   }
}