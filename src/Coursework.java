import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import classes.*;

//Note to self
//Calendar, gridlayout look, Gantt chart placement and actionperformed needs to be do.
//cannot retrieve the calendar, mess around with gridbagconstraint to make Project, Team and Task GUI frame look more pleasing.
//Gantt chart need to be added once it is created
//actionperformed only works for toolbar variables not any other.
//Fix this Abidon once you wake up
public class Coursework extends JFrame implements ActionListener, ListSelectionListener {

    public static programHandler data = programHandler.getInstance();

    MenuBar mb = new MenuBar(this);

    JFrame frame = new JFrame();
    JPanel westpnl = new JPanel(new GridBagLayout());
    JPanel centerpnl = new JPanel(new GridBagLayout());
    JPanel eastpnl = new JPanel(new GridBagLayout());


    JToolBar toolBar = new JToolBar();
    JButton btnNewProject = new JButton("New Project");
    JButton btnAddTeam = new JButton("Add Team");
    JButton btnAssignPerson = new JButton("Assign Team to Task");
    JButton btnSave = new JButton("Save");
    JButton btnExit = new JButton("Exit");



    Font LabelFnt = new Font("Times New Roman", Font.PLAIN, 16);
    JLabel lblProjectTasks = new JLabel();
    JLabel lblProjectTable = new JLabel();
    JLabel lblTeamList = new JLabel();
    JLabel lblTeamMembers = new JLabel();
    JLabel lblGanttChart = new JLabel();


    private static DefaultListModel<String> TeamListNames;
    private static JList<String> TeamList;

    private static ArrayList<String> ProjectBoxList = new ArrayList<>();
    private static JComboBox cbxProjectList;

    public static Object[][] tasktable;

    JTextArea txtTeamNames = new JTextArea(30,30);


    public Coursework() {
        JVM();

    }


