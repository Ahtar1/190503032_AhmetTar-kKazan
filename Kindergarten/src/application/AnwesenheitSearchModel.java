package application;

public class AnwesenheitSearchModel {

	String studentid;
	String TagZahl;
	public AnwesenheitSearchModel(String studentid, String tagZahl) {
		super();
		this.studentid = studentid;
		TagZahl = tagZahl;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getTagZahl() {
		return TagZahl;
	}
	public void setTagZahl(String tagZahl) {
		TagZahl = tagZahl;
	}
	
	
	
	
}
