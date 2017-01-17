/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginOperation;

import ActionsPackage.DataBaseAccess;
import EmployeePermission.Mainor;
import EmployeePermission.Major;
import Entities.Manager;
import Entities.Person;
import AdditionFactory.AddStudent;
import AdditionFactory.EmployeeFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr M.Saidam
 */
public class LoginDataBase {

    public static Person Login(String userName, String pass) throws ClassNotFoundException, SQLException, Exception {
        Person person = null;
        String[] split = userName.split(" ");
        System.out.println(""+split[0]+": "+split[1]);

        String query = "select * from [Employee] where  [fname] = ? And [lname] = ? And [password] = ?";
        Connection connect =  DataBaseAccess.Instance.getConnect();
      
      
            connect = DataBaseAccess.getInstance().getConnect();
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, split[0]);
            preparedStatement.setString(2, split[1]);
            preparedStatement.setString(3, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              person = (Person) EmployeeFactory.generateEmployee("Entities."+resultSet.getString("Type"));
                                 
                person.setFirstName(resultSet.getString("fname"));
                person.setLastName(resultSet.getString("lname"));
                person.setEmail(resultSet.getString("email"));
                person.setAddress(resultSet.getString("address"));
                person.setID(resultSet.getInt("EID"));
                person.setSalary(resultSet.getInt("salary"));

            }
            
            if(person instanceof Manager)
            {
                person = new Major(person);
            }else
            {
                person = new Mainor(person);
            }
            
            connect.close();
            
            return person;

       
       
                
           
            }
        }

       
    


