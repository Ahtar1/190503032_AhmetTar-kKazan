package application;

public class Personal extends Person{
	private String userName;
	private String password;
	private int gehalt;
	private String email;
	private String telefonnummer;
	
	
	
	
	public Personal(String name, String geschlecht, String userName, String password, int gehalt, String email,
			String telefonnummer) {
		super(name, geschlecht);
		this.userName = userName;
		this.password = password;
		this.gehalt = gehalt;
		this.email = email;
		this.telefonnummer = telefonnummer;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGehalt() {
		return gehalt;
	}
	public void setGehalt(int gehalt) {
		this.gehalt = gehalt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	
}
