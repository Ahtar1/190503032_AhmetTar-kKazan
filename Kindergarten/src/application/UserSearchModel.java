package application;

public class UserSearchModel {
	String user_ID;
	String name;
	String role;
	
	public UserSearchModel(String user_ID,String name,String role) {
		this.user_ID = user_ID;
		this.name = name;
		this.role = role;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
