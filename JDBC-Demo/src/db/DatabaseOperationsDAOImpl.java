package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bclass.Instructor;

public class DatabaseOperationsDAOImpl implements DatabaseOpertionsDAO {

	
	Connection con;
	PreparedStatement ps;
	
	public DatabaseOperationsDAOImpl() throws SQLException, ClassNotFoundException {
		con = DatabaseConnectionFactory.getConnection();
	}
	
	
	public boolean doInsertIntoInstructor(Instructor instructor)throws Exception
	{
		boolean status = false;
		
		int code = instructor.getInstructorcode();
		int salary = instructor.getSalary();
		int jobstartyear = instructor.getJobstartyear();
		String name = instructor.getName();
		
		// code to insert instructor into db
		
		String insertQuery = "insert into Instructor"
				+ " values(?,?,?,?)";
		
		ps = con.prepareStatement(insertQuery);
		ps.setInt(1, code);
		ps.setString(2, name);
		ps.setInt(3, salary);
		ps.setInt(4, jobstartyear);
		
		int i = ps.executeUpdate();
		
		if(i>0) status = true;

		return status;
	}
	
	
	public List<Instructor> getInstructors()throws Exception
	{
		List<Instructor> list = new ArrayList<Instructor>();
		String q = "select * from instructor";
		ps = con.prepareStatement(q);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			int code = rs.getInt("instructorcode");
			String name = rs.getString("name");
			int salary = rs.getInt("salary");
			int jobyear = rs.getInt("jobstartyear");
			
			Instructor instructor = new Instructor();
			instructor.setInstructorcode(code);
			instructor.setName(name);
			instructor.setSalary(salary);
			instructor.setJobstartyear(jobyear);
			
			list.add(instructor);
		}
		return list;
	}
	
	
	
}//end of DB Operation class


//  Unhandled exception type ClassNotFoundException






