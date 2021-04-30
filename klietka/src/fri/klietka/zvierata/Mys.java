package fri.klietka.zvierata;

public class Mys extends Zviera {
    private final boolean jeSamec;

    public Mys(boolean jeSamec) {
        this.jeSamec = jeSamec;
    }

    @Override
    public String getMeno() {
        if (this.jeSamec) {
            return "Mickey";
        } else {
            return "Minie";
        }
    }
}
