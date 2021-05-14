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

        this.zoznamStudentov.addElement(new Student("Jozko", "Mrkvicka"));
        this.zoznamStudentov.addElement(new Student("Ferko", "Mrkvicka"));
        this.zoznamStudentov.addElement(new Student("Terminator", "T1000"));
        this.zoznamStudentov.addElement(new Student("Igor", "Matovic"));
        this.zoznamStudentov.addElement(new Student("Agata", "Christie"));
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
