package com.example.demo.CONTROLLER;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Task;
import com.example.demo.DTO.TaskItems;
import com.example.demo.SERVICES.TaskService;

@RestController
@RequestMapping("/Api")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@CrossOrigin
	@GetMapping("/Task")
	public List<TaskItems> listTask(){
		return taskService.list();
	}
	
	@CrossOrigin
	@PostMapping("/Task")
	public Task addTask(@RequestBody Task task){
		return taskService.add(task);
	}

	@CrossOrigin
	@DeleteMapping("/Task/{id}")
	public void Delete(@PathVariable int id){
		taskService.delete(id);
	}
	
	

}
