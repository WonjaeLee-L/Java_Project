package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.certificateDTO;

public class certificateDAO extends _connection implements certificateDAO_interface {

	certificateDTO cerdto = new certificateDTO();

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
		
		query = "insert into certificate values (?)";
		try {
			ps = conn.prepareStatement(query);
			// 객체 생성(conn을 통해 쿼리문 입력 받고 실행)
			ps.setString(1, cerdto.getCer_name());
			result();
		} catch (Exception e) {
		} finally {
			close();
		}

	}

}