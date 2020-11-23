import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task_gui extends JFrame implements ActionListener {
    JFrame f = new JFrame("Project");
    JPanel tkpnl = new JPanel();
    Font tkfnt = new Font("Times New Roman", Font.PLAIN, 18);

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
        Task_gui();
    }

    private void Task(){
        lblName.setFont(tkfnt);
        lblDescription.setFont(tkfnt);
        lblDurations.setFont(tkfnt);

        tkpnl.setLayout(new GridLayout(3,2, 1,1));
        tkpnl.add(lblName);
        tkpnl.add(txtName);
        tkpnl.add(lblDescription);
        tkpnl.add(txtDescription);
        tkpnl.add(lblDurations);
        tkpnl.add(txtDurations);

        f.add(tkpnl);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.pack();
        f.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (txtName.equals(ae.getActionCommand())){

        }
        if (txtDescription.equals(ae.getActionCommand())){

        }
        if (txtDurations.equals(ae.getActionCommand())){

        }
    }
}
