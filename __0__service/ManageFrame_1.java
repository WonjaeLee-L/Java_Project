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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import __0__project_dao.certificateDAO_interface;
import __0__project_dao.counselDAO_interface;
import __0__project_dao.memberDAO;
import __0__project_dao.memberDAO_interface;
import __0__project_dto.certificateDTO;
import __0__project_dto.counselDTO;
import __0__project_dto.memberDTO;

public class ManageFrame_1 extends JFrame implements ActionListener, ItemListener {
	private border type = new border();
	private memberDAO_interface memberInterface = null;
	private counselDAO_interface counselInterface = null;
	private certificateDAO_interface certificateInterface = null;
	private ArrayList<memberDTO> arrayMember = null;
	private ArrayList<counselDTO> arrayCounsel = null;
	private ArrayList<certificateDTO> arrayCerti = null;
	private memberDAO memberdao = new memberDAO();
//
	// 폰트 설정
	private Font titleFont = new Font(Font.DIALOG, Font.BOLD, 20);
//	private Font borderFont = new Font(Font.DIALOG, Font.ITALIC, 10);

	// 가장 상위 변수
	private JPanel mainF = new JPanel(); // 컴포넌트&컨테이너.
	private JLabel title = new JLabel();
	private JPanel main = new JPanel();
	private JPanel main_center = new JPanel();
	private JPanel main_east = new JPanel();

	// main_center 변수
//	private TitledBorder centerBorder = null;

	private JPanel main_c_main = new JPanel();
	private JPanel main_c_main_c = new JPanel();
	private JPanel main_c_p = new JPanel();

	private List main_c_list = new List();
	private JButton main_c_p_btn = type.buttontype("영구 탈퇴");
	private JButton main_c_p_btn2 = type.buttontype("버튼2");
	private JButton main_c_p_btn3 = type.buttontype("버튼3");
	private JButton main_e_b_list_btn = type.buttontype("수락");

	private JLabel main_c_4_t = new JLabel();

	private JPanel main_c_main_s = new JPanel();
	private JPanel main_c_main_s_w = new JPanel();
	private JPanel main_c_main_s_c = new JPanel();

	private JLabel main_c_5 = new JLabel("이름");
	private JLabel main_c_5_1 = new JLabel("분야");
	private JLabel main_c_5_2 = new JLabel("회사");

	private JTextField main_c_5_select_1 = new JTextField();
	private JTextField main_c_5_select_2 = new JTextField();

	private JButton main_c_5_select_btn = type.buttontype("신청");
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

	private JPanel main_e_t_b = new JPanel();
	// main_e_t_b
	private JLabel main_e_t_b_1 = new JLabel("시험 점수");
	private JLabel main_e_t_b_2 = new JLabel("태도 점수");
	private JTextField main_e_t_b_t1 = new JTextField();
	private JTextField main_e_t_b_t2 = new JTextField();
	private JLabel main_e_t_b_3 = new JLabel();
	private JButton main_e_t_b_btn = type.buttontype("입력");
	private List main_e_b_list = new List();
	private String id;
	private String pwd;
	private int index;
	private String id_num;
	private String id_num_star;

	private String ccList[][] = { {"test1,1"}, {"test2,2"}, {"test3,3"}, {"test4,4"} };
	private JComboBox main_c_e_companyList = new JComboBox(ccList);


