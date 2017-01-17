package ActionsPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseAccess {

    private static  Connection connect;
    private Statement statement;
    public static DataBaseAccess Instance = DataBaseAccess.getInstance();

    private DataBaseAccess() {
        System.out.println("Access operation Done !!!");
        System.out.println("" + this.getClass().getResource("DataBaseAccess.java"));
    }

    public static DataBaseAccess getInstance() {
        if (Instance == null) {
            Instance = new DataBaseAccess();
        }

        return Instance;
    }

    public static Connection getConnect() throws ClassNotFoundException, SQLException {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        connect = DriverManager.getConnection("jdbc:ucanaccess://ProjectDataBase.accdb");

        return connect;
    }


    public void CloseConnection() {

        try {
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {

            
        }

    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

}
