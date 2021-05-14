package fri.student;

public class Student {
    private final String meno;
    private final String priezvisko;

    public Student(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.meno, this.priezvisko);
    }
}
