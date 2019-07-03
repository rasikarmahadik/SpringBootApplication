package com.example.SpringTodoApplication;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TododaoRepository dao;

	@Override
	public void createTodoList(Todo todos){
		todos.setCreateddate(new Date());
		dao.save(todos);
	}

	@Override
	public List<Todo> getAllTodoList() {
		return dao.findAll();
	}

	@Override
	public void updateTodoList(Todo todolist){
		dao.save(todolist);
	}

	@Override
	public void deleteToList(ObjectId id ){
		dao.deleteById(id.toString());
	}


}
