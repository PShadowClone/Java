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
public class AddCourse implements AddOperations {

    private  String query = "insert into Course (cname , hours , price , TID) values (?,?,?,?)";

    @Override
    public  boolean addPersons(Person person) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  boolean addCourse(Course course) throws ClassNotFoundException, SQLException {
        boolean flage = false;
        Connection connect = null;
        
            connect = DataBaseAccess.getInstance().getConnect();
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getHours());
            preparedStatement.setFloat(3, course.getPrice());
            preparedStatement.setInt(4, course.getTrainer().getID());
             flage = preparedStatement.execute();
             preparedStatement.close();
              connect.close();
       return flage;
                     
    }

}
