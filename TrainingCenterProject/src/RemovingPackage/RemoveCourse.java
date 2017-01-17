/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemovingPackage;

import ActionsPackage.DataBaseAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Amr M.Saidam
 */
public class RemoveCourse implements RemoveOperations{

    public boolean removeCourse(int ID) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM Course WHERE CID = ? ";
        boolean flage = false;
        Connection connect = null;

        connect = DataBaseAccess.getInstance().getConnect();

        PreparedStatement preparedStatement = connect.prepareStatement(query);

        preparedStatement.setInt(1, ID);

       flage =  preparedStatement.execute();
        

        preparedStatement.close();
        connect.close();
        return flage;

    }

    @Override
    public boolean removeEmployee(int ID) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
