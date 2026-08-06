package kr.co.sist.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("/policy/privacy")
	public String showPolicy() {
		return "policy/privacy";
	}
	
	@GetMapping("/policy/terms")
	public String showterms() {
		return "policy/terms";
	}
	
	
}
