package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.blockedDTO;
import __0__project_dto.memberDTO;

public class blockedDAO extends _connection implements blockedDAO_interface {

	public static blockedDAO blockeddao = null;

	private blockedDAO() {
		init();
	}

	public static blockedDAO getInstance() {
		if (blockeddao == null) {
			blockeddao = new blockedDAO();
		}
		return blockeddao;
	}

	@Override
	public void add(memberDTO memberdto) {
		conn();
		// 입력 쿼리
		query = "insert into blocked values (?,?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, memberdto.getName());
			ps.setString(2, memberdto.getId_num());
			result();
		} catch (Exception e) {
		} finally {
			close();
		}

	}

	public ArrayList<blockedDTO> allList() {
		conn();
		query = "select * from blocked";
		ArrayList<blockedDTO> blist = new ArrayList<>();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				blockedDTO btemp = new blockedDTO();
				btemp.setB_name(rs.getString("b_name"));
				btemp.setId_num(rs.getString("id_num"));
				blist.add(btemp);
			}
//			result();
		} catch (Exception e) {
		} finally {
			close();
		}
		return blist;
	}

}
