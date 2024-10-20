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

import __0__project_dao.memberDAO_interface;
import __0__project_dto.memberDTO;

public class SignUpFrame extends JFrame implements ActionListener, ItemListener {
	border type = new border();
	memberDAO_interface memberInterface = null;
	memberDTO mdto = null;
	SignInFrame signin = null;
	// 폰트 설정
	private Font titleFont = new Font(Font.DIALOG, Font.BOLD, 20);

	// 가장 상위 변수
	private JPanel mainF = new JPanel(); // 컴포넌트&컨테이너.
	private JLabel title = new JLabel("회원 가입");
	private JPanel main = new JPanel();
	private JPanel main_center = new JPanel();
	private JPanel main_east = new JPanel();

	// main_center 변수

	private JPanel main_c_main = new JPanel();
	private JLabel main_c_1 = new JLabel("이름");
	private JLabel main_c_2 = new JLabel("아이디");

	private JLabel main_c_3_l = new JLabel("비밀번호");
	private JLabel main_c_4 = new JLabel("주민등록번호");
	private JTextField main_c_1_t = new JTextField();
	private JTextField main_c_2_t = new JTextField();
	private JPanel main_c_3_t = new JPanel();
	private JTextField main_c_3_t1 = new JTextField();
	private JTextField main_c_3_t2 = new JTextField();
	private JTextField main_c_4_t = new JTextField();
	private JPanel main_c_7 = new JPanel();
	private JButton main_c_7_btn = type.buttontype("가입");
	private List main_e_b_list = new List();

	ArrayList<memberDTO> w = null;

	public SignUpFrame(memberDTO mdto) {
		// 테두리 폰트, 색상 변경
		this.mdto = mdto;
//		this.memberInterface = inter;
		this.setBounds(100, 200, 700, 300);
		title.setFont(titleFont);
		mainF.add(title);

		// 테두리 설정
		main_center.setBorder(new LineBorder(Color.white, 2));
		main_east.setBorder(new LineBorder(Color.white, 2));
		main_c_3_t1.setBorder(type.password("비밀번호를 입력하세요"));
		main_c_3_t2.setBorder(type.password("한 번 더 입력하세요"));
		this.add(mainF, "North");
		this.add(main_center, "Center");

		// 비밀번호
		main_c_3_t.setLayout(new GridLayout());
		main_c_3_t.add(main_c_3_t1);
		main_c_3_t.add(main_c_3_t2);
		// 비밀번호 입력 칸 테두리
		

		// main_center에 추가
		main_center.setLayout(new BorderLayout());
		main_center.add(main_c_main, "Center");
		main_center.add(main_c_7, "South");
		main_c_7.add(main_c_7_btn);

		// main_c_main(중앙) 추가.
		main_c_main.setLayout(new GridLayout(4, 2, 10, 10));
		main_c_main.setBorder(type.mainborder("개인 정보"));
		main_c_main.add(main_c_1);
		main_c_main.add(main_c_1_t);
		main_c_main.add(main_c_2);
		main_c_main.add(main_c_2_t);
		main_c_main.add(main_c_3_l);
		main_c_main.add(main_c_3_t);
		main_c_main.add(main_c_4);
		main_c_main.add(main_c_4_t);

		// 이벤트 감지를 위한 이벤트 등록
		main_c_3_t2.addActionListener(this);
		main_e_b_list.addItemListener(this);
//		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		////////// 여기 수정 
		if(mdto != null) {
			String want_id = mdto.getId();
			main_c_2_t.setText(want_id);
			main_c_2_t.setEnabled(false);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 인터페이스를 구현할 메서드
		if (e.getSource() == main_c_7_btn) {
			// 공란 확인 추가
			//
			//
			//
			//
			
			String name = main_c_1_t.getText();
			String id = main_c_2_t.getText();
			String id_num = main_c_4_t.getText();
			if(signin.findName(name) != -1) {
				NotiFrame noti = new NotiFrame("이름 중복! 자동으로 이름을 설정합니다.");
				name = signin.AutoID(name);
				main_c_1_t.setText(name);
				main_c_1_t.setEnabled(false);
			}
			
			if(main_c_3_t1.getText().equals(main_c_3_t2.getText())) {
				String pwd = main_c_3_t1.getText();
				if(signin.findID(id) == -1) {
					mdto.setName(name);
					mdto.setId(id);
					mdto.setPassword(pwd);
					mdto.setId_num(id_num);
					memberInterface.add(mdto);
					NotiFrame noti = new NotiFrame("회원가입 완료!");
					this.setVisible(false);
					this.setDefaultCloseOperation(HIDE_ON_CLOSE);
					SignInFrame signin = new SignInFrame(memberInterface,null,null,null);
//					, memberDAO mdao, counselDAO_interface cou_inter, certificateDAO_interface cer_inter					
				}else {
					NotiFrame noti = new NotiFrame("아이디 중복!");
				}
			}else {
				NotiFrame noti = new NotiFrame("비밀번호를 동일하게 입력하세요.");
			}

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

}
