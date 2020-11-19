package GUI_elements;

import javax.swing.JOptionPane;

class PopUP_Window{
    String warning = JOptionPane.showInputDialog(null, "Unacceptable input: Change your input here", "Warning Message!",
            JOptionPane.WARNING_MESSAGE);

    public PopUP_Window() {
        System.out.println(warning);
    }

}