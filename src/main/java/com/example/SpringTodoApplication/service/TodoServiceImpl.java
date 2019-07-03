package com.example.SpringTodoApplication.service;

import com.example.SpringTodoApplication.dao.Tododao;
import com.example.SpringTodoApplication.model.Todo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	Tododao dao;

	@Override
	public void createTodoList(List<Todo> todos){
		dao.saveAll(todos);
	}

	@Override
	public Collection<Todo> getAllTodoList() {
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

	@Override
	public void getTodaysList(){

	}
}
