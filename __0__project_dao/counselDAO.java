package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.counselDTO;

public class counselDAO extends _connection implements counselDAO_interface {

	counselDTO counseldto = new counselDTO();

	public counselDAO() {
	};

	@Override
	public void add(counselDTO coudto) {
		// 연결
		conn();
		// 입력 쿼리
		query = "insert into counsel values (?,?,default,null,null,null,0,0)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, coudto.getName());
			ps.setString(2, coudto.getInterest());

			result();
		} catch (Exception e) {
		} finally {
			close();
		}

	}

	@Override
	public void del() {
		System.out.println("del");

	}

	@Override
	public void mod() {
		System.out.println("mod");

	}

	@Override
	public ArrayList<counselDTO> list(String searchN) {
		System.out.println("list");
		return null;
	}

	@Override
	public ArrayList<counselDTO> allList() {
		conn();
		query = "select * from counsel";
		ArrayList<counselDTO> culist = new ArrayList<>();
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				counselDTO cutemp = new counselDTO();
				cutemp.setName(rs.getString("name"));
				cutemp.setInterest(rs.getString("interest"));
				cutemp.setAy_date(rs.getString("ay_date"));
				cutemp.setMemo(rs.getString("memo"));
				cutemp.setRecommend(rs.getString("recommend"));
				cutemp.setCs_date(rs.getString("cs_date"));
				cutemp.setScore(rs.getInt("score"));
				cutemp.setAttitude(rs.getInt("attitude"));
				culist.add(cutemp);
			}
		} catch (Exception e) {
		} finally {
			close();
		}
		return culist;

	}

}