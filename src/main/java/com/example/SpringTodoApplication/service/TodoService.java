package com.example.SpringTodoApplication.service;

import com.example.SpringTodoApplication.model.Todo;
import org.bson.types.ObjectId;

import java.util.Collection;
import java.util.List;


public interface TodoService {

	public void createTodoList(List<Todo> todos);

	public Collection<Todo> getAllTodoList();

	public void updateTodoList(Todo todolist);

	public void deleteToList(ObjectId id );

	public void getTodaysList();

}
