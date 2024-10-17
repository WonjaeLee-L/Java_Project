package __0__service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import __0__project_dao.memberDAO_interface;

public class SignInFrame extends JFrame {

	memberDAO_interface m_in = null;
	border b = new border();
	
	// 폰트 설정
	private Font titleFont = new Font(Font.DIALOG, Font.BOLD, 20);
	private Font borderFont = new Font(Font.DIALOG, Font.ITALIC, 10);

	private JPanel mainPanel = new JPanel();
	private JLabel left = new JLabel();
	private JPanel centerPanel = new JPanel();
	private JLabel right = new JLabel();

	private JLabel top = new JLabel();
//	private TitledBorder Border = null;
	private JPanel center = new JPanel();
	private JLabel id = new JLabel("ID");
	private JTextField id_t = new JTextField();
	
	private JLabel password = new JLabel("PASSWORD");
	private JTextField password_t = new JTextField();
	
	private JButton signup = new JButton("SIGNUP");
	private JButton signin = new JButton("SIGNIN");
	
	
	public SignInFrame(memberDAO_interface inter) {

		this.setBounds(100, 100, 500, 150);
		this.add(mainPanel, "Center");

//		Border = new TitledBorder("회원 로그인");
//		Border.setTitleFont(borderFont);
//		Border.setTitleColor(Color.darkGray);
//		Border.setBorder(new LineBorder(Color.darkGray));
		centerPanel.setBorder(b.mainborder("회원 로그인"));
		
//		Border = new TitledBorder("가입");
//		signup.setBorder(Border);
		
		
		mainPanel.setLayout(new GridLayout());
		mainPanel.add(left);
		mainPanel.add(centerPanel);
		mainPanel.add(right);

		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(top, "North");
		centerPanel.add(center, "Center");
		
		center.setLayout(new GridLayout(3,3));
		center.add(id);
		center.add(id_t);
		center.add(password);
		center.add(password_t);
		center.add(signup);
		center.add(signin);
		

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
