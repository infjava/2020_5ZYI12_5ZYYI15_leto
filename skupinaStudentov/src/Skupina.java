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

    public void pridajStudenta(Student student) {
        this.zoznamStudentov.add(student);
    }
}
