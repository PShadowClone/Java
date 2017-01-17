//package UserInterfaces.ManagerInterface;
//
//import java.awt.BorderLayout;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTabbedPane;
//
//public class ManageCoursePanel extends JTabbedPane
//{
//	
//	JFrame frame;
//	public ManageCoursePanel(JFrame frame)
//	{
//		this.frame = frame;
//		CreateInternalTabs();
//	}
//
//	
//	public void CreateInternalTabs()
//	
//	{
//		
//		PanelsForInternalTabs PFIT = new  PanelsForInternalTabs(frame);
//		PFIT.getTrainers();
//		PFIT.getCourses();
//		this.addTab("Add Course",PFIT.getGeneral());
//		this.addTab("Remove Course",PFIT.RemoveCourseButtons());
//		this.addTab("Edit Course",PFIT.getGeneral3());
//		this.addTab("Print All Courses",PFIT.CreateViews());
//		this.addTab("Confirm Student Requests",new JButton("Tabe"));
//		this.addTab("Graduate Student",new JButton("Tabe"));
//	}
//}
