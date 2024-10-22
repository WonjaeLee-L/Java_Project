package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.counselDTO;

public interface counselDAO_interface {
	void add(counselDTO coudto);

	void del();

	void mod();

	ArrayList<counselDTO> list(String searchN);

	ArrayList<counselDTO> allList();

}
