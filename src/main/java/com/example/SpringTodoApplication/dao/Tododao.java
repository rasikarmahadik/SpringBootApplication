package com.example.SpringTodoApplication.dao;

import com.example.SpringTodoApplication.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface Tododao extends MongoRepository<Todo,String> {

}
