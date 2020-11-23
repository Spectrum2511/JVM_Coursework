//initial inspiration
//www.codejava.net = https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
//Fix this so it connects to the project and task class before 23rd midnight.
//retrieving the date and time using a messagebox.
//best to utilise a textfield or make the messagebox as a confirmation box to save the file Abidon
public class Calendar extends JFrame implements ActionListener {

    //variables creation
    final JDatePickerImpl datePicker;
    UtilDateModel model = new UtilDateModel();
    JTextField TextDisplay = new JTextField();


    public Calendar() {

        //creates the GUI title and sets the component layout
        super("Calendar Testing");
        setLayout(new FlowLayout());

        //the model for the calendar is initialised
        model.setDate(2020, 11, 19);
        model.setSelected(true);

        //this sets up the text date format for the user to see
        Properties p = new Properties();
        p.put("text.year", "Year");
        p.put("text.month", "Month");
        p.put("text.today", "Today");

        //panel is created and combines the model and properties
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

        //the datepicker is created using a datepanel and a com.company.DateLabelFormatter abstract class
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        add(datePicker);

        //Creation of a button
        JButton ButtonOk = new JButton("OK");
        ButtonOk.addActionListener(this);
        add(ButtonOk);

        //creation of a textfield
        TextDisplay.addActionListener(this);
        TextDisplay.setColumns(25);
        add(TextDisplay);


        //Creation of the JFrame
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


    //Launches the Application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calendar().setVisible(true));
    }

    //Creates the action methods for the button.
    @Override
    public void actionPerformed(ActionEvent ae) {
            Date selectedDate = (Date) datePicker.getModel().getValue();
            JOptionPane.showMessageDialog(null, "Project selected date is: " + selectedDate);


        //retrieves the date from the datepicker calendar
        //  Date selectedDate = (Date) datePicker.getModel().getValue();

        //then displays it in a message box
        //TextDisplay
        //JOptionPane.showMessageDialog(null, "Project selected date is: " + selectedDate);
        //model.getClass(); > try to use this function to call a textfield Abidon

    }
}

