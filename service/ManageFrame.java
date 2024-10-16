package service;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao_inf.DBdao;

public class ManageFrame extends JFrame{
	DBdao dbdao = null;
	
	private JPanel mainPanel = new JPanel();
	private JLabel left = new JLabel();
	private JPanel centerPanel = new JPanel();
	private JLabel right = new JLabel();
	
	private JLabel top = new JLabel();
	private JPanel center = new JPanel();
	
	
	public ManageFrame() {
		this.setBounds(100,100,500,300);
		this.add(mainPanel, "Center");
		
		mainPanel.setLayout(new GridLayout());
		mainPanel.add(left);
		mainPanel.add(centerPanel);
		mainPanel.add(right);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(top,"North");
		centerPanel.add(center, "Center");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
