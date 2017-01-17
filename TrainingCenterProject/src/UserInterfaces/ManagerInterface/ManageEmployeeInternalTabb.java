//package UserInterfaces.ManagerInterface;
//
//import java.awt.BorderLayout;
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
//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.table.DefaultTableModel;
//
//import ActionsPackage.DataBaseAccess;
//import Entities.Course;
//import Entities.Trainer;
//
//public class ManageEmployeeInternalTabb 
//{
//	private JPanel CGeneral;
//	private JPanel SGeneral;
//	private JPanel RGeneral;
//	private JPanel EGeneral;
//	ArrayList<Trainer> Trainers = new ArrayList<Trainer>();
//	DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
//	public  Connection connect;
//	public  Statement statement;
//	
//	public ManageEmployeeInternalTabb()
//	{
//		CGeneral = new JPanel();
//		CGeneral.setLayout(new FlowLayout());
//		SGeneral = new JPanel();
//		SGeneral.setLayout(new FlowLayout());
//		RGeneral = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		EGeneral = new JPanel();
//	}
//	
//	public JPanel CreateTrainer()
//	{
//		String s  , sort;
//		JPanel TrainerPanel = new JPanel();
//		TrainerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//		TrainerPanel.setPreferredSize(new Dimension(180,440));
//		TrainerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Add Employee"));
//		
//		JLabel Fname = new JLabel("First Name");
//		final JTextField fname = new JTextField();
//		fname.setColumns(12);
//		
//		JLabel Sname = new JLabel("Second Name");
//		final JTextField sname = new JTextField();
//		sname.setColumns(12);
//		
//		JLabel ID = new JLabel(" ID    ");
//		final JTextField id = new JTextField();
//		id.setColumns(12);
//		
//		JLabel DoB = new JLabel("Email");
//		final JTextField dof = new JTextField();
//		dof.setColumns(12);
//		
//		
//		JLabel Phone = new JLabel("Password");
//		final JTextField phone = new JTextField();
//		phone.setColumns(12);
//		
//		
//		
//		JLabel Address = new JLabel("Address");
//		final JTextField address = new JTextField();
//		address.setColumns(12);
//		
//		JLabel Salary = new JLabel("Salary");
//		final JTextField salary = new JTextField();
//		salary.setColumns(12);
//		
//		JLabel sex = new JLabel("Sex : ");
//		JRadioButton Male = new JRadioButton("Male");
//		JRadioButton Female = new JRadioButton("Female");
//		ButtonGroup sexx = new ButtonGroup();
//		sexx.add(Male);
//		sexx.add(Female);
//		if(Male.isSelected())
//		{
//			s = "Male";
//			
//		}
//		else
//		{s="Female";}
//		JRadioButton Trainer = new JRadioButton("Trainer");
//		JRadioButton Secretary = new JRadioButton("Secretary");
//		ButtonGroup sortt = new ButtonGroup();
//		sortt.add(Trainer);
//		sortt.add(Secretary);
//		if(Trainer.isSelected())
//		{
//			sort = "Trainer";
//			
//		}
//		else
//		{sort="Secretary";}
//		JPanel Buttons = new JPanel();
//		JButton Save = new JButton("Save");
//		Buttons.setPreferredSize(new Dimension(150,40));
//		Buttons.add(Save);
//		
//		
//		
//		
//		//TrainerPanel.add( getCreateTrainerButtons(fname.getText(), sname.getText(), Float.parseFloat(salary.getText()), s, sort,dof.getText(),phone.getText() ,address.getText()));
//		
//		
//		
//		
//		Save.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//				try {
//			//	statement = connect.createStatement();
//					if(!(fname.getText().equals("") || sname.getText().equals("") || dof.getText().equals("") || phone.equals("") || id.getText().equals("") || salary.getText().equals("") )){
//					if(sort.equals("Trainer")){
//					dataBaseAccess.getStatement().execute("insert into Trainer (TID,fname,lname,sex,address,email,password,salary) values("+Integer.parseInt(id.getText())+",'"+fname.getText()+"','"+sname.getText()+"','"+s+"','"+dof.getText()+"','"+phone.getText()+"','"+address.getText()+"',"+Integer.parseInt(salary.getText())+")");
//					dataBaseAccess.getStatement().execute("insert into Login(UserName,Password,Status,EID)values('"+fname.getText()+" "+sname.getText()+"','"+phone.getText()+"','trainer',"+Integer.parseInt(id.getText())+")");
//					JOptionPane.showMessageDialog(null, "The "+fname.getText()+" "+sname.getText()+" was Added", "Add Trainer", JOptionPane.INFORMATION_MESSAGE);
//					}else
//					{
//						dataBaseAccess.getStatement().execute("insert into Secretary (SEID,fname,lname,sex,address,email,password,salary) values("+Integer.parseInt(id.getText())+",'"+fname.getText()+"','"+sname.getText()+"','"+s+"','"+dof.getText()+"','"+phone.getText()+"','"+address.getText()+"',"+Integer.parseInt(salary.getText())+")");
//						dataBaseAccess.getStatement().execute("insert into Login(UserName,Password,Status,EID)values('"+fname.getText()+" "+sname.getText()+"','"+phone.getText()+"','Secretary',"+Integer.parseInt(id.getText())+")");
//						JOptionPane.showMessageDialog(null, "The "+fname.getText()+" "+sname.getText()+" was Added", "Add Secretary", JOptionPane.INFORMATION_MESSAGE);
//					}
//					}else{JOptionPane.showMessageDialog(null, "Empty Field", "Input Error", JOptionPane.ERROR_MESSAGE);} 
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
//		});
//		
//		
//		TrainerPanel.add(Fname);
//		TrainerPanel.add(fname);
//		TrainerPanel.add(Sname);
//		TrainerPanel.add(sname);
//		TrainerPanel.add(ID);
//		TrainerPanel.add(id);
//		TrainerPanel.add(DoB);
//		TrainerPanel.add(dof);
//		TrainerPanel.add(Phone);
//		TrainerPanel.add(phone);
//		TrainerPanel.add(Address);
//		TrainerPanel.add(address);
//		TrainerPanel.add(Salary);
//		TrainerPanel.add(salary);
//		TrainerPanel.add(sex);
//		TrainerPanel.add(Male);
//		TrainerPanel.add(Female);
//		TrainerPanel.add(Trainer);
//		TrainerPanel.add(Secretary);
//		TrainerPanel.add(Save);
//		return TrainerPanel;
//		
//	}
//	
//	
//	public JPanel getCreateGeneral1()
//	{
//		CGeneral.add(CreateTrainer());
//		return CGeneral;
//	}
//	
//	public JPanel getCreateTrainerButtons(String fname , String lname,float salary, String s,String sort,String dof,String pass,String address)
//	{
//		JPanel Buttons = new JPanel();
//		JButton Save = new JButton("Save");
//		Buttons.setPreferredSize(new Dimension(150,40));
//		Buttons.add(Save);
//		Save.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				
//			//	try {
//				//	DataBaseAccess.getInstance();
//				//	dataBaseAccess.getStatement().executeUpdate("insert into Trainer (fname , lname , sex,email,password,address,salary) values('"+fname+"','"+lname+"','"+s+"','"+dof+"',"+pass+",'"+address+"',"+salary+")");
//			//	} catch (SQLException e) {
//					// TODO Auto-generated catch block
//				//	e.printStackTrace();
//			//	}
//			}
//		});
//		
//		
//		return Buttons;
//		
//	}
//	
//	
//	public JPanel CreateSecretay()
//	{
//		JPanel TrainerPanel = new JPanel();
//		
//		TrainerPanel.setPreferredSize(new Dimension(150,300));
//		TrainerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//		
//		JLabel Fname = new JLabel("First Name");
//		JTextField fname = new JTextField();
//		fname.setColumns(12);
//		
//		JLabel Sname = new JLabel("Second Name");
//		JTextField sname = new JTextField();
//		sname.setColumns(12);
//		
//		
//		JLabel DoB = new JLabel("Date of Birth");
//		JTextField dof = new JTextField();
//		dof.setColumns(12);
//		
//		
//		JLabel Phone = new JLabel("Phone Number");
//		JTextField phone = new JTextField();
//		phone.setColumns(12);
//		
//		
//		
//		JLabel Address = new JLabel("Address");
//		JTextField address = new JTextField();
//		address.setColumns(12);
//		
//		JLabel Salary = new JLabel("Salary");
//		JTextField salary = new JTextField();
//		salary.setColumns(12);
//		
//		
//		TrainerPanel.add(Fname);
//		TrainerPanel.add(fname);
//		TrainerPanel.add(Sname);
//		TrainerPanel.add(sname);
//		TrainerPanel.add(DoB);
//		TrainerPanel.add(dof);
//		TrainerPanel.add(Phone);
//		TrainerPanel.add(phone);
//		TrainerPanel.add(Address);
//		TrainerPanel.add(address);
//		TrainerPanel.add(Salary);
//		TrainerPanel.add(salary);
//		
//		return TrainerPanel;
//
//		
//	}
//	
//	public JPanel getCreateSecretayButtons()
//	{
//		JPanel Buttons = new JPanel();
//		JButton Save = new JButton("Save");
//		Buttons.setPreferredSize(new Dimension(150,80));
//		Buttons.add(Save);
//		
//		return Buttons;
//		
//	}
//	
//	public JPanel getCreateGeneral2()
//
//
//	{
//		SGeneral.add(CreateTrainer());
//		//SGeneral.add(getCreateTrainerButtons());
//		return SGeneral;
//	}
//	
//	
//	
//	public JScrollPane CreateTextArea()
//	{
//		JTable table1 = new JTable();
//        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
//        JScrollPane sp = new JScrollPane(table1);
//        Object[] col = {"ID","T: Name" , "T: Salary","T: Passwrod"}; 
//        model1.setColumnIdentifiers(col);
//        for(int x =0 ; x < Trainers.size() ; x++){
//        model1.addRow(new Object[]{Trainers.get(x).getID(),Trainers.get(x).getFirstName()+" "+Trainers.get(x).getLastName(),Trainers.get(x).getSalary(),Trainers.get(x).getPassword()});
//        }
//       model1.setRowCount(25);
//	table1.setEnabled(false);
//		
//		sp.setPreferredSize(new Dimension(250,350));
//		return sp;
//		
//	}
//	
//	public JPanel RemoveEmployee()
//	{
//		JPanel p = new JPanel(new FlowLayout());
//		p.setPreferredSize(new Dimension(200,120));
//		p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Employee"));
//		JLabel label = new JLabel();
//		label.setText("Employee Name");
//		JComboBox<Trainer> TrainersName = new JComboBox<Trainer>();
//		TrainersName.setPreferredSize(new Dimension(130,30));
//		ComboInputs(TrainersName);
//		p.add(label);
//		p.add(TrainersName);
//		p.add(RemoveTrainerButtons(TrainersName));
//		RGeneral.add(CreateTextArea());
//		RGeneral.add(p);
//		
//		
//		return RGeneral;
//		
//	}
//	
//	public JButton RemoveTrainerButtons(JComboBox<Trainer> temp)
//	{
//		JButton remove = new JButton("Remove");
//		remove.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					dataBaseAccess.getStatement().execute("delete from Trainer where TID = "+temp.getItemAt(temp.getSelectedIndex()).getID()+"");
//					
//					temp.removeItemAt(temp.getSelectedIndex());
//					 JOptionPane.showMessageDialog(null, "The "+temp.getItemAt(temp.getSelectedIndex()).getFirstName() +" "+temp.getItemAt(temp.getSelectedIndex()).getLastName()+" was deleted", "Remove Trainer", JOptionPane.INFORMATION_MESSAGE);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					//e.printStackTrace();
//					 JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//				}finally
//				{
//					dataBaseAccess.CloseConnection();
//				}
//				
//			}
//		});
//		return remove;
//	}
//
//	public JPanel GiveExtraMoney()
//	{
//		
//		
//		JPanel midel = new JPanel();
//		
//		//midel.setSize(100, 200);
//		midel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Employee"));
//		JLabel label = new JLabel("Employee ID");
//		
//		JComboBox<Trainer> TrainersName = new JComboBox<Trainer>();
//		TrainersName.setPreferredSize(new Dimension(130,30));
//		ComboInputs(TrainersName);
//		JButton Search = new JButton("Confirm");
//		JLabel label2 = new JLabel("Extra Money");
//		JTextField tff = new JTextField();
//		tff.setColumns(12);
//		
//		JButton Save = new JButton("Save & Confirm");
//		Save.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				for(Trainer t : Trainers)
//				{
//					if(t.getID() == TrainersName.getItemAt(TrainersName.getSelectedIndex()).getID())
//					{
//						TrainersName.getItemAt(TrainersName.getSelectedIndex()).setSalary(TrainersName.getItemAt(TrainersName.getSelectedIndex()).getSalary() + Float.parseFloat(tff.getText()));
//					}
//						
//				}
//				try {
//					dataBaseAccess.getStatement().execute("update Trainer set salary = "+TrainersName.getItemAt(TrainersName.getSelectedIndex()).getSalary()+" where TID = "+TrainersName.getItemAt(TrainersName.getSelectedIndex()).getID()+"");
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//				}finally
//				{
//					dataBaseAccess.CloseConnection();
//				}
//				
//			}
//		});
//		midel.setLayout(new FlowLayout());
//		midel.setPreferredSize(new Dimension(150,170));
//		midel.add(label);
//		midel.add(TrainersName);
//	//	midel.add(Search);
//		midel.add(label2);
//		midel.add(tff);
//		midel.add(Save);
//		
//		
//		EGeneral.add(CreateTextArea());
//		EGeneral.add(midel,SwingConstants.VERTICAL | SwingConstants.CENTER );
//		
//		return EGeneral;
//		
//	}
//	
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
//			JOptionPane.showMessageDialog(null, "Lsot Connection with DataBase", "Exception", JOptionPane.ERROR_MESSAGE);
//		}finally
//		{
//			dataBaseAccess.CloseConnection();
//		}
//	}
//
//	public void ComboInputs(JComboBox<Trainer> cour)
//	{
//		for(Trainer t : Trainers)
//		{
//			cour.addItem(t);
//		}
//	}
//}
