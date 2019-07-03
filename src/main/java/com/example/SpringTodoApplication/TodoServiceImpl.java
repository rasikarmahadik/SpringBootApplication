package com.example.SpringTodoApplication;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TododaoRepository dao;
	@Autowired
	MongoTemplate mongoTemplate;
	Query query =new Query();


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

	@Override
	public List<Todo> getCompletedList() {
    query.addCriteria(Criteria.where("completed").is(true));
    return  mongoTemplate.find(query,Todo.class);
	}

	@Override
	public List<Todo> getInCompletedList() {
	 query.addCriteria(Criteria.where("completed").is(false));
		return  mongoTemplate.find(query,Todo.class);
	}


}
