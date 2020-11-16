package GUI_elements;

import javax.swing.JOptionPane;

public class warnWindow {

    public warnWindow(String message){
        String warning = JOptionPane.showInputDialog(null, message, "Error",
                JOptionPane.WARNING_MESSAGE);
        System.out.println(warning);

    }
}