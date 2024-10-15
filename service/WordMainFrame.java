package service;

import java.awt.BorderLayout;
import java.awt.Color;
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

import dao_inf.DBdao;
import dto.WordDTO;

// JFrame으로부터 상속 받고, DBdao라는 인터페이스변수를 가지고 있다
public class WordMainFrame extends JFrame implements ActionListener, ItemListener {
	private JPanel title_p = new JPanel(); // 컴포넌트&컨테이너.
	// 기본 레이아웃이 flow 레이아웃.. 가운데부터하나씩 정렬
	private JLabel t = new JLabel("회원 정보");
	private JPanel main = new JPanel();
	private JPanel main_center = new JPanel();
	private JPanel main_east = new JPanel();
	private JPanel center_3 = new JPanel();


	DBdao dbdao = null;
	// main_center 변수
	JLabel main_c_title = new JLabel("개인 정보");
	JButton main_c_btn = new JButton("저장");
	JPanel main_c_main = new JPanel();
	JLabel main_c_1 = new JLabel("이름");
	JLabel main_c_2 = new JLabel("아이디");
	JLabel main_c_3 = new JLabel("비밀번호 수정");
	JLabel main_c_4 = new JLabel("주민등록번호");
	JLabel main_c_5 = new JLabel("시험 점수");
	JLabel main_c_6 = new JLabel("태도 점수");
	JLabel main_c_1_t = new JLabel();
	JLabel main_c_2_t = new JLabel();
	JPanel main_c_3_t = new JPanel();
	JTextField main_c_3_t1 = new JTextField();
	JTextField main_c_3_t2 = new JTextField();
	JLabel main_c_4_t = new JLabel();
	JLabel main_c_5_t = new JLabel();
	JLabel main_c_6_t = new JLabel();
	
	// main_east 변수
	JPanel main_e_main = new JPanel();
	JPanel main_e_t = new JPanel();
	JPanel main_e_b = new JPanel();
	JPanel main_e_t_in = new JPanel();
	
	// main_e_t의 내부, 우측 위
	JLabel main_e_t_t = new JLabel("상담 신청");
	JLabel main_e_t_b = new JLabel();
	
	// main_e_b의 내부, 우측 아래
	JLabel main_e_b_t = new JLabel("상담 이력");
	List main_e_b_list = new List();
	JButton main_e_btn = new JButton("신청");
	
	// center_3 변수
	JLabel c5 = new JLabel("단어수정");
	JButton c5btn = new JButton("수정");
	JPanel c5c = new JPanel();
	JLabel c6 = new JLabel("영어");
	JLabel c7 = new JLabel("한글");
	JTextField j5 = new JTextField();
	JTextField j6 = new JTextField();

	ArrayList<WordDTO> w = null;

