package __0__project_dto;

public class memberDTO {
	private String name = null;
	private String id = null;
	private String password = null;
	private String id_num = null;
	private String cer_name_1 = null;
	private String cer_name_2 = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId_num() {
		return id_num;
	}

	public void setId_num(String id_num) {
		this.id_num = id_num;
	}

	public String getCer_name_1() {
		return cer_name_1;
	}

	public void setCer_name_1(String cer_name_1) {
		this.cer_name_1 = cer_name_1;
	}

	public String getCer_name_2() {
		return cer_name_2;
	}

	public void setCer_name_2(String cer_name_2) {
		this.cer_name_2 = cer_name_2;
	}

	@Override
	public String toString() {
		return "이름 :" + name + ", 아이디 :" + id + ", 주민등록번호 :" + id_num.substring(0, 8).concat("*") + ", 자격증 :"
				+ cer_name_1 + ", 자격증 :" + cer_name_2 + "]";
	}

}