package __0__service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import __0__project_dao.blockedDAO;
import __0__project_dao.memberDAO;
import __0__project_dto.blockedDTO;
import __0__project_dto.memberDTO;

public class SignUpFrame extends JFrame implements ActionListener {
	border type = new border();
	ArrayList<memberDTO> arrayMember = new ArrayList<memberDTO>();
	ArrayList<blockedDTO> arrayBlock = new ArrayList<>();
	memberDTO memberdto = null;
	memberDAO memberdao = memberDAO.getInstance();
	blockedDAO blockeddao = blockedDAO.getInstance();

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
	private JPasswordField main_c_3_t1 = new JPasswordField();
	private JPasswordField main_c_3_t2 = new JPasswordField();
//	private JTextField main_c_3_t1 = new JTextField();
//	private JTextField main_c_3_t2 = new JTextField();
	private JTextField main_c_4_t = new JTextField();
	private JPanel main_c_7 = new JPanel();
	private JButton main_c_7_btn = type.buttontype("가입");

	public SignUpFrame(memberDTO memberdto) {

		// 테두리 폰트, 색상 변경
		this.memberdto = memberdto;

		this.setBounds(200, 300, 700, 300);
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
		main_c_7_btn.addActionListener(this);

//		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// SignIngFrame에서 입력한 id 그대로 가져옴
		String want_id = memberdto.getId();
		main_c_2_t.setText(want_id);
		if (want_id != null) {
			main_c_2_t.setEnabled(false);
		} else {
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 인터페이스를 구현할 메서드
		if (e.getSource() == main_c_7_btn) {
			main_c_3_t1.setBorder(type.mainborder(""));
			main_c_3_t2.setBorder(type.mainborder(""));
			main_c_4_t.setBorder(type.mainborder(""));
			arrayMember = memberdao.allList();
			int a1 = 0;
			int b1 = 0;
			for (memberDTO d : arrayMember) {
				if (d.getName().equals(main_c_1_t.getText())) {
					NotiFrame noti = new NotiFrame("이름 중복! 자동으로 이름을 설정합니다.");
					String newname = main_c_1_t.getText() + 1;
					main_c_1_t.setText(newname);
					main_c_1_t.setEnabled(false);
				}
			}

			arrayBlock = blockeddao.allList();
			for (blockedDTO b : arrayBlock) {
				if (b.getId_num().equals(main_c_4_t.getText())) {
					this.setVisible(false);
					this.setDefaultCloseOperation(HIDE_ON_CLOSE);
					SignInFrame signin = new SignInFrame();
					NotiFrame noti = new NotiFrame("차단된 사용자입니다.");
					a1=1;
				}
			}

			for (memberDTO d : arrayMember) {
				if (d.getId_num().equals(main_c_4_t.getText())) {
					NotiFrame noti = new NotiFrame("주민등록번호 중복");
					main_c_4_t.setBorder(type.warning(""));
					b1=1;
				}
			}
			char[] pwdchar1 = main_c_3_t1.getPassword();
			char[] pwdchar2 = main_c_3_t2.getPassword();
			String temppwd1 = new String(pwdchar1);
			String temppwd2 = new String(pwdchar2);
			
			if(a1!=1 && b1!=1) {
				if (main_c_3_t1.getPassword().equals(null) || main_c_3_t2.getPassword().equals(null)) {
					NotiFrame noti = new NotiFrame("비밀번호를 입력하세요");
					main_c_3_t1.setBorder(type.warning("!"));
				} else if (!temppwd1.equals(temppwd2)) {
					NotiFrame noti = new NotiFrame("비밀번호를 동일하게 입력하세요.");
					main_c_3_t1.setBorder(type.warning("!"));
					main_c_3_t2.setBorder(type.warning("!"));
					System.out.println(main_c_3_t1.getPassword());
					System.out.println(main_c_3_t2.getPassword());
					System.out.println(temppwd1);
					System.out.println(temppwd2);
				} else if (main_c_4_t.getText().length() != 13) {
					NotiFrame noti = new NotiFrame("주민번호를 입력하세요.");
					main_c_4_t.setBorder(type.warning("!"));
					main_c_3_t1.setBorder(new LineBorder(Color.white, 2));
					main_c_3_t2.setBorder(new LineBorder(Color.white, 2));
				} else if (temppwd1.equals(temppwd2)) {
//					char[] pwdchar = main_c_3_t2.getPassword();
//					String temppwd = new String(pwdchar);
					memberdto.setName(main_c_1_t.getText());
					memberdto.setId(main_c_2_t.getText());
					memberdto.setPassword(temppwd1);
					memberdto.setId_num(main_c_4_t.getText());
					memberdao.add(memberdto);
					this.setVisible(false);
					this.setDefaultCloseOperation(HIDE_ON_CLOSE);
					SignInFrame signin = new SignInFrame();
					NotiFrame noti = new NotiFrame("회원가입 완료!");
				}
				
			}
			
		}
		

	}
}