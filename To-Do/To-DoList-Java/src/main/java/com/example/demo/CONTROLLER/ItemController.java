package com.example.demo.CONTROLLER;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Item;
import com.example.demo.DTO.Task;
import com.example.demo.SERVICES.ItemService;

@RestController
@RequestMapping("/Api")
public class ItemController {

	
	@Autowired
	ItemService itemService;
	
	@CrossOrigin
	@GetMapping("Item")
	public List<Item> Item() {
		return itemService.listItem();
	}
	
	@CrossOrigin
	@PostMapping("Item")
	public Item addItem(@RequestBody Item Item) {
		return itemService.AddItem(Item);
	}
	
	@CrossOrigin
	@PutMapping("/Item/Update/{id}")
	public Item Actualizar(@RequestBody Item Item,@PathVariable int id) {
		return itemService.UpdateItem(Item);
	}
	
	
	@CrossOrigin
	@DeleteMapping("/Item/Delete/{id}")
	public String Delete(@PathVariable int id){
		itemService.DeleteItem(id);
		return "eleiminado";
	}
	
	
}
