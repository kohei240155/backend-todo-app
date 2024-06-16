package com.example.backendtodoapp.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendtodoapp.domain.model.Todo;
import com.example.backendtodoapp.domain.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}
	
	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public void delete(Long id) {
		todoRepository.deleteById(id);
	}
}
