package GUI_elements;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JVM extends JFrame {
    private JButton projectmanagement;
    private JButton addteam;
    private JButton assignperson;
    private JList teams;
    private JLabel projecttasks;
    private JTable project;
    private JTextArea details;
    private JPanel tablePanel;
    private JButton taskmanagement;
    public JPanel mainPanel;
    private JToolBar topToolBar;
    private JLabel projecttabletitle;

    private void setup(){

    }


    public JVM() {

        projectmanagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        addteam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        assignperson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        taskmanagement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        teams.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {

            }
        });
    }

}
