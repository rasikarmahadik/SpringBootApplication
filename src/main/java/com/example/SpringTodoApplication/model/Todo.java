package com.example.SpringTodoApplication.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection= "toDoData")
public class Todo {

	@Id
	public ObjectId _id;

	private String title;
	private String description;
	private Boolean completed;
	private Date date;

	public Todo(){}

	public Todo(ObjectId _id,String title,String description,Boolean completed, Date date){
     this._id =_id;
     this.title =title;
     this.description =description;
     this.completed =completed;
     this.date =date;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return completed;
	}

	public void setStatus(Boolean status) {
		this.completed = completed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Todo{" +
				"title='" + title + '\'' +
				", description='" + description + '\'' +
				", completed=" + completed +
				", date=" + date +
				'}';
	}
}
