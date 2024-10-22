package __0__project_dto;

public class blockedDTO {

	private String b_name = null;
	private String id_num = null;

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getId_num() {
		return id_num;
	}

	public void setId_num(String id_num) {
		this.id_num = id_num;
	}

	@Override
	public String toString() {
		return "blockedDTO [b_name=" + b_name + ", id_num=" + id_num + "]";
	}

}