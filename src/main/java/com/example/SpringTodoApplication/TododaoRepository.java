package com.example.SpringTodoApplication;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TododaoRepository extends MongoRepository<Todo,String> {


}
