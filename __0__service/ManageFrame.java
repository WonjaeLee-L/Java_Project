package __0__service;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import __0__project_dao.memberDAO_interface;
import __0__project_dto.memberDTO;

public class ManageFrame extends JFrame implements ActionListener, ItemListener {

	border type = new border();
	memberDAO_interface memberInterface = null;

	// 폰트 설정
	private Font titleFont = new Font(Font.DIALOG, Font.BOLD, 20);

	private JPanel mainF = new JPanel(); // 컴포넌트&컨테이너.
	private JLabel title = new JLabel("회원 관리");
	private JPanel main = new JPanel();
	private JPanel main_center = new JPanel();
	private JPanel main_west = new JPanel();

	// west
	private List namelist = new List();
	private JButton cancel = new JButton();

	// center
	private List oneperson = new List();
	// k = String.valueOf(data);
	// k+=(char)data

	ArrayList<memberDTO> w = null;

	public ManageFrame(memberDAO_interface inter) {

		this.memberInterface = inter;
		this.setBounds(200, 300, 700, 400);
		title.setFont(titleFont);
		mainF.add(title);
		main_center.setBorder(new LineBorder(Color.white, 2));
		main_west.setBorder(new LineBorder(Color.white, 2));

		this.add(mainF, "North");
		this.add(main, "Center");

		main.add(main_west, "West");
		main.add(main_center, "Center");

		// West에 목록만 목록 아래 페이지 종료
		main_west.add(namelist, "Center");
		cancel = type.buttontype("종료");
		main_west.add(cancel, "South");

		// Center에 6,2
		// 맨아래 왼쪽은 빈공간
		main_center.add(oneperson, "Center");

		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
