package services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service //bean
@SessionScope
public class LoginManagementService {
	private String username;
	private long userId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserId(long id) {
		// TODO Auto-generated method stub
		this.userId = id;
	}
	
	public long getUserId() {
		return this.userId;
	}
	
}
