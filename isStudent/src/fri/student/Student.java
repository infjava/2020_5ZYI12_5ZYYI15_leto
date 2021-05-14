package fri.student;

public class Student {
    private String meno;
    private String priezvisko;

    public Student(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    public void premenuj(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.meno, this.priezvisko);
    }
}
