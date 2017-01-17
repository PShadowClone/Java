/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GettingFactory;

import ActionsPackage.DataBaseAccess;
import Entities.Course;
import Entities.Employee;
import Entities.Person;
import Entities.Secretary;
import Entities.Student;
import Entities.Trainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amr M.Saidam
 */
public class GetCourses implements GettingOperations {
    
     @Override
     public  List<Course> getCourses() throws ClassNotFoundException, SQLException
    {
        List<Course> courses = new ArrayList<Course>();
        String query = "Select * From Course";
         Connection connect =  DataBaseAccess.Instance.getConnect();
           Statement statment = connect.createStatement();
           ResultSet resultSet  = statment.executeQuery(query);
            while(resultSet.next())
            {
                Course temp = new Course.CourseBuilder().setCourseName(resultSet.getString("cname")).
                        setHours(resultSet.getInt("hours")).setPrice(resultSet.getInt("price")).
                        setID(resultSet.getInt("CID")).setTrainerID(new Trainer(resultSet.getInt("TID"))).buildCourse();
              
                  courses.add(temp);
                
            }
            statment.close();
            connect.close();
            return courses;
    }

    @Override
   public List<Trainer> getTrainer() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getStudents() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Secretary> getSecretary() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
