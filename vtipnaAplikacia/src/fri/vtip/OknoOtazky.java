package fri.vtip;

import javax.swing.JFrame;

public class OknoOtazky {
    private final JFrame okno;

    public OknoOtazky() {
        this.okno = new JFrame("Otazka");

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
