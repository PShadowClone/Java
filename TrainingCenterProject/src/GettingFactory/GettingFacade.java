/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GettingFactory;

import Entities.Course;
import Entities.Employee;
import Entities.Person;
import Entities.Secretary;
import Entities.Student;
import Entities.Trainer;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Amr M.Saidam
 */
public class GettingFacade {

    private static GettingOperations gettingCourses;
    private static GettingOperations gettingStudents;
    private static GettingOperations gettingTrainers;
    private static GettingOperations gettingSecretary;
    public static GettingFacade Instance = getInstance();
    
    private GettingFacade()
    {
        gettingCourses = GettingRefliction.generateGettingData(GetCourses.class.getName());
        gettingStudents = GettingRefliction.generateGettingData(GetStudents.class.getName());
        gettingTrainers = GettingRefliction.generateGettingData(GetTrainers.class.getName());
        gettingSecretary =  GettingRefliction.generateGettingData(GetSecretary.class.getName());
    }
    
    public static GettingFacade getInstance()
    {
        if(Instance == null)
            Instance = new GettingFacade();
        return Instance;
    }
    
    public static List<Course> getCourses() throws ClassNotFoundException, SQLException
    {
        return gettingCourses.getCourses();
    }
    
     public static List<Student> getStudents() throws ClassNotFoundException, SQLException
    {
        return gettingStudents.getStudents();
    }
     
      public static List<Trainer> getTrainers() throws ClassNotFoundException, SQLException
    {
        return gettingTrainers.getTrainer();
    }
       public static List<Secretary> getSecretary() throws ClassNotFoundException, SQLException
    {
        return gettingSecretary.getSecretary();
    }
}
