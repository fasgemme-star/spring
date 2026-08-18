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
	
	@GetMapping("login")
	public String login() {
		return "user/login";
	}
	@GetMapping("getAdmin")
	public String getAdmin(HttpSession session) {
		session.setAttribute("userNo", "U000001");
		session.setAttribute("companyNo", "CO000001");
		session.setAttribute("user", ms.getUser((String)session.getAttribute("userNo")));
		return "index";
	}
	@GetMapping("getUser")
	public String getUser(HttpSession session) {
		session.setAttribute("userNo", "U000002");
		session.setAttribute("companyNo", "CO000001");
		session.setAttribute("user", ms.getUser((String)session.getAttribute("userNo")));
		return "index";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