	public ManageFrame_1(memberDAO_interface m_inter, counselDAO_interface cou_inter,
			certificateDAO_interface cer_inter, SignInFrame signinframe, String id, String pwd,
			ArrayList<memberDTO> arrayMember, memberDAO meberdao) {

		// 객체 주소 주입
		this.id = id;
		this.pwd = pwd;
		this.memberInterface = m_inter;
		this.counselInterface = cou_inter;
		this.certificateInterface = cer_inter;
		this.arrayMember = arrayMember;
//		this.memberdao = memberdao;
		// 창 크기 설정
		this.setBounds(200, 300, 1000, 400);

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

		// main에 추가한 main_center에 추가
		main_center.setLayout(new BorderLayout());
		main_center.add(main_c_main, "Center");
		main_center.add(main_c_7, "South");
		main_c_7.add(main_c_7_btn);

		// main_c_main(중앙) 추가.
		main_c_main.setLayout(new BorderLayout());
		main_c_main.add(main_c_main_c, "Center");
		main_c_main.add(main_c_main_s, "South");

		// *****************************************************************************
		// main_c_main에 리스트 크게 만들자

		main_c_main_c.setBorder(type.mainborder("회원 정보"));
		main_c_main_c.setLayout(new BorderLayout());
		main_c_main_c.add(main_c_list, "Center");
		main_c_main_c.add(main_c_p, "East");

		main_c_p.setLayout(new GridLayout(3, 1));
		main_c_p.add(main_c_p_btn);
		main_c_p.add(main_c_p_btn2);

		main_c_p.add(main_c_e_companyList);

		// 중앙 하단 >> 왼쪽 아래를 좌, 우로 구분
		main_c_main_s.setLayout(new GridLayout());
		main_c_main_s.add(main_c_main_s_w);

		main_c_main_s.add(main_c_main_s_c);


		// 중앙 하단, 왼쪽 아래, 좌
		main_c_main_s_w.setLayout(new GridLayout(3, 2));
		main_c_main_s_w.add(main_c_5);// 이름
		main_c_main_s_w.add(main_c_5_select_1);// 이름

		main_c_main_s_w.add(main_c_5_1);// 분야
		main_c_main_s_w.add(main_c_5_select_2);// 분야

		main_c_main_s_w.add(main_c_5_2);// 회사
		main_c_main_s_w.add(main_c_5_select_btn);// 회사

		// 중앙 하단, 왼쪽 아래, 우
		main_c_main_s_c.setLayout(new GridLayout(1, 2));
		// 패널 추가 패널에 select 두개 넣기
		main_c_main_s_c.add(main_c_5_t);// 정사각
		main_c_main_s_c.add(main_c_6_t);// 정사각
		main_c_5_t.add(main_c_5_list);
		main_c_6_t.add(main_c_6_list);

		// main_east에 추가
		main_east.setLayout(new BorderLayout());
		main_east.add(main_e_t, "North");
		main_east.add(main_e_b, "Center");

		// main_east 상단부 main_e_t 작업

		main_e_t.setBorder(type.mainborder("평가"));
		main_e_t.setLayout(new BorderLayout());
		main_e_t.add(main_e_t_b, "Center");

		// main_e_t_b 내부 작업
		main_e_t_b.setLayout(new GridLayout(3, 3, 10, 10));
		main_e_t_b.add(main_e_t_b_1);// 시험
		main_e_t_b.add(main_e_t_b_t1);// 태도
		main_e_t_b.add(main_e_t_b_2);
		main_e_t_b.add(main_e_t_b_t2);
		main_e_t_b.add(main_e_t_b_3);// 빈라벨
		main_e_t_b.add(main_e_t_b_btn);// 입력 버틍

		// main_east 하단부 main_e_b 작업
		main_e_b.setBorder(type.mainborder("상담 신청"));
		main_e_b.setLayout(new BorderLayout());
		main_e_b.add(main_e_b_list, "Center");
		main_e_b.add(main_e_b_list_btn, "South");

		// ******************************************
		// 이벤트 감지를 위한 이벤트 등록
		main_c_list.addItemListener(this);
		main_c_p_btn.addActionListener(this);
		
		main_c_5_select_btn.addActionListener(this);
		main_c_7_btn.addActionListener(this);
		main_e_b_list.addItemListener(this);
		main_c_5_list.addItemListener(this);
		main_c_6_list.addItemListener(this);
		main_e_t_b_btn.addActionListener(this);
		
		
		

//		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		memberInterface.allList();
//		logInInfo();
		allList();
		counsellistin();
		cerlistin();
		repaint();
//		mainF.revalidate();
//		mainF.paint(main_c_main_s_w.getGraphics());

	}

	private void allList() {
		arrayMember = memberInterface.allList();
		arrayCounsel = counselInterface.allList();
		for (memberDTO d : arrayMember) {
			// 로그인 회원의 정보 출력
			for (counselDTO c : arrayCounsel) {
				if (d.getName().equals(c.getName())) {
					main_c_list.add(d.getName() + d.getId() + d.getId_num().substring(0, 8).concat("*")
							+ d.getCer_name_1() + d.getCer_name_2() + c.getInterest() + c.getScore() + c.getAttitude());
				} else {
					main_c_list.add(d.getName() + d.getId() + d.getId_num().substring(0, 8).concat("*")
							+ d.getCer_name_1() + d.getCer_name_2());
				}
				break;

			}

		}
	}

	// 로그인 정보 불러오기
//	private void logInInfo() {
//		main_c_2_t.setText(id);
//		for (int i = 0; i < arrayMember.size(); i++) {
//			if (arrayMember.get(i).getId().equals(id)) {
//				main_c_1_t.setText(arrayMember.get(i).getName());
//				id_num = arrayMember.get(i).getId_num();
//				id_num_star = id_num.substring(0, 7).concat("******");
//				main_c_4_t.setText(id_num_star);
//				main_c_5_1.setText(arrayMember.get(i).getCer_name_1());
//				main_c_5_2.setText(arrayMember.get(i).getCer_name_2());
//				title.setText(main_c_1_t.getText() + "님 환영합니다.");
//				index = i;
//			}
//		}
//	}

	// 리스트 목록 보기
	private void counsellistin() {
		arrayCounsel = counselInterface.allList();
		for (counselDTO c : arrayCounsel) {
			// 회원의 상담정보 출력
			String csdate = c.getCs_date();
			if (csdate == null) {
				main_e_b_list.add(c.getName() + "님의 상담 신청. " + c.getAy_date().substring(2, 10) + "일자로 신청 중");
			}
		}
	}

