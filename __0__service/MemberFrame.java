package __0__service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import __0__project_dao.memberDAO_interface;
import __0__project_dto.memberDTO;

public class MemberFrame extends JFrame implements ActionListener, ItemListener {
	border type = new border();
	memberDAO_interface memberInterface = null;

	// 폰트 설정
	private Font titleFont = new Font(Font.DIALOG, Font.BOLD, 20);
//	private Font borderFont = new Font(Font.DIALOG, Font.ITALIC, 10);

	// 가장 상위 변수
	private JPanel mainF = new JPanel(); // 컴포넌트&컨테이너.
	private JLabel title = new JLabel("회원 정보");
	private JPanel main = new JPanel();
	private JPanel main_center = new JPanel();
	private JPanel main_east = new JPanel();

	// main_center 변수
//	private TitledBorder centerBorder = null;

//	private JButton main_c_btn = new JButton("저장");
	private JPanel main_c_main = new JPanel();
	private JLabel main_c_1 = new JLabel("이름");
	private JLabel main_c_2 = new JLabel("아이디");
//	private JPanel main_c_3 = new JPanel();
	private JLabel main_c_3_l = new JLabel("비밀번호 수정");
	private JButton main_c_3_btn = type.buttontype("저장");
	private JLabel main_c_4 = new JLabel("주민등록번호");
	private JLabel main_c_5 = new JLabel("시험 점수");
	private JLabel main_c_6 = new JLabel("태도 점수");
	private JLabel main_c_1_t = new JLabel();
	private JLabel main_c_2_t = new JLabel();
	private JPanel main_c_3_t = new JPanel();
	private JTextField main_c_3_t1 = new JTextField();
//	private JTextField main_c_3_t2 = new JTextField();
	private JLabel main_c_4_t = new JLabel();
	private JLabel main_c_5_t = new JLabel();
	private JLabel main_c_6_t = new JLabel();
	private JPanel main_c_7 = new JPanel();
	private JButton main_c_7_btn = type.buttontype("종료");
	// main_east 변수
	private JPanel main_e_t = new JPanel();
	private JPanel main_e_b = new JPanel();
	// main_e_t의 내부, 우측 위

//	private TitledBorder eastBorder = new TitledBorder("상담 신청");

	private JPanel main_e_t_b = new JPanel();
	// main_e_t_b
	private JLabel main_e_t_b_1 = new JLabel("날짜 입력");
	private JLabel main_e_t_b_2 = new JLabel("관심 직무 입력");
	private JTextField main_e_t_b_t1 = new JTextField();
	private JTextField main_e_t_b_t2 = new JTextField();
	private JLabel main_e_t_b_3 = new JLabel();
//	private JButton main_e_t_b_btn = new JButton("신청");
	private JButton main_e_t_b_btn = type.buttontype("신청");

	// main_east의 내부, 우측 아래

//	private TitledBorder eastBorder2 = new TitledBorder("상담 이력");

	private List main_e_b_list = new List();

	ArrayList<memberDTO> w = null;

	public MemberFrame(memberDAO_interface inter) {
		// 테두리 폰트, 색상 변경

//		centerBorder = new TitledBorder("개인 정보");
//		centerBorder.setTitleFont(borderFont);
//		centerBorder.setTitleColor(Color.darkGray);
//		centerBorder.setBorder(new LineBorder(Color.darkGray));

		this.memberInterface = inter; // DB 작업을 위한 객체 주소를 외부(Main class)로부터 주입 받는다.
		this.setBounds(100, 100, 700, 400);
		title.setFont(titleFont);
		mainF.add(title);

		// 테두리 설정
		main_center.setBorder(new LineBorder(Color.white, 2));
		main_east.setBorder(new LineBorder(Color.white, 2));
		main_e_t.setBorder(new LineBorder(Color.white, 2));
		main_e_b.setBorder(new LineBorder(Color.white, 2));

		this.add(mainF, "North");
		this.add(main, "Center");

		// main에 main_center, main_east 추가. (가장 상위)
		main.setLayout(new BorderLayout());
		main.add(main_center, "Center");
		main.add(main_east, "East");

		// 비밀번호 수정 칸
		main_c_3_t.setLayout(new GridLayout());
		main_c_3_t.add(main_c_3_t1);
		main_c_3_t.add(main_c_3_btn);

		// main에 추가한 main_center에 추가
		main_center.setLayout(new BorderLayout());
		main_center.add(main_c_main, "Center");
		main_center.add(main_c_7, "South");
		main_c_7.add(main_c_7_btn);

		// main_c_main(중앙) 추가.
		main_c_main.setLayout(new GridLayout(6, 2, 10, 10));
		main_c_main.setBorder(type.mainborder("개인 정보"));
		main_c_main.add(main_c_1);
		main_c_main.add(main_c_1_t);
		main_c_main.add(main_c_2);
		main_c_main.add(main_c_2_t);
		main_c_main.add(main_c_3_l);
		main_c_main.add(main_c_3_t);
		main_c_main.add(main_c_4);
		main_c_main.add(main_c_4_t);
		main_c_main.add(main_c_5);
		main_c_main.add(main_c_5_t);
		main_c_main.add(main_c_6);
		main_c_main.add(main_c_6_t);
		// main_east에 추가
		main_east.setLayout(new BorderLayout());
		main_east.add(main_e_t, "North");
		main_east.add(main_e_b, "Center");

		// main_east 상단부 main_e_t 작업
//		centerBorder = new TitledBorder("상담 신청");
		main_e_t.setBorder(type.mainborder("상담 신청"));
		main_e_t.setLayout(new BorderLayout());
		main_e_t.add(main_e_t_b, "Center");

		// main_e_t_b 내부 작업
		main_e_t_b.setLayout(new GridLayout(3, 3, 10, 10));
		main_e_t_b.add(main_e_t_b_1);
		main_e_t_b.add(main_e_t_b_t1);
		main_e_t_b.add(main_e_t_b_2);
		main_e_t_b.add(main_e_t_b_t2);
		main_e_t_b.add(main_e_t_b_3);
		main_e_t_b.add(main_e_t_b_btn);

		// main_east 하단부 main_e_b 작업
//		centerBorder = new TitledBorder("상담 이력");
		main_e_b.setBorder(type.mainborder("상담 이력"));
		main_e_b.setLayout(new BorderLayout());
		main_e_b.add(main_e_b_list, "Center");

		// 이벤트 감지를 위한 이벤트 등록
		main_c_3_btn.addActionListener(this);
		main_e_b_list.addItemListener(this);
		main_e_t_b_btn.addActionListener(this);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		listin();
	}

	// 리스트 목록 보기
	private void listin() {
		w = memberInterface.allList();
		for (memberDTO t : w) {
			main_e_b_list.add(t.getName() + " : " + t.getId_num());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 인터페이스를 구현할 메서드
		if (e.getSource() == main_c_3_btn) {
			String modId_num = main_c_1_t.getText() + main_c_2_t.getText();
			memberInterface.add();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int selectNum = main_e_b_list.getSelectedIndex();
		System.out.println(selectNum + "번이 선택 됨");

		// 1. 리스트에서 가져오기, 2. DB에서 가져오기 중에 1로 진행
		memberDTO mdto = w.get(selectNum);
//		j5.setText(tempdto.getEng());
//		j6.setText(tempdto.getKor());

	}
	
//	public void 

}
