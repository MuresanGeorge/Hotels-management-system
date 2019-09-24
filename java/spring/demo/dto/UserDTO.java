package spring.demo.dto;

public class UserDTO {

	private Integer id;
	private String username;
	private String password;
	private Integer role;


	public UserDTO() {
	}

	public UserDTO(Integer id, String username, String password, Integer role) {
		super();
		this.id = id;
		this.username= username;
		this.password = password;
		this.role = role;

	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class Builder {
		private Integer nestedid;
		private String nestedusername;
		private String nestedpassword;
		private Integer nestedrole;


		public Builder id(Integer id) {
			this.nestedid = id;
			return this;
		}
		public Builder role(Integer role) {
			this.nestedrole = role;
			return this;
		}

		public Builder username(String username) {
			this.nestedusername= username;
			return this;
		}
		
		public Builder password(String password) {
			this.nestedpassword = password;
			return this;
		}

		public UserDTO create() {
			return new UserDTO(nestedid, nestedusername,nestedpassword, nestedrole);
		}

	}


	@Override
	public String toString() {
		return "UserDTO{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				'}';
	}
}
