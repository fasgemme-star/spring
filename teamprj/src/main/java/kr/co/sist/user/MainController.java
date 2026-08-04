package kr.co.sist.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main() {
		return "redirect:index.html";
	}
	
	@GetMapping("policy/infou")
	public String showPolicy() {
		return "policy/infou";
	}
	
	@GetMapping("policy/terms")
	public String showTerms() {
		return "policy/terms";
	}
}
