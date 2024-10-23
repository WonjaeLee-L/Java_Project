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

import __0__project_dao.certificateDAO;
import __0__project_dao.counselDAO;
import __0__project_dao.memberDAO;
import __0__project_dto.certificateDTO;
import __0__project_dto.counselDTO;
import __0__project_dto.memberDTO;

public class MemberFrame extends JFrame implements ActionListener, ItemListener {
	private border type = new border();
	private ArrayList<memberDTO> arrayMember = null;
	private ArrayList<counselDTO> arrayCounsel = null;
	private ArrayList<certificateDTO> arrayCerti = null;
	public memberDAO memberdao = memberDAO.getInstance();
	public counselDAO counseldao = counselDAO.getInstance();
	public certificateDAO certificatedao = certificateDAO.getInstance();
	private memberDTO memberdto = null;

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

	private JLabel main_c_1 = new JLabel("이름");
	private JLabel main_c_2 = new JLabel("아이디");
	private JLabel main_c_3 = new JLabel("비밀번호 수정");
	private JLabel main_c_4 = new JLabel("주민등록번호");
	private JPanel main_c_1_p = new JPanel();
	private JButton main_c_1_btn = type.buttontype("회원 탈퇴");
	private JLabel main_c_1_t = new JLabel();
	private JLabel main_c_2_t = new JLabel();
	private JPanel main_c_3_p = new JPanel();
	private JTextField main_c_3_text = new JTextField();
	private JButton main_c_3_btn = type.buttontype("저장");
	private JPanel main_c_4_p = new JPanel();

	private JButton main_c_4_btn = type.buttontype("보이기");
//	private JButton main_c_4_btn = new JButton();

	private JLabel main_c_4_t = new JLabel();

	private JPanel main_c_main_s = new JPanel();
	private JPanel main_c_main_s_w = new JPanel();
	private JPanel main_c_main_s_c = new JPanel();

	private JLabel main_c_5 = new JLabel("보유 자격증 정보");
	private JLabel main_c_5_1 = new JLabel();
	private JLabel main_c_5_2 = new JLabel();
	private JPanel main_c_5_select = new JPanel();
	private JTextField main_c_5_select_1 = new JTextField();
	private JTextField main_c_5_select_2 = new JTextField();
	private JPanel main_c_5_3 = new JPanel();
	private JLabel main_c_5_4 = new JLabel();
	private JButton main_c_5_select_btn = type.buttontype("저장");
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
//	private String id;
//	private String pwd;
	private int index;
	private String id_num;
	private String id_num_star;
	// main_east의 내부, 우측 아래

//	private TitledBorder eastBorder2 = new TitledBorder("상담 이력");

