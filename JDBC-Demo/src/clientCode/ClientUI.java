package clientCode;

import java.util.List;
import java.util.Scanner;

import bclass.Instructor;
import db.DatabaseOperationsDAOImpl;

public class ClientUI {

	DatabaseOperationsDAOImpl obj ;
	
	Scanner sc;
	
	public ClientUI()throws Exception 
	{
		super();
		obj = new DatabaseOperationsDAOImpl();
		sc = new Scanner(System.in);
	}


	public static void main(String[] args) {
		try 
		{
			ClientUI browserClient = new ClientUI();
			
			//browserClient.insertInstructor();
		
			browserClient.getAllInstructors();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public void insertInstructor()throws Exception
	{
		Instructor mike = new Instructor();
		mike.setInstructorcode(1150);
		mike.setName("Mike");
		mike.setSalary(2000);
		mike.setJobstartyear(2019);
		
		
		boolean status = obj.doInsertIntoInstructor(mike);
		System.out.println(" Data Insertion Status : "+status);
	}
	
	public void getAllInstructors()throws Exception
	{
		List<Instructor> list = obj.getInstructors();
		
		if(list.isEmpty())
		{
			System.out.println(" ----- No Data Found ----");
		}
		else
		{
			for (Instructor instructor : list) {
				System.out.println(instructor);
			}
		}
		
	}
	
	
	
	
	
	
}//end class