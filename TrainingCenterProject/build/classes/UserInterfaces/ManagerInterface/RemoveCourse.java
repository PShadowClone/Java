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
//import java.awt.Button;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import javax.swing.ImageIcon;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.SwingConstants;
//import javax.swing.table.DefaultTableModel;
//
///**
// *
// * @author AmrSaidam
// */
//public class RemoveCourse {
//     ArrayList<Trainer> Trainers = new ArrayList<Trainer>();
//    DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
//    ArrayList<Course> Courses = new ArrayList<Course>();
//   
//    
//    public RemoveCourse()
//    {
//        getCourses();
//    }
//    public void getCourses()
//	{
//		try {
//			Course cou = new Course();
//			ResultSet result =  dataBaseAccess.getStatement().executeQuery("select * from Course");
//			while(result.next())
//			{
//				cou.setID(result.getInt("CID"));
//				cou.setCourseName(result.getString("cname"));
//				cou.setHours(result.getInt("hours"));
//				cou.setPrice(result.getFloat("price"));
//				for(Trainer t: Trainers){
//					if(t.getID() == result.getInt("TID"))
//						cou.setTrainerID(t);
//				}
//				Courses.add(cou);
//				cou =  new Course();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			dataBaseAccess.CloseConnection();
//		}
//	}
//    
//
//    public void Add_Data_To_Table(JTable Table )
//    {
//         DefaultTableModel model1 = (DefaultTableModel)Table.getModel();
//         // DefaultTableModel model2 = (DefaultTableModel)Show.getModel();
//        //JScrollPane sp = new JScrollPane(Table);
//         ImageIcon icon = new ImageIcon("1430622417_DeleteRed.png");
//         
//         for(int i = 1 ; i < 5 ; i++)
//         {
//           model1.removeRow(1);
//         }
//          
//        for(int i = 0; i < Courses.size(); i++) {
//              
//                   
//                model1.addRow(new Object[]{Courses.get(i).getID(),Courses.get(i).getCourseName(),Courses.get(i).getPrice(),Courses.get(i).getHours()});
//            
//        }
//        
//        model1.setRowCount(25);
//    }
//    
//      public  void getTrainers()
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
//      public void Fill_Courses_Combo(JComboBox Com)
//      {
//          for (int i = 0; i < Courses.size(); i++) {
//              Com.addItem(Courses.get(i));
//              
//          }
//      }
//      
//      
//      public void RemoveCourse(JComboBox<Course> Com)
//      {
//          for(int i = 0 ; i < Courses.size() ; i++)
//          {
//              if(Com.getItemAt(Com.getSelectedIndex()).getID() == Courses.get(i).getID())
//              {
//                  Courses.remove(i);
//                  Com.removeItemAt(Com.getSelectedIndex());
//                  Com.setSelectedItem(i+1);
//                  JOptionPane.showMessageDialog(null, "Remove Course","The Course was removed", JOptionPane.WARNING_MESSAGE);
//              }
//            
//              
//          }
//          try{
//           for (int i = 0; i < Courses.size(); i++) {
//              Com.remove(i);
//              
//          }
//             for (int i = 0; i < Courses.size(); i++) {
//              Com.addItem(Courses.get(i));
//              
//          }
//          }catch(Exception ex){}
//             
//      }
//      
//     public void remove_Table_item(JTable Table)
//     {
//         try{
//         DefaultTableModel model1 = (DefaultTableModel)Table.getModel();
//        //JScrollPane sp = new JScrollPane(Table);
//         ImageIcon icon = new ImageIcon("1430622417_DeleteRed.png");
//         int RowCount = model1.getRowCount();
//         System.out.println("Amr");
//         for(int i = RowCount -1 ; i >= 0 ; i--)
//         {
//           model1.removeRow(i);
//         }
//           
//                    System.out.println("Saidam");
//
//        for(int i = 0; i < Courses.size(); i++) {
//                model1.addRow(new Object[]{Courses.get(i).getID(),
//                    Courses.get(i).getCourseName(),
//                    Courses.get(i).getPrice(),
//                    Courses.get(i).getHours(),
//                    Courses.get(i).getTrainerID().getFirstName()+""+Courses.get(i).getTrainerID().getLastName()});
//            
//        }
//        model1.setRowCount(25);
//       
//     }catch(Exception ex )
//     {
//         System.out.println("Cournt error!!");
//     }
//     }
//
//}
