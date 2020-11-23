import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Remainder: Fix everyone little issue such as naming convention and major issue such as getting the objects to function as intended or and the gridlayout Abidon

public class Coursework extends JFrame implements ActionListener, ListSelectionListener {

    MenuBar mb = new MenuBar(this);

    JFrame frame = new JFrame();
    JPanel mainPNL = new JPanel();
   // JPanel mainpnl = new JPanel();

    JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
    JButton btnNewProject = new JButton("New Project");
    JButton btnAddTeam = new JButton("Add Team");
    JButton btnAssignPerson = new JButton("Assign Person");
    JButton btnSave = new JButton("Save");
    JButton btnExit = new JButton("Exit");

    String[] columnNames = {"Task Description", "Assigned to Team", "Starts:", "Ends", "Completed"};
    Object[][] data = {{" ", " ", " ", " ", " "}};
    JTable ProjectTable = new JTable(data, columnNames);

    Font LabelFnt = new Font("Times New Roman", Font.PLAIN, 16);
    JLabel lblProjectTasks = new JLabel();
    JLabel lblProjectTable = new JLabel();

    DefaultListModel<String> TeamListNamesExample = new DefaultListModel<>();
    JList<String> TeamList = new JList<>(TeamListNamesExample);

    String ProjectExample[]={"JVM Coursework","Sentiment Analysis using LSTM","HCI In-Car Navigation"};
    JComboBox cbxProjectList = new JComboBox(ProjectExample);

    JTextArea txtTeamNames = new JTextArea();

   // JScrollPane scrollPane = new JScrollPane();



    public static void main(String[] args) {
        Coursework cw = new Coursework();
    }


    public Coursework() {
        JVM();

    }


    private void JVM(){

        //once you wake up in the afternoon fix the grid layout so that it dispays toolbar at the top and the rest is clean and organised
        /*GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(grid);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(toolBar, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(lblProjectTasks, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(TeamList, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(cbxProjectList, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        this.add(txtTeamNames, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 3;
        this.add(ProjectTable, gbc);*/

        mainPNL.setLayout(new GridLayout(4,4, 2,2));
        mainPNL.add(toolBar);
        mainPNL.add(lblProjectTable);
        mainPNL.add(lblProjectTasks);
        mainPNL.add(ProjectTable);
        mainPNL.add(TeamList);
        mainPNL.add(txtTeamNames);
        mainPNL.add(cbxProjectList);
        //mainPNL.add(Gantt Chart);

        btnNewProject = mb.makeNavigationButton( "New Project","NewProject",
                "Create a new project");
        toolBar.add(btnNewProject);
        toolBar.addSeparator();

        btnAddTeam = mb.makeNavigationButton( "Add Task","AddTask",
                "Create a new task");
        toolBar.add(btnAddTeam);
        toolBar.addSeparator();

        btnAssignPerson = mb.makeNavigationButton( "Assign Person", "AssignPerson",
                "Assign a person to a team");
        toolBar.add(btnAssignPerson);
        toolBar.addSeparator();

        btnSave = mb.makeNavigationButton( "Save","Save",
                "Save everything");
        toolBar.add(btnSave);
        toolBar.addSeparator();

        btnExit = mb.makeNavigationButton( "Exit Program","Exit",
                "Close this program");
        toolBar.add(btnExit);
        toolBar.addSeparator();

       //add(toolBar, BorderLayout.NORTH);

        lblProjectTasks.setText("Project Tasks");
        lblProjectTasks.setFont(LabelFnt);

        lblProjectTable.setText("Project Table");
        lblProjectTable.setFont(LabelFnt);
        //add(ProjectTasks, BorderLayout.WEST);

        TeamListNamesExample.addElement("Team A");
        TeamListNamesExample.addElement("Team B");
        TeamListNamesExample.addElement("Team C");
        TeamListNamesExample.addElement("Team D");
        TeamList.setBounds(100,100, 100,100);
        //add(TeamList, BorderLayout.NORTH);


        cbxProjectList.setBounds(50, 50,100,30);

        txtTeamNames.setEditable(false);
        txtTeamNames.setBounds(10,30, 200,200);


        //ProjectTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
      //  scrollPane.setViewportView(ProjectTable);
        //setContentPane(grid);
//get the table working by displaying the title because it is blank
        ProjectTable.setCellSelectionEnabled(true);
        ListSelectionModel select= ProjectTable.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        frame.add(mainPNL);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("JVM Coursework");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {

        if ("NewProject".equals(ae.getActionCommand())) {
            Project_gui pj = new Project_gui();
            pj.setVisible(true);
        }

        if ("AddTask".equals(ae.getActionCommand())) {
            Task_gui tk = new Task_gui();
            tk.setVisible(true);
        }

        if ("AssignPerson".equals(ae.getActionCommand())) {
            Team_gui tm = new Team_gui();
            tm.setVisible(true);
        }

        if ("Save".equals(ae.getActionCommand())) {

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
        if ("Exit".equals(ae.getActionCommand())) {
            System.exit(0);
        }

    }

    @Override

    public void valueChanged(ListSelectionEvent ae) {

        String Data = null;
        int[] row = ProjectTable.getSelectedRows();
        int[] columns = ProjectTable.getSelectedColumns();
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                Data = (String) ProjectTable.getValueAt(row[i], columns[j]);
            }
        }
    }
}
