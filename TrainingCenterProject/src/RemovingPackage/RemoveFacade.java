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
public class RemoveFacade 
{
    private static RemoveOperations removeCourse;
    private static RemoveOperations removeEmployee;
    public static RemoveFacade Instance = RemoveFacade.getInstance();
    
    private RemoveFacade()
    {
        removeCourse = RemoveFactory.generateRemoving(RemoveCourse.class.getName());
        removeEmployee =  RemoveFactory.generateRemoving(RemoveEmployee.class.getName());
    
    }
    
    private static RemoveFacade getInstance()
    {
        if(Instance == null)
            Instance = new RemoveFacade();
        
        return Instance;
        
    }
    
    public static boolean removeCourse(int ID) throws ClassNotFoundException, SQLException
    {
        return removeCourse.removeCourse(ID);
    }
    
    public static boolean removeEmployee(int ID) throws ClassNotFoundException, SQLException
    {
        return removeEmployee.removeEmployee(ID);
    }
    
}
