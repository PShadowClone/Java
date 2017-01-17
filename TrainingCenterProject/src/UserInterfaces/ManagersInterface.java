/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterfaces;

import ActionsPackage.DataBaseAccess;
import Entities.Course;
import Entities.Employee;
import Entities.Person;
import Entities.Trainer;
import AdditionFactory.AddOperations;
import AdditionFactory.EmployeeFactory;
import AdditionFactory.FactoryFacade;
import EdittingPackage.EdittingFacade;
import Entities.Secretary;
import GettingFactory.GettingFacade;
import RemovingPackage.RemoveFacade;
import RemovingPackage.RemoveFactory;
import UpdatingPackage.UpdateComboBox;
import UpdatingPackage.UpdateCourseTable;
import UpdatingPackage.UpdatingCourse;

//import UserInterfaces.ManagerInterface.Operations;
//import UserInterfaces.ManagerInterface.RemoveCourse;
//import UserInterfaces.ManagerInterface.ValidationClass;
import com.sun.org.apache.xpath.internal.FoundIndex;
import datechooser.events.CursorMoveEvent;
import datechooser.events.CursorMoveListener;
import datechooser.events.SelectionChangedEvent;
import datechooser.events.SelectionChangedListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AmrSaidam
 */
public class ManagersInterface extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form ManagersInterface
     */
//    Operations op = new Operations();
    Insets taskBar = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
