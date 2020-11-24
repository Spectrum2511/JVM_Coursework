import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task_gui extends JFrame implements ActionListener {
    JFrame TKframe = new JFrame("Task");
    JPanel tkpnl = new JPanel();
    JPanel btnpnl = new JPanel();

    Font tkfnt = new Font("Times New Roman", Font.PLAIN, 18);

    JButton btnTKSave = new JButton("Save Task");
    JButton btnTaskExit = new JButton("Exit Task");

    JLabel lblName = new JLabel("Name");
    JLabel lblDescription = new JLabel("Task Description");
    JLabel lblDurations = new JLabel("Durations (Days)");

    JTextField txtName = new JTextField();
    JTextField txtDescription = new JTextField();
    JTextField txtDurations = new JTextField();

    // public static void main(String[] args) {
    //    Task tk = new Task();
    // }

    public Task_gui(){
        Task();
    }

    private void Task(){
        lblName.setFont(tkfnt);
        lblDescription.setFont(tkfnt);
        lblDurations.setFont(tkfnt);

        btnTKSave.setFont(tkfnt);
        btnTaskExit.setFont(tkfnt);

        btnpnl.add(btnTKSave);
        btnpnl.add(btnTaskExit);

        tkpnl.setLayout(new GridLayout(3,2, 15,15));
        tkpnl.add(lblName);
        tkpnl.add(txtName);
        tkpnl.add(lblDescription);
        tkpnl.add(txtDescription);
        tkpnl.add(lblDurations);
        tkpnl.add(txtDurations);

        TKframe.add(btnpnl, BorderLayout.NORTH);
        TKframe.add(tkpnl, BorderLayout.CENTER);

        TKframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TKframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        TKframe.pack();
        TKframe.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (txtName.equals(ae.getActionCommand())){

        }
        if (txtDescription.equals(ae.getActionCommand())){

        }
        if (txtDurations.equals(ae.getActionCommand())){

        }
        if (ae.getSource() == btnTKSave){
            int SaveConfirmation = JOptionPane.showConfirmDialog(null,
                    "Do you want to save all the recent changes?", "Save Program Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (SaveConfirmation == JOptionPane.YES_OPTION) {

            }
        }
        if (ae.getSource() == btnTaskExit){
            int TaskExitConfirmation = JOptionPane.showConfirmDialog(null,
                    "Do you want to exit the program?", "Exit Program Message Box",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);

            if (TaskExitConfirmation == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }
}
