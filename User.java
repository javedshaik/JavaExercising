
public class User {

	private String username;

	public User(String libUser) {
		this.username = libUser;
	}
	public User(User other){
		this.username = other.username;
	}

	public String getUser() {
		return username;
	}

	public void setUser(String libUser) {
		this.username = libUser;
	}

}
