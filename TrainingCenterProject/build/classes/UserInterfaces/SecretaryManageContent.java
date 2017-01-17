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
//import UserInterfaces.ManagerInterface.ManageCoursePanel;
//import UserInterfaces.ManagerInterface.ManageEmployee;
//import UserInterfaces.ManagerInterface.ManageFinacialFiles;
//
//public class SecretaryManageContent extends JFrame
//{
//	public SecretaryManageContent()
//	{
//		this.setLayout(new BorderLayout());
//		this.setSize(586,500);
//		this.setResizable(false);
//		
//		CreateMenuBar();
//		CreateTabes();
//	//	CreateNoteView();
//		
//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	this.setVisible(true);
//	this.setLocationRelativeTo(null);
//	}
//	
//	
//	public void CreateTabes()
//	{
//		SecretaryManagementTabbs SMT = new SecretaryManagementTabbs();
//		SMT.getStudents();
//		SMT.getCourses();
//		SMT.getTrainers();
//		JTabbedPane tpane = new JTabbedPane();
//		tpane.addTab("Create Student Account",SMT.getVarCreateStudentAccount());
//		tpane.addTab("Print Student Report", SMT.CheckTabs("Studnet ID"));
//		tpane.addTab("Print Student Schdule",SMT.addCoursetoStudent());
//	
//		tpane.setPreferredSize(new Dimension(880,300));
//		
//		add(tpane);
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
//	public static void main(String args[])
//	{
//		new SecretaryManageContent();
//	}
//
//}