//    ValidationClass VC = new ValidationClass();
//    RemoveCourse RC = new RemoveCourse();
//    EditCourse EC;
    Random input = new Random(6);
    private boolean CNStatus = false;
    private boolean ComStatus = false;
    private boolean SDStatus = false;
    private boolean status1 = false;

    Course temp = null;
    Course temper = null;
    ArrayList<Trainer> Employees;
    ArrayList<Secretary> secretary;
    DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance();
    ArrayList<Course> Courses = new ArrayList<Course>();
    ArrayList<Integer> indexs = null;
    List<String> permissions = null;
    List<String> allExtensions;
    UpdateComboBox updateCmob;
    UpdatingCourse updateCourse;
    //UpdateCourseTable updateCourseTable;

    boolean flage = false;

    DefaultTableModel model;
    DefaultTableModel removeModel;
    DefaultTableModel EmployeeModel;

    //  AddEmployee AE;
    public ManagersInterface() {
        initComponents();
        allExtensions = new ArrayList<>();
        ex2.setVisible(false);
        ext3.setVisible(false);
        model = (DefaultTableModel) showCourse.getModel();
        removeModel = (DefaultTableModel) removeCourse.getModel();
        EmployeeModel = (DefaultTableModel) EmployeeTable.getModel();
//        for (Trainer temps : Employees) {
//            Trainers.addItem(temps);
//            Trainers2.addItem(temps);
//            System.out.println(""+temps.getFirstName());
//           
//        }
        updateCmob = new UpdateComboBox();
        updateCourse = new UpdatingCourse();
        //  updateCourseTable = new UpdateCourseTable();
        updateCmob.addObserver(this);
        updateCourse.addObserver(this);
        //    updateCourseTable.addObserver(this);
        try {
            updateCmob.fillComboBoxes();
            updateCourse.fillCourses();
            //   updateCourseTable.CreateTextArea(model, showCourse, Courses);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        //  for(Secretary temp : secretary)
        {
            // System.out.println(""+temp.getFirstName());
            //jComboBox6.addItem(temp);
        }

//        try {
//            Employees =  (ArrayList<Trainer>) GettingFacade.Instance.getTrainers();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//         for (Person temp : Employees) {
//            Trainers.addItem(temp);
//            Trainers2.addItem(temp);
//           
//        }
//        ArrayList<Person> persons = new ArrayList<>();
//        persons.addAll(Employees);
//        persons.addAll(secretary);
//        
//        for (Person temps : persons) {
//            AllEmployees.addItem(temps);
//        }
//        
//        try {
//            Courses = (ArrayList<Course>) GettingFacade.Instance.getCourses();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        for (Course temp : Courses) {
//            Courses2.addItem(temp);
//        }
// /        this.getTrainers();
        //     this.getCourses();
        //   this.print();
//        AE = new AddEmployee(fname, fn,
//                lname, sn,
//                male, female,
//                Address, email, ext,
//                ex2, salary, sl, shek,
//                pass, repass, parr, ps, reps, war, Employees, trainer, sec);
        System.out.println("Before");

//        EC = new EditCourse();
        System.out.println("After");

        System.out.println("After then");
        this.setLocationRelativeTo(null);
        //this.setLayout(new FlowLayout());
        this.Add_Item_To_ComboPrice();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        CourseName.requestFocusInWindow();
        ButtonGroup br = new ButtonGroup();
        br.add(sec);
        br.add(trainer);

        ButtonGroup br3 = new ButtonGroup();
        br3.add(male2);
        br3.add(female2);

        ButtonGroup br4 = new ButtonGroup();
        br4.add(trainer2);
        br4.add(secretary2);

        ButtonGroup br2 = new ButtonGroup();
        br2.add(male);
        br2.add(female);
//        this.JTapppedAction();
        Price.setVisible(false);
        shekel.setVisible(false);
        Course c = null;
//        this.Course_Validate();
//        this.Course_Validate2();
//        this.Combo_Validate();
//        this.Combo_Validate2();
//        this.Date_Validate();
//        this.Price_Validate();
//     //  this.JTapppedAction();

        // RC.Fill_Courses_Combo(CourseCombo);
        //RC.Add_Data_To_Table(jTable2);
//        EC.Fill_Courses_Combo(Courses2);
        // this.editCourse();
        CoursePrice.addItem("Free");
        CoursePrice.addItem("Paid");
       getReadyForEditting();
        //this.setSize(new Dimension(900,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-taskBar.bottom));
        // this.jTabbedPane6.setPreferredSize(new Dimension(800,680));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        ShowTapped = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        CName = new javax.swing.JLabel();
        CourseName = new javax.swing.JTextField();
        CPrice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hours = new javax.swing.JSpinner();
        StartDate = new datechooser.beans.DateChooserCombo();
        StartD = new javax.swing.JLabel();
        EndDate = new datechooser.beans.DateChooserCombo();
        jLabel5 = new javax.swing.JLabel();
        CourseT = new javax.swing.JLabel();
        Trainers = new javax.swing.JComboBox<Trainer>();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Price = new javax.swing.JSpinner();
        jLabel42 = new javax.swing.JLabel();
        shekel = new javax.swing.JLabel();
        ComboPrice = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Courses2 = new javax.swing.JComboBox<Course>();
        jPanel7 = new javax.swing.JPanel();
        CN = new javax.swing.JLabel();
        CourseName2 = new javax.swing.JTextField();
        CP = new javax.swing.JLabel();
        CH = new javax.swing.JLabel();
        CourseHours = new javax.swing.JSpinner();
        SD = new javax.swing.JLabel();
        EDate1 = new datechooser.beans.DateChooserCombo();
        ED = new javax.swing.JLabel();
        SDate1 = new datechooser.beans.DateChooserCombo();
        CT = new javax.swing.JLabel();
        Trainers2 = new javax.swing.JComboBox<Trainer>();
        Upadte = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        CoursePrice = new javax.swing.JComboBox();
        Price2 = new javax.swing.JSpinner();
        sh = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        removeCourse = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CourseCombo = new javax.swing.JComboBox<Course>();
        jButton10 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showCourse = new javax.swing.JTable();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        fn = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        sn = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        em = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        ext = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        sl = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        ps = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        reps = new javax.swing.JLabel();
        repass = new javax.swing.JPasswordField();
        jLabel26 = new javax.swing.JLabel();
        trainer = new javax.swing.JRadioButton();
        sec = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Address = new javax.swing.JComboBox();
        salary = new javax.swing.JSpinner();
        shek = new javax.swing.JLabel();
        parr = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        ex2 = new javax.swing.JTextField();
        war = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        AllEmployees = new javax.swing.JComboBox <Person>();
        jPanel17 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        fname2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        sname2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        email2 = new javax.swing.JTextField();
        ext2 = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        address2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        salary2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        male2 = new javax.swing.JRadioButton();
        female2 = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        pass2 = new javax.swing.JPasswordField();
        jLabel36 = new javax.swing.JLabel();
        repass2 = new javax.swing.JPasswordField();
        jLabel37 = new javax.swing.JLabel();
        trainer2 = new javax.swing.JRadioButton();
        secretary2 = new javax.swing.JRadioButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        ext3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        RemovedEmployees = new javax.swing.JComboBox();
        jButton9 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        EmployeeTable = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel23 = new javax.swing.JPanel();
        jTextField15 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane2.addTab("tab1", jTabbedPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane6.setAutoscrolls(true);
        jTabbedPane6.setPreferredSize(new java.awt.Dimension(790, 800));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/course-icon.png"))); // NOI18N

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        CName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CName.setText("Course Name ");

        CPrice.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CPrice.setText("Course Price");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Hours");

        StartD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        StartD.setText("Start Date");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("End Date");

        CourseT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CourseT.setText("Course Trainer");

        Trainers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        Trainers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrainersActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1429818073_Download_save_down-48.png"))); // NOI18N
        jButton2.setToolTipText("Save");
        jButton2.setBorder(null);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1429817796_DeleteRed_1.png"))); // NOI18N
        jButton1.setToolTipText("Cancel");
        jButton1.setBorder(null);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        shekel.setText("Shekel");

        ComboPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jButton2)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addComponent(CourseT)
                                .addGap(18, 18, 18)
                                .addComponent(Trainers, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StartD)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(CPrice))
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(ComboPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(shekel))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel25Layout.createSequentialGroup()
                                .addComponent(CName)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(CourseName))))
                        .addGap(34, 34, 34))))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CName)
                    .addComponent(CourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CPrice)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(shekel)
                        .addComponent(ComboPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CourseT)
                    .addComponent(Trainers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ShowTapped.addTab("<html> <p style=\"color:#3333FF;font-size:15px;font-family:\">Add Course</p> </html>", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose the course"));

        jLabel10.setText("Course");

        Courses2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        Courses2.setSelectedItem(2);
        Courses2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Courses2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Courses2, 0, 131, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Courses2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Course"));

        CN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CN.setText("Course Name ");

        CP.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CP.setText("Course Price");

        CH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CH.setText("Hours");

        SD.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        SD.setText("Start Date");

        ED.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ED.setText("End Date");

        CT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CT.setText("Course Trainer");

        Upadte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1429818073_Download_save_down-48.png"))); // NOI18N
        Upadte.setToolTipText("Save");
        Upadte.setBorder(null);
        Upadte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpadteActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1429817796_DeleteRed_1.png"))); // NOI18N
        jButton3.setToolTipText("Cancel");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        CoursePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoursePriceActionPerformed(evt);
            }
        });

        sh.setText("Shekel");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Upadte)
                .addGap(51, 51, 51)
                .addComponent(jButton3)
                .addGap(38, 38, 38))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(CT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Trainers2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(CN)
                                .addGap(18, 18, 18)
                                .addComponent(CourseName2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SD)
                                    .addComponent(ED))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CourseHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(CoursePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addComponent(Price2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sh))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(EDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(CH)
                            .addComponent(CP))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(4, 10, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CourseName2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CP)
                    .addComponent(CoursePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Price2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sh))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CH)
                    .addComponent(CourseHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(ED, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CT)
                            .addComponent(Trainers2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addComponent(EDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(Upadte))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ShowTapped.addTab("<html> <p style=\"color:#3333FF;font-size:15px;font-family:Times New Roman\">Edit Course</p> </html>", jPanel3);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Courses"));

        removeCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Course Name ", "Course Price", "Course Hours", "Course Trainer"
            }
        ));
        jScrollPane2.setViewportView(removeCourse);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Remove Course", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel1.setText("Course Name");

        CourseCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseComboActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1429817796_DeleteRed_1.png"))); // NOI18N
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CourseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(107, 107, 107))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CourseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 337, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ShowTapped.addTab("<html> <p style=\"color:#3333FF;font-size:15px;font-family:Times New Roman\">Remove Course</p> </html>", jPanel6);

        showCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course ID", "Course Name", "Course Price", "Course Hours", "Trainer"
            }
        ));
        showCourse.setToolTipText("Press F5 for Refresh ");
        jScrollPane1.setViewportView(showCourse);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ShowTapped.addTab("<html> <p style=\"color:#3333FF;font-size:15px;font-family:Times New Roman\">Show Courses</p> </html>", jPanel11);

        jTabbedPane6.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Icon/1428861045_education_course_training.png")), ShowTapped); // NOI18N

        jTabbedPane8.setAutoscrolls(true);
        jTabbedPane8.setPreferredSize(new java.awt.Dimension(990, 720));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(997, 680));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Details"));

        fn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fn.setText("First Name");

        sn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sn.setText("Last Name");

        em.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        em.setText("E-mail");

        ext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Address");

        sl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sl.setText("Salary");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel23.setText("Sex");

        male.setBackground(new java.awt.Color(255, 255, 255));
        male.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        female.setBackground(new java.awt.Color(255, 255, 255));
        female.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        female.setText("Female");

        ps.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ps.setText("Password");

        reps.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        reps.setText("Re-Password");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel26.setText("Employee");

        trainer.setBackground(new java.awt.Color(255, 255, 255));
        trainer.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        trainer.setText("Trainer");

        sec.setBackground(new java.awt.Color(255, 255, 255));
        sec.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sec.setText("Secretary");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1428623948_save.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1428860499_cancel.png"))); // NOI18N

        Address.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gaza", "Rafah", "Khanunis" }));

        shek.setText("Shekel");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("@");

        ex2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ex2ActionPerformed(evt);
            }
        });

        war.setText("jLabel2");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sn)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21)
                            .addComponent(em)
                            .addComponent(sl)
                            .addComponent(ps)
                            .addComponent(reps)
                            .addComponent(jLabel26)
                            .addComponent(fn))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(male)
                                .addGap(18, 18, 18)
                                .addComponent(female))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ext, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ex2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(trainer)
                                .addGap(10, 10, 10)
                                .addComponent(sec))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(repass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(pass, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(parr, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(shek))
                            .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(war)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fn)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sn)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(male)
                    .addComponent(female))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(em)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ext, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ex2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sl)
                    .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shek))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ps))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(war))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(parr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reps)
                    .addComponent(repass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(trainer)
                    .addComponent(sec))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6)))
        );

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cute-cartoon-illustration-office-worker-9498107.jpg"))); // NOI18N
        jLabel27.setText("jLabel27");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("<html> <p style=\"color:#3333FF;font-size:15px;font-family:Times New Roman\">Add Employee</p> </html>", jPanel13);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose Employee"));

        jLabel28.setText("Employee : ");

        AllEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllEmployeesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AllEmployees, 0, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(AllEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Details"));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel29.setText("First Name");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel30.setText("Second Name");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel31.setText("E-mail");

        ext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ext2ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel32.setText("Address");

        address2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address2ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel33.setText("Salary");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel34.setText("Sex");

        male2.setBackground(new java.awt.Color(255, 255, 255));
        male2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        male2.setText("Male");
        male2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                male2ActionPerformed(evt);
            }
        });

        female2.setBackground(new java.awt.Color(255, 255, 255));
        female2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        female2.setText("Female");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel35.setText("Password");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel36.setText("Re-Password");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel37.setText("Employee");

        trainer2.setBackground(new java.awt.Color(255, 255, 255));
        trainer2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        trainer2.setText("Trainer");

        secretary2.setBackground(new java.awt.Color(255, 255, 255));
        secretary2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        secretary2.setText("Secretary");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1429818073_Download_save_down-48.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1429817796_DeleteRed_1.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("@");

        ext3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ext3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel34)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel29))
                .addGap(13, 13, 13)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salary2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(male2)
                                .addGap(18, 18, 18)
                                .addComponent(female2))
                            .addComponent(address2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(trainer2)
                                .addGap(10, 10, 10)
                                .addComponent(secretary2))
                            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(repass2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(pass2, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fname2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sname2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(email2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ext2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ext3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(fname2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(sname2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(male2)
                    .addComponent(female2))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(address2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(email2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ext2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ext3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(salary2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(repass2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(trainer2)
                    .addComponent(secretary2))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jButton8)))
        );

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1428765076_free-17-128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel38)))
                .addGap(31, 31, 31)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel38)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane8.addTab("<html> <p style=\"color:#3333FF;font-size:15px;font-family:Times New Roman\">Edit Employee\n</p> </html>", jPanel15);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choose Employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("Employee :");

        RemovedEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovedEmployeesActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1429817796_DeleteRed_1.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(RemovedEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(77, 77, 77))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(RemovedEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employees", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Employee Name", "Employee email", "Employee Address", "Employee Type", "Employee Salary"
            }
        ));
        jScrollPane3.setViewportView(EmployeeTable);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("<html> <p style=\"color:#3333FF;font-size:15px;font-family:Times New Roman\">Remove Employee</p> </html>", jPanel18);

        jTabbedPane6.addTab("", new javax.swing.ImageIcon(getClass().getResource("/Icon/1428721191_Businessman.png")), jTabbedPane8); // NOI18N

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel41.setText("<html> <p style=\"font-size:20px;font-family:Times New Roman\">Search</p> </html> 800 ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField15.setText("jTextField15");
        jTextField15.setBorder(null);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("User"));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout.PNG"))); // NOI18N
        jButton11.setToolTipText("Logout");
        jButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/return.PNG"))); // NOI18N
        jButton12.setToolTipText("return to login screen");
        jButton12.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1428863494_supportmale-128.png"))); // NOI18N
        jLabel40.setText("Hi Mr. Admin");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton11)
                .addGap(29, 29, 29)
                .addComponent(jButton12)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel40)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TrainersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrainersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrainersActionPerformed

    private void ext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ext2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ext2ActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
        ext3.setVisible(false);
        if (ext2.getSelectedItem().equals("Others ..")) {
            ext3.setVisible(true);
        }
    }//GEN-LAST:event_maleActionPerformed

    private void extActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extActionPerformed
        // TODO add your handling code here:
        ex2.setVisible(false);
        if (ext.getSelectedItem().equals("Others ..")) {
            ex2.setVisible(true);
        }

    }//GEN-LAST:event_extActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //String FirstName, String LastName, String Address, String Email, String Sex, int ID, String Password, float Salary) {
        String emails;
        if (ext.getSelectedItem().equals("Others ..")) {
            emails = email.getText() + "@" + ex2.getText();
        } else {
            emails = email.getText() + "@" + ext.getSelectedItem().toString();
        }
        Person person = new Secretary(fname.getText(), lname.getText(),
                Address.getSelectedItem().toString(),
                emails, (male.isSelected() ? "Male" : "Female"),
                (pass.getText().equals(repass.getText()) ? pass.getText() : "Role"),
                Float.parseFloat(salary.getValue().toString()),
                (trainer.isSelected() ? "Trainer" : "Secretary"), 1
        );
        try {
            FactoryFacade.addEmployee(person);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fail: Cannot save the Employee's details ", "Fail Message", JOptionPane.ERROR_MESSAGE);
        }
        try {

            updateCourse.fillCourses();
            updateCmob.fillComboBoxes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "" + person.getFirstName() + " " + person.getLastName() + " Employee has been saved successfully ", "Done !!", JOptionPane.INFORMATION_MESSAGE);

        fname.setText("");
        lname.setText("");
        Address.setSelectedIndex(1);
        male.setSelected(false);
        female.setSelected(false);
        trainer.setSelected(false);
        sec.setSelected(false);
        pass.setText("");
        repass.setText("");
        salary.setValue(new Integer(0));
        ext.setSelectedIndex(1);
        ex2.setText("");

