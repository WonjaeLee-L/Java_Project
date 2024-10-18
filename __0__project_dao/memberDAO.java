package __0__project_dao;

import java.sql.SQLException;
import java.util.ArrayList;

import __0__project_dto.memberDTO;

public class memberDAO extends _connection implements memberDAO_interface {

	memberDTO mdto = new memberDTO();

	public memberDAO() {

	}

	@Override
	public void add() {
		// 연결
		conn();
		// 입력 쿼리
		query = "insert into member values (?,?,?,?,0,default)";
		try {
			ps = conn.prepareStatement(query);
			// 객체 생성(conn을 통해 쿼리문 입력 받고 실행)
			ps.setString(1, mdto.getName());
			ps.setString(2, mdto.getId());
			ps.setString(3, mdto.getPassword());
			ps.setString(4, mdto.getId_num());
			ps.setString(5, mdto.getCer_name_1());
			ps.setString(6, mdto.getCer_name_2());
			result();
		} catch (Exception e) {
		} finally {
			close();
		}
	}

	@Override
	public void del() {
		// 연결
		conn();
		// 삭제 쿼리
		query = "delete from member where name = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, mdto.getName());

			result();
		} catch (Exception e) {
		} finally {
			close();
		}
	}

	@Override
	public void mod() {
		conn();
		query = "update member set password = ? where name = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, mdto.getPassword());
			ps.setString(2, mdto.getName());
		} catch (Exception e) {
		} finally {
			close();
		}
	}

	@Override
	public ArrayList<memberDTO> list(String searchN) {
		conn();
		query = "select * from member where id like '%"+searchN+"%'";
		ArrayList<memberDTO> mlist = new ArrayList<>();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
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
			// TODO Auto-generated catch block
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
		} catch (Exception e) {
		} finally {
			close();
		}
		return mlist;
	}
}
