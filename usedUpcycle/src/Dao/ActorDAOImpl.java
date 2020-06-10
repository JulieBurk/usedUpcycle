package consignment.usedUpcycle.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Actor;
import com.revature.util.JDBCConnection;

public class ActorDAOImpl implements ActorDAO {

	public static Connection conn = JDBCConnection.getConnection();

	public Actor getActor(int id) {

		try {

			String sql = "SELECT * FROM actors WHERE a_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, Integer.toString(id));

			// Our PreparedStatement is ready to be executed.
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// return the actor from this result set
				Actor a = new Actor(rs.getInt("A_ID"), rs.getString("NAME"), rs.getInt("AGE"), rs.getString("BIO"),
						rs.getString("GENDER"), rs.getBoolean("ALIVE"));
				return a;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Actor getActor(String name) {

		try {

			String sql = "SELECT * FROM actors WHERE name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Actor(rs.getInt("A_ID"), rs.getString("NAME"), rs.getInt("AGE"), rs.getString("BIO"),
						rs.getString("GENDER"), rs.getBoolean("ALIVE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Actor> getAllActors() {

		try {

			String sql = "SELECT * FROM actors";
			PreparedStatement ps = conn.prepareStatement(sql);

			List<Actor> actors = new ArrayList<Actor>();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				actors.add(new Actor(rs.getInt("A_ID"), rs.getString("NAME"), rs.getInt("AGE"), rs.getString("BIO"),
						rs.getString("GENDER"), rs.getBoolean("ALIVE")));
			}

			return actors;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean addActor(Actor a) {

		try {

			String sql = "CALL addActor(?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, a.getName());
			cs.setString(2, Integer.toString(a.getAge()));
			cs.setString(3, a.getBio());
			cs.setString(4, a.getGender());
//			if(a.isAlive()) {
//				cs.setString(5, "1");
//			} else {
//				cs.setString(5, "0");
//			}
			
			//Ternary Statement -> combine a simple boolean expression
			//into 1 statement
			//variable = condition ? valueIfTrue : valueIfFalse
			cs.setString(5, a.isAlive() ? "1" : "0");
			
			cs.execute();
			return true;
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateActor(Actor change) {
		
		try {
			
			String sql = "UPDATE actors SET name = ?, age = ?, bio = ?, gender = ?, alive = ? WHERE a_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getName());
			ps.setString(2, Integer.toString(change.getAge()));
			ps.setString(3, change.getBio());
			ps.setString(4, change.getGender());
			ps.setString(5, change.isAlive() ? "1" : "0");
			ps.setString(6, Integer.toString(change.getId()));
			
			ps.executeQuery();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deleteActor(int id) {
		
		try {
			
			String sql = "DELETE actors WHERE a_id = ?";
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
