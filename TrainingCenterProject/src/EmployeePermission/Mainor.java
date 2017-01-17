/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeePermission;

import Entities.Course;
import Entities.Person;
import AdditionFactory.AddStudent;
import AdditionFactory.ReflectionFactory;
import java.sql.Date;

/**
 *
 * @author Amr M.Saidam
 */
public class Mainor extends Person  {

    Person employee;

    public Mainor(Person employee) {
        this.employee = employee;
    }

    public int getID() {
        return employee.getID();
    }


    public String getFirstName() {
        return employee.getFirstName();
    }

  
    public String getLastName() {
        return employee.getLastName();
    }


    

    

    public String getAddress() {
        return employee.getAddress();
    }

  
    public String getEmail() {
        return employee.getEmail();
    }

  
    public String getSex() {
        return employee.getSex();
    }

    public String getPassword() {
        return employee.getPassword();
    }

   
    public float getSalary() {
        return employee.getSalary();
    }

  
    public boolean Check(Person employee) {
        return (!employee.personDesc().equalsIgnoreCase("Student"));
    }

    @Override
    public String personDesc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getPermissions() {
        this.employee.getPermissions();
    }

}
