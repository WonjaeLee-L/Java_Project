package __0__project_dao;

import java.sql.SQLException;
import java.util.ArrayList;

import __0__project_dto.certificateDTO;

public class certificateDAO extends _connection implements certificateDAO_interface {

//	certificateDTO cerdto = new certificateDTO();
	private static certificateDAO certificatedao = null;

	private certificateDAO() {
		init();
	}

	public static certificateDAO getInstance() {
		if (certificatedao == null) {
			certificatedao = new certificateDAO();
		}
		return certificatedao;
	}

	@Override
	public ArrayList<certificateDTO> allList() {
		conn();
		query = "select * from certificate";
		ArrayList<certificateDTO> cerlist = new ArrayList<>();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				certificateDTO certemp = new certificateDTO();
				certemp.setCer_name(rs.getString("cer_name"));
				certemp.setCer_type(rs.getString("cer_type"));
				certemp.setCer_num(rs.getInt("cer_num"));
				cerlist.add(certemp);
			}
		} catch (Exception e) {
		} finally {
			close();
		}
		return cerlist;

	}
	
	@Override
	public ArrayList<certificateDTO> typeList() {
		
		conn();
		ArrayList<certificateDTO> cerlist = new ArrayList<>();
		query = "select distinct cer_type from certificate";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				certificateDTO certemp = new certificateDTO();
//				certemp.setCer_name(rs.getString("cer_name"));
				certemp.setCer_type(rs.getString("cer_type"));
//				certemp.setCer_num(rs.getInt("cer_num"));
				cerlist.add(certemp);
			}
		} catch (Exception e) {
		} finally {
			close();
		}
		return cerlist;

	}

	@Override
	public void add() {
		conn();
		query = "insert into certificate values (?,?,cer_seq.nextval)";
		try {
			certificateDTO cerdto = new certificateDTO();
			ps = conn.prepareStatement(query);
			// 객체 생성(conn을 통해 쿼리문 입력 받고 실행)
			ps.setString(1, cerdto.getCer_name());
			ps.setString(2, cerdto.getCer_type());
			ps.setInt(3, cerdto.getCer_num());
			result();
		} catch (Exception e) {
		} finally {
			close();
		}

	}
	
	

	
	@Override
	public ArrayList<certificateDTO> list(String type) {
		conn();
		query = "select * from certificate where cer_type like '%" + type + "%'";
		ArrayList<certificateDTO> cerlist = new ArrayList<>();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				certificateDTO certemp = new certificateDTO();
				certemp.setCer_name(rs.getString("cer_name"));
				certemp.setCer_type(rs.getString("cer_type"));
				certemp.setCer_num(rs.getInt("cer_num"));
				cerlist.add(certemp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cerlist;
	}

}