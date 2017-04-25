package model;

public class User {
	String username;
	String password;

	public User(String u, String p) {
		username = u;
		password = p;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User))
			return false;
		User user = (User) obj;
		return user.getUsername().equals(this.username) 
				&& user.getPassword().equals(this.password);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result += 31 * this.username.hashCode();
		result += 31 * this.password.hashCode();
		return result;
	}

}
