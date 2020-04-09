package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.model.Task;
import com.example.demo.model.ToDo;

public class ToDoDaoImpl implements ToDoDao
{
	Task task;
	{
		task = new Task();
	}
	@Override
	public void createTask(String taskName)
	{
		task.createTask(taskName);
	}

	@Override
	public Map<String, List<ToDo>> getAllToDo() 
	{
		return task.getAllToDo();
	}

	@Override
	public void deleteTodo(String taskName,String todoName) 
	{
		task.deleteTodo(taskName, todoName);
	}

	@Override
	public void updateTodo(String taskName,String todoName, String newTodoName) 
	{
		task.updateTodo(taskName,todoName, newTodoName);
	}

	@Override
	public void deleteTask(String taskName)
	{
		task.deleteTask(taskName);
	}

	@Override
	public void updateTask(String oldName, String newName) 
	{
		task.updateTask(oldName, newName);
	}
}
