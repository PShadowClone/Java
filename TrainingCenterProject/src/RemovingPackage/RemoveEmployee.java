/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemovingPackage;

import ActionsPackage.DataBaseAccess;
import Entities.Trainer;
import java.rmi.Remote;
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
public class RemoveEmployee implements RemoveOperations {

    public boolean removeEmployee(int ID) throws ClassNotFoundException, SQLException {
        boolean flage = false;

        String query = "DELETE FROM Employee WHERE EID = ?";

        Connection connect = DataBaseAccess.getInstance().getConnect();
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setInt(1, ID);

        flage = preparedStatement.execute();

        preparedStatement.close();
        connect.close();
        return flage;
    }

    @Override
    public boolean removeCourse(int ID) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
