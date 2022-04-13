package application;

public class Eltern extends Person {
	private String telefonNummer;
	private int id;
	private int schuld;
	
	
	
	
	public Eltern(String name, String geschlecht, String telefonNummer, int id, int schuld) {
		super(name, geschlecht);
		this.telefonNummer = telefonNummer;
		this.id = id;
		this.schuld = schuld;
	}
	protected String getTelefonNummer() {
		return telefonNummer;
	}
	protected void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
	}
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected int getSchuld() {
		return schuld;
	}
	protected void setSchuld(int schuld) {
		this.schuld = schuld;
	}
	
	
}
