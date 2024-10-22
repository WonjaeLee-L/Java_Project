package __0__service;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class border {

	private TitledBorder Border = null;
	private Font borderFont = new Font(Font.DIALOG, Font.ITALIC, 10);
	private JButton button = null;

	public border() {

	}

	public TitledBorder mainborder(String name) {
		Border = new TitledBorder(name);
		Border.setTitleFont(borderFont);
		Border.setTitleColor(Color.darkGray);
		Border.setBorder(new LineBorder(Color.darkGray));
		return Border;
	}

	public TitledBorder noti(String name) {
		Border = new TitledBorder(name);
		Border.setTitleFont(borderFont);
		Border.setTitleColor(Color.red);
		Border.setBorder(new LineBorder(Color.red));
		return Border;
	}

	public TitledBorder counsellistinfo(String name) {
		Border = new TitledBorder(name);
		Border.setTitlePosition(TitledBorder.ABOVE_TOP);
		Border.setTitleFont(borderFont);
		Border.setTitleColor(Color.darkGray);
		Border.setBorder(new LineBorder(Color.darkGray));
		return Border;
	}

	public TitledBorder password(String name) {
		Border = new TitledBorder(name);
		Border.setTitlePosition(TitledBorder.ABOVE_TOP);
		Border.setTitleFont(borderFont);
		Border.setTitleColor(Color.red);
		Border.setBorder(new LineBorder(Color.red));
		return Border;
	}

	public TitledBorder warning(String name) {
		Border = new TitledBorder(name);
		Border.setTitlePosition(TitledBorder.ABOVE_BOTTOM);
		Border.setTitleFont(borderFont);
		Border.setTitleColor(Color.red);
		Border.setBorder(new LineBorder(Color.red));
		return Border;
	}

	public JButton buttontype(String name) {
		button = new JButton(name);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		return button;

	}
}
