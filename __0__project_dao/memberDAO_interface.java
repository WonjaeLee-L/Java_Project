package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.memberDTO;

public interface memberDAO_interface{

	void add();

	void del();

	void mod();

	ArrayList<memberDTO> list(String searchN);

	ArrayList<memberDTO> allList();

}
