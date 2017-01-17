///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package UserInterfaces.ManagerInterface;
//
//import java.awt.Color;
//import java.awt.Component;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JTable;
//import javax.swing.table.TableCellRenderer;
//
///**
// *
// * @author AmrSaidam
// */
//class JLabelCellenderer extends JLabel implements TableCellRenderer {
// 
//    public JLabelCellenderer(String path) {
//        setOpaque(true);
//        setBackground(Color.WHITE);
//         java.net.URL imgURL = getClass().getResource(path);
//         this.setIcon(new ImageIcon(imgURL));
//    }
// 
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//      //  setText((String) value);
//        if(isSelected){setBackground(new Color(184,207,229));}
//        else{setBackground(Color.WHITE);}
//        return this;
//    }
//
//    
//    
//}
