package consignment.usedUpcycle.models;

public class Actor {

	private int id;
	private String name;
	private int age;
	private String bio;
	private String gender;
	private boolean alive;
	
	public Actor() {
		super();
	}

	public Actor(int id, String name, int age, String bio, String gender, boolean alive) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.bio = bio;
		this.gender = gender;
		this.alive = alive;
	}

	//Id-less Constructor. It allows me to make an object
	//without the ID, which will be handled by our Sequence
	public Actor(String name, int age, String bio, String gender, boolean alive) {
		super();
		this.name = name;
		this.age = age;
		this.bio = bio;
		this.gender = gender;
		this.alive = alive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", age=" + age + ", bio=" + bio + ", gender=" + gender
				+ ", alive=" + alive + "]";
	}
	
}
