package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DTO.Task;

public interface ITaskDAO extends JpaRepository<Task, Integer> {

}
