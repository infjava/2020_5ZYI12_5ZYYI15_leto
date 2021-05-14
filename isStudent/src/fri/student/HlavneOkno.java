package fri.student;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public class HlavneOkno {
    private JPanel isStudent;
    private JList studenti;
    private JTextField meno;
    private JTextField priezvisko;
    private JButton novy;
    private JButton editovat;
    private JButton vymazat;

    public void zobraz() {
        JFrame okno = new JFrame("IS Student");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.add(this.isStudent);
        okno.pack();
        okno.setMinimumSize(new Dimension(350, 250));
        okno.setVisible(true);
    }
}
