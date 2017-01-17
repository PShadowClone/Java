//package UserInterfaces.ManagerInterface;
//
//import java.awt.BorderLayout;
//import java.awt.Button;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Graphics;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.GridLayout;
//import java.awt.Paint;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Vector;
//import java.util.regex.Pattern;
//
//import javax.swing.BorderFactory;
//import javax.swing.BoxLayout;
//import javax.swing.DefaultListModel;
//import javax.swing.Icon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPopupMenu;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.border.Border;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.text.IconView;
//
//import ActionsPackage.DataBaseAccess;
//import Entities.Course;
//import Entities.Trainer;
//
//
//
//public class PanelsForInternalTabs  
//{
//	private JPanel G ;
//	JPanel G2;
//	JPanel G3;
//	private static String CourseName;
//	JFrame frame;
//	private  Connection connect;
//	private  Statement statement;
//	DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
//	ArrayList<Trainer> Trainers = new ArrayList<Trainer>();
//	ArrayList<Course> Courses = new ArrayList<Course>();
//	 Trainer temp ;
//	 boolean stauts = false;
//	public PanelsForInternalTabs(JFrame frame)
//	{
//		this.frame = frame;
//		G = new JPanel();
//		G.setLayout(new FlowLayout());
//		G2 = new JPanel();
//		G3 = new JPanel();
//		G3.setLayout(new FlowLayout());
//	}
//
//	public JPanel AddCourseTabe()
//	{
//		
//		JPanel ManageCourse = new JPanel();
//		
//	
//		
//		ManageCourse.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Add Course"));
//		
//		 
//		JLabel AddCourse = new JLabel("Course Name");
//		JTextField add = new JTextField();
//		add.setColumns(12);
//		
//		ManageCourse.setPreferredSize(new Dimension(180,380));
//		ManageCourse.setLayout(new FlowLayout(FlowLayout.CENTER));
//		
//		JLabel Hours = new JLabel("Hours");
//		JTextField hours = new JTextField();
//		hours.setColumns(12);
//		
//		
//		
//		JLabel Start = new JLabel("Start Date");
//		JTextField start = new JTextField();
//		start.setColumns(12);
//		start.setToolTipText("mm/dd/yyyy");
//		
//		JLabel End = new JLabel("End Date");
//		JTextField end = new JTextField();
//		end.setColumns(12);
//		end.setToolTipText("mm/dd/yyyy");
//		
//		
//		JLabel Money = new JLabel("Course Price   ");
//		JTextField money = new JTextField();
//		money.setColumns(12);
//		
//		
//		JLabel CT = new JLabel("Course Trainer   ");
//		JComboBox<Trainer> Course_Trainer = new JComboBox<Trainer>();
//		Course_Trainer.setPreferredSize(new Dimension(130,30));
//		
//		for(Trainer t : Trainers)
//		{
//			Course_Trainer.addItem(t);
//		}
//
//		
//				
//		
//		
//		
//		
//		JButton Save= new JButton("Save");
//		Save.setPreferredSize(new Dimension(100,50));
//		Save.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//		
//		
//		ManageCourse.add(AddCourse);
//		ManageCourse.add(add);
//		ManageCourse.add(Hours);
//		ManageCourse.add(hours);
//		ManageCourse.add(Start);
//		ManageCourse.add(start);
//		ManageCourse.add(End);
//		ManageCourse.add(end);
//		ManageCourse.add(Money);
//		ManageCourse.add(money);
//		ManageCourse.add(CT);
//		ManageCourse.add(Course_Trainer);
//		ManageCourse.add(AddCourseButtons(add, hours, money,Course_Trainer.getItemAt(Course_Trainer.getSelectedIndex())));
//		
//		
//		
//		return ManageCourse;
//		
//		
//	}
//	
//	public JPanel AddCourseButtons(JTextField add , JTextField hours , JTextField money , Trainer train)
//	{
//		
//		JPanel p = new JPanel();
//		
//		JButton Save= new JButton("Save");
//		Save.setPreferredSize(new Dimension(100,50));
//		Save.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//			Save.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					
//					if(!(add.getText().equals("") || hours.getText().equals("") || money.getText().equals("") || train.equals(""))){
//						
//								dataBaseAccess.getStatement().executeUpdate("insert into Course (cname,hours,price,TID) values('"+add.getText()+"',"+Integer.parseInt(hours.getText())+","+Integer.parseInt(money.getText())+","+train.getID()+")");
//					
//								JOptionPane.showMessageDialog(null, "The course was Saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
//					}else
//					{
//						JOptionPane.showMessageDialog(null, "Empty Field", "Input Error", JOptionPane.ERROR_MESSAGE);
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					System.out.print("Amr1");
//				} catch(java.lang.NumberFormatException ex)
//				{
//					JOptionPane.showMessageDialog(null, "You Sould input real values ", "Input Error", JOptionPane.ERROR_MESSAGE);
//				}
//				finally
//				{
//					
//						dataBaseAccess.CloseConnection();
//					
//				}
//				
//			}
//		});
//		p.setPreferredSize(new Dimension(100,60));
//		p.add(Save);
//	
//		return p;
//	
//	}
//
//	public JPanel getGeneral()
//	{ 
//		G.add(AddCourseTabe());
//		
//		return G;
//	}
//	
//
//	public JPanel RemoveCourse()
//	{
//		JPanel p = new JPanel();
//		
//		return p;
//	}
//	
//	public JPanel RemoveCourseButtons()
//	{
//		JPanel cont = new JPanel();
//		JPanel p = new JPanel();
//		p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Remove Course"));
//		JLabel label = new JLabel();
//		label.setText("Course Name");
//		JComboBox<Course> cour = new JComboBox<Course>();
//		cour.setPreferredSize(new Dimension(130,30));
//		
//		ComboInputs(cour);
//		
//		
//		JButton remove = new JButton("Remove");
//		remove.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					System.out.println(""+cour.getItemAt(cour.getSelectedIndex()).getID());
//					dataBaseAccess.getStatement().execute("Delete from Course where CID="+cour.getItemAt(cour.getSelectedIndex()).getID()+"");
//					 JOptionPane.showMessageDialog(null, "The "+cour.getItemAt(cour.getSelectedIndex()).getCourseName()+" was deleted", "Remove Course", JOptionPane.INFORMATION_MESSAGE);
//					cour.removeItemAt(cour.getSelectedIndex());
//					
//					 Courses.remove(cour.getSelectedIndex());
//					// cont.remove(RemoveCourseList());
//					 //cont.add(RemoveCourseList());
//					 //RemoveCourseList();
//					 JOptionPane.showMessageDialog(null, "The Course was removed", "remove", JOptionPane.ERROR_MESSAGE);
//					 stauts  =true;
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}finally
//				{
//					dataBaseAccess.CloseConnection();
//				}
//				
//			}
//		});
//		
//			cont.add(RemoveCourseList());
//		p.setPreferredSize(new Dimension(150,120));
//		p.add(label);
//		p.add(cour);
//		p.add(remove);
//		cont.add(p);
//		return cont;
//	}
//	
//	public JPanel getGeneral2()
//	{
//		G2.add(RemoveCourseList());
//	
//		G2.add(RemoveCourseButtons(),SwingConstants.VERTICAL | SwingConstants.CENTER);
//		return G2;
//		
//	}
//	
//	public JComboBox<Course> EditCourseTab()
//	{
//		
//		
//		JPanel midel = new JPanel();
//		
//		midel.setSize(100, 350);
//		midel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Choose Course"));
//		JLabel label = new JLabel("Course");
//		JComboBox<Course> CB = new JComboBox<Course>();
//		this.ComboInputs(CB);
//		CB.setPreferredSize(new Dimension(130,30));
//		
//		
//		
//	//	JButton Save = new JButton("Save");
//		
//		midel.setLayout(new FlowLayout());
//		midel.setPreferredSize(new Dimension(150,100));
//		midel.add(label);
//		midel.add(CB);
//		
//		
//		//midel.add(Save);
//		
//		
//	//	G3.add(CreateTextArea());
//		G3.add(midel);
//		
//		return CB;
//		
//	}
//	
//	public JPanel EditCourseTabButton()
//	{
//		JPanel p = new JPanel();
//		JButton button = new JButton("Save");
//		button.setPreferredSize(new Dimension(100,50));
//		button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//		p.setPreferredSize(new Dimension(100,60));
//		p.add(button);
//		return p;
//		
//	} 
//	
//	
//	public JPanel getGeneral3()
//	{
//		
//		
//		G3.add(EditCourse(EditCourseTab()));
//		
//		
//		return G3;
//	}
//	
//	public JPanel EditCourse(JComboBox<Course>CB)
//	{
//		
//		JPanel ManageCourse = new JPanel();
//		
//	
//		
//		ManageCourse.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Add Course"));
//		
//		 
//		JLabel AddCourse = new JLabel("Course Name");
//		JTextField add = new JTextField();
//		add.setColumns(12);
//		
//		ManageCourse.setPreferredSize(new Dimension(180,380));
//		ManageCourse.setLayout(new FlowLayout(FlowLayout.CENTER));
//		
//		JLabel Hours = new JLabel("Hours");
//		JTextField hours = new JTextField();
//		hours.setColumns(12);
//		
//		
//		
//		JLabel Start = new JLabel("Start Date");
//		JTextField start = new JTextField();
//		start.setColumns(12);
//		start.setToolTipText("mm/dd/yyyy");
//		
//		JLabel End = new JLabel("End Date");
//		JTextField end = new JTextField();
//		end.setColumns(12);
//		end.setToolTipText("mm/dd/yyyy");
//		
//		
//		JLabel Money = new JLabel("Course Price   ");
//		JTextField money = new JTextField();
//		money.setColumns(12);
//		
//		
//		JLabel CT = new JLabel("Course Trainer   ");
//		JComboBox<Trainer> Course_Trainer = new JComboBox<Trainer>();
//		Course_Trainer.setPreferredSize(new Dimension(130,30));
//		
//		for(Trainer t : Trainers)
//		{
//			Course_Trainer.addItem(t);
//			System.out.println(t.getFirstName());
//			
//		}
//		
//
//		
//				CB.addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						add.setText(CB.getItemAt(CB.getSelectedIndex()).getCourseName());
//						hours.setText(""+CB.getItemAt(CB.getSelectedIndex()).getHours());
//						money.setText(""+CB.getItemAt(CB.getSelectedIndex()).getPrice());
//						add.setText(CB.getItemAt(CB.getSelectedIndex()).getCourseName());
//						Course_Trainer.setSelectedItem(CB.getItemAt(CB.getSelectedIndex()).getTrainerID());
//						
//						
//					}
//				});
//		
//		
//		
//		
//		JButton Save= new JButton("Save");
//		Save.setPreferredSize(new Dimension(100,50));
//		Save.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//		Save.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				try {
//					dataBaseAccess.getStatement().executeUpdate("UPDATE Course set cname = '"+add.getText()+"', hours = "+Integer.parseInt(hours.getText())+",  price = "+Float.parseFloat(money.getText())+", TID = "+Course_Trainer.getItemAt(Course_Trainer.getSelectedIndex()).getID()+" where CID = "+CB.getItemAt(CB.getSelectedIndex()).getID()+" ");
//					 JOptionPane.showMessageDialog(null, "The "+add.getText()+" was updated", "Update Course", JOptionPane.INFORMATION_MESSAGE);
//				} catch (NumberFormatException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}finally
//				{
//					dataBaseAccess.CloseConnection();
//				}
//				
//			}
//		});
//		
//		ManageCourse.add(AddCourse);
//		ManageCourse.add(add);
//		ManageCourse.add(Hours);
//		ManageCourse.add(hours);
//		ManageCourse.add(Start);
//		ManageCourse.add(start);
//		ManageCourse.add(End);
//		ManageCourse.add(end);
//		ManageCourse.add(Money);
//		ManageCourse.add(money);
//		ManageCourse.add(CT);
//		ManageCourse.add(Course_Trainer);
//		ManageCourse.add(Save);
//		
//		
//		
//		return ManageCourse;
//		
//		
//	}
//	public JScrollPane CreateTextArea()
//	{
//		JTable table1 = new JTable();
//        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//        JScrollPane sp = new JScrollPane(table1);
//        Object[] col = {"ID","C: Name" , "C: Price","C: Hours"}; 
//        model1.setColumnIdentifiers(col);
//        for(int x =0 ; x < Courses.size() ; x++){
//        model1.addRow(new Object[]{Courses.get(x).getID(),Courses.get(x).getCourseName(),Courses.get(x).getPrice(),Courses.get(x).getHours()});
//        }
//       model1.setRowCount(25);
//       table1.setEnabled(false);
//		
//		sp.setPreferredSize(new Dimension(250,350));
//		return sp;
//		
//	}
//	
//	public JPanel CreateViews()
//	{
//		JPanel view = new JPanel();
//		view.add(CreateTextArea());
//		
//		return view;
//	}
//	
//	
//	public static String getCourseName()
//	{
//		return CourseName;
//	}
//	
//	public  void getTrainers()
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
//	public JScrollPane RemoveCourseList()
//	{
//		
//		DefaultListModel<Course> Course_View = new DefaultListModel<Course>();
//		JList<Course> t = new JList<Course>(Course_View);
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
//       table1.setEnabled(false);
//		sp.setPreferredSize(new Dimension(320,350));
//		
//		return sp;
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
//	public void ComboInputs(JComboBox<Course> cour)
//	{
//		for(Course c : Courses)
//		{
//			cour.addItem(c);
//		}
//	}
//	
//	public JScrollPane REmoveUpadte()
//	{
//		JTable table1 = new JTable();
//        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//        JScrollPane sp = new JScrollPane(table1);
//        Object[] col = {"ID","C: Name" , "C: Price","C: Hours"}; 
//        model1.setColumnIdentifiers(col);
//        for(int x =0 ; x < Courses.size() ; x++){
//        model1.addRow(new Object[]{Courses.get(x).getID(),Courses.get(x).getCourseName(),Courses.get(x).getPrice(),Courses.get(x).getHours()});
//        }
//       model1.setRowCount(25);
//       table1.setEnabled(false);
//		sp.setPreferredSize(new Dimension(320,350));
//		return sp;
//	}
//}
