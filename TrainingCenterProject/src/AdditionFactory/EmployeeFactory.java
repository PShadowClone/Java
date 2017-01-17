/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionFactory;

import Entities.Employee;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr M.Saidam
 */
public class EmployeeFactory 
{
    
    public static Employee generateEmployee(String name)
    {
        Class clas;
        Employee employee = null;
        try {
            clas = Class.forName(name);
         employee = (Employee) clas.getConstructor().newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(EmployeeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(EmployeeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EmployeeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EmployeeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(EmployeeFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(EmployeeFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }
    
}
