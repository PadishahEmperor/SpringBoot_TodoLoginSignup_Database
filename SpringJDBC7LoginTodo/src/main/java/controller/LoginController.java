package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.LoginProcessor;

@Controller
public class LoginController {
	//DI
	private final LoginProcessor loginProcessor;

	public LoginController(LoginProcessor loginProcessor) {
		super();
		this.loginProcessor = loginProcessor;
	}
	
	@PostMapping("/")
	public String checkLogin(@RequestParam String username, @RequestParam String password,Model model) {
		
		if(this.loginProcessor.verifyCredentials(username, password)) { //returns boolean
			model.addAttribute("message", "Logged In:  "+ username);
			return "redirect:/taskManager";
		}else {
			model.addAttribute("message", "Login Failed!");
			System.out.println("See if this gets printed in console");
			//return "redirect:/";
			return "login.html";
		}
		
	}
	
	@GetMapping("/")
	public String loginPage() {
		return "login.html";
	}
	
	
}
