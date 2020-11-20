import javax.swing.JOptionPane;

class PopUP_Window {
    public static void main(String[] args) {
        String warning = JOptionPane.showInputDialog(null, "Unacceptable input: Change your input here", "Warning Message!",
                JOptionPane.WARNING_MESSAGE);
        System.out.println(warning);
    }
}