	public WordMainFrame(DBdao d) {
		this.dbdao = d; // DB 작업을 위한 객체 주소를 외부(Main class)로부터 주입 받는다.
		this.setBounds(100, 100, 500, 300);
		title_p.add(t);
		
		// 라인 설정
		main_center.setBorder(new LineBorder(Color.white, 3));
		main_east.setBorder(new LineBorder(Color.DARK_GRAY, 3));
//		main_c_s.setBorder(new LineBorder(Color.yellow, 3)); 필요 xx
		
		
		main.setBackground(Color.yellow);
//		this.setLayout(new BorderLayout());
		this.add(title_p, "North");
		this.add(main, "Center");
		main_center.setBackground(Color.red);
		main_east.setBackground(Color.cyan);
		center_3.setBackground(Color.green);
		// 위 3개의 패널을 center_p 에 추가시키는데
		main.setLayout(new BorderLayout());
		main.add(main_center, "Center");
		main.add(main_east, "East");
//		main.add(center_3);
//		main_c_1.setBackground(Color.red);
		// 비밀번호 수정
		main_c_3_t.setLayout(new GridLayout());
		main_c_3_t.add(main_c_3_t1);
		main_c_3_t.add(main_c_3_t2);

		// center_1 작업
		main_c_main.setBackground(Color.gray);
		main_c_main.setLayout(new GridLayout(6, 6,10,10));
		main_c_main.add(main_c_1);
		main_c_main.add(main_c_1_t);
		main_c_main.add(main_c_2);
		main_c_main.add(main_c_2_t);
		main_c_main.add(main_c_3);
		main_c_main.add(main_c_3_t);
		main_c_main.add(main_c_4);
		main_c_main.add(main_c_4_t);
		main_c_main.add(main_c_5);
		main_c_main.add(main_c_5_t);
		main_c_main.add(main_c_6);
		main_c_main.add(main_c_6_t);
		
		
		main_center.setLayout(new BorderLayout());
		main_center.add(main_c_title, "North");
		main_center.add(main_c_btn, "South");
		main_center.add(main_c_main, "Center");

		// center_2작업
		main_e_t.setLayout(new BorderLayout());
		main_e_t.add(main_e_t_t, "North");
		main_e_t.add(main_e_t_in, "Center");
		
		main_e_t_in.setLayout(new GridLayout());
//		main_e_t_in.add(c1btn)
		main_e_b.setLayout(new BorderLayout());
		
		
		main_e_main.setLayout(new BorderLayout());
		main_e_main.add(main_e_t, "North");
		main_e_main.add( main_e_b, "Center");
//		main_e_main.add(c22btn, "South");
		main_east.setLayout(new BorderLayout());
		main_east.add(main_e_main, "Center");

		// center_3 작업
		j5.setEnabled(false); // j5(영어) 수정 불가 설정
		c5c.setBackground(Color.gray);
		c5c.setLayout(new GridLayout(2, 2));
		c5c.add(c6);
		c5c.add(j5);
		c5c.add(c7);
		c5c.add(j6);
		center_3.setLayout(new BorderLayout());
		center_3.add(c5, "North");
		center_3.add(c5btn, "South");
		center_3.add(c5c, "Center");

		// 이벤트 감지를 위한 이벤트 등록
		main_c_btn.addActionListener(this);
		main_e_b_list.addItemListener(this);
		main_e_btn.addActionListener(this);
		c5btn.addActionListener(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		init();
	}

	// 리스트 목록 보기
	private void init() {
		w = dbdao.selectAll();
		for (WordDTO t : w) {
			main_e_b_list.add(t.getEng() + " : " + t.getKor());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 인터페이스를 구현할 메서드
		if (e.getSource() == main_c_btn) {
			String eng = main_c_1_t.getText();
			String kor = main_c_2_t.getText();
			System.out.println(eng + "/" + kor);
			// 이벤트르발생한소스가 c1btn이라면, j1, j2를 각 변수에 저장

			// DTO에 저장하고 DAO를 통해서 DB에 저장
			WordDTO wdto = new WordDTO();
			wdto.setEng(eng);
			wdto.setKor(kor);
			dbdao.add(wdto);
		} else if (e.getSource() == c5btn) {
			String eng = j5.getText();
			String kor = j6.getText();
			WordDTO wdto = new WordDTO();
			wdto.setEng(eng);
			wdto.setKor(kor);
			dbdao.mod(wdto);

			// dao에게 넘겨서 수정합니다. 단, 영어단어는 수정 불가
		} else if (e.getSource() == main_e_btn) {
			String eng = j5.getText();
			WordDTO wdto = new WordDTO();
			wdto.setEng(eng);
			// dao에게 넘겨서 삭제를 합니다.
			dbdao.delect(wdto);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int selectNum = main_e_b_list.getSelectedIndex();
		System.out.println(selectNum + "번이 선택 됨");

		// 1. 리스트에서 가져오기, 2. DB에서 가져오기 중에 1로 진행
		WordDTO tempdto = w.get(selectNum);
		j5.setText(tempdto.getEng());
		j6.setText(tempdto.getKor());

	}

}
