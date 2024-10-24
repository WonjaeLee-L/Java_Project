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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import __0__project_dao.blockedDAO;
import __0__project_dao.certificateDAO;
import __0__project_dao.companyDAO;
import __0__project_dao.counselDAO;
import __0__project_dao.memberDAO;
import __0__project_dto.certificateDTO;
import __0__project_dto.companyDTO;
import __0__project_dto.counselDTO;
import __0__project_dto.memberDTO;

public class ManageFrame_1 extends JFrame implements ActionListener, ItemListener {
	private border type = new border();

	private ArrayList<memberDTO> arrayMember = new ArrayList<>();
	private ArrayList<counselDTO> arrayCounsel = new ArrayList<>();
	private ArrayList<certificateDTO> arrayCertificate = null;
	private ArrayList<companyDTO> arrayCompany = null;
	private memberDAO memberdao = memberDAO.getInstance();
	public counselDAO counseldao = counselDAO.getInstance();
	public blockedDAO blockeddao = blockedDAO.getInstance();
	public certificateDAO certificatedao = certificateDAO.getInstance();
	public companyDAO companydao = companyDAO.getInstance();
	public memberDTO memberdto = null;
	public counselDTO counseldto = new counselDTO();

	// 폰트 설정
	private Font titleFont = new Font(Font.DIALOG, Font.BOLD, 20);

	// 가장 상위 변수
	private JPanel mainF = new JPanel(); // 컴포넌트&컨테이너.
	private JLabel title = new JLabel();
	private JPanel main = new JPanel();
	private JPanel main_center = new JPanel();
	private JPanel main_east = new JPanel();

	// main_center 변수
	private JPanel main_c_main = new JPanel();
	private JPanel main_c_main_c = new JPanel();

	private List main_c_list = new List();
	private JButton main_c_p_btn = type.buttontype("영구 탈퇴");
	private JPanel main_c_main_s = new JPanel();
	private JPanel main_c_main_s_w = new JPanel();
	private JPanel main_c_main_s_c = new JPanel();

	private JLabel main_c_5 = new JLabel("추천 회사");
	private JLabel main_c_5_1 = new JLabel();
	private JLabel main_c_5_2 = new JLabel();

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
	private JButton main_e_t_b_btn = type.buttontype("입력");
	private List main_e_b_list = new List();

	private JComboBox main_e_t_b_3 = new JComboBox();;
	String csdate = null;
	String push_company = null;

