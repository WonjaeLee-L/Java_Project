package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.companyDTO;
import __0__project_dto.counselDTO;
import __0__project_dto.memberDTO;

public class companyDAO extends _connection implements companyDAO_interface {

	public static companyDAO companydao = null;

	private companyDAO() {
		init();
	}

	public static companyDAO getInstance() {
		if (companydao == null) {
			companydao = new companyDAO();
		}
		return companydao;
	}

	@Override
	public void mod(counselDTO cdto, memberDTO mdto) {
		// 연결
		conn();
		query = "update company set name = ?, id_num = ?, min_score = ? where department = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, mdto.getName());
			ps.setString(2, mdto.getId_num());
			ps.setInt(3, cdto.getScore());
			ps.setString(4, cdto.getRecommend());
			rs = ps.executeQuery();
		} catch (Exception e) {
		} finally {
			result();
			close();
		}

	}

	@Override
	public ArrayList<companyDTO> allList() {
		conn();
		query = "select * from company";
		ArrayList<companyDTO> clist = new ArrayList<>();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				companyDTO ctemp = new companyDTO();
				ctemp.setCom_name(rs.getString("com_name"));
				ctemp.setName(rs.getString("name"));
				ctemp.setId_num(rs.getString("id_num"));
				ctemp.setDepartment(rs.getString("department"));
				ctemp.setMin_score(rs.getInt("min_score"));
				clist.add(ctemp);
			}
		} catch (Exception e) {
		} finally {

			close();
		}
		return clist;
	}

}
