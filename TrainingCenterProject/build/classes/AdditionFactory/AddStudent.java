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
public class AddStudent implements AddOperations {

    String query = "insert into Student(fname,lname,address,email)values(?,?,?,?)";

    @Override
    public boolean addPersons(Person person) throws ClassNotFoundException {
        Connection connect = null;
        try {
            connect = DataBaseAccess.getInstance().getConnect();
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getAddress());
            preparedStatement.setString(4, person.getEmail());
            return preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }

    @Override
    public boolean addCourse(Course course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
