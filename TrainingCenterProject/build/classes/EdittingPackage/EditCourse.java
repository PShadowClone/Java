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
public class EditCourse implements EditOperation{

    private static String query = "Update Course set cname = ? , hours = ? , price = ? , TID = ? where CID = ?";

    @Override
    public int editCourse(Course course) throws ClassNotFoundException, SQLException {
        int flage = 0;
        Connection connect = null;

        connect = DataBaseAccess.getInstance().getConnect();

        PreparedStatement preparedStatement = connect.prepareStatement(query);

        preparedStatement.setString(1, course.getCourseName());
        preparedStatement.setInt(2, course.getHours());
        preparedStatement.setFloat(3, course.getPrice());
        preparedStatement.setInt(4, course.getTrainer().getID());
        preparedStatement.setInt(5, course.getID());
        flage = preparedStatement.executeUpdate();
        System.out.println("Flage :"+course.getID());
        preparedStatement.close();
        connect.close();
        return flage;

    }

    @Override
    public int EditPersons(Person person) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
