package GUI_elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project_inp extends JFrame{
    private JButton addproject_btn;
    private JButton editproject_btn;
    private JButton deleteproject_btn;
    private JTextField txt_startdate;
    private JTextField txt_projectduration;
    private JTextField txt_projectdescription;
    private JTextField txt_projectname;
    private JLabel projectconfiguration_lbl;
    private JLabel lbl_projectduration;
    private JLabel lbl_startdate;
    private JLabel lbl_description;
    private JLabel lbl_projectname;
    public JPanel projectPanel;


    //Launches the Application
    public static void main(String[] args) {
        JFrame projectframe = new JFrame("Project");
        projectframe.setContentPane(new Project_inp().projectPanel);
        //frame1.setSize(700, 600);
        projectframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projectframe.pack();
        projectframe.setVisible(true);
    }


    public Project_inp() {
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
        txt_projectname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        txt_projectdescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        txt_startdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        txt_projectduration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
