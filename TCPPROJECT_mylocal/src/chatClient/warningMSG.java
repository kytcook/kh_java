package chatClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class warningMSG extends JFrame implements ActionListener {
	/****************************************
	 * 				   선언부					*	
	 ****************************************/
	
	JButton 		jbtn_yes 	= new JButton("네");	// 업데이트 버튼
	JButton 		jbtn_no 	= new JButton("아니오");	// 업데이트 버튼
	JLabel 			jlb_real	= new JLabel("정말로 삭제하시겠습니까??");		   			// 아이디 라벨
	
	
	String myid		 = null;
	String user_repw = null;
	changeView_02 cv = null;
	/****************************************
	 * 				   생성자					*	
	 ****************************************/
	
	public warningMSG(changeView_02 cv) {
		this.cv = cv;
	}
	
	/****************************************
	 * 				   화면처리				*	
	 ****************************************/
	public void initDisplay() {
		////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////
		
	    this.setLayout(null);								
	    this.setTitle("꽉자바 ver.1");							
	    this.setSize(300, 150);								
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	    this.setVisible(true);									
	    this.setLocation(800, 400);								
	    this.addWindowListener(new WindowAdapter() { 
	   	 public void windowClosing(WindowEvent e) {
	            System.exit(0);
	 
	   	 }});
	    
	    // 진짜 삭제?
	    jlb_real.setBounds(70, 5, 200, 40);				
	    this.add(jlb_real);								
	    
	    // yes or no 버튼
	    jbtn_yes.setBounds(25, 45, 100, 40);			
	    this.add(jbtn_yes);								
	    jbtn_no.setBounds(150, 45, 100, 40);			
	    this.add(jbtn_no);								
	    jbtn_yes.addActionListener(this);		
	    jbtn_no.addActionListener(this);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_yes) {
			System.out.println(myid);
			
		}

	}

}
