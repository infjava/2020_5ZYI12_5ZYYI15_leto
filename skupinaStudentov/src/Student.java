/**
 * 24. 2. 2021 - 8:17
 *
 * @author janik
 */
public class Student {

    private final String osobneCislo;
    private final String meno;
    private final String priezvisko;

    public Student(String osobneCislo, String meno, String priezvisko) {
        this.osobneCislo = osobneCislo;
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    public String getOsobneCislo() {
        return this.osobneCislo;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }
}
