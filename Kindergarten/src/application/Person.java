package application;

public class Person {
	
	private String name;
	private String geschlecht;
	
	
	public Person() {
		
	}
	public Person(String name, String geschlecht) {
		this.name = name;
		this.geschlecht = geschlecht;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	
	
}
