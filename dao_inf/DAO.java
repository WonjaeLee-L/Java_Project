package dao_inf;

import java.util.ArrayList;

import dto.DTO;

// DBdao를 implements 받고, override
public class DAO implements DBdao {

	// Dao 작업 필요

	public DAO() {
	}

	@Override
	public void add(DTO wdto) {
		System.out.println("insert : " + wdto.getEng());
	}

	@Override
	public ArrayList<DTO> selectAll() {

		// sample 코드 >> 실제 코드는 DB에서 가져오기
		ArrayList<DTO> w = new ArrayList<DTO>();
		DTO temp = new DTO();
		temp.setEng("apple");
		temp.setKor("사과");
		w.add(temp);
		temp = new DTO();
		temp.setEng("banana");
		temp.setKor("바나나");
		w.add(temp);
		temp = new DTO();
		temp.setEng("banana");
		temp.setKor("바나나");
		w.add(temp);

		temp = new DTO();
		temp.setEng("banana");
		temp.setKor("바나나");
		w.add(temp);

		temp = new DTO();
		temp.setEng("banana");
		temp.setKor("바나나");
		w.add(temp);

		temp = new DTO();
		temp.setEng("banana");
		temp.setKor("바나나");
		w.add(temp);

		temp = new DTO();
		temp.setEng("banana");
		temp.setKor("바나나");
		w.add(temp);


		return w;
	}

	@Override
	public void mod(DTO wdto) {
		// TODO Auto-generated method stub
		System.out.println("수정 : " + wdto.getEng() + "/" + wdto.getKor());
	}

	@Override
	public void delect(DTO wdto) {
		// TODO Auto-generated method stub
		System.out.println("삭제 : " + wdto.getEng());
	}

}
