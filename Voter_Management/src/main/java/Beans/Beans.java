package Beans;

import java.sql.SQLException;

import dao.UserDao;
import dao.UserDaoImpl;
import pojos.User;

public class Beans {
	private String email;
	private String password;
//	dependency : user dao
	private UserDaoImpl userDao;
	//	user details : User pojo
	private User userDetails;
//	add a property to store a message
	private String message;
	public Beans() throws SQLException {
		userDao=new UserDaoImpl();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
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
	
	public String validateUser() throws SQLException {
		userDetails=userDao.authenticateUser(email, password);
		if(userDetails==null) {
			message="Invalid login, please try again";
			return "login";
		}
		message="Login successfully...!";
		if(userDetails.getRole().equals("admin"))
			return "admin_page";
		if(userDetails.isVotingStatus())
			return "logout";
		return "candidate_list";
	}
	
}
