/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdatingPackage;

import Entities.Course;
import java.awt.Dimension;
import java.util.List;
import java.util.Observable;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amr M.Saidam
 */
public class UpdateCourseTable extends Observable {

    public JScrollPane CreateTextArea(DefaultTableModel model, JTable table, List<Course> Courses) {

        JScrollPane sp = new JScrollPane(table);
        Object[] col = {"ID", "C: Name", "C: Price", "C: Hours"};
        model.setColumnIdentifiers(col);
        for (int x = 0; x < Courses.size(); x++) {
            model.addRow(new Object[]{Courses.get(x).getID(), Courses.get(x).getCourseName(), Courses.get(x).getPrice(), Courses.get(x).getHours()});
        }
        model.setRowCount(25);
        table.setEnabled(false);

        sp.setPreferredSize(new Dimension(250, 350));
        setChanged();
        notifyObservers();
        return sp;

    }

}
