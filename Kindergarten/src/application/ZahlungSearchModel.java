package application;

public class ZahlungSearchModel {
	String studentid;
	String elternName;
	String gezahltBetrag;
	String ungezahltBetrag;
	public ZahlungSearchModel(String studentid, String elternName, String gezahltBetrag, String ungezahltBetrag) {
		super();
		this.studentid = studentid;
		this.elternName = elternName;
		this.gezahltBetrag = gezahltBetrag;
		this.ungezahltBetrag = ungezahltBetrag;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getElternName() {
		return elternName;
	}
	public void setElternName(String elternName) {
		this.elternName = elternName;
	}
	public String getGezahltBetrag() {
		return gezahltBetrag;
	}
	public void setGezahltBetrag(String gezahltBetrag) {
		this.gezahltBetrag = gezahltBetrag;
	}
	public String getUngezahltBetrag() {
		return ungezahltBetrag;
	}
	public void setUngezahltBetrag(String ungezahltBetrag) {
		this.ungezahltBetrag = ungezahltBetrag;
	}

	
	
	
	
}
