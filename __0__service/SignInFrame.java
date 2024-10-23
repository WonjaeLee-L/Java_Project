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

import __0__project_dao.memberDAO;
import __0__project_dto.memberDTO;

public class SignInFrame extends JFrame implements ActionListener {

	private memberDAO memberdao = memberDAO.getInstance();
	private memberDTO memberdto = new memberDTO();
	private ArrayList<memberDTO> arrayMember = null;
	private border type = new border();
	// 폰트 설정
	private Font titleFont = new Font(Font.DIALOG, Font.BOLD, 20);

	// 메인
	private JPanel mainPanel = new JPanel();

	// mainPanel 내부
	private JLabel left = new JLabel();
	private JPanel centerPanel = new JPanel();
	private JLabel right = new JLabel();

	// centerPanel 내부
	private JLabel id = new JLabel("ID");
	private JTextField id_t = new JTextField();
	private JLabel password = new JLabel("PASSWORD");
	private JTextField password_t = new JTextField();
	private JButton signup = type.buttontype("SIGNUP");
	private JButton signin = type.buttontype("SIGNIN");

	public SignInFrame() {
		
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
		// 로그인 버튼sss
		if (e.getSource() == signin) {
			memberdto.setId(id_t.getText());
			memberdto.setPassword(password_t.getText());

			if (id_t.getText().equals("super") && password_t.getText().equals("super")) {
				this.setVisible(false);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
				ManageFrame_1 manageframe = new ManageFrame_1(memberdto);
			} else if (id_t.getText().equals("super")) {
				NotiFrame noti = new NotiFrame("가입할 수 없는 아이디입니다.");
				id_t.setBorder(type.warning(""));
			} else if (id_t.getText().isEmpty()) {
				NotiFrame noti = new NotiFrame("아이디를 입력하세요");
				id_t.setBorder(type.warning("!"));
				// 입력한 아이디가 없는 경우
			} else if (findID(id_t.getText()) == -1 && !id_t.getText().equals("super")) {
				memberdto.setId(id_t.getText());
				SignUpFrame sign = new SignUpFrame(memberdto);
				// , memberInterface
				NotiFrame noti = new NotiFrame("등록되지 않은 아이디입니다. 입력한 아이디로 회원가입을 진행합니다.");
				this.setVisible(false);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
				// 로그인 성공
			} else if (findID(id_t.getText()) == findPwd(password_t.getText())) {
				this.setVisible(false);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
				for(memberDTO d : arrayMember) {
					if(memberdto.getId().equals(d.getId())) {
						memberdto = d;
					}
				}
				MemberFrame memframe = new MemberFrame(memberdto);
			}
			// 비밀번호 오류
			else if (findID(id.getText()) != findPwd(password_t.getText())) {
				NotiFrame noti = new NotiFrame("비밀번호가 틀렸습니다");
				password_t.setBorder(type.warning("!"));
			}
		}

		// 가입 버튼
		if (e.getSource() == signup)

		{
			this.setVisible(false);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			SignUpFrame sign = new SignUpFrame(memberdto);
		}

	}

	private void memberlistin() {
		arrayMember = memberdao.allList();
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
}