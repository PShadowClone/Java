/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemovingPackage;

import AdditionFactory.ReflectionFactory;
import EdittingPackage.EditOperation;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr M.Saidam
 */
public class RemoveFactory 
{

  public static RemoveOperations generateRemoving(String name)
    {
        Class clas = null;
        RemoveOperations removeOperations = null;
        try {
             clas = Class.forName(name);
            removeOperations = (RemoveOperations)clas.getConstructor().newInstance();
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
        return removeOperations;
                
        
    }
}
