package application;

public class ElternSearchModel {
	String studentid;
	String ElternName;
	String ElternNo;
	public ElternSearchModel(String studentid, String elternName, String elternNo) {
		super();
		this.studentid = studentid;
		ElternName = elternName;
		ElternNo = elternNo;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getElternName() {
		return ElternName;
	}
	public void setElternName(String elternName) {
		ElternName = elternName;
	}
	public String getElternNo() {
		return ElternNo;
	}
	public void setElternNo(String elternNo) {
		ElternNo = elternNo;
	}
	
	
}
