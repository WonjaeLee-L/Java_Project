package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.companyDTO;
import __0__project_dto.counselDTO;
import __0__project_dto.memberDTO;

public interface companyDAO_interface {
	void mod(counselDTO cdto, memberDTO mdto);
	ArrayList<companyDTO> allList();
}
