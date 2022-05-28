package swing.template;

import javax.swing.JButton;
/* javax폴더 밑에 swing이라는 폴더미에 JFrame이라는 클래스를 찾는다.
 * import를 통해 해당하는 소스안에 추가를 해야 JDK(자바가상머신)활용해서
     해당하는 클래스를 컴파일하고, 컴파일을 통해 만들어진 소스가 실행될 수 있다. */
import javax.swing.JFrame;
/* extends 예약어 : 뒤에오는 클래스를 상속받겠다는 예약어.
	    JFrame이 가진 변수,메소드를 활용할 수 있다. 재사용가능
 * JFrame : 자바가상머신을 설치했을 때 제공되는 API에 해당  */
public class BorderLayoutApp_1 extends JFrame {
	//(14~18)선언부 -> 전역변수 (해당하는 클래스 전역에서 사용), 인스턴스화 5번 됨
	// 인스턴스화를 -> RAM(메모리영역)에 해당하는 클래스를 로딩.
	JButton btn_north  = new JButton("북쪽");
	JButton btn_south  = new JButton("남쪽");
	JButton btn_east   = new JButton("동쪽");
	JButton btn_west   = new JButton("서쪽");
	JButton btn_center = new JButton("중앙");
	public void initDisplay() {
		this.add("North",btn_north);
		this.add("South",btn_south);
		this.add("East",btn_east);
		this.add("West",btn_west);
		this.add("Center",btn_center);
		this.setSize(500, 500);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		BorderLayoutApp_1 bv = new BorderLayoutApp_1();
		bv.initDisplay();
	}

}
