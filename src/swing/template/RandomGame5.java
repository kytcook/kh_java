package swing.template;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RandomGame5 extends JFrame implements ActionListener{
	private JPanel p_south = null;
	private JTextArea ta_result = null;
	private JScrollPane jsp = null;
	private JButton btn_zero = null;
	private JButton btn_one = null;
	private JButton btn_two = null;
	private JButton btn_three = null;
	private JButton btn_four = null;
	private JButton btn_five = null;
	private JButton btn_six = null;
	private JButton btn_seven = null;
	private JButton btn_eight = null;
	private JButton btn_nine = null;
	private JButton btn_exit = null;
	private JButton btn_newGame = null;
	int count = 1;
	//Computer가 채번한 값
	int com = 0;
	//사용자가 입력한 값
	int user = 0;
	String hint = "";
	boolean isFlag = false;
	JOptionPane oDialog = null;
	public RandomGame5(){
		initDisplay();
		newGame();
	}
	public void initDisplay(){
		p_south = new JPanel();
		p_south.setLayout(new GridLayout(4,5));
		ta_result = new JTextArea();
		jsp = new JScrollPane(ta_result,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		btn_zero = new JButton("0");
		btn_zero.addActionListener(this);
		btn_one = new JButton("1");
		btn_one.addActionListener(this);
		btn_two = new JButton("2");
		btn_two.addActionListener(this);
		btn_three = new JButton("3");
		btn_three.addActionListener(this);
		btn_four = new JButton("4");
		btn_four.addActionListener(this);
		btn_five = new JButton("5");
		btn_five.addActionListener(this);
		btn_six = new JButton("6");
		btn_six.addActionListener(this);
		btn_seven = new JButton("7");
		btn_seven.addActionListener(this);
		btn_eight = new JButton("8");
		btn_eight.addActionListener(this);
		btn_nine = new JButton("9");
		btn_nine.addActionListener(this);
		btn_exit = new JButton("종료");	
		btn_exit.setBackground(Color.red);
		btn_exit.addActionListener(this);
		btn_newGame = new JButton("새게임");	
		btn_newGame.setBackground(Color.green);
		btn_newGame.addActionListener(this);
		p_south.add(btn_zero);
		p_south.add(btn_one);
		p_south.add(btn_two);
		p_south.add(btn_three);
		p_south.add(btn_four);
		p_south.add(btn_five);
		p_south.add(btn_six);
		p_south.add(btn_seven);
		p_south.add(btn_eight);
		p_south.add(btn_nine);
		p_south.add(btn_exit);
		p_south.add(btn_newGame);
		ta_result.setEnabled(false);
		ta_result.setFont(new Font("바탕", Font.BOLD, 20));
		ta_result.setForeground(Color.black);
		getContentPane().add(p_south,BorderLayout.SOUTH);
		getContentPane().add(jsp,BorderLayout.CENTER);
		this.setTitle("숫자맞추기 게임");
		this.setSize(500,300);
		this.setVisible(true);
	}
	public void newGame()
	{
		ta_result.append("새로운 게임을 시작합니다."+"\n");
		count = 1;
		com = (int)(Math.random()*10);
	}
	public void gameTest(int user)
	{
		if(user==com){
			hint = "축하합니다.";
			ta_result.append(count++ +". 입력한 값은 "+user+" : "+hint+"\n");
			//dispose();
			//newGame();
			isFlag = true;
		}else if(user > com){
			hint = "나차라~~";
			ta_result.append(count++ +". 입력한 값은 "+user+" : "+hint+"\n");
			ta_result.setCaretPosition(ta_result.getDocument().getLength());
			if(count == 6){
				ta_result.append("넌 바보"+"\n");
				newGame();
			}
				isFlag = true;
				//count = 1;
		}else if(user < com){
			hint = "노피라~~";
			ta_result.append(count++ +". 입력한 값은 "+user+" : "+hint+"\n");
			ta_result.setCaretPosition(ta_result.getDocument().getLength());
			if(count == 6){
				ta_result.append("넌 바보"+"\n");
				newGame();
			}	
				isFlag = true;
				//count = 1;
		}
	}
	public static void main(String[] args) {
		new RandomGame5();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
			
		if(obj==btn_zero){
			gameTest(Integer.parseInt(btn_zero.getText()));
		}
		else if(obj==btn_one){
			gameTest(Integer.parseInt(btn_one.getText()));
		}
		else if(obj==btn_two){
			gameTest(Integer.parseInt(btn_two.getText()));
		}
		else if(obj==btn_three){
			gameTest(Integer.parseInt(btn_three.getText()));
		}
		else if(obj==btn_four){
			gameTest(Integer.parseInt(btn_four.getText()));
		}
		else if(obj==btn_five){
			gameTest(Integer.parseInt(btn_five.getText()));
		}
		else if(obj==btn_six){
			gameTest(Integer.parseInt(btn_six.getText()));
		}
		else if(obj==btn_seven){
			gameTest(Integer.parseInt(btn_seven.getText()));
		}
		else if(obj==btn_eight){
			gameTest(Integer.parseInt(btn_eight.getText()));
		}
		else if(obj==btn_nine){
			gameTest(Integer.parseInt(btn_nine.getText()));
		}
		else if(obj == btn_newGame){
			newGame();
		}
		else if(obj == btn_exit){
			System.exit(0);
		}
	}
}