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
public class FactoryFacade {
    private static AddOperations addCourse;
    private static AddOperations addEmployee;
    
    public static FactoryFacade  factoryfacade = FactoryFacade.getInstance();
    
    private FactoryFacade()
    {
        addCourse = ReflectionFactory.generateAddtions(AddCourse.class.getName());
        addEmployee = ReflectionFactory.generateAddtions(AddEmployee.class.getName());
    }
    
    public static FactoryFacade getInstance()
    {
        if(factoryfacade == null)
            factoryfacade = new FactoryFacade();
        return factoryfacade;
    }
    
    public static boolean addCourse(Course course) throws Exception
    {
        return addCourse.addCourse(course);
    }
     public static boolean addEmployee(Person person) throws Exception
    {
        return addEmployee.addPersons(person);
    }
    
    
}
