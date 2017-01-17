/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import UserInterfaces.ManagersInterface;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Amr M.Saidam
 */
public class Manager extends Person implements Employee{

  
    @Override
    public String personDesc() {
        return "Manager";
    }

    @Override
    public void getPermissions() {
                  throw new NullPointerException();

    }
}
