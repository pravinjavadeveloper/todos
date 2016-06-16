package com.pic.todos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pic.todos.dao.TodoDao;
import com.pic.todos.model.Todo;
import com.pic.todos.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDao todoDao;

	@Override
	public List<Todo> getAllTodos() {
		return todoDao.getAllTodos();
	}

}
