import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task_gui extends JFrame {
    private JButton addTaskButton;
    private JButton editTaskButton;
    private JButton deleteTaskButton;
    private JTextField txt_taskname;
    private JTextField txt_taskdescription;
    private JLabel lbl_taskname;
    private JLabel lbl_taskdescription;
    private JLabel lbl_taskconfiguration;
    private JTextField txt_taskduration;
    private JLabel lbl_taskduration;
    public JPanel taskPanel;


    //Launches the Application
    public static void main(String[] args) {
        JFrame taskframe = new JFrame("Task");
        taskframe.setContentPane(new Task_gui().taskPanel);
        //frame1.setSize(700, 600);
        taskframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        taskframe.pack();
        taskframe.setVisible(true);
    }


    public Task_gui() {
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txt_taskname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txt_taskdescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        txt_taskduration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
