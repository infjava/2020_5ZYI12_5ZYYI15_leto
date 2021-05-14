package fri.student;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
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
