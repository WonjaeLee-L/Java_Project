package __0__project_main;

import __0__project_dao._connection;
import __0__project_dao.memberDAO;

public class Main{

	public static void main(String[] args) {
		_connection co = new _connection();
		memberDAO na = new memberDAO();
		na.allList();
		
	}

}