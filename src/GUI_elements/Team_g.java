package GUI_elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Team_g extends JFrame {
    public JPanel teamPanel;
    private JTextField txt_personname1;
    private JTextField txt_personname2;
    private JTextField txt_personname3;
    private JTextField txt_personname4;
    private JLabel lbl_teamassignment;
    private JLabel lbl_pname1;
    private JLabel lbl_pname2;
    private JLabel lbl_pname3;
    private JLabel lbl_pname4;
    private JButton addTeamButton;
    private JButton editTeamButton;
    private JButton deleteTeamButton;


    //Launches the Application
    public static void main(String[] args) {
        JFrame teamframe = new JFrame("Team");
        teamframe.setContentPane(new Team_g().teamPanel);
        //frame1.setSize(700, 600);
        teamframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teamframe.pack();
        teamframe.setVisible(true);
    }


    public Team_g() {
        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txt_personname1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txt_personname2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txt_personname3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txt_personname4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
