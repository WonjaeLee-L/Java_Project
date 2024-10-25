package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.blockedDTO;
import __0__project_dto.memberDTO;

public interface blockedDAO_interface {

	void add(memberDTO memberdto);

	ArrayList<blockedDTO> allList();
}
