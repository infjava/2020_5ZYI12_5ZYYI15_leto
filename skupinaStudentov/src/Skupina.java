import java.util.ArrayList;

/**
 * 24. 2. 2021 - 8:17
 *
 * @author janik
 */
public class Skupina {
    private final String cisloSkupiny;
    private final ArrayList<Student> zoznamStudentov;

    public Skupina(String cisloSkupiny) {
        this.cisloSkupiny = cisloSkupiny;
        this.zoznamStudentov = new ArrayList<>();
    }

    public String getCisloSkupiny() {
        return this.cisloSkupiny;
    }

    public int getPocetStudentov() {
        return this.zoznamStudentov.size();
    }

    public void pridajStudenta(Student student) {
        this.zoznamStudentov.add(student);
    }

    public void odoberStudenta(String osobneCislo) {
        for (Student student : this.zoznamStudentov) {
            if (student.getOsobneCislo().equals(osobneCislo)) {
                this.zoznamStudentov.remove(student);
                return;
            }
        }
    }

    public Student getStudent(String osobneCislo) {
        for (Student student : this.zoznamStudentov) {
            if (student.getOsobneCislo().equals(osobneCislo)) {
                return student;
            }
        }
        return null;
    }

    public void vypisStudentov() {
        System.out.printf("Studenti skupiny %s:%n", this.cisloSkupiny);
        for (Student student : this.zoznamStudentov) {
            System.out.println(student);
        }
    }
}
