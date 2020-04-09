package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task 
{
	//private String taskId;
	//Making a new HashMap.
	private Map<String, List<ToDo>> tasks;
	{
		tasks = new HashMap<String,List<ToDo>>();
	}
	
	//Function to create a new task.
	public void createTask(String taskName)
	{
		tasks.put(taskName, createTodo());
	}
	
	//Function to add create Todos.
	public List<ToDo> createTodo()
	{
		Scanner scanner = new Scanner(System.in);
		List<ToDo> todos = new ArrayList<ToDo>();
		int choice;
		do
		{
			System.out.println("1.Add todo");
			System.out.println("2.Exit");
			System.out.println("Enter choice");
			choice = scanner.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Enter todo name: ");
					todos.add(new ToDo(scanner.next()));
					break;
				default:
					break;
			}
		}while(choice != 2);
		return todos;
	}
	
	//Function to get all tasks
	public Map<String, List<ToDo>> getAllToDo()
	{
		return tasks;
	}
	
	//Function to remove a todo.
	public void deleteTodo(String taskName, String todoName)
	{
		for(ToDo todo: tasks.get(taskName))
		{
			if(todo.getTodoName().equals(todoName))
			{
				tasks.get(taskName).remove(todo);
				break;
			}
		}
	}
	
	//Function to remove a task.
	public void deleteTask(String taskName)
	{
		tasks.remove(taskName);
	}
	
	//Function to update a todo.
	public void updateTodo(String taskName,String todoName,String newTodoName)
	{
		 for(ToDo todo:tasks.get(taskName))
		{
			if(todo.getTodoName().equals(todoName))
			{
				todo.setTodoName(newTodoName);
				break;
			}
		}
	}
	
	//Function to update tasks.
	public void updateTask(String oldName,String newName)
	{
		tasks.put(newName, tasks.get(oldName));
		tasks.remove(oldName);
	}
}
