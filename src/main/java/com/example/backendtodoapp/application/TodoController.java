package com.example.backendtodoapp.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendtodoapp.application.service.TodoService;
import com.example.backendtodoapp.domain.model.Todo;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public List<Todo> getAllTodos() {
		return todoService.findAll();
	}
	
	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		return todoService.save(todo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable Long id) {
		todoService.delete(id);
	}
	
}
