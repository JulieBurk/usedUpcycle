package consignment.usedUpcycle.Dao;

import java.util.List;

import com.revature.models.Actor;

public interface ActorDAO {

	//CRUD Operations
	//CREATE, READ, UPDATE, and DELETE
	
	public Actor getActor(int id);
	public Actor getActor(String name);
	public List<Actor> getAllActors();
	public boolean addActor(Actor a);
	public boolean updateActor(Actor change);
	public boolean deleteActor(int id);
	
}
