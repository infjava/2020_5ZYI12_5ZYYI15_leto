package fri.vtip;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int vyber = JOptionPane.showConfirmDialog(null, "Chces uspesne skoncit predmet Informatika 2?");
        if (vyber == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "To myslis vazne?");
        }
    }
}
