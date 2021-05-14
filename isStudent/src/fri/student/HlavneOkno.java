package fri.student;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HlavneOkno {
    private JPanel isStudent;

    public void zobraz() {
        JFrame okno = new JFrame("IS Student");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.add(this.isStudent);
        okno.pack();
        okno.setVisible(true);
    }
}
