///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package UserInterfaces.ManagerInterface;
//
//import ActionsPackage.DataBaseAccess;
//import Entities.Trainer;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import javax.swing.BorderFactory;
//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//
///**
// *
// * @author AmrSaidam
// */
//public class Operations {
//
//    ArrayList<Trainer> Trainers = new ArrayList<Trainer>();
//    DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
//    public Connection connect;
//    public Statement statement;
//
//    public void CreateTrainer(String fname , String sname , String sex , String address , Date dob, String email , int Salary ,String Pass , String Employee) 
//    {
//        //, sname.getText(), Float.parseFloat(salary.getText()), s, sort,dof.getText(),phone.getText() ,address.getText()));
//
//        try {
//            //	statement = connect.createStatement();
//           
//                if (Employee.equals("Trainer")) {
//                    dataBaseAccess.getStatement().execute("insert into Trainer (fname,lname,sex,dob,address,email,password,salary) values(\"'" + fname + "','" + sname + "','" + sex + "','" + dob + "','" + address + "','" + email + "','"+Pass+"'," + Salary + ")");
//                    dataBaseAccess.getStatement().execute("insert into Login(UserName,Password,Status)values('" + fname + " " + sname + "','" + Pass + "','trainer',\")");
//                    JOptionPane.showMessageDialog(null, "The " + fname + " " + sname + " was Added", "Add Trainer", JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    dataBaseAccess.getStatement().execute("insert into Secretary (fname,lname,sex,address,email,password,salary) values(\"'" + fname + "','" + sname + "','" + sex + "','" + dob + "','" + address + "','" + email + "','"+Pass+"'," + Salary + ")");
//                    dataBaseAccess.getStatement().execute("insert into Login(UserName,Password,Status,EID)values('" + fname + " " + sname + "','" + Pass + "','Secretary')  ");
//                    JOptionPane.showMessageDialog(null, "The " + fname + " " + sname + " was Added", "Add Secretary", JOptionPane.INFORMATION_MESSAGE);
//                }
//            
//        }catch (SQLException ex) {
//            // TODO Auto-generated catch block
//            JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//            System.out.print("Amr1");
//        } finally{
//
//            dataBaseAccess.CloseConnection();
//
//        }
//}
//
//
//    }
//
