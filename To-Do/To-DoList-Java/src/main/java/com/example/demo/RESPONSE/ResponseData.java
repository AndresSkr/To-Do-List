package com.example.demo.RESPONSE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.DTO.Task;
import com.example.demo.DTO.TaskItems;
import com.example.demo.DTO.Item;

public class ResponseData {

	public ResponseData() {
	}
	
	/*Metodo para retornar la Data Ordenada*/
	public List<TaskItems> configData(List<Task> lstTask, List<Item> lstItem) {
		
		List<TaskItems> lstTaskResponse = new ArrayList<TaskItems>();
		lstTask.forEach((element)->{
			
			int idTask = element.getId();
			String nameTask = element.getName();
			
			List<Item> itemsResponse  = lstItem.stream().filter(p -> p.getTaskCode().getId()==idTask).collect(Collectors.toList());
			
			lstTaskResponse.add(new TaskItems(idTask,nameTask , itemsResponse));
		});
		return lstTaskResponse;
		
	}
	

}
