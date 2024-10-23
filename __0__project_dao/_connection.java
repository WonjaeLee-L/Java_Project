package __0__project_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _connection {
	protected String username = "system";
	protected String password = "11111111";
	protected String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	protected String driverName = "oracle.jdbc.driver.OracleDriver";
	protected String query = null;
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	protected _connection _dao = null;

	public _connection() {
//		init();
	}

	// 드라이버 로드
	public void init() {
		try {
			Class.forName(driverName);
//			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 연결
	public void conn() {
		try {
			conn = DriverManager.getConnection(url, username, password);
//			System.out.println("커넥션 성공");

		} catch (Exception e) {
		}
	}

	// 자원 반납
	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
		}
	}

	// 확인
	public void result() {
		try {
			int result = ps.executeUpdate();
			if (result > 0) {
				conn.commit();
//				System.out.println("입력 성공");
			} else {
				conn.rollback();
//				System.out.println("입력 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}