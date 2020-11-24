import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Team_gui extends JFrame implements ActionListener {
    JFrame TMframe = new JFrame("Team");
    JPanel tmpnl = new JPanel();
    JPanel btnpnl = new JPanel();

    Font tmfnt = new Font("Times New Roman", Font.PLAIN, 18);

    JButton btnTMSave = new JButton("Save Team");
    JButton btnTeamExit = new JButton("Exit Team");

    JLabel lblTeamName = new JLabel("Team Name");
    JLabel lblMemberNames = new JLabel("Members Name");

    JTextField txtName = new JTextField();
    JTextArea txtDescription = new JTextArea();

    // public static void main(String[] args) {
    //    Team tm = new Team();
    // }

    public Team_gui(){
        Team();
    }

    private void Team(){
        lblTeamName.setFont(tmfnt);
        lblMemberNames.setFont(tmfnt);
        txtName.setFont(tmfnt);
        txtDescription.setFont(tmfnt);

        btnTMSave.setFont(tmfnt);
        btnTeamExit.setFont(tmfnt);

        btnpnl.add(btnTMSave);
        btnpnl.add(btnTeamExit);

        tmpnl.setLayout(new GridLayout(2,2, 15,15));
        tmpnl.add(lblTeamName);
        tmpnl.add(txtName);
        tmpnl.add(lblMemberNames);
        tmpnl.add(txtDescription);

        TMframe.add(btnpnl, BorderLayout.NORTH);
        TMframe.add(tmpnl, BorderLayout.CENTER);

        TMframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TMframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        TMframe.pack();
        TMframe.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (txtName.equals(ae.getActionCommand())){

        }
        if (txtDescription.equals(ae.getActionCommand())){

        }
        if (ae.getSource() == btnTMSave){
            int SaveConfirmation = JOptionPane.showConfirmDialog(null,
                    "Do you want to save all the recent changes?", "Save Program Message Box",
                    JOptionPane.YES_NO_OPTION);

            if (SaveConfirmation == JOptionPane.YES_OPTION) {

            }
        }
        if (ae.getSource() == btnTeamExit){
            int TaskExitConfirmation = JOptionPane.showConfirmDialog(null,
                    "Do you want to exit the program?", "Exit Program Message Box",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);

            if (TaskExitConfirmation == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }
}
