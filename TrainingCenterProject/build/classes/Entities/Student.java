package Entities;

import java.sql.Date;
import java.util.ArrayList;


public class Student extends Person
{

	
	private ArrayList<Course> Student_Course = new ArrayList<Course>();

	public Student(){}
	public Student(String firstName, String lastName, Date dOB,String address, String email, String sex, String password , int ID ,  String Password,float Salary) {
		super(ID, firstName, lastName, address, email, sex, Password, Salary);
		
	}

	
	public ArrayList<Course> getStudent_Course() {
		return Student_Course;
	}

	public void setStudent_Course(ArrayList<Course> student_Course) {
		this.Student_Course = student_Course;
	}
	
	
	public String toString()
	{
		return this.getFirstName()+" "+this.getLastName();
	}


    @Override
    public String personDesc() {
     return "Student";
    }

    @Override
    public void getPermissions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
