/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdatingPackage;

import Entities.Course;
import Entities.Person;
import Entities.Secretary;
import Entities.Trainer;
import GettingFactory.GettingFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.JComboBox;

/**
 *
 * @author Amr M.Saidam
 */
public class UpdateComboBox extends Observable
{
    public void fillComboBoxes() throws ClassNotFoundException, SQLException
    {
        System.out.println("In Observable");
        List<Person> persons = new ArrayList<Person>();
        List<Trainer> trainers  = GettingFacade.Instance.getTrainers();
        List<Secretary> secretary  = GettingFacade.Instance.getSecretary();
        persons.addAll(trainers);
        persons.addAll(secretary);
        
       setChanged();
        notifyObservers(persons);
    }
    
     public void fillCourses() throws ClassNotFoundException, SQLException
    {
        List<Course> courses  = GettingFacade.Instance.getCourses(); 
         setChanged();
        notifyObservers(courses);
    }
}
