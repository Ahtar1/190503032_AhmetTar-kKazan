package application;

public class NoteSearchModel {
	String studentID;
	String sport;
	String math;
	String drama;
	String musik;
	String zeichnen;
	
	public NoteSearchModel(String studentID,String sport,String math,String drama,String musik,String zeichnen) {
		this.studentID = studentID;
		this.sport = sport;
		this.math = math;
		this.drama = drama;
		this.musik = musik;
		this.zeichnen = zeichnen;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentId) {
		this.studentID = studentId;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getDrama() {
		return drama;
	}

	public void setDrama(String drama) {
		this.drama = drama;
	}

	public String getMusik() {
		return musik;
	}

	public void setMusik(String musik) {
		this.musik = musik;
	}

	public String getZeichnen() {
		return zeichnen;
	}

	public void setZeichnen(String zeichnen) {
		this.zeichnen = zeichnen;
	}
	
}
