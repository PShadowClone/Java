/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EdittingPackage;

import Entities.Course;
import Entities.Person;
import java.sql.SQLException;

/**
 *
 * @author Amr M.Saidam
 */
public interface EditOperation 
{
     public int editCourse(Course course) throws ClassNotFoundException, SQLException;
     public  int EditPersons(Person person) throws ClassNotFoundException, SQLException;
    
}
