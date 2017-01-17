///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package UserInterfaces.ManagerInterface;
//
//import ActionsPackage.DataBaseAccess;
//import Entities.Course;
//import Entities.Trainer;
//import datechooser.beans.DateChooserCombo;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Random;
//import javax.swing.JComboBox;
//import javax.swing.JOptionPane;
//import javax.swing.JSpinner;
//import javax.swing.JTextField;
//
///**
// *
// * @author AmrSaidam
// */
//public class EditCourse {
//    
//      ArrayList<Trainer> Trainers = new ArrayList<Trainer>();
//    DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
//    ArrayList<Course> Courses = new ArrayList<Course>();
//    Random input = new Random(24);
//   
//    JComboBox Com= null;
//    Course temp = null;
//    public EditCourse()
//    {
//        
//       try{
//        getTrainers();
//         getCourses();
//       }catch(Exception ex)
//       {}
//    }
//
//   
//      public  void getTrainers()
//	{
////		
////		try {
////			Trainer temp = new Trainer();
////			ResultSet result;
////			//result = dataBaseAccess.getStatement().executeQuery("select * from Trainer");
////			while(result.next())
////			{
////				temp.setID(result.getInt("TID"));
////				temp.setFirstName(result.getString("fname"));
////				temp.setLastName(result.getString("lname"));
////				temp.setSex(result.getString("sex"));
////				temp.setAddress(result.getString("address"));
////				temp.setEmail(result.getString("email"));
////				temp.setPassword(result.getString("password"));
////				temp.setSalary(result.getFloat("salary"));
////				Trainers.add(temp);
////				temp = new Trainer();
////			}
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
////		}finally
////		{
////			dataBaseAccess.CloseConnection();
////		}
//	}
//  public void getCourses()
//	{
//		try {
//			//Course cou = new Course();
//			ResultSet result = null;// dataBaseAccess.getStatement().executeQuery("select * from Course");
//			while(result.next())
//			{
//				//cou.setID(result.getInt("CID"));
//				//cou.setCourseName(result.getString("cname"));
//				//cou.setHours(result.getInt("hours"));
//				//cou.setPrice(result.getFloat("price"));
//				for(Trainer t: Trainers){
//					//if(t.getID() == result.getInt("TID"))
//						//cou.setTrainerID(t);
//                                       
//				}
//				//Courses.add(cou);
//				//cou =  new Course();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//                       
//		}
//		finally
//		{
//			dataBaseAccess.CloseConnection();
//		}
//	}
//
//     public void Fill_Courses_Combo(JComboBox<Course> Com)
//      {
//          for (int i = 0; i < Courses.size(); i++) {
//              Com.addItem(Courses.get(i));
//              
//          }
//      }
//     
//     public void getValue(JTextField CourseName ,
//             JComboBox Combo , JSpinner price ,
//             JSpinner hours , DateChooserCombo SD ,
//             DateChooserCombo ED , JComboBox<Trainer> trainer  )
//     {
//         Com.addActionListener(new ActionListener() {
//
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 temp = (Course) Com.getItemAt(Com.getSelectedIndex());
//                  CourseName.setText(temp.getCourseName());
//         Combo.setSelectedItem("Paid");
//         price.setValue(temp.getPrice());
//         hours.setValue(temp.getHours());
//         SD.setText(""+input.nextInt()+""+input.nextInt()+""+"2015");
//         ED.setText(""+input.nextInt()+""+input.nextInt()+""+"2015");
//      //   trainer.setSelectedItem(temp.getTrainerID().getFirstName()+""+temp.getTrainerID().getLastName());
//             }
//         });
//     }
//     
//     public void Fill_Field(Course temp ,JTextField CourseName ,
//             JComboBox Combo , JSpinner price ,
//             JSpinner hours , DateChooserCombo SD ,
//             DateChooserCombo ED , JComboBox<Trainer> trainer  )
//     {
//         CourseName.setText(temp.getCourseName());
//         Combo.setSelectedItem("Paid");
//         price.setValue(temp.getPrice());
//         hours.setValue(temp.getHours());
//         SD.setText(""+input.nextInt()+""+input.nextInt()+""+"2015");
//         ED.setText(""+input.nextInt()+""+input.nextInt()+""+"2015");
/////         trainer.setSelectedItem(temp.getTrainerID().getFirstName()+""+temp.getTrainerID().getLastName());
//         
//        
//     }
//     
//     public void fill_Trainers(JComboBox<Trainer> tr)
//     {
//         for (int i = 0; i < Trainers.size(); i++) {
//           tr.addItem(Trainers.get(i));
//             
//         }
//         
//     }
//     
//      public  void getTrainers(ArrayList<Trainer> Trainers)
//	{
//		
//		try {
//			Trainer temp = new Trainer();
//			ResultSet result;
//			result = null;//dataBaseAccess.getStatement().executeQuery("select * from Trainer");
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
//}
