/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr M.Saidam
 */
public class ReflectionFactory {
    
    public static AddOperations generateAddtions(String name)
    {
        Class clas = null;
        AddOperations addOperations = null;
        try {
             clas = Class.forName(name);
            addOperations = (AddOperations)clas.getConstructor().newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReflectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ReflectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ReflectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ReflectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReflectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ReflectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ReflectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return addOperations;
                
        
    }
    
}
