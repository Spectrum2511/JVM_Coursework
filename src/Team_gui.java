import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Team_gui extends JFrame implements ActionListener {
    JFrame f = new JFrame("Project");
    JPanel tmpnl = new JPanel();
    Font tmfnt = new Font("Times New Roman", Font.PLAIN, 18);

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

        tmpnl.setLayout(new GridLayout(2,2, 1,1));
        tmpnl.add(lblTeamName);
        tmpnl.add(txtName);
        tmpnl.add(lblMemberNames);
        tmpnl.add(txtDescription);

        f.add(tmpnl);

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
    }
}