    private void JVM(){
        load_gui();
        btnNewProject = mb.makeNavigationButton( "New Project","NewProject",
                "Create a new project");
        toolBar.add(btnNewProject);
        toolBar.addSeparator();

        btnAddTeam = mb.makeNavigationButton( "Add Task","AddTask",
                "Create a new task");
        toolBar.add(btnAddTeam);
        toolBar.addSeparator();

        btnAssignPerson = mb.makeNavigationButton( "Assign Team to Task", "AssignTeam",
                "Assign a person to a team");
        toolBar.add(btnAssignPerson);
        toolBar.addSeparator();

        btnSave = mb.makeNavigationButton( "Save","Save",
                "Save everything");
        toolBar.add(btnSave);
        toolBar.addSeparator();

        btnExit = mb.makeNavigationButton( "Exit Program","MainExit",
                "Close this program");
        toolBar.add(btnExit);
        toolBar.addSeparator();


        lblProjectTasks.setText("Projects:");
        lblProjectTasks.setFont(LabelFnt);

        lblProjectTable.setText("Project Table");
        lblProjectTable.setFont(LabelFnt);

        lblGanttChart.setText("Time till completion (Gantt Chart)");
        lblGanttChart.setFont(LabelFnt);

        lblTeamList.setText("List of Teams");
        lblTeamList.setFont(LabelFnt);

        lblTeamMembers.setText("Information:");
        lblTeamMembers.setFont(LabelFnt);

        JScrollPane listSP = new JScrollPane(TeamList);
        listSP.setPreferredSize(new Dimension(200,200));

        cbxProjectList.setSelectedIndex(-1);

        txtTeamNames.setEditable(false);


        String[] columnNames = {"Task Description", "Assigned to Team", "Start", "End", "Completed"};

        JTable ProjectTable = new JTable(tasktable, columnNames);
        ProjectTable.setCellSelectionEnabled(false);
        JScrollPane tableSP = new JScrollPane(ProjectTable);
        tableSP.setPreferredSize(new Dimension(800,400));

        //Explanation for gridlayout is on yt and the oracle website Abidon.
        //read and explain it afterwards
        //https://www.youtube.com/watch?v=ZipG38DJJK8
        //https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
        //https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15, 15, 15);

//left panel work
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        westpnl.add(lblProjectTasks, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        westpnl.add(cbxProjectList, gbc);



//centerpanel work
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        centerpnl.add(lblProjectTable,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        centerpnl.add(tableSP,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        centerpnl.add(lblGanttChart,gbc);

        //gantt chart comes here. add a scrollpane to it if it contains alot of data
     /* gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        centerpnl.add(_____,gbc); //Gantt Chart variable goes here
*/


//eastpanel work

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        eastpnl.add(lblTeamList,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        eastpnl.add(listSP,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        eastpnl.add(lblTeamMembers,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 4;
        gbc.fill = 4;
        eastpnl.add(txtTeamNames,gbc);

        frame.add(toolBar, BorderLayout.NORTH);
        frame.add(westpnl, BorderLayout.WEST);
        frame.add(centerpnl, BorderLayout.CENTER);
        frame.add(eastpnl, BorderLayout.EAST);


        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("JVM Coursework");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void load_gui(){
        if (!data.getProjects().isEmpty()){
            tasktable = new Object[data.getCurrentProject().getProjectTasks().size()][5];
            ArrayList<Task> t = data.getCurrentProject().getProjectTasks();
            for (int i = 0; i < data.getCurrentProject().getProjectTasks().size(); i++){
                Task f = data.getCurrentProject().getProjectTasks().get(i);
                Object[] arr = {f.getTaskDesc(), f.getAssignedTeam().getTeamName(), f.getTaskStartDate(), f.getTaskEndDate(), f.getIsCompleted()};
                for (int j = 0; j < 5; j++){
                    tasktable[i][j] = arr[j];
                }
            }
            for (Project i: data.getProjects()){
                ProjectBoxList.add(i.getProjName());
            }
            cbxProjectList= new JComboBox(ProjectBoxList.toArray());

            TeamListNames = new DefaultListModel<>();
            for (Team i: data.getCurrentProject().getProjectTeams()){
                TeamListNames.addElement(i.getTeamName());
            }
            TeamList = new JList<>(TeamListNames);
        }else{
            data.CreateProject("new project", "example project", String.valueOf(LocalDate.now()),10);
            data.getCurrentProject().addTask("Say hello to world",2, "null");
            load_gui();
        }
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        if ("NewProject".equals(ae.getActionCommand())) {
            Project_gui pj = new Project_gui(this);
        }

        if ("AddTask".equals(ae.getActionCommand())) {
            Task_gui tk = new Task_gui();
        }

        if ("AssignTeam".equals(ae.getActionCommand())) {
            Team_gui tm = new Team_gui();
        }

        if ("Save".equals(ae.getActionCommand())) {
            int SaveConfirmation = JOptionPane.showConfirmDialog(null,
                    "Do you want to save all the recent changes?", "Save Program Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (SaveConfirmation == JOptionPane.YES_OPTION) {
                try {
                    data.saveInstances();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //https://www.javatpoint.com is used as inspiration for all
        //example of a list using a button command in the link above
        if (TeamList.getSelectedIndex() != -1) {
         //   String data = " ";
         //   data = "Programming language Selected: " + TeamList.getSelectedValue();
            //label.setText(data);
        }

        //example
        if (cbxProjectList.equals(ae.getActionCommand())) {
            //cbxProjectList.getItemAt(cbxProjectList.getSelectedIndex());
        }

        if (txtTeamNames.equals(ae.getActionCommand())) {
        //    String text = txtTeamNames.getText();
         //   String word[]=text.split("\\s");
         }
        if ("MainExit".equals(ae.getActionCommand())) {

            int MainExitConfirmation = JOptionPane.showConfirmDialog(null,
                    "Do you want to exit the program?", "Exit Program Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (MainExitConfirmation == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }

    //supposed to be a JTable actionlistener. see if it works otherwise call me.
    @Override
    public void valueChanged(ListSelectionEvent ae) {

      /*  String Data = null;
        int[] row = ProjectTable.getSelectedRows();
        int[] columns = ProjectTable.getSelectedColumns();
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                Data = (String) ProjectTable.getValueAt(row[i], columns[j]);
            }
        }*/
    }
}
