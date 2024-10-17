package __0__project_main;

import __0__project_dao._connection;
import __0__project_dao.memberDAO;
import __0__service.MemberFrame;
import __0__service.SignInFrame;

public class Main{

	public static void main(String[] args) {
		_connection co = new _connection();
		memberDAO mdao = new memberDAO();
		MemberFrame mf = new MemberFrame(mdao);
		SignInFrame sf = new SignInFrame(mdao);
	}

}