package com.example.SpringTodoApplication.controller;

import com.example.SpringTodoApplication.model.Todo;
import com.example.SpringTodoApplication.service.TodoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

	@Autowired
    TodoService service;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addtodoList(@RequestBody List<Todo> todos){
        service.createTodoList(todos);
		return "List has been created" ;
	}


	@RequestMapping(value="/", method = RequestMethod.GET)
	public Collection<Todo> getAllPets() {
		return service.getAllTodoList();
	}

	@RequestMapping(value ="/{id}", method = RequestMethod.PUT)
	public void modifyToDoListById(@PathVariable("id") ObjectId id, @Valid @RequestBody  Todo todo) {
	  todo.set_id(id);
      service.updateTodoList(todo);
	}

	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
	public void deleteTodoList(@PathVariable ObjectId id) {
		 service.deleteToList(id);
	}

}
