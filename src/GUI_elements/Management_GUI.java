package GUI_elements;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Management_GUI {
    private JButton addproject_btn;
    private JButton editproject_btn;
    private JButton deleteproject_btn;
    private JList list_teammanipulation;
    private JTextField txt_details;
    private JTextField txt_timeallocated;
    private JTextField txt_assignedto;
    private JTextField txt_task;
    private JLabel ptablemanipulation_lbl;
    private JLabel pteammanipulation_lbl;
    private JLabel lbl_timeallocated;
    private JLabel lbl_details;
    private JLabel lbl_assignedto;
    private JLabel lbl_task;
    private JPanel projectPanel;

    public Management_GUI() {
        addproject_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        editproject_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        deleteproject_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        list_teammanipulation.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {

            }
        });
        txt_task.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        txt_assignedto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        txt_details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        txt_timeallocated.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
