package fri.klietka.zvierata;

public class Lev extends Zviera {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }
}
