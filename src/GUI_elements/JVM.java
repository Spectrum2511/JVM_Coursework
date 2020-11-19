package GUI_elements;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JVM extends JFrame {
    private JFrame mainframe = new JFrame("JVM");
    private JButton btn_addproject;
    private JButton btn_addtask;
    private JButton btn_assignteams;
    private JList list_teams;
    private JLabel lbl_projecttasks;
    private JTable table_project;
    private JTextArea textArea_details;
    private JPanel mainPanel;
    private JToolBar topToolBar;
    private JLabel lbl_projecttabletitle;
    private JButton savebtn;
    private JComboBox Projectcbx;

    public class JVMTable {

        public JVMTable() {

            DefaultTableModel model = new DefaultTableModel();

            table_project.setAutoCreateRowSorter(true);
            table_project.setFillsViewportHeight(true);
            //table_project.setPreferredScrollableViewportSize(new Dimension(550, 200));
            model.addColumn("Task");
            model.addColumn("Assigned to");
            model.addColumn("Details");
            model.addColumn("Time Allocated");
            table_project.setModel(model);
            JScrollPane scrollPane = new JScrollPane(table_project);
            add(scrollPane);
        }
    }

        //Launches the Application
    public static void main(String[] args) {

   }


    //Creates the functions
    public JVM() {

        mainframe.setContentPane(mainPanel);
        //mainframe.setSize(700, 600);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.pack();
        mainframe.setVisible(true);

        btn_addproject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Project_g Project = new Project_g();
                Project.setContentPane(new Project_g().projectPanel);
                Project.pack();
                Project.setVisible(true);
            }
        });

        btn_addtask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Task_g Task = new Task_g();
                Task.setContentPane(new Task_g().taskPanel);
                Task.pack();
                Task.setVisible(true);
            }
        });

        btn_assignteams.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Team_g Team = new Team_g();
                Team.setContentPane(new Team_g().teamPanel);
                Team.pack();
                Team.setVisible(true);
            }
        });

        list_teams.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {

            }
        });

        table_project.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               // model.insertRow(model.getRowCount(), new Object[]{})
                //JVMTable JVMTable = new JVMTable();
                //JVMTable = (DefaultTableModel)table_project.getModel();

            }
        });

        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Projectcbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
