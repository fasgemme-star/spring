package kr.co.sist.user.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService ts;
	
	@GetMapping("todo")
	public String showTodoPage(HttpSession session) {
		return "user/todo";
	}
	
	public String TodoList(RangeDTO rDTO, HttpSession session) {
		return "";
	}
	
	public String  addTodo(TodoDTO tdDTO, HttpSession session, Model model) {
		return "";
	}
	
	public String modifyTodo(TodoDTO tdDTO,Model model) {
		return "";
	}
	
	public String deleteTodo(String todoNo, HttpSession session) {
		return "";
	}
	
	public String modifyTodiStatus(String status, String todoNo, HttpSession sesseion) {
		return "";
	}

}
