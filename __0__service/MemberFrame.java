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

import __0__project_dao.certificateDAO_interface;
import __0__project_dao.counselDAO_interface;
import __0__project_dao.memberDAO_interface;
import __0__project_dto.certificateDTO;
import __0__project_dto.counselDTO;
import __0__project_dto.memberDTO;

public class MemberFrame extends JFrame implements ActionListener, ItemListener {
	private border type = new border();
	private memberDAO_interface memberInterface = null;
	private counselDAO_interface counselInterface = null;
	private certificateDAO_interface certificateInterface = null;
	private ArrayList<memberDTO> arrayMember = null;
	private ArrayList<counselDTO> arrayCounsel = null;
	private ArrayList<certificateDTO> arrayCerti = null;

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

	private JPanel main_c_main = new JPanel();

	private JPanel main_c_main_c = new JPanel();

	private JLabel main_c_1 = new JLabel("이름");
	private JLabel main_c_2 = new JLabel("아이디");
	private JLabel main_c_3 = new JLabel("비밀번호 수정");
	private JLabel main_c_4 = new JLabel("주민등록번호");

	private JLabel main_c_1_t = new JLabel();
	private JLabel main_c_2_t = new JLabel();
	private JPanel main_c_3_p = new JPanel();
	private JTextField main_c_3_text = new JTextField();
	private JButton main_c_3_btn = type.buttontype("저장");
	private JLabel main_c_4_t = new JLabel();

	private JPanel main_c_main_s = new JPanel();
	private JPanel main_c_main_s_w = new JPanel();
	private JPanel main_c_main_s_c = new JPanel();

	private JLabel main_c_5 = new JLabel("보유 자격증 정보");
	private JTextField main_c_5_select_1 = new JTextField();
	private JTextField main_c_5_select_2 = new JTextField();
//	private String ccList[] = { "test1", "test2", "test3", "test4" };
	private List main_c_5_list = new List();
	private List main_c_6_list = new List();
	private JPanel main_c_5_t = new JPanel();
	private JPanel main_c_6_t = new JPanel();

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
	private List main_e_b_list = new List();

	// main_east의 내부, 우측 아래

//	private TitledBorder eastBorder2 = new TitledBorder("상담 이력");

	public MemberFrame(memberDAO_interface m_inter, counselDAO_interface cou_inter,
			certificateDAO_interface cer_inter) {
		// 테두리 폰트, 색상 변경
//		main_c_5_list = new JList(ccList);
//		main_c_5_list.setVisibleRowCount(3);
//		main_c_5_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		main_c_5_list.setFixedCellWidth(100);

//		main_c_6_list = new JList(ccList);
//		main_c_6_list.setVisibleRowCount(3);
//		main_c_6_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		main_c_6_list.setFixedCellWidth(100);

//		main_c_5_t.add(new JScrollPane(main_c_5_list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
//		main_c_6_t.add(new JScrollPane(main_c_6_list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

		// centerBorder = new TitledBorder("개인 정보");
//		centerBorder.setTitleFont(borderFont);
//		centerBorder.setTitleColor(Color.darkGray);
//		centerBorder.setBorder(new LineBorder(Color.darkGray));

		// 객체 주소 주입
		this.memberInterface = m_inter;
		this.counselInterface = cou_inter;
		this.certificateInterface = cer_inter;

		// 창 크기 설정
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
		main_c_3_p.setLayout(new GridLayout());
		main_c_3_p.add(main_c_3_text);
		main_c_3_p.add(main_c_3_btn);

		// main에 추가한 main_center에 추가
		main_center.setLayout(new BorderLayout());
		main_center.add(main_c_main, "Center");
		main_center.add(main_c_7, "South");
		main_c_7.add(main_c_7_btn);

		// main_c_main(중앙) 추가.
		main_c_main.setLayout(new BorderLayout());
		main_c_main.add(main_c_main_c, "Center");
		main_c_main.add(main_c_main_s, "South");

		main_c_main_c.setLayout(new GridLayout(4, 2, 10, 10));
		main_c_main_c.setBorder(type.mainborder("개인 정보"));
		main_c_main_c.add(main_c_1);
		main_c_main_c.add(main_c_1_t);
		main_c_main_c.add(main_c_2);
		main_c_main_c.add(main_c_2_t);
		main_c_main_c.add(main_c_3);
		main_c_main_c.add(main_c_3_p);
		main_c_main_c.add(main_c_4);
		main_c_main_c.add(main_c_4_t);

		// 중앙 하단 >> 왼쪽 아래를 좌, 우로 구분
		main_c_main_s.setLayout(new BorderLayout());
		main_c_main_s.add(main_c_main_s_w, "West");
		main_c_main_s.add(main_c_main_s_c, "Center");

		// 중앙 하단, 왼쪽 아래, 좌
		main_c_main_s_w.setLayout(new BorderLayout());
		main_c_main_s_w.add(main_c_5, "North");
		main_c_main_s_w.add(main_c_5_select_1, "Center");
		main_c_main_s_w.add(main_c_5_select_2, "South");
		// 중앙 하단, 왼쪽 아래, 우
		main_c_main_s_c.setLayout(new BorderLayout());
		main_c_main_s_c.add(main_c_5_t, "Center");
		main_c_main_s_c.add(main_c_6_t, "East");
		
		main_c_5_t.add(main_c_5_list);
		main_c_6_t.add(main_c_6_list);
		
		
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
		main_c_7_btn.addActionListener(this);
		main_e_b_list.addItemListener(this);
		main_c_5_list.addItemListener(this);
		main_c_6_list.addItemListener(this);
		main_e_t_b_btn.addActionListener(this);

//		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		counsellistin();
		cerlistin();

	}

