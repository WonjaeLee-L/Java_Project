package __0__project_dto;

public class certificateDTO {
	private String name = null;
	private String name_1 = null;
	private int point_1 = 0;
	private String name_2 = null;
	private int point_2 = 0;
	private int total_point = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_1() {
		return name_1;
	}

	public void setName_1(String name_1) {
		this.name_1 = name_1;
	}

	public int getPoint_1() {
		return point_1;
	}

	public void setPoint_1(int point_1) {
		this.point_1 = point_1;
	}

	public String getName_2() {
		return name_2;
	}

	public void setName_2(String name_2) {
		this.name_2 = name_2;
	}

	public int getPoint_2() {
		return point_2;
	}

	public void setPoint_2(int point_2) {
		this.point_2 = point_2;
	}

	public int getTotal_point() {
		return total_point;
	}

	public void setTotal_point(int total_point) {
		this.total_point = total_point;
	}

	@Override
	public String toString() {
		return "certificateDTO [name=" + name + ", name_1=" + name_1 + ", point_1=" + point_1 + ", name_2=" + name_2
				+ ", point_2=" + point_2 + ", total_point=" + total_point + "]";
	}

}
