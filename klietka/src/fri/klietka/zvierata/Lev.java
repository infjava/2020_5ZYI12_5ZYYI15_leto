package fri.klietka.zvierata;

public class Lev extends VycviceneZviera {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void predvedSa() {
        System.out.println("Lev skocil cez ohnivu obruc");
    }
}
