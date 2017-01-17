/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GettingFactory;

import AdditionFactory.EmployeeFactory;
import Entities.Employee;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr M.Saidam
 */
public class GettingRefliction 
{
    
    public static GettingOperations generateGettingData(String name)
    {
        Class clas;
        GettingOperations gettingOperations = null;
        try {
            clas = Class.forName(name);
         gettingOperations = (GettingOperations) clas.getConstructor().newInstance();
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
        return gettingOperations;
    }
}
