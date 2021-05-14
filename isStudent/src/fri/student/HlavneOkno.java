package fri.student;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Dimension;

public class HlavneOkno {
    private final DefaultListModel<Student> zoznamStudentov;
    private JPanel isStudent;
    private JList<Student> studenti;
    private JTextField meno;
    private JTextField priezvisko;
    private JButton novy;
    private JButton editovat;
    private JButton vymazat;

    public HlavneOkno() {
        this.zoznamStudentov = new DefaultListModel<>();

        this.studenti.setModel(this.zoznamStudentov);

        this.novy.addActionListener(e -> this.novyStudent());
        this.vymazat.addActionListener(e -> this.vymazStudenta());

        DocumentListener kontrolaZmeny = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujPovoleniaTlacitok();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujPovoleniaTlacitok();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujPovoleniaTlacitok();
            }
        };

        this.priezvisko.getDocument().addDocumentListener(kontrolaZmeny);
        this.meno.getDocument().addDocumentListener(kontrolaZmeny);

        this.aktualizujPovoleniaTlacitok();
    }

    private void aktualizujPovoleniaTlacitok() {
        this.novy.setEnabled(!this.meno.getText().isEmpty() && !this.priezvisko.getText().isEmpty());
    }

    private void novyStudent() {
        String menoStudenta = this.meno.getText();
        String priezviskoStudenta = this.priezvisko.getText();

        Student student = new Student(menoStudenta, priezviskoStudenta);

        this.zoznamStudentov.addElement(student);
    }

    private void vymazStudenta() {
        Student oznacenyStudent = this.studenti.getSelectedValue();
        this.zoznamStudentov.removeElement(oznacenyStudent);
    }

    public void zobraz() {
        JFrame okno = new JFrame("IS Student");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.add(this.isStudent);
        okno.pack();
        okno.setMinimumSize(new Dimension(350, 250));
        okno.setVisible(true);
    }
}
