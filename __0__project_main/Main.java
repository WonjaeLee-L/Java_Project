package __0__project_main;

import __0__project_dao._connection;
import __0__project_dao.memberDAO;
import __0__service.ManageFrame;
import __0__service.MemberFrame;
import __0__service.NotiFrame;
import __0__service.SignInFrame;
import __0__service.SignUpFrame;

public class Main{

	public static void main(String[] args) {
		_connection co = new _connection();
		memberDAO mdao = new memberDAO();
		MemberFrame mf = new MemberFrame(mdao);
		SignInFrame sf = new SignInFrame(mdao);
		NotiFrame nf = new NotiFrame(mdao);
		SignUpFrame uf = new SignUpFrame(mdao);
		ManageFrame maf = new ManageFrame(mdao);
	}

}