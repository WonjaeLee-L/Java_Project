package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.counselDTO;

public interface counselDAO_interface {

	void add(counselDTO counseldto);

	void del();

	void mod(counselDTO counseldto);

	ArrayList<counselDTO> list(String searchN);

	ArrayList<counselDTO> allList();

}