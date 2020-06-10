package consignment.usedUpcycle.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.JDBCConnection;

public class UserDAOImpl implements UserDAO {

	public static Connection conn = JDBCConnection.getConnection();

	public User getUser(int id) {

		try {
			String sql = "SELECT * FROM users WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new User(rs.getInt("U_ID"), 
						rs.getString("USERNAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("EMAIL"), 
						rs.getLong("PHONE"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public User getUser(String username) {

		try {
			
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new User(rs.getInt("U_ID"), 
						rs.getString("USERNAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("EMAIL"), 
						rs.getLong("PHONE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getAllUsers() {

		try {
			
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			List<User> userList = new ArrayList<User>();
			
			while(rs.next()) {
				userList.add(new User(rs.getInt("U_ID"), 
						rs.getString("USERNAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("EMAIL"), 
						rs.getLong("PHONE")));
			}
			
			return userList;
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addUser(User u) {

		try {
			
			String sql = "CALL addUser(?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, u.getEmail());
			cs.setString(4, Long.toString(u.getPhone()));
			
			cs.execute();
			return true;
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User change) {
		
		try {
			
			String sql = "UPDATE users SET username = ?, password = ?, email = ?, phone = ? WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getUsername());
			ps.setString(2, change.getPassword());
			ps.setString(3, change.getEmail());
			ps.setString(4, Long.toString(change.getPhone()));
			ps.setString(5, Integer.toString(change.getId()));
			
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int id) {
		
		try {
			
			String sql = "DELETE users WHERE u_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(id));
			
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
