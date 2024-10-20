package __0__project_dto;

public class counselDTO {
	private String name = null;
	private String interest = null;
	private String memo = null;
	private String recommend = null;
	private String cs_date = null;
	private int score = 0;
	private int attitude = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getCs_date() {
		return cs_date.substring(0, 16);
	}

	public void setCs_date(String cs_date) {
		this.cs_date = cs_date;
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
		return "counselDTO [name=" + name + ", interest=" + interest + ", memo=" + memo + ", recommend=" + recommend
				+ ", cs_date=" + cs_date + ", score=" + score + ", attitude=" + attitude + "]";
	}

	

}