//       AE.Add_Employee(fname ,fn ,
//                        lname ,  sn ,
//                        male ,  female , 
//                        Address ,  email ,  ext,
//                        ex2 , salary , sl , shek,
//                        pass ,  repass ,  parr , ps ,  reps , war ,Trainers1, trainer , sec);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int price;
        if (ComboPrice.getSelectedItem().equals("Free")) {
            price = 0;
        } else {
            price = Integer.parseInt(Price.getValue().toString());
        }

        Course course = new Course.CourseBuilder().
                setCourseName(CourseName.getText()).
                setHours(Integer.parseInt(hours.getValue().toString())).
                setPrice(price).setTrainerID((Trainer) Trainers.getSelectedItem()).buildCourse();
        System.out.println("" + course.getCourseName());

        try {
            FactoryFacade.factoryfacade.addCourse(course);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fail: Cannot save the course ", "Fail Message", JOptionPane.ERROR_MESSAGE);
        }
        try {
            updateCourse.fillCourses();
            updateCmob.fillComboBoxes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "" + course.getCourseName() + " Course has saved successfully ", "Done !!", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void ComboPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboPriceActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Course course = (Course) CourseCombo.getSelectedItem();
        try {
            // TODO add your handling code here:
//        RC.RemoveCourse(CourseCombo);
            //      RC.remove_Table_item(jTable2);

            RemoveFacade.Instance.removeCourse(course.getID());
            updateCourse.fillCourses();
            updateCmob.fillComboBoxes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "" + course.getCourseName() + " Course has been removed successfully ", "Done !!", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void CoursePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoursePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CoursePriceActionPerformed

    private void UpadteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpadteActionPerformed
//        try {
//            // TODO add your handling code here:
//            AddCourse_Validate2();
//        } catch (ParseException ex) {
//            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
//        }
        int price;
        if (ComboPrice.getSelectedItem().equals("Free")) {
            price = 0;
        } else {
            price = Integer.parseInt(Price.getValue().toString());
        }
        Course temp = (Course) Courses2.getSelectedItem();

        Course course = new Course.CourseBuilder().
                setCourseName(CourseName2.getText()).
                setHours(Integer.parseInt(CourseHours.getValue().toString())).
                setPrice(CoursePrice.getSelectedItem().equals("Free") ? 0 : Float.parseFloat(Price2.getValue().toString())).
                setTrainerID((Trainer) Trainers2.getSelectedItem()).setID(temp.getID()).buildCourse();
        System.out.println("" + course.getCourseName());

        try {
            EdittingFacade.Insance.editCourse(course);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            updateCourse.fillCourses();
            updateCmob.fillComboBoxes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "" + course.getCourseName() + " Course has updated successfully ", "Done !!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_UpadteActionPerformed

    private void ex2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ex2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ex2ActionPerformed

    private void address2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address2ActionPerformed

    private void male2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_male2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_male2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Person temp = (Person) AllEmployees.getSelectedItem();

        String emails;
        if (ext2.getSelectedItem().equals("Others ..")) {
            emails = email2.getText() + "@" + ext3.getText();
        } else {
            emails = email2.getText() + "@" + ext2.getSelectedItem().toString();
        }
        Person person = new Secretary(fname2.getText(), sname2.getText(),
                address2.getText(),
                emails, (male2.isSelected() ? "male" : "female"),
                (pass2.getText().equals(repass2.getText()) ? pass2.getText() : "Role"),
                Float.parseFloat(salary2.getText()),
                (trainer2.isSelected() ? "Trainer" : "Secretary"), temp.getID()
        );
        try {
            EdittingFacade.Insance.EditPersons(person);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fail: Cannot save the Employee's details ", "Fail Message", JOptionPane.ERROR_MESSAGE);
        }
        try {
            updateCourse.fillCourses();
            updateCmob.fillComboBoxes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "" + person.getFirstName() + " " + person.getLastName() + " Employee's details has been updated successfully ", "Done !!", JOptionPane.INFORMATION_MESSAGE);

        fname2.setText("");
        sname2.setText("");
        address2.setText(" ");
        male2.setSelected(false);
        female2.setSelected(false);
        trainer2.setSelected(false);
        secretary2.setSelected(false);
        pass2.setText("");
        repass2.setText("");
        salary2.setText(" ");
        ext2.setSelectedIndex(1);
        email2.setText("");
        ext3.setText(" ");
        ext3.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void ext3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ext3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ext3ActionPerformed

    private void Courses2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Courses2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Courses2ActionPerformed

    private void AllEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllEmployeesActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_AllEmployeesActionPerformed

    private void CourseComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseComboActionPerformed

    private void RemovedEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovedEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemovedEmployeesActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Person person = (Person) RemovedEmployees.getSelectedItem();
        try {
            RemoveFacade.Instance.removeEmployee(person.getID());
            updateCourse.fillCourses();
            updateCmob.fillComboBoxes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "" + person.getFirstName() + " " + person.getLastName() + " Employee has been removed successfully ", "Done !!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton9ActionPerformed

    public void getReadyForEditting() {
        AllEmployees.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flage = false;
                Person person = (Person) AllEmployees.getSelectedItem();
                if(person != null){
                String[] emailExtension = person.getEmail().split("@");
                fname2.setText(person.getFirstName());
                sname2.setText(person.getLastName());
                address2.setText(person.getAddress());
                email2.setText(emailExtension[0]);
                ext3.setVisible(false);
                for (int i = 0; i <= ext2.getItemCount(); i++) {
                    if (emailExtension[1].equalsIgnoreCase((String) ext2.getItemAt(i))) {
                        ext2.setSelectedItem(emailExtension[1]);
                        flage = true;
                    }
                }
                if (flage == false) {

                    ext2.setSelectedItem("Others ..");
                    ext3.setVisible(true);
                    ext3.setText(emailExtension[1]);

                }

                if (person.getSex().equals("male")) {
                    male2.setSelected(true);
                } else {
                    female2.setSelected(true);
                }
                pass2.setText(person.getPassword());
                repass2.setText(person.getPassword());
                salary2.setText("" + person.getSalary());
                if (person instanceof Trainer) {
                    trainer2.setSelected(true);
                } else {
                    secretary2.setSelected(true);
                }

            }
            }

        });

    }

    public void Add_Item_To_ComboPrice() {

        ComboPrice.addItem("Free");
        ComboPrice.addItem("Paid");
        ext2.addItem("hotmail.com");
        ext2.addItem("yahoo.com");
        ext2.addItem("outlock.com");
        ext2.addItem("Others ..");
        ext.addItem("hotmail.com");
        ext.addItem("yahoo.com");
        ext.addItem("outlock.com");
        ext.addItem("Others ..");
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Address;
    private javax.swing.JComboBox AllEmployees;
    private javax.swing.JLabel CH;
    private javax.swing.JLabel CN;
    private javax.swing.JLabel CName;
    private javax.swing.JLabel CP;
    private javax.swing.JLabel CPrice;
    private javax.swing.JLabel CT;
    private javax.swing.JComboBox ComboPrice;
    private javax.swing.JComboBox CourseCombo;
    private javax.swing.JSpinner CourseHours;
    private javax.swing.JTextField CourseName;
    private javax.swing.JTextField CourseName2;
    private javax.swing.JComboBox CoursePrice;
    private javax.swing.JLabel CourseT;
    private javax.swing.JComboBox Courses2;
    private javax.swing.JLabel ED;
    private datechooser.beans.DateChooserCombo EDate1;
    private javax.swing.JTable EmployeeTable;
    private datechooser.beans.DateChooserCombo EndDate;
    private javax.swing.JSpinner Price;
    private javax.swing.JSpinner Price2;
    private javax.swing.JComboBox RemovedEmployees;
    private javax.swing.JLabel SD;
    private datechooser.beans.DateChooserCombo SDate1;
    private javax.swing.JTabbedPane ShowTapped;
    private javax.swing.JLabel StartD;
    private datechooser.beans.DateChooserCombo StartDate;
    private javax.swing.JComboBox Trainers;
    private javax.swing.JComboBox Trainers2;
    private javax.swing.JButton Upadte;
    private javax.swing.JTextField address2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private javax.swing.JLabel em;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email2;
    private javax.swing.JTextField ex2;
    private javax.swing.JComboBox ext;
    private javax.swing.JComboBox ext2;
    private javax.swing.JTextField ext3;
    private javax.swing.JRadioButton female;
    private javax.swing.JRadioButton female2;
    private javax.swing.JLabel fn;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField fname2;
    private javax.swing.JSpinner hours;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField lname;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton male2;
    private javax.swing.JProgressBar parr;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JLabel ps;
    private javax.swing.JTable removeCourse;
    private javax.swing.JPasswordField repass;
    private javax.swing.JPasswordField repass2;
    private javax.swing.JLabel reps;
    private javax.swing.JSpinner salary;
    private javax.swing.JTextField salary2;
    private javax.swing.JRadioButton sec;
    private javax.swing.JRadioButton secretary2;
    private javax.swing.JLabel sh;
    private javax.swing.JLabel shek;
    private javax.swing.JLabel shekel;
    private javax.swing.JTable showCourse;
    private javax.swing.JLabel sl;
    private javax.swing.JLabel sn;
    private javax.swing.JTextField sname2;
    private javax.swing.JRadioButton trainer;
    private javax.swing.JRadioButton trainer2;
    private javax.swing.JLabel war;
    // End of variables declaration//GEN-END:variables

    public boolean Course_Validate() {

        CourseName.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (CNStatus == false) {
                    CName.setForeground(Color.BLACK);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                Pattern p = Pattern.compile("^\\w+\\D");
                Matcher m = p.matcher(CourseName.getText());
                if (m.find()) {
                    CNStatus = true;
                    status1 = true;

                }

                if (CNStatus == false) {
                    CName.setForeground(Color.red);
                    jLabel42.setText("The name should begin with word");
                    jLabel42.setForeground(Color.red);

                }

                CNStatus = false;

            }
        });
        return false;
    }

    public void fillAllExtension() {
        allExtensions.add("hotmail.com");
        allExtensions.add("Outlock.com");
        allExtensions.add("yahoo.com");
    }

    public void Combo_Validate() {
        ComboPrice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (ComboPrice.getSelectedItem().equals("Paid")) {
                    System.out.println("" + ComboPrice.getSelectedIndex());
                    Price.setVisible(true);
                    shekel.setVisible(true);
                } else if (ComboPrice.getSelectedItem().equals("Free")) {
                    Price.setVisible(false);
                    shekel.setVisible(false);
                }
            }
        });
        ComboPrice.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }

    public void Date_Validate() {
        StartDate.addCursorMoveListener(new CursorMoveListener() {

            @Override
            public void onCursorMove(CursorMoveEvent cme) {
                StartD.setForeground(Color.black);
            }
        });

        StartDate.addSelectionChangedListener(new SelectionChangedListener() {

            @Override
            public void onSelectionChange(SelectionChangedEvent sce) {

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal2 = null;
                cal2.set(2015, 6, 1, 32, 3, 3);

                StartDate.setMinDate(cal);
                StartDate.setDateFormat(dateFormat);
                EndDate.setDateFormat(dateFormat);
                EndDate.setMinDate(cal2);

                // System.out.println(""+date2);
                SDStatus = false;
            }
        });

    }

    public void Price_Validate() {
        Price.setValue(10);
        int number = Integer.parseInt(Price.getModel().getValue().toString());
        System.out.println("" + Price.getValue().toString());
        if (number == 10) {
            System.out.println("Fuck you ");

        }

        Price.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

    }

    public void AddCourse_Validate() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        Date date;

        Date date2;
        StartDate.setDateFormat(dateFormat);
        date = SDF.parse(dateFormat.format(cal.getTime()));
        if ((status1 == true) && (Integer.parseInt(hours.getValue().toString()) > 0)) {
            if ((ComboPrice.getSelectedItem().equals("Paid") && (Integer.parseInt(Price.getValue().toString()) > 0)) || ComboPrice.getSelectedItem().equals("Free")) {
                if (StartDate.getSelectedDate().getTime().after(date) && (EndDate.getSelectedDate().getTime().after(StartDate.getSelectedDate().getTime()))) {
                    if (!Trainers.getSelectedItem().equals(null)) {
                        JOptionPane.showMessageDialog(this, "The register course compltested", "Confirm message", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        CourseT.setForeground(Color.red);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "The register course compltested", "Confirm message", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                CPrice.setForeground(Color.red);
            }
        } else if (status1 == false) {
            CName.setForeground(Color.red);
        }

    }

    public Course editCourse() {
//        EC.fill_Trainers(Trainers2);

        Courses2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

                int month = 1 + input.nextInt(12);
                int day = 1 + input.nextInt(3);
                int number = 1 + input.nextInt(3);

                Calendar cal2 = Calendar.getInstance();
               // date = SDF.parse(dateFormat.format(cal.getTime()));

                // cal.set(2015, month, day);
                // cal2.set(2015, month+number, day+number);
                temp = (Course) Courses2.getItemAt(Courses2.getSelectedIndex());
                CourseName2.setText(temp.getCourseName());
                CoursePrice.setSelectedItem("Paid");
                Price2.setValue(temp.getPrice());
                CourseHours.setValue(temp.getHours());

                try {
                    //  Date d = SDF.parse(""+temp.getSDate().getTime());
                    for (Course c : Courses) {
                        if (c.getID() == temp.getID()) {

                            System.out.println("" + c.getSDate());
//                            cal.setTime(c.getSDate());
                            //                           cal2.setTime(c.getEDate());

                            SDate1.setSelectedDate(cal);
                            EDate1.setSelectedDate(cal2);
                        }
                    }

                    // EDate1.setSelectedDate(cal2);
                    //   System.out.println(""+Courses2.getItemAt(Courses2.getSelectedIndex()));
//            Trainers2.setSelectedItem(temp.getTrainerID());
                } catch (Exception ex) {
                    Logger.getLogger(ManagersInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        temper = temp;
        return temp;
    }

    public void print() {
        for (Course c : Courses) {
            System.out.println("" + c.getCourseName() + "  " + c.getSDate());
        }

    }

    public boolean Course_Validate2() {

        CourseName2.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (CNStatus == false) {
                    CN.setForeground(Color.BLACK);
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                Pattern p = Pattern.compile("^\\w+\\D");
                Matcher m = p.matcher(CourseName2.getText());
                if (m.find()) {
                    CNStatus = true;
                    status1 = true;

                }

                if (CNStatus == false) {
                    CN.setForeground(Color.red);
                    jLabel4.setText("The name should begin with word");
                    jLabel4.setForeground(Color.red);

                }

                CNStatus = false;

            }
        });
        return false;
    }

    public void Combo_Validate2() {
        CoursePrice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (CoursePrice.getSelectedItem().equals("Paid")) {
                    System.out.println("" + CoursePrice.getSelectedIndex());
                    Price2.setVisible(true);
                    sh.setVisible(true);
                } else if (CoursePrice.getSelectedItem().equals("Free")) {
                    Price2.setVisible(false);
                    sh.setVisible(false);
                }
            }
        });
        CoursePrice.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }

    public void Price_Validate2() {

        int number = Integer.parseInt(Price2.getModel().getValue().toString());
        System.out.println("" + Price2.getValue().toString());
        if (number == 10) {
            System.out.println("Fuck you ");

        }

        Price2.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

    }
