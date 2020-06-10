package consignment.usedUpcycle.dao;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {

	public User getUser(int id);
	public User getUser(String username);
	public List<User> getAllUsers();
	public boolean addUser(User u);
	public boolean updateUser(User change);
	public boolean deleteUser(int id);
	
}
