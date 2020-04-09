package db;

import java.util.List;

import bclass.Instructor;

public interface DatabaseOpertionsDAO {
	
	public boolean doInsertIntoInstructor(Instructor instructor)throws Exception;
	
	public List<Instructor> getInstructors()throws Exception;
	
	
}
