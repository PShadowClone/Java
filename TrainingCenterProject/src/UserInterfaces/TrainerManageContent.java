//package UserInterfaces;
//
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//
//import javax.swing.JFrame;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JTabbedPane;
//import javax.swing.JTextArea;
//
////import UserInterfaces.SecretaryManagementTabbs;
//
//public class TrainerManageContent extends JFrame
//{
//	
//	int TID ;
//	
//	
//	public TrainerManageContent(int TID)
//	{
//		this.TID = TID;
//	//	new TrainerManageContent();
//		
//		this.setLayout(new BorderLayout());
//		this.setSize(880,450);
//		this.setResizable(false);
//		
//		
//		//CreateNoteView();
//		
//		
//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	this.setVisible(true);
//	this.setLocationRelativeTo(null);
//	CreateMenuBar();
//	CreateTabes(this.TID);
//	}
//	//public TrainerManageContent()
//	//{
//
//		//this.setLayout(new BorderLayout());
//		//this.setSize(880,450);
//		//this.setResizable(false);
//		
//		
//		//CreateNoteView();
//		
//		
//	//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////	this.setVisible(true);
//	//this.setLocationRelativeTo(null);
//	//CreateMenuBar();
//	//CreateTabes();
//		
////	}
//	
//	
//	public void CreateTabes(int id)
//	{
//	
//		TrainerManagementTabbs TMT = new TrainerManagementTabbs(this.TID);
//		
//		
//		
//		
//		
//		JTabbedPane tpane = new JTabbedPane();
//		tpane.addTab("Show Students in Course",TMT.CheckTabs("Course ID" , "Student"));
//		tpane.addTab("Put Students Marks", TMT.CreateTextArea(this.TID));
//	//	tpane.addTab("Show Student Schedule",TMT.CreateStudentScheduel());
//		tpane.setPreferredSize(new Dimension(880,300));
//		
//		this.getContentPane().add(tpane,BorderLayout.WEST);
//		
//	}
//	
//	
//	public void CreateNoteView()
//	{
//		JTextArea ShowText = new JTextArea();
//		ShowText.setPreferredSize(new Dimension(700,100));
//		add(ShowText , BorderLayout.PAGE_END);
//	}
//	
//	
//	public void CreateMenuBar()
//	{
//		JMenuBar Mp = new JMenuBar();
//		JMenu file = new JMenu("File");
//		JMenu show = new JMenu("Show");
//		JMenu about = new JMenu("About");
//		Mp.add(file);
//		Mp.add(show);
//		Mp.add(about);
//		this.setJMenuBar(Mp);
//	}
//	
//
//	
//	public static void main(String args[])
//	{
//		new TrainerManageContent(4);
//	}
//}