//
// public void AddCourse_Validate2() throws ParseException
//    {
//        Course Amr = (Course) Courses2.getItemAt(Courses2.getSelectedIndex());
//         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            Calendar cal = Calendar.getInstance();
//            SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
//            Date date;
//            Date date2;
//         // SDate1.setDateFormat(dateFormat);
//            date = SDF.parse(dateFormat.format(cal.getTime()));
//        if((status1 == true) && (Integer.parseInt(CourseHours.getValue().toString())  > 0))
//        {
//            if((ComboPrice.getSelectedItem().equals("Paid") && (Integer.parseInt(Price.getValue().toString())  > 0)) || ComboPrice.getSelectedItem().equals("Free"))
//            {
//                if(SDate1.getSelectedDate().getTime().after(date) && (EDate1.getSelectedDate().getTime().after(SDate1.getSelectedDate().getTime()))){
//                    if(!Trainers.getSelectedItem().equals(null)){
//                       for(Course co : Courses){
//                           if(co.getID() == Amr.getID()){
//                               co.setCourseName(CourseName2.getText());
//                               co.setHours(Integer.parseInt(CourseHours.getValue().toString()));
//                               co.setPrice(Float.parseFloat(Price2.getValue().toString()));
//                               co.setTrainerID((Trainer) Trainers2.getItemAt(Trainers2.getSelectedIndex()));
//                         JOptionPane.showMessageDialog(this, "The course has been updated", "Confirm message",JOptionPane.INFORMATION_MESSAGE);
//                       }
//                       }
//                    }else{CT.setForeground(Color.red);}
//            }
//            else{SD.setForeground(Color.red);  ED.setForeground(Color.red);}
//                
//            }else{CP.setForeground(Color.red);}
//        }else if(status1 == false){CN.setForeground(Color.red);}
//        
//    }
//
//     public  void getTrainers()
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
//				Trainers1.add(temp);
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
//  public void getCourses()
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
//                                cou.setSDate(result.getDate("StartDate"));
//                                cou.setEDate(result.getDate("EndDate"));
//                              //  System.out.println(""+cou.getSDate());
//				for(Trainer t: Trainers1){
//					if(t.getID() == result.getInt("TID"))
//						cou.setTrainerID(t);
//                                       
//				}
//                                System.out.println(""+cou.getSDate());
//				Courses.add(cou);
//				cou =  new Course();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//                       
//		}
//		finally
//		{
//			dataBaseAccess.CloseConnection();
//		}
//	}
//
//  public void JTapppedAction()
//  {
//      ShowTapped.addFocusListener(new FocusListener() {
//       
//          @Override
//          public void focusGained(FocusEvent e) {
//            
//              
//             }
//          
//
//          @Override
//          public void focusLost(FocusEvent e) {
//              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//          }
//      });
//      
//       ShowTapped.addChangeListener(new ChangeListener() {
//
//          @Override
//          public void stateChanged(ChangeEvent e) {
//              
//               DefaultTableModel model1 = (DefaultTableModel)Show.getModel();
//               int number  = model1.getRowCount();
//             // for(int i = 0 ; i <4 ; i++)
//                  
//         {
//          
//         }
//          if(flage == false)
//         {
//             for(int j = 0 ; j < Courses.size() ; j++){
//            model1.addRow(new Object[]{Courses.get(j).getID(),
//                        Courses.get(j).getCourseName(),
//                        Courses.get(j).getPrice(),
//                        Courses.get(j).getHours(),
//                        Courses.get(j).getTrainerID().getFirstName()+" "+Courses.get(j).getTrainerID().getLastName()});
//                         indexs.add(Courses.get(j).getID());   
//         }
//         }
//          
//              for (int i = 0; i < indexs.size() ; i++) {
//               
//                  
//                  for  (int j = 0; j < Courses.size(); j++){
//                  if((indexs.get(i) != Courses.get(j).getID()))
//                  {
//                         model1.addRow(new Object[]{Courses.get(j).getID(),
//                        Courses.get(j).getCourseName(),
//                        Courses.get(j).getPrice(),
//                        Courses.get(j).getHours(),
//                        Courses.get(j).getTrainerID().getFirstName()+" "+Courses.get(j).getTrainerID().getLastName()});
//                         indexs.add(Courses.get(j).getID());
//                         
//                         flage = true;
//                  }
//                      
//                  }
//             
//            
//        
//        
//       
//                  
//              }
//              // model1.setRowCount(25);
//          }
//      });
//      
//  }

    @Override
    public void update(Observable o, Object arg) {
        String Type = "Secretary";
        if (o.getClass().getName().equalsIgnoreCase(UpdateComboBox.class.getName())) {
         
            
//            for (int i = rowCount-1; i >= 0 ; i--) {
//                model.removeRow(i);
//                
//            }
                EmployeeModel.setRowCount(0);

            

            ArrayList<Person> persons = (ArrayList<Person>) arg;

           
            Trainers.removeAllItems();
            Trainers2.removeAllItems();
            AllEmployees.removeAllItems();
            RemovedEmployees.removeAllItems();
            for (Person temps : persons) {
                if (temps instanceof Trainer) {

                    Trainers.addItem(temps);
                    Trainers2.addItem(temps);
                }
                AllEmployees.addItem(temps);
                RemovedEmployees.addItem(temps);
                EmployeeModel.addRow(new Object[]{temps.getID(),
                    temps.getFirstName() + " " + temps.getLastName(), temps.getEmail(), temps.getAddress(), ((temps instanceof Trainer) ? "Trainer" : "Secretary"), temps.getSalary()});

            }
        } else if (o.getClass().getName().equalsIgnoreCase(UpdatingCourse.class.getName())) {
            int rowCount = 0;
            System.out.println("Course Done $%^&");
            ArrayList<Course> course = (ArrayList<Course>) arg;
            Courses2.removeAllItems();
            CourseCombo.removeAllItems();
            for (Course temps : course) {
                Courses2.addItem(temps);
                CourseCombo.addItem(temps);
            }

            // JScrollPane sp = new JScrollPane(showCourse);
            // Object[] col = {"ID", "C: Name", "C: Price", "C: Hours"};
            // model.setColumnIdentifiers(col);
            if (rowCount >= 0) {
//            for (int i = rowCount-1; i >= 0 ; i--) {
//                model.removeRow(i);
//                
//            }
                model.setRowCount(0);
                removeModel.setRowCount(0);
            }

            for (int x = 0; x < course.size(); x++) {
                model.addRow(new Object[]{course.get(x).getID(),
                    course.get(x).getCourseName(), course.get(x).getPrice(), course.get(x).getHours()});
                removeModel.addRow(new Object[]{course.get(x).getID(),
                    course.get(x).getCourseName(), course.get(x).getPrice(), course.get(x).getHours()});
            }
            ///model.setRowCount(25);
            showCourse.setEnabled(false);
            removeCourse.setEnabled(false);

            //  model.
            //sp.setPreferredSize(new Dimension(250, 350));
        }

    }

}
