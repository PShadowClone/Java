/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdatingPackage;

import Entities.Course;
import GettingFactory.GettingFacade;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Amr M.Saidam
 */
public class UpdatingCourse extends Observable
{
    
    UpdateComboBox getCourses;
    public UpdatingCourse()
    {}
    public void fillCourses() throws ClassNotFoundException, SQLException
    {
        List<Course> courses  = GettingFacade.Instance.getCourses();  
        setChanged();
        notifyObservers(courses);
    }
    
}
