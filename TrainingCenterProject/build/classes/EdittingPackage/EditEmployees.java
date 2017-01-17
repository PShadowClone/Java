/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdittingPackage;

import ActionsPackage.DataBaseAccess;
import Entities.Course;
import Entities.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Amr M.Saidam
 */
public class EditEmployees implements EditOperation
{
    
     
    @Override
    public  int EditPersons(Person person) throws ClassNotFoundException, SQLException  {
        int flage = 0;
          String query = "Update Employee set fname = ?, lname = ? ,sex = ?, email = ?, address = ?, password = ? , Type = ? , salary = ? where EID = ?";
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
            preparedStatement.setInt(9, person.getID());
           flage = preparedStatement.executeUpdate();
           
             preparedStatement.close();
             connect.close();

              return flage;
               
            

       

    }

    @Override
    public int editCourse(Course course) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
