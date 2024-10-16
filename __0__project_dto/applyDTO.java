package __0__project_dto;

public class applyDTO {
	private String name = null;
	private String a_date = null;
	private String accept = null;
	private String ac_date = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getA_date() {
		return a_date;
	}

	public void setA_date(String a_date) {
		this.a_date = a_date;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAc_date() {
		return ac_date;
	}

	public void setAc_date(String ac_date) {
		this.ac_date = ac_date;
	}

	@Override
	public String toString() {
		return "applyDTO [name=" + name + ", a_date=" + a_date + ", accept=" + accept + ", ac_date=" + ac_date + "]";
	}

}
