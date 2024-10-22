package __0__service;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import __0__project_dao.memberDAO_interface;

public class NotiFrame extends JFrame {

	border type = new border();
	private JPanel mainPanel = new JPanel();
	private JLabel noti = new JLabel();

	public NotiFrame(String text) {
		this.setBounds(400, 300, 100, 100);
		this.add(mainPanel, "Center");
		mainPanel.setBorder(type.noti("알림"));
		noti.setText(text);
		mainPanel.add(noti);

		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

}
