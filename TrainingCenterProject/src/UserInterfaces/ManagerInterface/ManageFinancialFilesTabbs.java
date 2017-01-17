//package UserInterfaces.ManagerInterface;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JList;
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
//public class ManageFinancialFilesTabbs  
//{
//
//	JPanel VerCeckStudent;
//	JPanel VerAddCourseMoney;
//	JPanel VerCheckEmployee;
//	JPanel VerDiscountForStudent;
//	ArrayList<Student> Students = new ArrayList<Student>();
//	ArrayList<Course> Courses = new ArrayList<Course>();
//	ArrayList<Trainer> Trainers = new ArrayList<Trainer>();
//	DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
//	JComboBox<Trainer> tempTrainer;
//	Trainer t = new Trainer();
//	public ManageFinancialFilesTabbs()
//	{
//		VerCeckStudent = new JPanel(new FlowLayout());
//		VerAddCourseMoney = new JPanel(new FlowLayout());
//		VerCheckEmployee = new JPanel(new FlowLayout());
//		VerDiscountForStudent = new JPanel(new FlowLayout());
//		
//	}
//	
//	
//	
//	public JPanel CheckTabs(String Title1 ,String Title2 )
//	{
//		
//		
//		JPanel midel = new JPanel();
//		JPanel buto = new JPanel();
//		midel.setSize(100, 350);
//		
//		JLabel label = new JLabel(Title2);
//		
//		JComboBox<Trainer> TrainersName = new JComboBox<Trainer>();
//		TrainersName.setPreferredSize(new Dimension(130,30));
//		TrainersInputs(TrainersName);
//		JButton Search = new JButton("Search");
//		 JTable table1 = new JTable();
//	      DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//	      JScrollPane sp = new JScrollPane(table1);
//	      Object[] col = {"ID","T: Name" , "T: Salary","T: Passwrod"}; 
//	      model1.setColumnIdentifiers(col);
//	     
//	        		
//	       
//		sp.setPreferredSize(new Dimension(300,350));
//		Search.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent event) {
//				
//				tempTrainer = TrainersName;
//				t= TrainersName.getItemAt(TrainersName.getSelectedIndex());
//				model1.addRow(new Object[]{t.getID(),t.getFirstName()+" "+t.getLastName(),t.getSalary(),t.getPassword()});
//			}
//		});
//		//midel.setPreferredSize(new Dimension(300,300));
//		buto.add(label);
//		buto.add(TrainersName);
//		buto.add(Search);
//		buto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), Title1));
//		midel.setLayout(new FlowLayout());
//		buto.setPreferredSize(new Dimension(150,120));
//		
//		midel.add(buto);
//		midel.add(sp);
//		
//		return midel;
//		
//	}
//
//	
//	public JScrollPane CreateTextArea()
//	{
//		JList t = new JList();
//		
//		JTable table1 = new JTable();
//        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//        JScrollPane sp = new JScrollPane(table1);
//        Object[] col = {"ID","S: Name" , "S: Address","S: E-mail"}; 
//        model1.setColumnIdentifiers(col);
//        for(int x =0 ; x < Students.size() ; x++){
//        model1.addRow(new Object[]{Students.get(x).getID(),Students.get(x).getFirstName()+" "+Students.get(x).getLastName(),Students.get(x).getAddress(),Students.get(x).getEmail()});
//        }
//       model1.setRowCount(25);
//	table1.setEnabled(false);
//		sp.setPreferredSize(new Dimension(300,350));
//		return sp;
//		
//	}
//	public JScrollPane PrintCourses()
//	{
//		JList t = new JList();
//		
//		JTable table1 = new JTable();
//        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//        JScrollPane sp = new JScrollPane(table1);
//        Object[] col = {"ID","C: Name" , "C: Price","C: Hours"}; 
//        model1.setColumnIdentifiers(col);
//        for(int x =0 ; x < Courses.size() ; x++){
//        model1.addRow(new Object[]{Courses.get(x).getID(),Courses.get(x).getCourseName(),Courses.get(x).getPrice(),Courses.get(x).getHours()});
//        }
//       model1.setRowCount(25);
//	table1.setEnabled(false);
//		sp.setPreferredSize(new Dimension(300,350));
//		return sp;
//		
//	}
//	
//	public JPanel getVerTextArea(String Title)
//	{
//		this.VerCeckStudent.add(CreateTextArea());
//		//this.VerCeckStudent.add(CheckTabs(Title , "Student Name"),SwingConstants.VERTICAL | SwingConstants.CENTER );
//		return this.VerCeckStudent;
//		
//	}
//	
//	public void PrintTrainerDetails(Trainer tmp)
//	{
//		JList<String> t = new JList<String>();
//		
//		
//		
//	}
//	public JPanel AddMoney(String Title1 , String Title2 , String Title3)
//	{
//
//		JPanel midel = new JPanel();
//		
//		midel.setSize(100, 350);
//		midel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), Title3));
//		JLabel label = new JLabel(Title1);
//		
//		JComboBox<Course> Course_Combo = new JComboBox<Course>();
//		Course_Combo.setPreferredSize(new Dimension(130,30));
//	//	JButton Search = new JButton("Search");
//		JLabel label2 = new JLabel(Title2);
//		JTextField tff = new JTextField();
//		tff.setColumns(12);
//		ComboInputs(Course_Combo);
//		JButton Save = new JButton("Save & Confirm");
//		
//		midel.setLayout(new FlowLayout());
//		midel.setPreferredSize(new Dimension(150,180));
//		midel.add(label);
//		midel.add(Course_Combo);
//		//midel.add(Search);
//		midel.add(label2);
//		midel.add(tff);
//		midel.add(Save);
//		
//		Save.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				
//				try {
//					dataBaseAccess.getStatement().execute("update Course set price = "+Float.parseFloat(tff.getText())+" where CID = "+Course_Combo.getItemAt(Course_Combo.getSelectedIndex()).getID()+"");
//				} catch (NumberFormatException | SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}finally
//				{
//					dataBaseAccess.CloseConnection();
//				}
//				
//			}
//		});
//		
//		
//		return midel;
//	}
//	
//	public JPanel getVerAddCourseMoney(String Tilte3)
//	{
//		this.VerAddCourseMoney.add(PrintCourses());
//		this.VerAddCourseMoney.add(AddMoney("Course ID","Course Money",Tilte3),SwingConstants.VERTICAL | SwingConstants.CENTER );
//		return this.VerAddCourseMoney;
//		
//	}
//	
//	public JPanel getVerCheckEmployee(String Title)
//	{
//	//	this.VerCheckEmployee.add(PrintTrainerDetails());
//		this.VerCheckEmployee.add(CheckTabs(Title , "Employee Name"));
//		return this.VerCheckEmployee;
//	}
//	
//	
//	public JPanel getVerDiscountForStudent(String Title)
//	{
//		this.VerDiscountForStudent.add(CreateTextArea());
//		this.VerDiscountForStudent.add(AddMoney("Student ID", "Discount Amount" , Title));
//		return this.VerDiscountForStudent;
//	}
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
//			e.printStackTrace();
//		}finally
//		{
//			dataBaseAccess.CloseConnection();
//		}
//	}
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
//			e.printStackTrace();
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
//			e.printStackTrace();
//		}finally
//		{
//			dataBaseAccess.CloseConnection();
//		}
//	}
//
//	public void ComboInputs(JComboBox<Course> cour)
//	{
//		for(Course c : Courses)
//		{
//			cour.addItem(c);
//		}
//	}
//	public void TrainersInputs(JComboBox<Trainer> cour)
//	{
//		for(Trainer c : Trainers)
//		{
//			cour.addItem(c);
//		}
//	}
//}
