package fri.vtip;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class OknoOtazky {
    private final JFrame okno;

    public OknoOtazky() {
        this.okno = new JFrame("Otazka");

        this.okno.setLayout(new BorderLayout());

        this.okno.add(new JLabel("Chces uspesne skoncit predmet Informatika 2?"), BorderLayout.NORTH);
        this.okno.add(new JButton("Ano"), BorderLayout.WEST);
        this.okno.add(new JButton("Nie"), BorderLayout.EAST);

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
