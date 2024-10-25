package __0__project_dao;

import java.sql.SQLException;
import java.util.ArrayList;

import __0__project_dto.memberDTO;

public class memberDAO extends _connection implements memberDAO_interface {

	public static memberDAO memberdao = null;
	// public static or private로 해야 의미 o
	// 어차피 getInstance로 호출하여 memberdao를 반환받으므로 호출 되는 것.
	
	private memberDAO() {
		init();
	}

	public static memberDAO getInstance() {
		if (memberdao == null) {
			memberdao = new memberDAO();
		}
		return memberdao;
	}

	@Override
	public void add(memberDTO mdto) {
		// 연결
		conn();
		// 입력 쿼리
		query = "insert into member values (?,?,?,?,null,null)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, mdto.getName());
			ps.setString(2, mdto.getId());
			ps.setString(3, mdto.getPassword());
			ps.setString(4, mdto.getId_num());
			result();
		} catch (Exception e) {
		} finally {
			close();
		}
	}

	@Override
	public void del(memberDTO mdto) {
		// 연결
		conn();
		// 삭제 쿼리
		query = "delete from member where id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, mdto.getId());
			result();
		} catch (Exception e) {
		} finally {
			close();
		}
	}

	@Override
	public void updateCerti(String name, String text, int num) {
		conn();
		query = "update member set cer_name_" + num + " = ? where name = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, text);
			ps.setString(2, name);
			result();
		} catch (Exception e) {
		} finally {
			close();
		}
	}

	@Override
	public void modPwd(String name, String pwd) {
		conn();
		query = "update member set password = ? where name = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, pwd);
			ps.setString(2, name);
			result();
		} catch (Exception e) {
		} finally {
			close();
		}
	}

	@Override
	public ArrayList<memberDTO> list(String searchN) {
		conn();
		query = "select * from member where id like '%" + searchN + "%'";
		ArrayList<memberDTO> mlist = new ArrayList<>();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				memberDTO mtemp = new memberDTO();
				mtemp.setName(rs.getString("name"));
				mtemp.setId(rs.getString("id"));
				mtemp.setPassword(rs.getString("password"));
				mtemp.setId_num(rs.getString("id_num"));
				mtemp.setCer_name_1(rs.getString("cer_name_1"));
				mtemp.setCer_name_2(rs.getString("cer_name_2"));
				mlist.add(mtemp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mlist;
	}

	@Override
	public ArrayList<memberDTO> allList() {
		conn();
		query = "select * from member";
		ArrayList<memberDTO> mlist = new ArrayList<>();
		try {
			ps = conn.prepareStatement(query);
			while (rs.next()) {
				memberDTO mtemp = new memberDTO();
				mtemp.setName(rs.getString("name"));
				mtemp.setId(rs.getString("id"));
				mtemp.setPassword(rs.getString("password"));
				mtemp.setId_num(rs.getString("id_num"));
				mtemp.setCer_name_1(rs.getString("cer_name_1"));
				mtemp.setCer_name_2(rs.getString("cer_name_2"));
				mlist.add(mtemp);
				result();
			}
		} catch (Exception e) {
		} finally {
			close();
		}
		return mlist;
	}

}