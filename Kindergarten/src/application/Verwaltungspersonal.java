package application;

public class Verwaltungspersonal extends Personal{
	
	private int id;
	
	

	public Verwaltungspersonal(String name, String geschlecht, String userName, String password, int gehalt,
			String email, String telefonnummer, int id) {
		super(name, geschlecht, userName, password, gehalt, email, telefonnummer);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
