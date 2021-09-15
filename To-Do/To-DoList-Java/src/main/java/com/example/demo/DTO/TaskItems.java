package com.example.demo.DTO;

import java.util.List;

public class TaskItems extends Task {
	
	private  List<Item> items;

	public TaskItems(int id, String name, List<Item> items) {
		super(id, name);
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	

}
