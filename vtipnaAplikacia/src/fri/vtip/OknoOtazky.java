package fri.vtip;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OknoOtazky {
    private final JFrame okno;

    public OknoOtazky() {
        this.okno = new JFrame("Otazka");

        this.okno.setLayout(new BorderLayout(0, 10));

        this.okno.add(new JLabel("Chces uspesne skoncit predmet Informatika 2?"), BorderLayout.NORTH);

        JPanel tlacitka = new JPanel();
        tlacitka.setLayout(new GridLayout(1, 2, 10, 0));

        JButton ano = new JButton("Ano");
        JButton nie = new JButton("Nie");

        ano.addMouseListener(new MouseAdapter() {
            private boolean prvyAno = true;

            @Override
            public void mouseEntered(MouseEvent e) {
                tlacitka.removeAll();

                if (this.prvyAno) {
                    tlacitka.add(nie);
                    tlacitka.add(ano);
                } else {
                    tlacitka.add(ano);
                    tlacitka.add(nie);
                }
                this.prvyAno = !this.prvyAno;

                tlacitka.revalidate();
                tlacitka.repaint();
            }
        });

        nie.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "To myslis vazne?");
            System.exit(0);
        });

        tlacitka.add(ano);
        tlacitka.add(nie);

        this.okno.add(tlacitka, BorderLayout.CENTER);

        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
