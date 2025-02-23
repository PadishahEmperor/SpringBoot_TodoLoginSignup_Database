package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import model.User;
import repositories.SignUpRepository;

@Controller
public class SignupController {
	private final SignUpRepository signUpRepository;
	
	
	public SignupController(SignUpRepository signUpRepository) {
		super();
		this.signUpRepository = signUpRepository;
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup.html";
	}
	
	@PostMapping("/signup")
	public String signup2(@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model) {
		User user = new User();
		user.setEmail(email);
		user.setName(username);
		user.setPassword(password);
		this.signUpRepository.storeSignupData(user);
		
		return "login.html";
	}
}
