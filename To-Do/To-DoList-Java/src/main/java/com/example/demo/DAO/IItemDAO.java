package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.DTO.Item;

public interface IItemDAO extends JpaRepository<Item, Integer>{

	
	@Query(value ="select t.name as task, i.name as nameItem "
			+ "from task t inner join "
			+ "item i on "
			+ "t.Id= i.taskCode",
			nativeQuery = true) 
	List<String> findTaskItems();
}
