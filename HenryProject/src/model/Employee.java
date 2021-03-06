package model;

public class Employee implements java.io.Serializable {
	private int id;
	private String name;
	private int gender;
	
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "id=" + id + "; name=" + name + "; gender=" + gender + "\n";
	}
}
