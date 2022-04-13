package application;

public class Schueler extends Person{

	private int Alter;
	private int id;
	
	
	
	public Schueler(String name, String geschlecht, int alter, int id) {
		super(name, geschlecht);
		Alter = alter;
		this.id = id;
	}
	public int getAlter() {
		return Alter;
	}
	public void setAlter(int alter) {
		Alter = alter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
