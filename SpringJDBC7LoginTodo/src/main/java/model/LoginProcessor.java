package model;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import repositories.LoginDataRepository;
//import repositories.TaskRepository;
import services.LoginManagementService;
import services.TaskService;

//Define Scope
//Add it to Spring Context, make it a bean
@RequestScope
@Component
public class LoginProcessor {
	private String username;
	private String password;
	private long userId;
	
	//DI: LoginMangementService
	// Add a bean of task manager as well, i guess
	private final LoginManagementService loginManagementService;
	private final LoginDataRepository loginDataRepository;
	//private final TaskService taskService;
	
	//Constructor
	@Autowired
	public LoginProcessor(LoginManagementService loginManagementService, LoginDataRepository loginDataRepository, TaskService taskService) {
		super();
		this.loginManagementService = loginManagementService;
		this.loginDataRepository = loginDataRepository;
		//this.taskService = taskService;
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
	
	
	
	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public boolean verifyCredentials(String email, String password) { // 
		
		/*if(username.equals("vishal") && password.equals("pass123")) {
			this.loginManagementService.setUsername(username);
			return true;
		}else {
			return false;
		}*/
		
		User user = new User();
		
		user.setEmail(email);
		user.setPassword(password);
		
		
		User userData = this.loginDataRepository.getUser(user);
		// UserData has- id, email, pass
		
		
		if(userData == null) {
			return false;
		}
		
		this.loginManagementService.setUsername(email); // For session
		this.loginManagementService.setUserId(userData.getId());
		//this.userId = userData.getId();
		return true;
	}
	
	/*public List<Task> getTasks() {

		return this.taskService.getTasks(this.userId);
	}
	
	public void addTask(String task) {
		this.taskService.addTask(this.userId, task);
	}*/
	
}
