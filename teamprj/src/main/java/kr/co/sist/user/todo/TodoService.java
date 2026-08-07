package kr.co.sist.user.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	private TodoDAO tDAO;
	
	public List<TodoDomain> getTodoList(RangeDTO rDTO) {
		List<TodoDomain> list = null;
		
		return list;
	}
	
	public TodoDomain getTodoDetail(String userNo, String todoNo) {
		TodoDomain td = null;
		return td;
	}
	
	public boolean createTodo(TodoDTO tdDTO) {
		boolean flag = false;
		return flag;
	}
	
	public boolean deleteTodo(String userNo, String todoNo) {
		boolean flag = false;
		return flag;
	}
	
	public boolean changeTodoStatus(String status, String todoNo) {
		boolean flag = false;
		return flag;
	}
	
}
