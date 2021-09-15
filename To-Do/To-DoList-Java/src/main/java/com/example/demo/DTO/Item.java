package com.example.demo.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	private int Id;
	
	@ManyToOne
	@JoinColumn(name= "taskcode")
	private Task taskCode;
	
	private String name;
	private boolean done;
	public Item(int id, Task taskCode, String name, boolean done) {
		Id = id;
		this.taskCode = taskCode;
		this.name = name;
		this.done = done;
	}
	
	public Item() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Task getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(Task taskCode) {
		this.taskCode = taskCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Item [Id=" + Id + ", taskCode=" + taskCode + ", name=" + name + ", done=" + done + "]";
	}
	
	
}
