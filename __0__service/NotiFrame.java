package __0__service;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import __0__project_dao.memberDAO_interface;

public class NotiFrame extends JFrame {
	
	
	border type = new border();
	private JPanel mainPanel = new JPanel();
	private JLabel noti = new JLabel("중복!");

	public NotiFrame(memberDAO_interface inter) {
		this.setBounds(300, 200, 100, 100);
		this.add(mainPanel, "Center");
		mainPanel.setBorder(type.noti("경고"));
		mainPanel.add(noti);
		
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
