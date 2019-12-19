package model;

public class User {
	private int id;
	private String email;
	private String password;
	private String location;
	private String gender;
	private String comment;
	
	
	
	public User() {
		super();
	}
	public User( String email, String password, String location, String gender, String comment) {
		this.email = email;
		this.password = password;
		this.location = location;
		this.gender = gender;
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", location='" + location + '\'' +
				", gender='" + gender + '\'' +
				", comment='" + comment + '\'' +
				'}';
	}
}
