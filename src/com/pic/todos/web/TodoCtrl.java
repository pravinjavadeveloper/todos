package com.pic.todos.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pic.todos.model.Todo;
import com.pic.todos.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoCtrl {

	@Autowired
	private TodoService todoService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Todo> addTodo() {
		return todoService.getAllTodos();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Todo> updateTodo() {
		return todoService.getAllTodos();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Todo> deleteTodo() {
		return todoService.getAllTodos();
	}*/
	
	
}
