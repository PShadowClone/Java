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
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//
//
//public class ValidationClass {
//    ArrayList<Trainer> Trainers = new ArrayList<Trainer>();
//    DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
//    
//    private boolean CNStatus = false;
//    
//    public ValidationClass()
//     {
//           getTrainers();
//           
//     }
//    public void Course_Validate(JLabel Name,JTextField CourseName , JFrame Frame)
//    {
//        
//        CourseName.addFocusListener(new FocusListener() {
//
//            @Override
//            public void focusGained(FocusEvent e) {
//                 if(CNStatus == false)
//           {
//               Name.setForeground(Color.BLACK);
//           }
//        
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                Pattern p = Pattern.compile("^\\w+\\D");
//        Matcher m = p.matcher(CourseName.getName());
//        if(m.find())
//        {
//            CNStatus = true;
//        }
//        
//        if(CNStatus == false)
//        {
//            Name.setForeground(Color.red);
//        }
//                
//            }
//        });
//        
//    }
//    
//    
//    public  void getTrainers()
//	{
//		
//		try {
//			Trainer temp = new Trainer();
//			ResultSet result;
//			result = dataBaseAccess.getStatement().executeQuery("select * from Trainer");
//			while(result.next())
//			{
//				temp.setID(result.getInt("TID"));
//				temp.setFirstName(result.getString("fname"));
//				temp.setLastName(result.getString("lname"));
//				temp.setSex(result.getString("sex"));
//				temp.setAddress(result.getString("address"));
//				temp.setEmail(result.getString("email"));
//				temp.setPassword(result.getString("password"));
//				temp.setSalary(result.getFloat("salary"));
//				Trainers.add(temp);
//				temp = new Trainer();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//		}finally
//		{
//			dataBaseAccess.CloseConnection();
//		}
//	}
//    
//public void Fill_Trainers_Combo(JComboBox Com)
//{
//    for(int i = 0 ; i < Trainers.size() ; i++)
//    {
//        if(!Trainers.get(i).equals(null)){
//            Com.addItem(Trainers.get(i));
//        }
//        Com.setSelectedItem(Trainers.get(1));
//    }
//}
//
//}
