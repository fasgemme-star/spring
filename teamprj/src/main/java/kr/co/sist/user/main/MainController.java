package kr.co.sist.user.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired(required = false)
	private MainService ms;

	@GetMapping("/")
	public String main(HttpSession session) {
		session.setAttribute("userNo", "U000001");
		session.setAttribute("companyNo", "CO000001");
		session.setAttribute("user", ms.getUser("U000001"));
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
