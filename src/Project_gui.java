import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Project_gui extends JFrame implements ActionListener {

    programHandler handler = programHandler.getInstance();

    JFrame PJframe = new JFrame("Project");
    JPanel pjpnl = new JPanel();
    JPanel btnpanel = new JPanel();
    Font PJfnt = new Font("Times New Roman", Font.PLAIN, 16);

    JButton btnPJSave = new JButton("Create Project");

    JLabel lblName = new JLabel("Name");
    JLabel lblDescription = new JLabel("Description");
    JLabel lblStartDate = new JLabel("Start Date");
    JLabel lblDurations = new JLabel("Durations (Days)");

    JTextField txtName = new JTextField();
    JTextField txtDescription = new JTextField();
    JTextField txtStartDate = new JTextField();
    JTextField txtDurations = new JTextField();

   // public static void main(String[] args) {
    //    Project pj = new Project();
   // }

    public Project_gui(){
        Project();
    }

    private void Project(){

        lblName.setFont(PJfnt);
        lblDescription.setFont(PJfnt);
        lblStartDate.setFont(PJfnt);
        lblDurations.setFont(PJfnt);

        btnPJSave.setFont(PJfnt);
        btnPJSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnpanel.add(btnPJSave);

        pjpnl.setLayout(new GridLayout(4,2, 15,15));
        pjpnl.add(lblName);
        pjpnl.add(txtName);
        pjpnl.add(lblDescription);
        pjpnl.add(txtDescription);
        pjpnl.add(lblStartDate);
        pjpnl.add(txtStartDate);
        pjpnl.add(lblDurations);
        pjpnl.add(txtDurations);


        PJframe.add(btnpanel, BorderLayout.NORTH);
        PJframe.add(pjpnl, BorderLayout.CENTER);

        PJframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PJframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        PJframe.pack();
        PJframe.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        handler.CreateProject(txtName.getText(),txtDescription.getText(), txtStartDate.getText(), Integer.parseInt(txtDurations.getText()));
        Coursework.load_gui();

        //none of these action command will work since it is only works with toolbar. ill try to solve this tomorrow morninig
        if (txtName.equals(e.getActionCommand())){

        }
        if (txtDescription.equals(e.getActionCommand())){

        }
        if (txtStartDate.equals(e.getActionCommand())){

        }
        if (txtDurations.equals(e.getActionCommand())){

        }

        if (e.getSource() == btnPJSave){
            handler.CreateProject(txtName.getText(),txtDescription.getText(), txtStartDate.getText(), Integer.parseInt(txtDurations.getText()));
            Coursework.load_gui();
        }

    }
}