	public MemberFrame(memberDTO memberdto) {
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
		this.memberdto = memberdto;
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

		main_c_main_c.setLayout(new GridLayout(4, 2, 10, 10));
		main_c_main_c.setBorder(type.mainborder("개인 정보"));
		main_c_main_c.add(main_c_1);
		main_c_main_c.add(main_c_1_p);
		main_c_main_c.add(main_c_2);
		main_c_main_c.add(main_c_2_t);
		main_c_main_c.add(main_c_3);
		main_c_main_c.add(main_c_3_p);
		main_c_main_c.add(main_c_4);
		main_c_main_c.add(main_c_4_p);
		
		// 아이디 나오고, 탈퇴버튼
		main_c_1_p.setLayout(new GridLayout(1,2));
		main_c_1_p.add(main_c_1_t);
		main_c_1_p.add(main_c_1_btn);
		
		main_c_4_p.setLayout(new GridLayout());
		main_c_4_p.add(main_c_4_t);
		main_c_4_p.add(main_c_4_btn);
//		if(main_c_4_p)
		// 비밀번호 수정 칸
		main_c_3_p.setLayout(new GridLayout());
		main_c_3_p.add(main_c_3_text);
		main_c_3_p.add(main_c_3_btn);

		// 중앙 하단 >> 왼쪽 아래를 좌, 우로 구분
		main_c_main_s.setLayout(new BorderLayout());
		main_c_main_s.add(main_c_main_s_w, "West");
		main_c_main_s.add(main_c_main_s_c, "Center");

		// 중앙 하단, 왼쪽 아래, 좌
		main_c_main_s_w.setLayout(new GridLayout(3, 1));
		main_c_main_s_w.add(main_c_5);
		main_c_main_s_w.add(main_c_5_1);
		main_c_main_s_w.add(main_c_5_2);

		// 중앙 하단, 왼쪽 아래, 우
		main_c_main_s_c.setLayout(new GridLayout(1, 3));
		// 패널 추가 패널에 select 두개 넣기
		main_c_main_s_c.add(main_c_5_select);
		main_c_main_s_c.add(main_c_5_t);
		main_c_main_s_c.add(main_c_6_t);

		main_c_5_select.setLayout(new GridLayout(3, 1));
		main_c_5_select.add(main_c_5_select_1);
		main_c_5_select.add(main_c_5_select_2);
		main_c_5_select.add(main_c_5_3);
		main_c_5_t.add(main_c_5_list);
		main_c_6_t.add(main_c_6_list);

		main_c_5_3.setLayout(new GridLayout(1, 2));
		main_c_5_3.add(main_c_5_4);
		main_c_5_3.add(main_c_5_select_btn);

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
		main_c_1_btn.addActionListener(this);
		main_c_3_btn.addActionListener(this);
		main_c_5_select_btn.addActionListener(this);
		main_c_7_btn.addActionListener(this);
		main_e_b_list.addItemListener(this);
		main_c_5_list.addItemListener(this);
		main_c_6_list.addItemListener(this);
		main_e_t_b_btn.addActionListener(this);
		main_c_4_btn.addActionListener(this);
		main_c_4_btn.addItemListener(this);
//		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		memberInterface.allList();
		logInInfo();

		counsellistin();
		cerlistin();
		repaint();
//		mainF.revalidate();
//		mainF.paint(main_c_main_s_w.getGraphics());

	}

	// 로그인 정보 불러오기
	private void logInInfo() {
		main_c_1_t.setText(memberdto.getName());
		arrayMember = memberdao.allList();
//		main_c_2_t.setText(main_c_1_t.getText());
		for (int i = 0; i < arrayMember.size(); i++) {
			if (arrayMember.get(i).getName().equals(main_c_1_t.getText())) {
				memberdto.setId(arrayMember.get(i).getId());
				memberdto.setName(arrayMember.get(i).getName());
				memberdto.setId_num(arrayMember.get(i).getId_num());
				memberdto.setCer_name_1(arrayMember.get(i).getCer_name_1());
				memberdto.setCer_name_2(arrayMember.get(i).getCer_name_2());
				main_c_1_t.setText(memberdto.getName());
//				main_c_1_t.setText(arrayMember.get(i).getName());
				main_c_2_t.setText(memberdto.getId());
//				main_c_2_t.setText(arrayMember.get(i).getId());
				
				
//				main_c_4_t.setText(memberdto.getId_num());
//				main_c_4_t.setText(arrayMember.get(i).getId_num());				
//				id_num_star = arrayMember.get(i).getId_num().substring(0, 7).concat("******");
				main_c_4_t.setText(memberdto.getId_num().substring(0, 7).concat("******"));
				main_c_5_1.setText(memberdto.getCer_name_1());
				main_c_5_2.setText(memberdto.getCer_name_2());
				title.setText(main_c_1_t.getText() + "님 환영합니다.");
				index = i;
			}
		}
	}

	// 리스트 목록 보기
	private void counsellistin() {
		arrayCounsel = counseldao.allList();
		for (counselDTO c : arrayCounsel) {
			// 로그인 회원의 상담정보 출력
			if (c.getName().equals(memberdto.getName())) {
				String csdate = c.getCs_date();
				if (csdate == null) {
					main_e_b_list.add("미상담 건:" + c.getAy_date().substring(2, 10) + "일자로 신청 중");
				} else {
					main_e_b_list.add("상담 완료 :" + c.getName() + c.getCs_date().substring(2, 10) + "일자로 상담 완료");
				}
			}
		}
	}

