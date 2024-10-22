package __0__service;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import __0__project_dto.counselDTO;

public class CouncelInfoFrame extends JFrame {
	//
	
	border type = new border();
	private JPanel mainPanel = new JPanel();
	private JLabel name = new JLabel();
	private JLabel interest = new JLabel();
	private JLabel ay_date = new JLabel();
	private JLabel memo = new JLabel();
	private JLabel recommend = new JLabel();
	private JLabel cs_date = new JLabel();
	private JLabel score = new JLabel();
	private JLabel attitude = new JLabel();

	public CouncelInfoFrame(counselDTO cudto) {
		this.setBounds(1000, 300, 100, 100);
		this.add(mainPanel, "Center");
		mainPanel.setBorder(type.mainborder("상세 정보"));
		name.setText(cudto.getName());
		name.setBorder(type.counsellistinfo("이름"));
		interest.setText(cudto.getInterest());
		interest.setBorder(type.counsellistinfo("관심 분야"));
		ay_date.setText(cudto.getAy_date());
		ay_date.setBorder(type.counsellistinfo("신청 일자"));
		
		if(cudto.getCs_date() == null) {
			memo.setBorder(type.warning("상담사 입력"));
		}else if(cudto.getCs_date() != null) {
			memo.setText(cudto.getMemo());
			memo.setBorder(type.counsellistinfo("상담 내용"));
		}
		
		if(cudto.getCs_date() == null) {
			recommend.setBorder(type.warning("상담사 입력"));
		}else if(cudto.getCs_date() != null) {
			recommend.setText(cudto.getRecommend());
			recommend.setBorder(type.counsellistinfo("추천 분야"));
		}
		
		if(cudto.getCs_date() == null) {
			cs_date.setBorder(type.warning("상담사 입력"));
		}else if(cudto.getCs_date() != null) {
			cs_date.setText(cudto.getCs_date());
			cs_date.setBorder(type.counsellistinfo("상담 일자"));
		}
		
		if(cudto.getCs_date() == null) {
			score.setBorder(type.warning("상담사 입력"));
		}else if(cudto.getCs_date() != null) {
			score.setText(Integer.toString(cudto.getScore()));
			score.setBorder(type.counsellistinfo("시험 점수"));
		}
		
		if(cudto.getCs_date() == null) {
			attitude.setBorder(type.warning("상담사 입력"));
		}else if(cudto.getCs_date() != null) {
			attitude.setText(Integer.toString(cudto.getAttitude()));
			attitude.setBorder(type.counsellistinfo("태도 점수"));
		}
		
		mainPanel.setLayout(new GridLayout(8,1));
		mainPanel.add(name);
		mainPanel.add(interest);
		mainPanel.add(ay_date);
		mainPanel.add(memo);
		mainPanel.add(recommend);
		mainPanel.add(cs_date);
		mainPanel.add(score);
		mainPanel.add(attitude);

		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	public void c_info(counselDTO cudto) {
		
		
	}

}
