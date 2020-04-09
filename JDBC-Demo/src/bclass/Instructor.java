package bclass;

public class Instructor {

	private int instructorcode;
	private String name;
	private int salary;
	private int jobstartyear;
	
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getInstructorcode() {
		return instructorcode;
	}
	public void setInstructorcode(int instructorcode) {
		this.instructorcode = instructorcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getJobstartyear() {
		return jobstartyear;
	}
	public void setJobstartyear(int jobstartyear) {
		this.jobstartyear = jobstartyear;
	}
	@Override
	public String toString() {
		return "Instructor [instructorcode=" + instructorcode + ", name=" + name + ", salary=" + salary
				+ ", jobstartyear=" + jobstartyear + "]";
	}
	
	
	
	
	
}










