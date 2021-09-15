package com.example.demo.DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	private int id;
	private String name;
	
	public Task(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Task() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + "]";
	}
	

}
