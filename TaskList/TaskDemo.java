package edu.orangecoastcollege.cs170.ssharif4.ic25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskDemo
{

    @SuppressWarnings("unchecked")
	public static void main(String[] args)
    {
        
    	Scanner scnr = new Scanner(System.in);
    	String deadline, duedate, name;
    	int priority;
    	
    	ArrayList<Task> TasksList = new ArrayList<>();
    	
    	File binaryFile = new File("task.dat");
    	
    	System.out.println("Previously saved Tasks from binary file:");
    	
    	if(binaryFile.exists())
    	{
    		try {
				ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
				
				TasksList = (ArrayList<Task>) fileReader.readObject();
				fileReader.close();
				
				for(Task t: TasksList)
				{
					System.out.println(t);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
    	}else
    		System.out.println("[None, please enter new Tasks]");
    	
    	do
    	{
    		System.out.print("\nPlease enter task name (or \"quit\" to exit): ");
    		name = scnr.nextLine();
    		if(name.equalsIgnoreCase("quit"))
    			break;
    		
    		System.out.print("Please enter due date (in form MM/DD/YYYY): ");
    		duedate = scnr.nextLine();
    		
    		System.out.print("Please enter deadline  :");
    		deadline = scnr.nextLine();
    		
    		System.out.print("Please enter priority: ");
    		priority = scnr.nextInt();
    		
    		TasksList.add(new Task(name, duedate, deadline, priority));
    		scnr.nextLine();
    	}while(!name.equalsIgnoreCase("quit"));
    	scnr.close();
    	
    	try
        {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(TasksList);
            fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