	// 리스트 목록 보기
	private void counsellistin() {
		arrayCounsel = counselInterface.allList();
		for (counselDTO c : arrayCounsel) {
			main_e_b_list.add(c.getName() + " : " + c.getInterest());
		}

	}

	private void cerlistin() {
		arrayCerti = certificateInterface.allList();
		for (certificateDTO cer : arrayCerti) {
			main_c_5_list.add(cer.getCer_name());
			main_c_6_list.add(cer.getCer_name());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 인터페이스를 구현할 메서드
		if (e.getSource() == main_c_3_btn) {
			String modId_num = main_c_1_t.getText() + main_c_2_t.getText();
			memberInterface.add();
		}
		
		// 종료 버튼 >> 누르면 화면 안보이고, 로그인 창 띄우기
		if(e.getSource() == main_c_7_btn) {
			this.setVisible(false);
			// 화면 안보일경우 종료되도록
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			SignInFrame sign= new SignInFrame(memberInterface);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == main_e_b_list) {
			int selectNum = main_e_b_list.getSelectedIndex();
			System.out.println(selectNum + "번이 선택 됨");

			// 1. 리스트에서 가져오기, 2. DB에서 가져오기 중에 1로 진행
			counselDTO cudto = arrayCounsel.get(selectNum);

			// 출력하게 하기

			NotiFrame n = new NotiFrame(memberInterface);
			System.out.println(cudto.getName() + ":" + cudto.getCs_date());

		}
		
		// 자격증 리스트에서 누르면 첫번째 text로 가게
		if (e.getSource() == main_c_5_list) {
			memberDTO mdto = new memberDTO();
			int cerNum_1 = main_c_5_list.getSelectedIndex();
			certificateDTO cerdto = arrayCerti.get(cerNum_1);
			main_c_5_select_1.setText(cerdto.getCer_name());
			// 누른 자격증 insert 하도록
			memberInterface.mod(mdto);			
			
			
		}
		// 자격증 리스트에서 누르면 두번째 text로 가게
		if (e.getSource() == main_c_6_list) {

			int cerNum_2 = main_c_6_list.getSelectedIndex();
			certificateDTO cerdto1 = arrayCerti.get(cerNum_2);
			main_c_5_select_2.setText(cerdto1.getCer_name());
		}

	}

}
