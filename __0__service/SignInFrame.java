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
	memberDAO_interface memberInterface = null;
	memberDAO memberdao = null;
	public ArrayList<memberDTO> arrayMember = null;
	SignInFrame signinframe = null;
	border type = new border();
	memberDTO mdto = new memberDTO();

	// 폰트 설정
	private Font titleFont = new Font(Font.DIALOG, Font.BOLD, 20);

	// 메인
	private JPanel mainPanel = new JPanel();

	// mainPanel 내부
	private JLabel left = new JLabel();
	private JPanel centerPanel = new JPanel();
	private JLabel right = new JLabel();
	private JLabel top = new JLabel();

	// centerPanel 내부
	private JLabel id = new JLabel("ID");
	private JTextField id_t = new JTextField();
	private JLabel password = new JLabel("PASSWORD");
	private JTextField password_t = new JTextField();
	private JButton signup = type.buttontype("SIGNUP");
	private JButton signin = type.buttontype("SIGNIN");
	private memberDAO_interface memberDAO_interface;

	public SignInFrame(memberDAO_interface m_inter, memberDAO mdao, counselDAO_interface cou_inter, certificateDAO_interface cer_inter) {
		this.memberInterface = m_inter;
		this.counselInterface = cou_inter;
		this.certificateInterface = cer_inter;
		this.memberdao = mdao;

		this.setBounds(100, 100, 500, 150);
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

		this.memberInterface = m_inter;
		
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
		// 로그인 버튼 클릭시 >> 로그인 되면서 MemberFrame으로 이동
		if (e.getSource() == signin) {
			String id = id_t.getText();
			String pwd = password_t.getText();
			if (loginID(id) != null && findPwd(pwd) != -1 && findID(id)==findPwd(pwd)) {
				// 로그인 창 제거
				
				this.setVisible(false);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
				
				// 로그인
				MemberFrame mframe = new MemberFrame(memberInterface, counselInterface, certificateInterface, signinframe, id, pwd, arrayMember, memberdao);
			}else if(loginID(id) != null && findID(id)!=findPwd(pwd)) {
				NotiFrame noti = new NotiFrame("비밀번호가 틀렸습니다");
			}else if(findID(id)==-1) {
				NotiFrame noti = new NotiFrame("등록되지 않은 아이디입니다.");
				mdto.setId(id);
				this.setVisible(false);
				this.setDefaultCloseOperation(HIDE_ON_CLOSE);
//				void schedule(new SignUpFrame(memberInterface), 1000);
				SignUpFrame sign = new SignUpFrame(mdto);
			}

		}
		// 가입버튼 클릭시
		if (e.getSource() == signup) {
			this.setVisible(false);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			SignUpFrame sign = new SignUpFrame(mdto);
		}

	}

	private void memberlistin() {
		arrayMember = memberInterface.allList();
//		for(memberDTO mem : arrayMember) {
//			
//		}
	}

//	private void loginProcess() {
//
//		nowUser = loginID(id);
//		if (nowUser == null) {
//			System.out.println("아이디 없음");
//		} else {
//			System.out.println("로그인 성공! 메뉴로 이동");
//			nowUser.menu(partManager);
//			// nowUser가 menu 메서드를 콜할때 partManager 주소를 넘긴 것
//		}
//	}
	private int findPwd(String a) {
		for (int i = 0; i < arrayMember.size(); i++) {
			if (arrayMember.get(i).getPassword().equals(a)) {
				return i;
			}
		}
		return -1;
	}
	
	private int findID(String a) {
		for (int i = 0; i < arrayMember.size(); i++) {
			if (arrayMember.get(i).getId().equals(a)) {
				return i;
			}
		}
		return -1;
	}

	// 리턴타입 Stu 주소
	public memberDTO loginID(String id) {
		int idx = findID(id);
		if (idx != -1) {
			memberDTO m = arrayMember.get(idx);
			return m;
		}
		return null;
	}
}
