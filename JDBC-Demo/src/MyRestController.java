package com.info;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class MyRestController {
	
	Student stu;
	
	

	List<Student> stuList;
	public MyRestController() {
		stu = new Student(101,"Ramesh","Kumar", true);
	
		stuList = new ArrayList<Student>();
		
		stuList.add(new Student(102, "rakesh","kumar", true));
		stuList.add(new Student(103, "amit","kumar", false));
		stuList.add(new Student(104, "saurabh","kumar", false));
		stuList.add(new Student(105, "ashish","kumar", true));
		stuList.add(stu);
		
	
		System.out.println(" \n\n ---->> Demo Rest Controller "+stu+" : "+stuList);
		
	}



	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Hello User";
	}
	
	@RequestMapping("/student")
	public Student provideStudent()
	{
		return stu;
	}
	// www.abc.com/{{productName}}/{{age}}/{{producttype}}/{{productid}}
	//     www.glbajaj.com/student/101
	@RequestMapping(value="/student/{stuid}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Student provideStudent(@PathVariable int id)
	{
		System.out.println("inside method provide Student by id "+id);
		for(Student s:stuList)
		{
			if(s.getId() == id)
			{
				return stu;
			}
		}
		return null;
	}
	
	
	
	
	
}//end class
