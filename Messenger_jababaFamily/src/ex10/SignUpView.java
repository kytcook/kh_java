package ex10;

import javax.swing.*;
import java.awt.*;

public class SignUpView extends JFrame {
	
	ChattingClient cc;
	JPanel rPanel;
	JLabel rLabel;
	JLabel rId, rPassword, rName;
	JTextField tId, tPassword, tName;
	JButton rButton;

	public SignUpView(ChattingClient cc){
		this.cc = cc;
	}
	
	public void view() {
		this.setTitle("Sign-Up");
	    super.setResizable(true);
	    setSize(350, 400);
	    setLocationRelativeTo(null);

	    rPanel = new JPanel();
	    rPanel.setLayout(new BorderLayout());
	    setContentPane(rPanel);

	    rLabel = new JLabel("Sign-Up");
	    rLabel.setFont(new Font("Serif", Font.BOLD, 40));
	    rLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    rPanel.add(rLabel, BorderLayout.NORTH);

	    JPanel main = new JPanel(new GridLayout(7, 2, 10, 10));

	    rId = new JLabel("ID");
	    rId.setHorizontalAlignment(SwingConstants.CENTER);
	    main.add(rId);

	    tId = new JTextField();
	    main.add(tId);

	    rPassword = new JLabel("PWD");
	    rPassword.setHorizontalAlignment(SwingConstants.CENTER);
	    main.add(rPassword);

	    tPassword = new JTextField();
	    main.add(tPassword);

	    rName = new JLabel("NAME");
	    rName.setHorizontalAlignment(SwingConstants.CENTER);
	    main.add(rName);

	    tName = new JTextField();
	    main.add(tName);

	    rPanel.add(main, BorderLayout.CENTER);

	    JPanel sMain = new JPanel();
	    rPanel.add(sMain, BorderLayout.EAST);

	    rButton = new JButton("등록하기");
	    rButton.setFont(new Font("Serif", Font.BOLD, 20));
	    rPanel.add(rButton, BorderLayout.SOUTH);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    rButton.addActionListener(cc);
	}
}
