package com.example.demo.SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.IItemDAO;
import com.example.demo.DTO.Item;

@Service
public class ItemService {

	
	@Autowired
	IItemDAO itemDao;
	
	public List<Item> listItem(){
		return itemDao.findAll();
	}
	
	public Item AddItem(Item item) {
		return itemDao.save(item);
	}
	
	public Item UpdateItem(Item itemUpdate) {
		return itemDao.save(itemUpdate);
	}
	
	
	public void DeleteItem(int idItemDelete) {
		 itemDao.deleteById(idItemDelete);
	}
}
