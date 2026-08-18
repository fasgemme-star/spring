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
		String userNo = (String) session.getAttribute("userNo");
		
		if (userNo != null) {
	        // 별도의 검색 조건이 넘어오지 않았다면 내 관련 할일만 조회되도록 기본값 설정
	        if (rDTO.getUserNo() == null && rDTO.getRepresentativeUserNo() == null) {
	            rDTO.setUserNo(userNo);
	            rDTO.setRepresentativeUserNo(userNo);
	        }
	    }
		
		System.out.println("========="+rDTO.toString());
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
	
	@PostMapping("modifyTodoStatus")
	public String modifyTodoStatus(String status, String todoNo, HttpSession sesseion) {
		ts.changeTodoStatus(status, todoNo);
		return "redirect:/todo";
	}

}
