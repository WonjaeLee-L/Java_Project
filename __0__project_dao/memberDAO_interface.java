package __0__project_dao;

import java.util.ArrayList;

import __0__project_dto.memberDTO;

public interface memberDAO_interface {
	
	void add(memberDTO mdto);

	void del(memberDTO mdto);

	ArrayList<memberDTO> list(String searchN);

	ArrayList<memberDTO> allList();

	void updateCerti(String name, String text, int num);

	void modPwd(String name, String pwd);
}