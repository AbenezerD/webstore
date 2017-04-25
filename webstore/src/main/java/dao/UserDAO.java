package dao;

import java.util.HashMap;

public class UserDAO {
	public HashMap<String, String> setOfUsers(){
		HashMap<String, String> vUsers = new HashMap<>();
		vUsers.put("esa", "123");
		vUsers.put("ab", "456");
		vUsers.put("guest", "111");
		return vUsers;
	}

}
