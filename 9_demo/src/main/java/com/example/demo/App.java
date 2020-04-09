package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.example.demo.factory.ToDoService;
import com.example.demo.factory.ToDoServiceImpl;
import com.example.demo.model.ToDo;

public class App 
{
	private ToDoService service;
	{
		service = new ToDoServiceImpl();
	}
	private static Scanner scanner = new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	int choice = 0;
		App app=new App();

		do 
		{
			System.out.println("1. Create Task.");
			System.out.println("2. Display All Task.");
			System.out.println("3.Delete");
			System.out.println("4.Update todo by name");
			System.out.print("choose your choice: ");
			choice = scanner.nextInt();
			
			switch (choice) 
			{
				case 1:
					System.out.println("Enter task name: ");
					app.service.createTask(scanner.next());
					break;
				case 2:
					Map<String, List<ToDo>> list=app.service.getAllToDo();
					for(Map.Entry<String, List<ToDo>> entry : list.entrySet())
					{
						System.out.println("Task name: "+entry.getKey());
						for(ToDo data:entry.getValue())
						{
							System.out.println("ToDo Id: "+data.getTodoId()+"ToDo Name: "+data.getTodoName());
						}
					}
					break;
				case 3:
					int option;
					do
					{
						System.out.println("1.Delete ToDo");
						System.out.println("2.Delete Task");
						System.out.println("3.Back");
						System.out.println("Enter choice");
						option = scanner.nextInt();
						switch(option)
						{
						 case 1:
							 System.out.println("Enter task name");
							 String taskName = scanner.next();
							 System.out.println("Enter name of todo to delete");
							 String todoName = scanner.next();
							 app.service.deleteTodo(taskName,todoName);
							 break;
						 case 2:
							 System.out.println("Enter task name to delete");
							 app.service.deleteTask(scanner.next());
							 break;
						 default:
							 break;
						}
					}while(option != 3);
					break;
				case 4:
					int option1;
					do
					{
						System.out.println("1.Update ToDo");
						System.out.println("2.Change Task name");
						System.out.println("3.Back");
						System.out.println("Enter choice");
						option1 = scanner.nextInt();
						switch(option1)
						{
							case 1:
								System.out.println("Enter task name to update");
								String taskName = scanner.next();
								System.out.println("Enter old name");
								String oldName = scanner.next();
								System.out.println("Enter new name");
								String newName = scanner.next();
								app.service.updateTodo(taskName,oldName, newName);
								break;
							case 2:
								System.out.println("Enter old name");
								String oldTaskName = scanner.next();
								System.out.println("Enter new name");
								String newTaskName = scanner.next();
								app.service.updateTask(oldTaskName,newTaskName);
								break;
							default:
								break;
						}
					}while(option1 != 3);
					break;
				case 0:
					System.out.println("bye.!!!!!");
					System.exit(0);
					break;
				default:
					break;
			}

		} while (choice != 0);
    }
}
