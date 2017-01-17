//package UserInterfaces;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
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
//public class TrainerManagementTabbs
//{
//	
//	private JPanel VarShowStudent;
//	private JPanel VarPutStudentsMarks;
//	private JPanel VarPrintStudentScheduel;
//	ArrayList<Student> Students = new ArrayList<Student>();
//	ArrayList<Course> Courses = new ArrayList<Course>();
//	ArrayList<Trainer> Trainers = new ArrayList<Trainer>();
//	DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
//	public int tid = 0;
//	
//	
//	public TrainerManagementTabbs(int TID)
//	{
//		this.tid = TID;
////		getTrainers(dataBaseAccess.getStatement());
//		dataBaseAccess.CloseConnection();
//		
//	}
//	
//	public JPanel CheckTabs(String Title1 ,String Title2 )
//	{
//		
//		
//		JPanel midel = new JPanel();
//		JPanel buton = new JPanel();
//		//midel.setSize(100, 350);
//		midel.setLayout(new FlowLayout());
//		JPanel ptable = new JPanel();
//		buton.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), Title1));
//		JLabel label = new JLabel(Title2);
//		
//		JComboBox<Course> CB = new JComboBox<Course>();
//		CB.setPreferredSize(new Dimension(140,30));
////		ComboInputs(CB);
//		JTable table1 = new JTable();
//        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//        JScrollPane sp = new JScrollPane(table1);
//        Object[] col = {"ID","S: Name" , "S: Address","S: E-mail"}; 
//        model1.setColumnIdentifiers(col);
//       
//		JButton Search = new JButton("Search");
//	
//		Search.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				 model1.getDataVector().removeAllElements();
//				for(int x =0 ; x <CB.getItemAt(CB.getSelectedIndex()).Course_Student.size() ; x++)
//			       {
//			       model1.addRow(new Object[]{CB.getItemAt(CB.getSelectedIndex()).Course_Student.get(x).getID(),
//			    		   CB.getItemAt(CB.getSelectedIndex()).Course_Student.get(x).getFirstName()+" "+CB.getItemAt(CB.getSelectedIndex()).Course_Student.get(x).getLastName(),
//			    		   CB.getItemAt(CB.getSelectedIndex()).Course_Student.get(x).getAddress(),
//			    		   CB.getItemAt(CB.getSelectedIndex()).Course_Student.get(x).getEmail()});
//			       }
//				
//				
//			}});
//	//	 sp.setPreferredSize(new Dimension(300,150));
//		 model1.setRowCount(25);
//		buton.add(label);
//		buton.add(CB);
//		buton.add(Search);
//		buton.setPreferredSize(new Dimension(170,130));
//        sp.setPreferredSize(new Dimension(500,300));
//        ptable.setPreferredSize(new Dimension(600,400));
//	
//		ptable.add(sp);
//		midel.add(buton);
//		midel.add(ptable);
//		
//	//	midel.add(CB);
//		//midel.add(Search);
//		
//		
//		return midel;
//		
//		
//	}
//
//	
//	public JPanel CheckTabs()
//	{
//		
//		
//		JPanel midel = new JPanel();
//		
//	//	midel.setSize(100, 450);
//		
//		JLabel label = new JLabel("Student ID");
//		
//		JTextField tf = new JTextField();
//		tf.setColumns(12);
//		
//		JLabel label2 = new JLabel("Student Mark");
//		
//		JTextField tf2 = new JTextField();
//		tf2.setColumns(12);
//		JButton Save = new JButton("Save & Confirm");
//	
//		
//		
//		midel.setLayout(new FlowLayout());
//		midel.setPreferredSize(new Dimension(150,130));
//		midel.add(label);
//		midel.add(tf);
//		midel.add(label2);
//		midel.add(tf2);
//		midel.add(Save);
//		
//		
//		return midel;
//		
//		
//	}
//	
//	public JPanel CreateTextArea(int t)
//	{
//		JPanel cont  = new JPanel();
//		JPanel tables = new JPanel();
//		JPanel other = new JPanel();
//		//JList t = new JList();
//		cont.setLayout(new FlowLayout());
//		JTable table1 = new JTable();
//        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//        JScrollPane sp = new JScrollPane(table1);
//        Object[] col = {"ID","S: Name" , "S: Address","S: E-mail"}; 
//        model1.setColumnIdentifiers(col);
//		//JScrollPane sp = new JScrollPane(t);
//        
//		sp.setPreferredSize(new Dimension(350,320));
//		JLabel Course = new JLabel("Courses");
//		JComboBox<Course> Trainer_Courses = new JComboBox<Course>();
//		Trainer_Courses.setPreferredSize(new Dimension(140,30));
//		for(Course c : Courses)
//		{
////			if(c.getTrainerID().getID() == t){
////				Trainer_Courses.addItem(c);
////				System.out.println("#@$!%");
////			}
////			
//		}
//		
//		
//		for(int x =0 ; x <Trainer_Courses.getItemAt(Trainer_Courses.getSelectedIndex()).Course_Student.size() ; x++)
//	       {
//	       model1.addRow(new Object[]{Trainer_Courses.getItemAt(Trainer_Courses.getSelectedIndex()).Course_Student.get(x).getID(),
//	    		   Trainer_Courses.getItemAt(Trainer_Courses.getSelectedIndex()).Course_Student.get(x).getFirstName()+" "+Trainer_Courses.getItemAt(Trainer_Courses.getSelectedIndex()).Course_Student.get(x).getLastName(),
//	    		   Trainer_Courses.getItemAt(Trainer_Courses.getSelectedIndex()).Course_Student.get(x).getAddress(),
//	    		   Trainer_Courses.getItemAt(Trainer_Courses.getSelectedIndex()).Course_Student.get(x).getEmail()});
//	       }
//		JLabel Student = new JLabel("Student");
//		JComboBox<Student> Trainer_Students = new JComboBox<Student>();
//		Trainer_Students.setPreferredSize(new Dimension(140,30));
//		Trainer_Courses.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Trainer_Students.removeAllItems();
//				for(Student s : Trainer_Courses.getItemAt(Trainer_Courses.getSelectedIndex()).getCourse_Student())
//				{
//					
//					Trainer_Students.addItem(s);
//				}
//				
//				
//			}
//		});
//		
//		
//		
//		JLabel stdMark = new JLabel("Student Mark");
//		JTextField StdMark = new JTextField();
//		StdMark.setPreferredSize(new Dimension(140,30));
//		
//	//	tables.setPreferredSize(new Dimension(300,300));
//		JButton Save = new JButton("Save");
//		
//		Save.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					//dataBaseAccess.getStatement().execute("update Enroll set mark = "+Float.parseFloat(StdMark.getText())+" where SID = "+Trainer_Students.getItemAt(Trainer_Students.getSelectedIndex()).getID()+" and CID = "+Trainer_Courses.getItemAt(Trainer_Courses.getSelectedIndex()).getID()+"");
//					JOptionPane.showMessageDialog(null, "The Register Complete", "Register Course", JOptionPane.INFORMATION_MESSAGE);
//				} catch (NumberFormatException e) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//				}
//				finally
//				{
//					dataBaseAccess.CloseConnection();
//				}
//				
//			}
//		});
//		//cont.add(cont);
//		cont.setPreferredSize(new Dimension(600,600));
//		other.setPreferredSize(new Dimension(180,239));
//		tables.setPreferredSize(new Dimension(400,500));
//		other.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Student Marks"));
//		
//		tables.add(sp);
//		other.add(Course);
//		other.add(Trainer_Courses);
//		other.add(Student);
//		other.add(Trainer_Students);
//		other.add(stdMark);
//		other.add(StdMark);
//		other.add(Save);
//		
//		cont.add(tables);
//		cont.add(other);
//		return cont;
//		
//	}
//	
//	public JPanel getVarShowStudent( String Title2)
//	{
//		this.VarShowStudent.add(this.CheckTabs("Choose Course",Title2));
//	//	this.VarShowStudent.add(this.CreateTextArea());
//		
//		
//		return this.VarShowStudent;
//		
//	}
//	
//	
//	
//	public JPanel getVarPutStudentsMarks(String Title , int TID)
//	{
//		JPanel tmp = new JPanel();
//		//this.VarPutStudentsMarks.add(this.CreateTextArea());
//		tmp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Student's Marks"));
//		tmp.add(this.CheckTabs());
//		
//		
//		this.VarPutStudentsMarks.add(tmp);
//		
//		return this.VarPutStudentsMarks;
//		
//	}
//	
//	public JPanel CreateStudentScheduel()
//	{
//		JPanel tmp  = new JPanel();
//		JPanel p1 = new JPanel();
//		JLabel name = new JLabel("Student Name");
//		JComboBox CB = new JComboBox();
//	
//		CB.setPreferredSize(new Dimension(140,30));
//		p1.add(name);
//		p1.add(CB);
//		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Student Scheduel"));
//		p1.setPreferredSize(new Dimension(170,100));
//		JPanel p2 = new JPanel();
//		JList scheduel = new JList();
//		scheduel.setPreferredSize(new Dimension(500,200));
//		JScrollPane SP = new JScrollPane(scheduel);
//		SP.setPreferredSize(new Dimension(500,200));
//		p2.setPreferredSize(new Dimension(520,240));
//		p2.add(SP);
//		p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Student Scheduel"));
//		
//		tmp.setPreferredSize(new Dimension(600,400));
//		tmp.add(p1);
//		tmp.add(p2);
//	//	this.VarPrintStudentScheduel.add(p1);
//		this.VarPrintStudentScheduel.add(tmp);
//		this.VarPrintStudentScheduel.setPreferredSize(new Dimension(100,100));
//	//	VarPrintStudentScheduel.setSize(100,100);
//		
//		return this.VarPrintStudentScheduel;
//		
//	}
//	public void getCourses(Statement dataaccess)
//	{
////		try {
////			Course cou = new Course();
////			ResultSet result =  dataaccess.executeQuery("select * from Course");
////			while(result.next())
////				
////			{
////				
////				cou.setID(result.getInt("CID"));
////				cou.setCourseName(result.getString("cname"));
////				cou.setHours(result.getInt("hours"));
////				cou.setPrice(result.getFloat("price"));
////				//System.out.println(""+cou.getCourseName());
////				for(Trainer t: Trainers){
////					if(t.getID() == result.getInt("TID"))
////						cou.setTrainerID(t);
////				
////				}
////				Courses.add(cou);
////				System.out.println(""+cou.getCourseName());
////				cou =  new Course();
////			}
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
////		}
////	}
////	
////	public  void getTrainers(Statement dataaccess)
////
////	{
////		
////		try {
////			Trainer temp = new Trainer();
////			ResultSet result;
////			result = dataaccess.executeQuery("select * from Trainer");
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
////			getCourses(dataaccess);
////			getStudents(dataaccess);
////			getEnroll(dataaccess);
////			
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
////
////
////	public void ComboInputs(JComboBox<Course> cour)
////	{
////		for(Course c : Courses)
////		{
////			if(c.getTrainerID().getID() == this.tid)
////					cour.addItem(c);
////		}
//	}
//	
//	
//	public void getEnroll(Statement dataaccess) 
//	{
//		ResultSet result;
//		Student std = new Student();
//		//System.out.print("-0-0");
//		try {
//			result =  dataaccess.executeQuery("select * from Enroll");
//			while(result.next())
//			{
//				
//				for(int x = 0 ; x<Courses.size() ; x++)
//				{
//					
//					if(Courses.get(x).getID() == result.getInt("CID"))
//					{
//						
//						for(int y = 0 ; y < Students.size() ; y++){
//							if(Students.get(y).getID() == result.getInt("SID")){
//									Courses.get(x).Course_Student.add(Students.get(y));
//									
//							}
//						}
//					}
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.print("Can not Access");
//			JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//		}
//	}
//	public  void getStudents(Statement dataaccess)
//	{
//		
//		try {
//			Student temp = new Student();
//			ResultSet result;
//			result = dataaccess.executeQuery("select * from Student");
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
//		}
//	}
//
//}
