package __0__project_dto;

public class memberDTO {
	private String name = null;
	private String id = null;
	private String password = null;
	private String id_num = null;
	private int score = 0;
	private int attitude = 0;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAttitude() {
		return attitude;
	}

	public void setAttitude(int attitude) {
		this.attitude = attitude;
	}

	@Override
	public String toString() {
		return "memberDTO [name=" + name + ", id=" + id + ", password=" + password + ", id_num=" + id_num + ", score="
				+ score + ", attitude=" + attitude + "]";
	}

}
