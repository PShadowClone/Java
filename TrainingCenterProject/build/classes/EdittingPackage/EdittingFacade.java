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
public class EdittingFacade 
{
    private static EditOperation editCourse;
    private static EditOperation editEmployee;
    public static EdittingFacade Insance = EdittingFacade.getInsatnce();
    
    private EdittingFacade()
    {
        editCourse = EdittingFactory.generateEditions(EditCourse.class.getName());
        editEmployee = EdittingFactory.generateEditions(EditEmployees.class.getName());
    }
    
    public static int editCourse(Course course) throws ClassNotFoundException, SQLException
    {
        return editCourse.editCourse(course);
    }
    
    private static  EdittingFacade getInsatnce()
    {
        if(Insance == null)
            Insance = new EdittingFacade();
        return Insance;
    }
    
     public static int EditPersons(Person person) throws ClassNotFoundException, SQLException
     {
         return editEmployee.EditPersons(person);
     }
    
}
