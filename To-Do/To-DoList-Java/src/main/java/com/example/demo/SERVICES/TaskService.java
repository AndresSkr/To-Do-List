package com.example.demo.SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.IItemDAO;
import com.example.demo.DAO.ITaskDAO;
import com.example.demo.DTO.Item;
import com.example.demo.DTO.Task;
import com.example.demo.DTO.TaskItems;
import com.example.demo.RESPONSE.ResponseData;

@Service
public class TaskService {
	
	@Autowired
	ITaskDAO iTaskDao;
	@Autowired
	IItemDAO iItemDao;
	
	
	ResponseData response = new ResponseData();
	
	public List<TaskItems> list(){

		List<Task> lstTask = iTaskDao.findAll();
		List<Item> lstItem = iItemDao.findAll();
		
		List<TaskItems> lstResponse = response.configData(lstTask, lstItem);
		
	
		return lstResponse;
	}
	
	public Task add(Task task) {
		return iTaskDao.save(task);
	}
	
	public void delete(int id) {
		 iTaskDao.deleteById(id);
	}

}
