package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.certificateDTO;

public interface certificateDAO_interface {

	void add();

	ArrayList<certificateDTO> allList();

	ArrayList<certificateDTO> list(String type);

	ArrayList<certificateDTO> typeList();
}