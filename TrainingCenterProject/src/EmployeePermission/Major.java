/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeePermission;

import Entities.Course;
import Entities.Employee;
import AdditionFactory.AddEmployee;
import Entities.Person;
import AdditionFactory.AddCourse;
import AdditionFactory.AddStudent;
import AdditionFactory.ReflectionFactory;
import UserInterfaces.ManagersInterface;

import java.sql.Date;

/**
 *
 * @author Amr M.Saidam
 */
public class Major extends Person {

    Person employee;
    public Major(Person employee) throws Exception
    {
       
        this.employee = employee;
    }
    
   
    public int getID() {
		return employee.getID();
	}

	public void setID(int iD) {
		employee.setID(iD);
	}

	

	public String getFirstName() {
		return employee.getFirstName();
	}


	public void setFirstName(String firstName) {
		employee.setFirstName(firstName);
	}


	public String getLastName() {
		return employee.getLastName();
	}


	public void setLastName(String lastName) {
		employee.setLastName(lastName);
	}


	public String getAddress() {
		return employee.getAddress();
	}


	public void setAddress(String address) {
		employee.setAddress(address);
	}


	public String getEmail() {
		return employee.getEmail();
	}


	public void setEmail(String email) {
		employee.setEmail(email);
	}


	public String getSex() {
		return employee.getSex();
	}


	public void setSex(String sex) {
		employee.setSex(sex);
	}

    public String getPassword() {
        return employee.getPassword();
    }

    public void setPassword(String Password) {
        this.employee.setPassword(Password);
    }

    public float getSalary() {
        return employee.getSalary();
    }

    public void setSalary(float Salary) {
        this.employee.setSalary(Salary);
    }
        
     public boolean Check(Person employee)
    {
        return (!employee.personDesc().equalsIgnoreCase("Student"));
    }
    

    @Override
    public String personDesc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getPermissions() {
         new ManagersInterface().setVisible(true);
    }

   
    
}
