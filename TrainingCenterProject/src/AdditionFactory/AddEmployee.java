/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionFactory;

import ActionsPackage.DataBaseAccess;
import Entities.Course;
import Entities.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr M.Saidam
 */
public class AddEmployee implements AddOperations {

    @Override
    public  boolean addPersons(Person person) throws ClassNotFoundException, SQLException  {
        boolean flage = false;
          String query = "insert into Employee(fname,lname,sex,email,address,password,Type,salary)values(?,?,?,?,?,?,?,?)";
        Connection connect = DataBaseAccess.getInstance().getConnect();
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getSex());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.setString(5, person.getAddress());
            preparedStatement.setString(6, person.getPassword());
            preparedStatement.setString(7, person.personDesc());
            preparedStatement.setFloat(8, person.getSalary());
           flage = preparedStatement.execute();
           
             preparedStatement.close();
             connect.close();

              return flage;
               
            

       

    }

    @Override
    public boolean addCourse(Course course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
