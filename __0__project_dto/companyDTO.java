package __0__project_dto;

public class companyDTO {
	private String name = null;
	private String department = null;
	private int min_score = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getMin_score() {
		return min_score;
	}

	public void setMin_score(int min_score) {
		this.min_score = min_score;
	}

	@Override
	public String toString() {
		return "companyDTO [name=" + name + ", department=" + department + ", min_score=" + min_score + "]";
	}

}