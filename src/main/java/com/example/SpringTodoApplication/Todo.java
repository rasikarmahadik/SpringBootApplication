package com.example.SpringTodoApplication;

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
	private Date createddate;
	private Date deadline;


	public Todo(){}

	public Todo(ObjectId _id,String title,String description,Boolean completed, Date createddate,Date deadline ){
     this._id =_id;
     this.title =title;
     this.description =description;
     this.completed =completed;
     this.createddate =createddate;
     this.deadline =deadline;
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

	public void setDescription(String description) {this.description = description; }

	public Boolean getCompleted() {return completed; }

	public void setCompleted(Boolean completed) { this.completed = completed; }

	public Date getCreateddate() { return createddate; }

	public void setCreateddate(Date createddate) { this.createddate = createddate; }

	public Date getDeadline() { return deadline; }

	public void setDeadline(Date deadline) { this.deadline = deadline; }

	@Override
	public String toString() {
		return "Todo{" +
				"_id=" + _id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", completed=" + completed +
				", createddate=" + createddate +
				", deadline=" + deadline +
				'}';
	}
}
