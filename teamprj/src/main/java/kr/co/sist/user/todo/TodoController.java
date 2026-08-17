package kr.co.sist.user.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService ts;
	
	@GetMapping("todo")
	public String showTodoPage(RangeDTO rDTO, HttpSession session, Model model) {
		System.out.println(rDTO.toString());
		model.addAttribute("todoList", ts.getTodoList(rDTO));
		return "user/todo";
	}
	
	@PostMapping("addTodo")
	public String  addTodo(TodoDTO tdDTO, HttpSession session, Model model) {
		tdDTO.setUserNo((String) session.getAttribute("userNo"));
		ts.createTodo(tdDTO);
		return "redirect:/todo";
	}
	
	
	public String deleteTodo(String todoNo, HttpSession session) {
		ts.deleteTodo((String)session.getAttribute("userNo"), todoNo);
		return "";
	}
	
	public String modifyTodiStatus(String status, String todoNo, HttpSession sesseion) {
		return "";
	}

}
