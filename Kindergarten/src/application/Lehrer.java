package application;

import java.util.ArrayList;

public class Lehrer extends Personal {
	private int id;
	private ArrayList<Klasse> klassenList = new ArrayList();
	
	
	
	
	
	public Lehrer(String name, String geschlecht, String userName, String password, int gehalt, String email,
			String telefonnummer, int id, ArrayList<Klasse> klassenList) {
		super(name, geschlecht, userName, password, gehalt, email, telefonnummer);
		this.id = id;
		this.klassenList = klassenList;
	}

	public void addKlasse(Klasse klasse) {
		this.klassenList.add(klasse);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList getKlasse() {
		return klassenList;
	}
	
	
	
}
