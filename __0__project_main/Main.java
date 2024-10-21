package __0__project_main;

import __0__project_dao._connection;
import __0__project_dao.certificateDAO;
import __0__project_dao.counselDAO;
import __0__project_dao.memberDAO;
import __0__service.SignInFrame;

public class Main {

	public static void main(String[] args) {
		_connection co = new _connection();
		memberDAO mdao = new memberDAO();
		counselDAO cudao = new counselDAO();
		certificateDAO cerdao = new certificateDAO();


//		MemberFrame mf = new MemberFrame(mdao, cudao, cerdao);
		SignInFrame sf = new SignInFrame(mdao, mdao, cudao, cerdao);
//		NotiFrame nf = new NotiFrame(mdao);
//		SignUpFrame uf = new SignUpFrame(mdao);
//		ManageFrame maf = new ManageFrame(mdao);
		
		
		
		// 회원 탈퇴 칸을 멤버에서 만들고
		// 삭제 하면서 정보를 blockedDTO에 저장하도록함(이름 외래키는 없앤다)
		
		// 회사 테이블 만든다. 회사는 따로 만들지 않고, 테이블에서 이용하도록 하면, 안되는구나. 그냥 만들어놓고, 신청을 한다.
		// 회사마다의 테이블을 만들어서 회사 정보로 로그인 시에 신청자 정보가 넘어오도록 한다.(의미가 있나? 그냥 계속 똑같은데,,)
		// 
		// 매니저는 추후
	}

}