package com.example.backendtodoapp.application.service;

import java.util.List;
import java.util.Optional;

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
	
	public Todo update(Long id, Todo updatedTodo) {
		Optional<Todo> optionalTodo = todoRepository.findById(id);
		if (optionalTodo.isPresent()) {
			Todo existingTodo = optionalTodo.get();
			existingTodo.setTitle(updatedTodo.getTitle());
			existingTodo.setCompleted(updatedTodo.isCompleted());
			existingTodo.setUpdatedAt(updatedTodo.getUpdatedAt());
			return todoRepository.save(existingTodo);
		} else {
			throw new RuntimeException("Todo not found with id " + id);
		}
	}
	
	public Todo findById(Long id) {
		return todoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Todo not found with id " + id));
	}
}
