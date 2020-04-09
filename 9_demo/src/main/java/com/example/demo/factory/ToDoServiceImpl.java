package com.example.demo.factory;

import java.util.List;
import java.util.Map;

import com.example.demo.dao.ToDoDao;
import com.example.demo.dao.ToDoDaoImpl;
import com.example.demo.model.ToDo;

public class ToDoServiceImpl implements ToDoService
{
	ToDoDao todoDao;
	{
		todoDao = new ToDoDaoImpl();
	}
	@Override
	public void createTask(String taskName) 
	{
		todoDao.createTask(taskName);
	}

	@Override
	public Map<String, List<ToDo>> getAllToDo() 
	{
		return todoDao.getAllToDo();
	}

	@Override
	public void deleteTodo(String taskName,String todoName) 
	{
		todoDao.deleteTodo(taskName,todoName);
	}

	@Override
	public void updateTodo(String taskName,String todoName, String newTodoName) 
	{
		todoDao.updateTodo(taskName,todoName, newTodoName);
	}

	@Override
	public void deleteTask(String taskName) 
	{
		todoDao.deleteTask(taskName);
	}

	@Override
	public void updateTask(String oldName, String newName)
	{
		todoDao.updateTask(oldName, newName);
	}
	
	
}