	// 자격증 정보 리스트 (선택)
	private void cerlistin() {
		arrayCerti = certificatedao.allList();
		for (certificateDTO cer : arrayCerti) {
			main_c_5_list.add(cer.getCer_name());
			main_c_6_list.add(cer.getCer_name());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 비밀번호 수정
		if (e.getSource() == main_c_3_btn) {
			String modpwd = main_c_3_text.getText();
			String name = main_c_1_t.getText();
			if (modpwd.equals(memberdto.getPassword())) {
				NotiFrame n = new NotiFrame("동일한 비밀번호로 변경할 수 없습니다.");
			} else if (modpwd.isEmpty()) {
				NotiFrame n = new NotiFrame("수정할 비밀번호를 입력하세요.");
			} else {
				memberdao.modPwd(name, modpwd);
				new NotiFrame("비밀번호 변경 완료");
			}
		}

		// 종료 후 ,로그인 창 열기
		if (e.getSource() == main_c_7_btn) {
			this.setVisible(false);
			// 화면 안보일경우 종료
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			SignInFrame sign = new SignInFrame();
		}

		// 자격증 정보 저장
		if (e.getSource() == main_c_5_select_btn) {
			String select_1 = main_c_5_select_1.getText();
			String select_2 = main_c_5_select_2.getText();
			String name_1 = main_c_1_t.getText();

			memberdao.updateCerti(name_1, select_1, 1);
			memberdao.updateCerti(name_1, select_2, 2);
			new MemberFrame(memberdto);
		}

		if (e.getSource() == main_c_4_btn) {
//			String star = "*";
			if (main_c_4_t.getText().contains("*")) {
				new MemberFrame(memberdto);
				main_c_4_btn = type.buttontype("숨기기");
				main_c_4_t.setText(memberdto.getId_num());

			} else {
				new MemberFrame(memberdto);
				main_c_4_btn = type.buttontype("보이기");
				main_c_4_t.setText(id_num_star);

			}
		}

		// 신청 정보 저장
		if (e.getSource() == main_e_t_b_btn) {
			arrayCounsel = counseldao.allList();
			String text_inter = main_e_t_b_t2.getText();
			String text_date = main_e_t_b_t1.getText();
			for (counselDTO coudto : arrayCounsel) {
				if (coudto.getName().equals(main_c_1_t.getText())) {
					coudto.setInterest(text_inter);
					coudto.setAy_date(text_date);
					counseldao.add(coudto);
				}
			}

		}
		
		// 회원 탈퇴
		if(e.getSource() == main_c_1_btn) {
			// 로그인되어있는 사람만 탈퇴하므로
			memberdao.del(memberdto);
			this.setVisible(false);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			SignInFrame sign = new SignInFrame();
			
//			arrayMember = memberdao.allList();
//			for(memberDTO memdto : arrayMember) {
//				if(memdto.getId().equals(main_c_2_t.getText())) {
//					memberdao.del(memdto);
//					this.setVisible(false);
//					// 화면 안보일경우 종료
//					this.setDefaultCloseOperation(HIDE_ON_CLOSE);
//					SignInFrame sign = new SignInFrame();
//				}
//			}
		}
		
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 로그인 한 사람의 상담 리스트 클릭 이벤트 >> 상세 정보(미상담건과 분리해서 표기)
		if (e.getSource() == main_e_b_list) {
			int selectNum = main_e_b_list.getSelectedIndex();
			counselDTO cudto = arrayCounsel.get(selectNum);
			CouncelInfoFrame clistinfo = new CouncelInfoFrame(cudto);
		}

		// 자격증 리스트에서 누르면 첫번째 text에 출력
		if (e.getSource() == main_c_5_list) {
			int cerNum_1 = main_c_5_list.getSelectedIndex();
			certificateDTO cerdto = arrayCerti.get(cerNum_1);
			main_c_5_select_1.setText(cerdto.getCer_name());

		}
		// 자격증 리스트에서 누르면 두번째 text에 출력
		if (e.getSource() == main_c_6_list) {
			int cerNum_1 = main_c_6_list.getSelectedIndex();
			certificateDTO cerdto = arrayCerti.get(cerNum_1);
			main_c_5_select_2.setText(cerdto.getCer_name());

		}

	}

}