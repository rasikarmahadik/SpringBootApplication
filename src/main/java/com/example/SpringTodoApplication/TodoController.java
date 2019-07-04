package com.example.SpringTodoApplication;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

	@Autowired
	TodoService service;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/getTodolist", method = RequestMethod.GET)
	public List<Todo> getAllTodoList() {
		logger.debug("Getting all The ToDoList.");
		return service.getAllTodoList();
	}

	@RequestMapping(value = "/createTodoList", method = RequestMethod.POST)
	public String addtodoList(@RequestBody Todo todos){
		logger.debug("Saving List.");
        service.createTodoList(todos);
		return "List has been created" ;
	}


	@RequestMapping(value ="/updateToDoList/{id}", method = RequestMethod.PUT)
	public String modifyToDoListById(@PathVariable("id") ObjectId id, @Valid @RequestBody  Todo todo) {
	  todo.set_id(id);
      service.updateTodoList(todo);
		return "TodoList with list-id= " + id + " updated.";
	}

	@RequestMapping(value ="/deleteToDoList/{id}", method = RequestMethod.DELETE)
	public String deleteTodoList(@PathVariable ObjectId id) {
		logger.debug("Deleting Todolist with list-id= {}.", id);
		 service.deleteToList(id);
		return "TodoList with list-id= " + id + " deleted.";
	}

	@RequestMapping(value="/getCompletedTodolist", method = RequestMethod.GET)
	public List<Todo> getCompletedList() {
		logger.debug("Getting all The Completed ToDoList.");
		return service.getCompletedList();
	}

	@RequestMapping(value="/getInCompletedTodolist", method = RequestMethod.GET)
	public List<Todo> getInCompletedList() {
		logger.debug("Getting all The Incomplete ToDoList.");
		return service.getInCompletedList();
	}

	@RequestMapping(value="/getTodaysTodolist", method = RequestMethod.GET)
	public List<Todo> getTodaysList() {
		logger.debug("Getting all todays ToDoList.");
		return service.getTodaysToDoList();
	}


	@RequestMapping(value="/getTomorrowTodolist", method = RequestMethod.GET)
	public List<Todo> getTomorrowToDoList() {
		logger.debug("Getting all tomorrow's ToDoList.");
		return service.getTomorrowToDoList();
	}



}
