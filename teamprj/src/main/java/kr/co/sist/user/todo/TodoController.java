package kr.co.sist.user.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class TodoController {
	
	@GetMapping("Todo")
	public String showTodoPage(HttpSession session) {
		return "";
	}
	
	

}