	public ManageFrame_1(memberDTO memberdto) {

		// 객체 주소 주입
		this.memberdto = memberdto;
		arrayMember = memberdao.allList();
		arrayCounsel = counseldao.allList();
		arrayCompany = companydao.allList();
		// 창 크기 설정
		this.setBounds(200, 300, 1000, 400);
		title.setText("관리자님 환영합니다.");
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
		main_c_7.add(main_c_p_btn);
		main_c_7.add(main_c_7_btn);

		// main_c_main(중앙) 추가.
		main_c_main.setLayout(new BorderLayout());
		main_c_main.add(main_c_main_c, "Center");
		main_c_main.add(main_c_main_s, "South");

		main_c_main_c.setBorder(type.mainborder("회원 정보"));
		main_c_main_c.setLayout(new BorderLayout());
		main_c_main_c.add(main_c_list, "Center");

		// 중앙 하단 >> 왼쪽 아래를 좌, 우로 구분
		main_c_main_s.setLayout(new GridLayout());
		main_c_main_s.add(main_c_main_s_w);

		main_c_main_s.add(main_c_main_s_c);

		// 중앙 하단, 왼쪽 아래, 좌
		main_c_main_s_w.setLayout(new GridLayout(3, 2));
		main_c_main_s_w.add(main_c_5);// 회사
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
		main_e_t_b.add(main_e_t_b_1);
		main_e_t_b.add(main_e_t_b_t1);// 시험
		main_e_t_b.add(main_e_t_b_2);
		main_e_t_b.add(main_e_t_b_t2);// 태도
		main_e_t_b.add(main_e_t_b_3);// 빈라벨
		main_e_t_b.add(main_e_t_b_btn);// 입력 버튼

		// main_east 하단부 main_e_b 작업
		main_e_b.setBorder(type.mainborder("상담 신청"));
		main_e_b.setLayout(new BorderLayout());
		main_e_b.add(main_e_b_list, "Center");

		// 이벤트 감지를 위한 이벤트 등록
		main_c_list.addItemListener(this);
		main_c_p_btn.addActionListener(this);
		main_e_t_b_3.addItemListener(this);
		main_c_5_select_btn.addActionListener(this);
		main_c_7_btn.addActionListener(this);
		main_e_b_list.addItemListener(this);
		main_c_5_list.addItemListener(this);
		main_c_6_list.addItemListener(this);
		main_e_t_b_btn.addActionListener(this);

		allList();
		counsellistin();
		companylistin();
		interestin();

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void allList() {
		// 모든 회원의 정보 출력(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
		arrayMember = memberdao.allList();
		arrayCounsel = counseldao.allList();
		for (memberDTO mdto : arrayMember) {
			if(!arrayCounsel.isEmpty()) {
				for (counselDTO cdto : arrayCounsel) {
					if (mdto.getName().equals(cdto.getName())) {
						main_c_list.add(mdto.toString() + cdto.toString());
					} else {
						main_c_list.add(mdto.toString());
					}
					break;
				}
				
			}else {
				main_c_list.add(mdto.toString());
			}
		}
	}

	// 관심 분야 리스트(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
	private void interestin() {
		arrayCertificate = certificatedao.typeList();
		ArrayList<String> recommend = new ArrayList<String>();
		for (certificateDTO cer : arrayCertificate) {
			recommend.add(cer.getCer_type());
		}
		main_e_t_b_3.setModel(new DefaultComboBoxModel<String>(recommend.toArray(new String[0])));
	}

	// 리스트 목록 보기(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
	private void counsellistin() {
		arrayCounsel = counseldao.allList();
		for (counselDTO c : arrayCounsel) {
			// 회원의 상담정보 출력
			String csdate = c.getCs_date();
			if (csdate == null) {
				main_e_b_list.add(c.getName() + "님의 상담 신청. " + c.getAy_date().substring(2, 10) + "일자로 신청 중");
			}
		}
	}

	// 회사 이름 리스트 (0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
	private void companylistin() {
		arrayCompany = companydao.allList();
		for (companyDTO com : arrayCompany) {
			main_c_5_list.add(com.getCom_name());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 신청 버튼을 누르면 회사(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
		if (e.getSource() == main_c_5_select_btn) {
			String finalname = main_c_5_select_1.getText();
			arrayMember = memberdao.allList();
			arrayCounsel = counseldao.allList();
			for (memberDTO d : arrayMember) {
				if (d.getName().equals(finalname)) {
					for (counselDTO c : arrayCounsel) {
						if (c.getName().equals(finalname)) {
							c.setRecommend(push_company);
							companydao.mod(c, d);
							NotiFrame noti = new NotiFrame(push_company + "분야 회사에 추천하였습니다.");
							main_c_5_1.setText(d.getName());
							main_c_5_2.setText(push_company + "분야");

						}
					}
				}
			}

		}

		// 종료 후 ,로그인 창 열기(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
		if (e.getSource() == main_c_7_btn) {
			this.setVisible(false);
			// 화면 안보일경우 종료(0)(0)(0)(0)(0)(0)(0)(0)(0)
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			SignInFrame sign = new SignInFrame();
		}

		// 회원 탈퇴(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
		if (e.getSource() == main_c_p_btn) {
			for (memberDTO memdto : arrayMember) {
				if (memdto.getName().equals(main_c_5_select_1.getText())) {
					memberdao.del(memdto);
					blockeddao.add(memdto);
					NotiFrame noti = new NotiFrame("영구 탈퇴");
					// 바로 갱신
					this.setVisible(false);
					this.setDefaultCloseOperation(HIDE_ON_CLOSE);
					new ManageFrame_1(memberdto);

				}
			}
		}
		// 시험 점수, 태도 점수, 추천 분야 입력(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
		if (e.getSource() == main_e_t_b_btn) {
			String recommend = main_e_t_b_3.getSelectedItem().toString();
			for (counselDTO c : arrayCounsel) {
				if (c.getName().equals(main_c_5_select_1.getText())) {
					c.setScore(Integer.parseInt(main_e_t_b_t1.getText()));
					c.setAttitude(Integer.parseInt(main_e_t_b_t2.getText()));
					c.setRecommend(recommend);
					counseldao.mod(c);
					this.setVisible(false);
					this.setDefaultCloseOperation(HIDE_ON_CLOSE);
					new ManageFrame_1(memberdto);
					NotiFrame noti = new NotiFrame("점수 입력 완료");
					
				}
			}

		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 전체 리스트 누르면 회원 이름이 아래로 입력
		// 됨(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
		if (e.getSource() == main_c_list) {
			int selectNum = main_c_list.getSelectedIndex();
			arrayMember = memberdao.allList();
			memberDTO mdto = arrayMember.get(selectNum);

			String name = mdto.getName();
			String cer_type = mdto.getCer_name_1();
			String interest = null;
			String recommend = null;
			main_c_5_select_1.setText(name);

			arrayCounsel = counseldao.allList();
			for (counselDTO c : arrayCounsel) {
				if (c.getName().equals(name)) {
					interest = c.getInterest();
					recommend = c.getRecommend();
					if (cer_type.equals(interest) || interest.equals(recommend)) {
						push_company = interest;
						main_c_5_select_2.setText(interest);
					} else if (cer_type.equals(recommend)) {
						main_c_5_select_2.setText(recommend);
						push_company = recommend;
					} else {

					}
				}
			}
		}

		// 상담 신청이 들어온 리스트 누르면 정보
		// 표시(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
		if (e.getSource() == main_e_b_list) {
			String name1 = main_e_b_list.getSelectedItem().substring(0, 2);
			arrayCounsel = counseldao.allList();
			for (counselDTO coundto : arrayCounsel) {
				if (coundto.getName().substring(0, 2).equals(name1)) {
					CouncelInfoFrame clistinfo = new CouncelInfoFrame(coundto);
				}
			}
		}

		// 회사 이름 누르면 추천 한 사람 정보 표시
		// (0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)(0)
		if (e.getSource() == main_c_5_list) {
			main_c_6_list.clear();
			String comname = main_c_5_list.getSelectedItem();
			for (companyDTO comdto : arrayCompany) {
				if (comdto.getCom_name().equals(comname)) {
					main_c_6_list.add(
							comdto.getName() + "/" + comdto.getId_num().substring(0, 8) + "/" + comdto.getMin_score());
				}
			}
		}
	}

}
