package com.pic.todos.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pic.todos.dao.TodoDao;
import com.pic.todos.model.Todo;

@Repository
public class TodoDaoImpl implements TodoDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	@Override
	public List<Todo> getAllTodos() {
		System.out.println(hibernateTemplate.getMaxResults());
		List<Todo> list = new ArrayList<Todo>();
		list.add(new Todo("Arvind", new Date()));
		return list;
	}

}
