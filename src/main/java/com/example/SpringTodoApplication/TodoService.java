package com.example.SpringTodoApplication;

import com.example.SpringTodoApplication.Todo;
import org.bson.types.ObjectId;

import java.util.List;


public interface TodoService {

	public void createTodoList(Todo todos);

	public List<Todo> getAllTodoList();

	public void updateTodoList(Todo todolist);

	public void deleteToList(ObjectId id );

	public List<Todo> getCompletedList();

	public List<Todo> getInCompletedList();

	public List<Todo> getTodaysToDoList();

	public List<Todo> getTomorrowToDoList();

}
