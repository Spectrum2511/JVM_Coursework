import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project_gui extends JFrame implements ActionListener {
    JFrame f = new JFrame("Project");
    JPanel pjpnl = new JPanel();
    Font PJfnt = new Font("Times New Roman", Font.PLAIN, 18);

    JLabel lblName = new JLabel("Name");
    JLabel lblDescription = new JLabel("Description");
    JLabel lblStartDate = new JLabel("Start Date");
    JLabel lblDurations = new JLabel("Durations (Days)");

    JTextField txtName = new JTextField();
    JTextField txtDescription = new JTextField();
    JTextField txtStartDate = new JTextField();
    JTextField txtDurations = new JTextField();

    //JDatePickerImpl datePicker;
   // UtilDateModel model = new UtilDateModel();
    //JButton ButtonOk = new JButton("OK");

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

        pjpnl.setLayout(new GridLayout(4,2, 1,1));
        pjpnl.add(lblName);
        pjpnl.add(txtName);
        pjpnl.add(lblDescription);
        pjpnl.add(txtDescription);

        pjpnl.add(lblStartDate);
        pjpnl.add(txtStartDate);
        pjpnl.add(lblDurations);
        pjpnl.add(txtDurations);

        f.add(pjpnl);

        //probably I have to create this in another class and call it to my Task and Project class to gt the calendar to display itself
       // model.setDate(2020, 11, 19);
      //  model.setSelected(true);

        //this sets up the text date format for the user to see
      //  Properties p = new Properties();
      //  p.put("text.year", "Year");
      //  p.put("text.month", "Month");
      //  p.put("text.today", "Today");

        //panel is created and combines the model and properties
       // JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

        //the datepicker is created using a datepanel and a com.company.DateLabelFormatter abstract class
       // datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        //add(datePicker);

        //Creation of a button
       // ButtonOk.addActionListener(this);
       // add(ButtonOk);




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
        if (txtStartDate.equals(ae.getActionCommand())){

        }
        if (txtDurations.equals(ae.getActionCommand())){

        }
        //  if (ButtonOk.equals(ae.getActionCommand())){
      //      Date selectedDate = (Date) datePicker.getModel().getValue();
       //     JOptionPane.showMessageDialog(null, "Project selected date is: " + selectedDate);

      //  }
    }
}
