package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.model.ToDo;

public interface ToDoDao 
{
	public void createTask(String name);
	public Map<String, List<ToDo>> getAllToDo();
	public void deleteTask(String taskName);
	public void deleteTodo(String taskName,String todoName);
	public void updateTodo(String taskName,String todoName,String newTodoName);
	public void updateTask(String oldName,String newName);
}
