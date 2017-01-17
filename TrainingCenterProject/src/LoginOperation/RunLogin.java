/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginOperation;



import Entities.Person;
import java.sql.SQLException;

/**
 *
 * @author Amr M.Saidam
 */
public class RunLogin 
{
   public static void login(String userName , String pass) throws ClassNotFoundException, SQLException, Exception , NullPointerException
   {
       Person person = null;
       if((person = LoginDataBase.Login(userName, pass)) != null)      
       {
           person.getPermissions();
          
       }
   }
    
}