	// 자격증 정보 리스트 (선택)
	private void cerlistin() {
		arrayCerti = certificateInterface.allList();
		for (certificateDTO cer : arrayCerti) {
			main_c_5_list.add(cer.getCer_name());
			main_c_6_list.add(cer.getCer_name());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 종료 후 ,로그인 창 열기000000000000
		if (e.getSource() == main_c_7_btn) {
			this.setVisible(false);
			// 화면 안보일경우 종료
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			SignInFrame sign = new SignInFrame(memberInterface, memberdao, counselInterface, certificateInterface);
		}

		
		// 회원 탈퇴
		if(e.getSource() == main_c_p_btn) {
			for(memberDTO memdto : arrayMember) {
				if(memdto.getName().equals(main_c_5_select_1.getText())) {
					memberInterface.del(memdto);
					NotiFrame noti = new NotiFrame("영구 탈퇴");
					
					
					

//					this.setVisible(false);
					// 화면 안보일경우 종료
//					this.setDefaultCloseOperation(HIDE_ON_CLOSE);
//					SignInFrame sign = new SignInFrame(memberInterface, memberdao, counselInterface, certificateInterface);
				}
			}
		}
		
		
		
		
		
//		// 비밀번호 수정
//		if (e.getSource() == main_c_3_btn) {
//			String modpwd = main_c_3_text.getText();
//			String name = main_c_1_t.getText();
//			if (modpwd.equals(pwd)) {
//				NotiFrame n = new NotiFrame("동일한 비밀번호로 변경할 수 없습니다.");
//			} else if (modpwd.isEmpty()) {
//				NotiFrame n = new NotiFrame("수정할 비밀번호를 입력하세요.");
//			} else {
//				memberdao.modPwd(name, modpwd);
//				new NotiFrame("비밀번호 변경 완료");
//			}
//		}

//		// 자격증 정보 저장
//		if (e.getSource() == main_c_5_select_btn) {
//			String select_1 = main_c_5_select_1.getText();
//			String select_2 = main_c_5_select_2.getText();
//			String name_1 = main_c_1_t.getText();
//
//			memberdao.updateCerti(name_1, select_1, 1);
//			memberdao.updateCerti(name_1, select_2, 2);

//			repaint();

//		}

//		 버튼 변경 수정*****************한번실행되고 끝/
		//
		//
		//
		//

//		if (e.getSource() == main_c_4_btn) {
//			String text = main_c_4_t.getText();
//			String star = "*";
//			if (text.contains(star)) {
//				main_c_4_btn = type.buttontype("숨기기");
//				main_c_4_t.setText(id_num);
//				System.out.println("출력");
////				repaint();
//			} else {
//				main_c_4_btn = type.buttontype("보이기");
//				main_c_4_t.setText(id_num_star);
//				System.out.println("nn");
////				repaint();
//			}
//		}
//
//		// 신청 정보 저장
//		if (e.getSource() == main_e_t_b_btn) {
//			arrayCounsel = counselInterface.allList();
//			String text_inter = main_e_t_b_t2.getText();
//			String text_date = main_e_t_b_t1.getText();
//			for (counselDTO coudto : arrayCounsel) {
//				if (coudto.getName().equals(main_c_1_t.getText())) {
//					coudto.setInterest(text_inter);
//					coudto.setAy_date(text_date);
//					counselInterface.add(coudto);
//				}
//			}
//
//		}
//		


	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 리스트 클릭 하면, main_c_5_select_1으로

		if (e.getSource() == main_c_list) {
			int selectNum = main_c_list.getSelectedIndex();
			memberDTO mdto = arrayMember.get(selectNum);
			main_c_5_select_1.setText(mdto.getName());

		}

		// 추천 분야 메서드 a,b,c

		if (e.getSource() == main_e_b_list) {
			int selectNum = main_e_b_list.getSelectedIndex();
			counselDTO cudto = arrayCounsel.get(selectNum);
			CouncelInfoFrame clistinfo = new CouncelInfoFrame(cudto);
		}

		// 자격증 리스트에서 누르면 첫번째 text에 출력
		if (e.getSource() == main_c_5_list) {
			memberDTO mdto = new memberDTO();
			int cerNum_1 = main_c_5_list.getSelectedIndex();
			certificateDTO cerdto = arrayCerti.get(cerNum_1);
			main_c_5_select_1.setText(cerdto.getCer_name());

		}
		// 자격증 리스트에서 누르면 두번째 text에 출력
		if (e.getSource() == main_c_6_list) {
			memberDTO mdto = new memberDTO();
			int cerNum_1 = main_c_6_list.getSelectedIndex();
			certificateDTO cerdto = arrayCerti.get(cerNum_1);
			main_c_5_select_2.setText(cerdto.getCer_name());

		}

	}

}
