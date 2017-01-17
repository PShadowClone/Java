/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionFactory;

import Entities.Course;
import Entities.Person;

/**
 *
 * @author Amr M.Saidam
 */
public interface AddOperations {
    public   boolean addPersons(Person person)throws Exception;
    public  boolean addCourse(Course course)throws Exception;
    
    
}
