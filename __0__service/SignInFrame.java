package __0__service;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import __0__project_dao.certificateDAO_interface;
import __0__project_dao.counselDAO_interface;
import __0__project_dao.memberDAO;
import __0__project_dao.memberDAO_interface;
import __0__project_dto.memberDTO;

public class SignInFrame extends JFrame implements ActionListener {

	private counselDAO_interface counselInterface = null;
	private certificateDAO_interface certificateInterface = null;
	private memberDAO_interface memberInterface = null;
	private memberDAO member_dao = null;
	private  ArrayList<memberDTO> arrayMember = null;
	private border type = new border();
	private memberDTO mdto = new memberDTO();
	private SignInFrame signinframe = null;

	// 폰트 설정
	private Font titleFont = new Font(Font.DIALOG, Font.BOLD, 20);

	// 메인
	private JPanel mainPanel = new JPanel();

	// mainPanel 내부
	private JLabel left = new JLabel();
	private JPanel centerPanel = new JPanel();
	private JLabel right = new JLabel();
//	private JLabel top = new JLabel();

	// centerPanel 내부
	private JLabel id = new JLabel("ID");
	private JTextField id_t = new JTextField();
	private JLabel password = new JLabel("PASSWORD");
	private JTextField password_t = new JTextField();
	private JButton signup = type.buttontype("SIGNUP");
	private JButton signin = type.buttontype("SIGNIN");
//	private memberDAO_interface memberDAO_interface;

	public SignInFrame(memberDAO_interface memberInterface, memberDAO member_dao, counselDAO_interface counselInterface,
			certificateDAO_interface certificatInterface) {
		this.memberInterface = memberInterface;
		this.counselInterface = counselInterface;
		this.certificateInterface = certificatInterface;
		this.member_dao = member_dao;

		this.setBounds(400, 300, 500, 150);
		this.add(mainPanel, "Center");

		centerPanel.setBorder(type.mainborder("회원 로그인"));

		mainPanel.setLayout(new GridLayout());
		mainPanel.add(left);
		mainPanel.add(centerPanel);
		mainPanel.add(right);

		centerPanel.setLayout(new GridLayout(3, 3));
		centerPanel.add(id);
		centerPanel.add(id_t);
		centerPanel.add(password);
		centerPanel.add(password_t);
		centerPanel.add(signup);
		centerPanel.add(signin);

		// 이벤트 감지
		signin.addActionListener(this);
		signup.addActionListener(this);

		memberlistin();

		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 로그인 버튼
		if (e.getSource() == signin) {
			String id = id_t.getText();
			String pwd = password_t.getText();

			// 아이디 미입력
			if (id_t.getText().isEmpty()) {
				NotiFrame noti = new NotiFrame("아이디를 입력하세요");
				id_t.setBorder(type.warning("!"));
				// 입력한 아이디가 없는 경우
			} else if (findID(id) == -1) {
				mdto.setId(id);
				SignUpFrame sign = new SignUpFrame(mdto, signinframe, memberInterface);
				// , memberInterface
				NotiFrame noti = new NotiFrame("등록되지 않은 아이디입니다. 입력한 아이디로 회원가입을 진행합니다.");
				this.setVisible(false);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
				// 로그인 성공
			} else if (findID(id) == findPwd(pwd)) {
				this.setVisible(false);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
				MemberFrame mframe = new MemberFrame(memberInterface, counselInterface, certificateInterface,
						signinframe, id, pwd, arrayMember, member_dao);
				// 비밀번호 오류
			} else if (findID(id) != findPwd(pwd)) {
				NotiFrame noti = new NotiFrame("비밀번호가 틀렸습니다");
				password_t.setBorder(type.warning("!"));
			}

		}
		// 가입 버튼
		if (e.getSource() == signup) {
			this.setVisible(false);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			SignUpFrame sign = new SignUpFrame(mdto, signinframe, memberInterface);
//			, memberInterface
		}

	}

	private void memberlistin() {
		arrayMember = memberInterface.allList();
	}

	private int findPwd(String a) {
		for (int i = 0; i < arrayMember.size(); i++) {
			if (arrayMember.get(i).getPassword().equals(a)) {
				return i;
			}
		}
		return -1;
	}

	public int findID(String a) {
		for (int i = 0; i < arrayMember.size(); i++) {
			if (arrayMember.get(i).getId().equals(a)) {
				return i;
			}
		}
		return -1;
	}

	public int findName(String a) {
		for (int i = 0; i < arrayMember.size(); i++) {
			if (arrayMember.get(i).getName().equals(a)) {
				return i;
			}
		}
		return -1;
	}

	public String AutoID(String a) {
		for (int i = 0; i < arrayMember.size(); i++) {
			if (arrayMember.get(i).equals(a)) {
				a = a + i;
			}
		}
		return a;
	}

//	public int findId_num(String a) {
//		for (int i = 0; i < arrayMember.size(); i++) {
//			if (arrayMember.get(i).getId_num().equals(a)) {
//				return i;
//			}
//		}
//		return -1;
//	}

//	public memberDTO loginID(String id) {
//		int idx = findID(id);
//		if (idx != -1) {
//			memberDTO m = arrayMember.get(idx);
//			return m;
//		}
//		return null;
//	}
}