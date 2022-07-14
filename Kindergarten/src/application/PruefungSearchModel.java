package application;

public class PruefungSearchModel {
	String classNo;
	String lehrfach;
	String date;
	public PruefungSearchModel(String classNo, String lehrfach, String date) {
		super();
		this.classNo = classNo;
		this.lehrfach = lehrfach;
		this.date = date;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getLehrfach() {
		return lehrfach;
	}
	public void setLehrfach(String lehrfach) {
		this.lehrfach = lehrfach;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
