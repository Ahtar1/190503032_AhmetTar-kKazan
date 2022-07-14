package application;

public class StudentSearchModel {

	int studentID;
	String name;
	int age;
	String classNo;
	
	public StudentSearchModel(int queryid,String name,int queryAge,String classNo) {
		this.studentID = queryid;
		this.name = name;
		this.age = queryAge;
		this.classNo = classNo;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	
	
}
