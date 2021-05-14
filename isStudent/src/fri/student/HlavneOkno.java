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
        this.editovat.addActionListener(e -> this.editujStudenta());
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

        this.studenti.addListSelectionListener(e -> this.zmenaOznaceniaStudenta());

        this.priezvisko.getDocument().addDocumentListener(kontrolaZmeny);
        this.meno.getDocument().addDocumentListener(kontrolaZmeny);

        this.aktualizujPovoleniaTlacitok();
    }

    private void aktualizujPovoleniaTlacitok() {
        Student oznacenyStudent = this.studenti.getSelectedValue();
        boolean menoPriezviskoZadane = !this.meno.getText().isEmpty() && !this.priezvisko.getText().isEmpty();

        this.novy.setEnabled(menoPriezviskoZadane);
        this.vymazat.setEnabled(oznacenyStudent != null);

        if (oznacenyStudent == null || !menoPriezviskoZadane) {
            this.editovat.setEnabled(false);
        } else {
            boolean menoPriezviskoZmenene = !this.meno.getText().equals(oznacenyStudent.getMeno())
                    || !this.priezvisko.getText().equals(oznacenyStudent.getPriezvisko());

            this.editovat.setEnabled(menoPriezviskoZmenene);
        }
    }

    private void zmenaOznaceniaStudenta() {
        Student oznacenyStudent = this.studenti.getSelectedValue();
        if (oznacenyStudent != null) {
            this.meno.setText(oznacenyStudent.getMeno());
            this.priezvisko.setText(oznacenyStudent.getPriezvisko());
        }

        this.aktualizujPovoleniaTlacitok();
    }

    private void novyStudent() {
        String menoStudenta = this.meno.getText();
        String priezviskoStudenta = this.priezvisko.getText();

        Student student = new Student(menoStudenta, priezviskoStudenta);

        this.zoznamStudentov.addElement(student);
    }

    private void editujStudenta() {
        Student oznacenyStudent = this.studenti.getSelectedValue();

        String menoStudenta = this.meno.getText();
        String priezviskoStudenta = this.priezvisko.getText();

        oznacenyStudent.premenuj(menoStudenta, priezviskoStudenta);

        this.studenti.updateUI();

        this.aktualizujPovoleniaTlacitok();
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
