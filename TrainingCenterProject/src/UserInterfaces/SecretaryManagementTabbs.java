//package UserInterfaces;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.table.DefaultTableModel;
//
//import ActionsPackage.DataBaseAccess;
//import Entities.Course;
//import Entities.Student;
//import Entities.Trainer;
//
//
//
//public class SecretaryManagementTabbs 
//{
//	
//	
//	public JPanel VarCreateStudentAccount;
//	public JPanel VerPrintStudentReport;
//	public JPanel VerPrintStudentSchedule;
//	DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
//	public  Connection connect;
//	public  Statement statement;
//	ArrayList<Student> Students = new ArrayList<Student>();
//	ArrayList<Course> Courses = new ArrayList<Course>();
//	ArrayList<Trainer> Trainers = new ArrayList<Trainer>();
//	public SecretaryManagementTabbs()
//	{
//		VarCreateStudentAccount = new JPanel();
//		VarCreateStudentAccount.setLayout(new FlowLayout());
//		VerPrintStudentReport = new JPanel(new FlowLayout());
//		VerPrintStudentSchedule = new JPanel(new FlowLayout());
//	}
//	
//	
//	
//	public JPanel CreateStudenttab()
//	{
//		JPanel empty = new JPanel();
//		empty.setPreferredSize(new Dimension(75,300));
//		JPanel cont = new JPanel();
//		JPanel StudentTab = new JPanel();
//		cont.setLayout(new FlowLayout());
//		StudentTab.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Student Registration"));
//		StudentTab.setPreferredSize(new Dimension(180,350));
//		StudentTab.setLayout(new FlowLayout());
//		JLabel Fname = new JLabel("First Name");
//		JTextField fname = new JTextField();
//		fname.setColumns(12);
//		
//		JLabel Sname = new JLabel("Second Name");
//		JTextField sname = new JTextField();
//		sname.setColumns(12);
//		
//		
//		JLabel Sex = new JLabel("Sex     ");
//		JTextField sex = new JTextField();
//		sex.setColumns(12);
//		
//		
//		JLabel Email = new JLabel("E-mail");
//		JTextField email = new JTextField();
//		email.setColumns(12);
//		
//		
//		
//		JLabel Address = new JLabel("Address");
//		JTextField address = new JTextField();
//		address.setColumns(12);
//		JButton Save = new JButton("Save");
//		Save.setPreferredSize(new Dimension(100,50));
//		Save.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//		Save.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					if(!(fname.getText().equals("") || sname.getText().equals("") || sex.getText().equals("") || address.getText().equals("") || email.getText().equals(""))){
//						dataBaseAccess.getStatement().execute("insert into Student (fname,lname,sex,address,email) values('"+fname.getText()+"','"+sname.getText()+"','"+sex.getText()+"','"+address.getText()+"','"+email.getText()+"')");
//						JOptionPane.showMessageDialog(null, "The "+fname.getText()+" "+sname.getText()+" Student was inserted", "Add Student", JOptionPane.INFORMATION_MESSAGE);
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//					System.out.print("Amr1");
//				}
//				finally
//				{
//					
//						dataBaseAccess.CloseConnection();
//						
//					
//				}
//			}
//				
//			
//		});
//		StudentTab.add(Fname);
//		StudentTab.add(fname);
//		StudentTab.add(Sname);
//		StudentTab.add(sname);
//		StudentTab.add(Sex);
//		StudentTab.add(sex);
//		StudentTab.add(Email);
//		StudentTab.add(email);
//		StudentTab.add(Address);
//		StudentTab.add(address);
//		
//		StudentTab.add(Save);
//		cont.add(empty);
//		cont.add(StudentTab);
//		return cont;
//
//		
//	}
//	
//	public JButton CreateStudentButtons()
//	{
//		JButton Save = new JButton("Save");
//		Save.setPreferredSize(new Dimension(100,50));
//		Save.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//		
//		return Save;
//	}
//	
//	public JPanel getVarCreateStudentAccount()
//	{
//		JPanel p = new JPanel();
//		p.setPreferredSize(new Dimension(300,100));
//		this.VarCreateStudentAccount.add(CreateStudenttab());
//		this.VarCreateStudentAccount.add(p);
//		return this.VarCreateStudentAccount;
//		}
//	
//	public JPanel CheckTabs(String Title )
//	{
//		
//		
//		JPanel bot = new JPanel();
//		JPanel midel = new JPanel();
//	
//		JTable table1 = new JTable();
//        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//        JScrollPane sp = new JScrollPane(table1);
//        Object[] col = {"ID","S: Name" , "S: Address","S: E-mail"}; 
//        model1.setColumnIdentifiers(col);
//       
//      //  model1.addRow(new Object[]{Students.get(x).getID(),Students.get(x).getFirstName()+" "+Students.get(x).getLastName(),Students.get(x).getAddress(),Students.get(x).getEmail()});
//        
//        sp.setPreferredSize(new Dimension(250,350));
//		//midel.setSize(100, 350);
//		
//		JLabel label = new JLabel(Title);
//		
//		JComboBox<Student> Student_Combo = new JComboBox<Student>();
//		Student_Combo.setPreferredSize(new Dimension(130,30));
//		StudentsInputs(Student_Combo);
//		JButton Search = new JButton("Search");
//		Search.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				 model1.addRow(new Object[]{Student_Combo.getItemAt(Student_Combo.getSelectedIndex()).getID(),Student_Combo.getItemAt(Student_Combo.getSelectedIndex()).getFirstName()+" "+Student_Combo.getItemAt(Student_Combo.getSelectedIndex()).getLastName(),Student_Combo.getItemAt(Student_Combo.getSelectedIndex()).getAddress(),Student_Combo.getItemAt(Student_Combo.getSelectedIndex()).getEmail()});
//			        
//			}
//		});
//		bot.add(label);
//		bot.add(Student_Combo);
//		bot.add(Search);
//		bot.setPreferredSize(new Dimension(150,100));
//		midel.add(bot);
//		midel.add(sp);
//		
//		
//		
//		
//		
//		return midel;
//		
//		
//	}
//
//	public JPanel addCoursetoStudent()
//	{
//		JPanel cont = new JPanel();
//		JPanel Tables = new JPanel();
//		JPanel regit = new JPanel();
//		Tables.setPreferredSize(new Dimension(250,350));
//		JTable table1 = new JTable();
//        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//        JScrollPane sp = new JScrollPane(table1);
//        Object[] col = {"ID","S: Name" , "S: Address","S: E-mail"}; 
//        model1.setColumnIdentifiers(col);
//       for(int x =0 ; x < Students.size() ; x++)
//       {
//       model1.addRow(new Object[]{Students.get(x).getID(),Students.get(x).getFirstName()+" "+Students.get(x).getLastName(),Students.get(x).getAddress(),Students.get(x).getEmail()});
//       }
//        sp.setPreferredSize(new Dimension(250,150));
//        
//        JTable table2 = new JTable();
//        DefaultTableModel model2 = (DefaultTableModel)table2.getModel();
//        JScrollPane sp1 = new JScrollPane(table2);
//        Object[] col1 = {"ID","C: Name" , "C: Price","C: Hours"}; 
//        model2.setColumnIdentifiers(col1);
//        for(int x =0 ; x < Courses.size() ; x++){
//        model2.addRow(new Object[]{Courses.get(x).getID(),Courses.get(x).getCourseName(),Courses.get(x).getPrice(),Courses.get(x).getHours()});
//        }
//
//        sp1.setPreferredSize(new Dimension(250,150));
//        
//       model2.setRowCount(25);
//       model1.setRowCount(25);
//       table1.setEnabled(false);
//       table2.setEnabled(false);
//       regit.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Registration"));
//       regit.setPreferredSize(new Dimension(150,180));
//       	JLabel label = new JLabel("Course");
//		JComboBox<Course> Course_Combo = new JComboBox<Course>();
//		ComboInputs(Course_Combo);
//		Course_Combo.setPreferredSize(new Dimension(130,30));
//		JLabel label2 = new JLabel("Student");
//		JComboBox<Student> Student_Combo = new JComboBox<Student>();
//		StudentsInputs(Student_Combo);
//		Student_Combo.setPreferredSize(new Dimension(130,30));
//		
//		JButton reg = new JButton("Register");
//		reg.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					dataBaseAccess.getStatement().execute("insert into Enroll (SID,CID)values("+Student_Combo.getItemAt(Student_Combo.getSelectedIndex()).getID()+","+Course_Combo.getItemAt(Course_Combo.getSelectedIndex()).getID()+")");
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//				}finally
//				{
//					dataBaseAccess.CloseConnection();
//				}
//				
//			}});
//		regit.add(label);
//		regit.add(Course_Combo);
//		regit.add(label2);
//		regit.add(Student_Combo);
//		regit.add(reg);
//        Tables.add(sp);
//        Tables.add(sp1);
//        cont.add(Tables);
//        cont.add(regit);
//        
//        
//        return cont;
//		
//	}
//	public void CreateTextArea()
//	{
//		
//		JList t = new JList();
//		
//      // model1.setRowCount(25);
//			//	sp.setPreferredSize(new Dimension(250,350));
//		//return sp;
//		
//	}
//	
//	public JPanel getVerPrintStudentReport(String Title)
//	{
//	//	this.VerPrintStudentReport.add(CreateTextArea());
//		this.VerPrintStudentReport.add(CheckTabs( Title));
//		return this.VerPrintStudentReport;
//	}
//	
//	public JPanel getVerPrintStudentSchedule(String Title)
//	{
//		this.VerPrintStudentSchedule.add(CheckTabs( Title));
//		//this.VerPrintStudentSchedule.add(CreateTextArea());
//		
//		return this.VerPrintStudentSchedule;
//	}
//	
//	public void UseDataBsase()
//	{
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public  void getStudents()
//	{
//		
//		try {
//			Student temp = new Student();
//			ResultSet result;
//			result = dataBaseAccess.getStatement().executeQuery("select * from Student");
//			while(result.next())
//			{
//				temp.setID(result.getInt("SID"));
//				temp.setFirstName(result.getString("fname"));
//				temp.setLastName(result.getString("lname"));
//				temp.setSex(result.getString("sex"));
//				temp.setAddress(result.getString("address"));
//				temp.setEmail(result.getString("email"));
//				Students.add(temp);
//				temp = new Student();
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
//	public void StudentsInputs(JComboBox<Student> cour)
//	{
//		for(Student c : Students)
//		{
//			cour.addItem(c);
//		}
//	}
//
//
//	public void ComboInputs(JComboBox<Course> cour)
//	{
//		for(Course c : Courses)
//		{
//			cour.addItem(c);
//		}
//	}
//	
//	
//	public void getCourses()
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
//			JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//		}
//		finally
//		{
//			dataBaseAccess.CloseConnection();
//		}
//	}
//	
//	public  void getTrainers()
//
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
//}
