/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GettingFactory;

import Entities.Course;
import Entities.Employee;
import Entities.Person;
import Entities.Secretary;
import Entities.Student;
import Entities.Trainer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amr M.Saidam
 */
public interface GettingOperations {
     public  List<Course> getCourses() throws ClassNotFoundException, SQLException;
     public List<Trainer> getTrainer() throws ClassNotFoundException, SQLException;
     public List<Student> getStudents() throws ClassNotFoundException, SQLException;
      public List<Secretary> getSecretary() throws ClassNotFoundException, SQLException;
    
}
