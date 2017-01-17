/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemovingPackage;

import java.sql.SQLException;

/**
 *
 * @author Amr M.Saidam
 */
public interface RemoveOperations
{
     public boolean removeCourse(int ID) throws ClassNotFoundException, SQLException ;
      public boolean removeEmployee(int ID) throws ClassNotFoundException, SQLException ;
    
}
