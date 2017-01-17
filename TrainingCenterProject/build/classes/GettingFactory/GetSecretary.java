/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GettingFactory;

import ActionsPackage.DataBaseAccess;
import Entities.Course;
import Entities.Secretary;
import Entities.Student;
import Entities.Trainer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amr M.Saidam
 */
public class GetSecretary implements GettingOperations
{
    
     public List<Secretary> getSecretary() throws ClassNotFoundException, SQLException {
        String query = "";
        List<Secretary> trainers = new ArrayList<Secretary>();
       
            
      
            query = "Select * From [Employee] where [Type] = 'Secretary'";
       
           
        Connection connect = DataBaseAccess.getInstance().getConnect();
        PreparedStatement preparedStatement = connect.prepareStatement(query);
       
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Secretary temp  = new Secretary();
            System.out.println("TypeOfTrainer");
            temp.setID(resultSet.getInt("EID"));
            temp.setFirstName(resultSet.getString("fname"));
            temp.setLastName(resultSet.getString("lname"));
            temp.setEmail(resultSet.getString("email"));
            temp.setAddress(resultSet.getString("address"));
            temp.setID(resultSet.getInt("EID"));
            temp.setSalary(resultSet.getInt("salary"));
            temp.setPassword(resultSet.getString("password"));
            trainers.add(temp);

        }
        preparedStatement.close();
        connect.close();
        return trainers;
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
    public List<Student> getStudents() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
