package __0__service;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class border {

	private TitledBorder Border = null;
	private Font borderFont = new Font(Font.DIALOG, Font.ITALIC, 10);
	
	public border() {
		
		
	}
	
	public TitledBorder mainborder(String memo) {
		Border = new TitledBorder(memo);
		Border.setTitleFont(borderFont);
		Border.setTitleColor(Color.darkGray);
		Border.setBorder(new LineBorder(Color.darkGray));
		return Border;
	}
}
