package consignment.usedUpcycle.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.User;

public class LoginService {
	
	/*
	 * This Class and by extension, this layer,
	 * is where all of our larger functionality should exist.
	 * Meaning, we can make calls to our DAOs to retrieve
	 * data, and then do something with it here.
	 */
	
	//fields for each DAO that we want access to in this
	//class. So we at least need a UserDAO
	
	public static UserDAO ud = new UserDAOImpl();
	
	//Now we can make methods to do some real work.
	public static boolean login(User u) {
		
		//A side question, ignore otherwise
//		List<User> users = new ArrayList<User>();
//		if(users.contains(u)) {
//			//some code;
//		}
		
		User currentUser = ud.getUser(u.getUsername());
		
		if(currentUser == null) {
			return false;
		} else if(currentUser.getPassword().equals(u.getPassword())) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static User getUser(String username) {
		return ud.getUser(username);
	}

	
	public static User register(User u) {
		
		//With no input validation, this becomes a
		//very basic service.
		if(ud.addUser(u)) {
			return ud.getUser(u.getUsername());
		} else {
			return null;
		}
		
	}
}
