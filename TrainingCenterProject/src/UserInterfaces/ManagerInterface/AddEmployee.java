///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package UserInterfaces.ManagerInterface;
//
//import Entities.Trainer;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.util.ArrayList;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import javax.swing.BorderFactory;
//import javax.swing.ButtonGroup;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
//import javax.swing.JProgressBar;
//import javax.swing.JRadioButton;
//import javax.swing.JSpinner;
//import javax.swing.JTextField;
//import javax.swing.border.Border;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import javax.swing.plaf.TextUI;
//
///**
// *
// * @author AmrSaidam
// */
//public class AddEmployee 
//{
//    private int numberOfdigit = 0;
//     private int numberOfchar = 0;
//     private int numberOfUpperchar = 0;
//     private boolean underScroe = false;
//     
//     boolean[] Erorr ; 
//    
//    boolean fstatus = false;
//    boolean sstatus = false;
//    
//   
//    boolean Vstatus1 = false;
//    boolean Vstatus2 = false;
//    boolean Vstatus3 = false;
//    boolean Vstatus4 = false;
//    boolean Vstatus5 = false; 
//    boolean Vstatus6 = false; 
//    boolean Vstatus7 = false;
//    boolean Vstatus8 = false;
//      
//      
//      
//    public AddEmployee(JTextField fname ,JLabel fn  ,
//                       JTextField sname , JLabel sn ,
//                       JRadioButton male , JRadioButton female , 
//                       JComboBox<String> Address , JTextField email , JComboBox<String> ext,
//                       JTextField ex2 ,JSpinner salary ,JLabel sl ,JLabel shek,
//                       JPasswordField pass ,  JPasswordField repass , JProgressBar par ,JLabel ps , JLabel reps ,
//                       JLabel war , ArrayList<Trainer> Trainer ,
//                       JRadioButton trainer ,  JRadioButton sec)
//    {
//        for(Trainer t : Trainer){
//        System.out.println("$#"+t.getFirstName());
//        }
//        Erorr = new boolean[6];
//        ex2.setVisible(false);
//        par.setVisible(false);
//        this.fname_Validate(fname, fn);
//        this.sname_Validate(sname, sn);
//        this.Add_To_Groub(male, female);
//         this.Add_To_Groub2(trainer, sec);
//        this.Fill_Address(Address);
//        this.Fill_extnsion(ext);
//        this.email_Validate(email, ext, sl, ex2);
//        this.Salary_Validate(salary, sl, shek);
//        this.Password_validate(pass, repass, par, ps, reps ,war);
//        this.Confirm_Passwrod(pass, repass );
//        
//    }
//    
//    
//    public void fname_Validate(JTextField fname , JLabel fn)
//    {
//        fname.addFocusListener(new FocusListener() {
//
//            @Override
//            public void focusGained(FocusEvent e) {
//                   if(fstatus == false)
//           {
//               fn.setForeground(Color.BLACK);
//           }
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                Pattern p = Pattern.compile("^\\w+\\D$");
//        Matcher m = p.matcher(fname.getText());
//        if(m.find())
//        {
//            fstatus = true;
//            fstatus = true;
//            Vstatus1 = true;
//           
//        }
//        
//        if(fstatus == false)
//        {
//            fn.setForeground(Color.red);
//           // jLabel42.setText("The name should begin with word");
//           // jLabel42.setForeground(Color.red);
//            
//        }
//        
//        fstatus = false;
//                
//            }
//        });
//        
//
//    }
//    
//    
//    public void sname_Validate(JTextField sname , JLabel sn)
//    {
//        sname.addFocusListener(new FocusListener() {
//
//            @Override
//            public void focusGained(FocusEvent e) {
//                   if(sstatus == false)
//           {
//               sn.setForeground(Color.BLACK);
//           }
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                Pattern p = Pattern.compile("^\\w+\\D$");
//        Matcher m = p.matcher(sname.getText());
//        if(m.find())
//        {
//            sstatus = true;
//            sstatus = true; 
//            Vstatus2 = true;
//        }
//        
//        if(sstatus == false)
//        {
//            sn.setForeground(Color.red);
//           // jLabel42.setText("The name should begin with word");
//           // jLabel42.setForeground(Color.red);
//            
//        }
//        
//        sstatus = false;
//                
//            }
//        });
//        
//
//    }
//
//    public void Add_To_Groub( JRadioButton male , JRadioButton female)
//    {
//        ButtonGroup GP = new ButtonGroup();
//        GP.add(male);
//        GP.add(female);
//    }
//      public void Add_To_Groub2( JRadioButton trainer , JRadioButton sec)
//    {
//        ButtonGroup GP = new ButtonGroup();
//        GP.add(trainer);
//        GP.add(sec);
//    }
//
//    public void Fill_Address(JComboBox<String> Address)
//    {
//        Address.addItem("Gaza");
//        Address.addItem("El-westa");
//        Address.addItem("Khanyonis");
//        Address.addItem("Rafah");
//        Address.addItem("Jabalya");
//             
//        
//    }
//
//    public void email_Validate(JTextField email , JComboBox<String> ext , JLabel em ,JTextField ex2 )
//    {
//        email.addFocusListener(new FocusListener() {
//
//            @Override
//            public void focusGained(FocusEvent e) {
//                 if(fstatus == false)
//           {
//               em.setForeground(Color.BLACK);
//           }
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                Pattern p = Pattern.compile("^[a-zA-Z0-9_.+-]+$");
//        Matcher m = p.matcher(email.getText());
//        if(m.find())
//        {
//            fstatus = true;
//            fstatus = true;
//           Vstatus3 = true;
//           
//        }
//        
//        if(fstatus == false)
//        {
//            em.setForeground(Color.red);
//           // jLabel42.setText("The name should begin with word");
//           // jLabel42.setForeground(Color.red);
//            
//        }
//        
//        fstatus = false;
//                
//            }
//        });
//        
//        ext.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               if(ext.getItemAt(ext.getSelectedIndex()).equals("Other .."))
//               {
//                   ext.setVisible(false);
//                   ex2.setVisible(true);
//
//               }
//            }
//        });
//    }
//
//    public void Fill_extnsion(JComboBox<String> ext )
//    {
//        ext.addItem("hotmail.com");
//         ext.addItem("outlook.com");
//           ext.addItem("outlook.net");
//          ext.addItem("gmail.com");
//            ext.addItem("Other ..");
//            ext.setSelectedIndex(1);
//    }
//
//    public void Salary_Validate(JSpinner salary , JLabel sl , JLabel shek)
//    {
//        salary.addChangeListener(new ChangeListener() {
//
//            @Override
//            public void stateChanged(ChangeEvent e) {
//             
//                   Vstatus4 = true;
//                
//            }
//        });
//    }
//
//
//    public void Password_validate( JPasswordField pass ,  JPasswordField repass , JProgressBar par , JLabel ps , JLabel reps ,JLabel war )
//    {
//        war.setText("The password must contain Character and digit or UnderScor");
//        pass.addFocusListener(new FocusListener() {
//
//            @Override
//            public void focusGained(FocusEvent e) 
//            {
//                ps.setForeground(Color.black);
//              
//               }
//            
//
//            @Override
//            public void focusLost(FocusEvent e) {
//            Pattern p = Pattern.compile("^[a-zA-Z]\\w{3,14}$");
//               Matcher m = p.matcher(pass.getText());
//               if(m.find())
//               {
//                   char[] number = pass.getText().toCharArray();
//                   for(int i = 0 ; i < number.length ; i++)
//                   {
//                       if(Character.isDigit(number[i]))
//                       {
//                           numberOfdigit++;
//                           par.setVisible(true);
//                           par.setValue(30);
//                           par.setBackground(Color.red);
//                                   Vstatus4 = true;
//                       }else if(Character.isUpperCase(number[i]))
//                       {
//                           numberOfUpperchar++;
//                          par.setVisible(true);
//                           par.setValue(60);
//                           par.setBackground(Color.blue); 
//                                  Vstatus4 = true;
//                           
//                       }else if(number[i] == '_'){underScroe = true;         Vstatus4 = true;}
//                      
//                   }
//                   
//                   if(numberOfUpperchar > 3 && underScroe == true  )
//                   {
//                       numberOfchar++;
//                       par.setVisible(true);
//                       par.setValue(60);
//                       par.setBackground(Color.GREEN);
//                               Vstatus4 = true;
//                       
//                   }else
//                   {
//                       par.setVisible(true);
//                       par.setValue(50);
//                       par.setBackground(Color.ORANGE);
//                   }
//                   
//                   if( number.length <4 )
//                   {
//                      // war.setText("The password must contain Character and digit or UnderScor");
//                       war.setForeground(Color.red);
//                      ps.setForeground(Color.red);
//                    //  Erorr[4] = false;
//                   }
//               }
//            }
//        });
//        
//        
//    }
//
//    public void Confirm_Passwrod(JPasswordField pass , JPasswordField repass )
//    {
//        repass.addFocusListener(new FocusListener() {
//
//            @Override
//            public void focusGained(FocusEvent e) {
//              pass.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//              repass.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if(!(pass.getText().equals(repass.getText())))
//                {
//                    pass.setBorder(BorderFactory.createLineBorder(Color.red));
//                    repass.setBorder(BorderFactory.createLineBorder(Color.red));
//                }else{Vstatus5 = true;}
//         
//            }
//        });
//    }
//
//    public void Add_Employee(JTextField fname ,JLabel fn  ,
//                       JTextField sname , JLabel sn ,
//                       JRadioButton male , JRadioButton female , 
//                       JComboBox<String> Address , JTextField email , JComboBox<String> ext,
//                       JTextField ex2 ,JSpinner salary ,JLabel sl ,JLabel shek,
//                       JPasswordField pass ,  JPasswordField repass , 
//                       JProgressBar par ,JLabel ps , JLabel reps ,
//                       JLabel war , ArrayList<Trainer>Trainer ,  JRadioButton trainer ,  JRadioButton sec)
//    {
//         this.fname_Validate(fname, fn);
//        this.sname_Validate(sname, sn);
//       
//      
//       
//        this.email_Validate(email, ext, sl, ex2);
//        this.Salary_Validate(salary, sl, shek);
//        this.Password_validate(pass, repass, par, ps, reps ,war);
//        this.Confirm_Passwrod(pass, repass);
//        int numberOfErorr = 0;
//       
//        Trainer temp = new Trainer();
//            
//         System.out.println(""+Vstatus1);
//                 System.out.println(""+Vstatus2);
//                  System.out.println(""+Vstatus3);
//                   System.out.println(""+Vstatus4);
//                    System.out.println(""+Vstatus5);
//            if( Vstatus1 == true && Vstatus2 == true  && Vstatus3 == true && Vstatus4 == true && Vstatus5 == true && Integer.parseInt(salary.getValue().toString()) > 0)
//            {
//                for(Trainer tr : Trainer)
//                {
//                    if(ext.getItemAt(ext.getSelectedIndex()).equals("Other ..")){
//                        if(!(tr.getEmail().equals(email.getText()+"@"+ex2.getText())))
//                        {
//                            temp.setFirstName(fname.getText());
//                            temp.setLastName(sname.getText());
//                            temp.setEmail(email.getText()+"@"+ex2.getText());
//                            temp.setAddress(Address.getItemAt(Address.getSelectedIndex()));
//                            temp.setSalary(Float.parseFloat(salary.getValue().toString()));
//                            if(male.isSelected())
//                            {
//                                temp.setSex("male");
//                            }else{ temp.setSex("female");}
//                            
//                           
//                                temp.setPassword(pass.getText());
//                            
//                            
//                            Trainer.add(temp);
//                            System.out.println("@Other");
//                              JOptionPane.showMessageDialog(null, "The employee has been saved", "Confirm", JOptionPane.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
//                        }else{JOptionPane.showMessageDialog(null, "The employee was added before", "warning", JOptionPane.ERROR_MESSAGE);}
//                        }else if(!(tr.getEmail().equals(email.getText()+"@"+ext.getItemAt(ext.getSelectedIndex()))))
//                        {
//                             temp.setFirstName(fname.getText());
//                            temp.setLastName(sname.getText());
//                            temp.setEmail(email.getText()+"@"+ex2.getText());
//                            temp.setAddress(Address.getItemAt(Address.getSelectedIndex()));
//                            temp.setSalary(Float.parseFloat(salary.getValue().toString()));
//                            if(male.isSelected())
//                            {
//                                temp.setSex("male");
//                            }else{ temp.setSex("female");}
//                            
//                           
//                                temp.setPassword(pass.getText());
//                            
//                             System.out.println("@"+ext.getItemAt(ext.getSelectedIndex()));
//                            Trainer.add(temp);
//                              JOptionPane.showMessageDialog(null, "The employee has been saved", "Confirm", JOptionPane.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
//                        }else{JOptionPane.showMessageDialog(null, "The employee was added before", "warning", JOptionPane.ERROR_MESSAGE);}
//                    }
//                }else{JOptionPane.showMessageDialog(null, "Invalid inputs", "warning", JOptionPane.ERROR_MESSAGE);}
//               
//              
//                
//            }
//            
//        
//        
//        
//          
//  
//
//
//}
