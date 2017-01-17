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
public class GetStudents implements GettingOperations
{
     public List<Student> getStudents() throws ClassNotFoundException, SQLException
    {
        List<Student> students = new ArrayList<Student>();
        String query = "Select * From Student";
         Connection connect =  DataBaseAccess.getInstance().getConnect();                       
           Statement statement = connect.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                Student temp = new Student();   
                temp.setID(resultSet.getInt("SID"));
                temp.setFirstName(resultSet.getString("fname"));
                temp.setLastName(resultSet.getString("lname"));
                temp.setEmail(resultSet.getString("email"));
                temp.setAddress(resultSet.getString("address"));
                
                      students.add(temp);        
                
            }
            statement.close();
            connect.close();
            return students;
    }

    @Override
    public List<Course> getCourses() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Trainer> getTrainer() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Secretary> getSecretary() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
