//package UserInterfaces.ManagerInterface;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Insets;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JScrollPane;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
//import javax.swing.table.AbstractTableModel;
//import javax.swing.table.TableModel;
//
//public class ManageContent extends JFrame
//{
//	public ManageContent(){
//		
//		
//		this.setLayout(new BorderLayout());
//		this.setSize(586,560);
//		this.setResizable(false);
//		
//		CreateMenuBar();
//		CreateTabes();
//		//CreateNoteView();
//		
//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	this.setVisible(true);
//	this.setLocationRelativeTo(null);
//	
//	
//	}
//	
//	
//	public void CreateTabes()
//	{
//		
//		JTabbedPane tpane = new JTabbedPane();
//		tpane.addTab("Manage Courses",new ManageCoursePanel(this));
//		tpane.addTab("Manage Employee",new ManageEmployee());
//		tpane.addTab("Manage Financial Files ",new ManageFinacialFiles());
//		tpane.setPreferredSize(new Dimension(580,300));
//		
//		UIManager.getDefaults().put("tpane.contentBorderInsets", new Insets(0,0,0,0));
//		UIManager.getDefaults().put("tpane.tabsOverlapBorder", true);
//		add(tpane,BorderLayout.WEST);
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
//}
