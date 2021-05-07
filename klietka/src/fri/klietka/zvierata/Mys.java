package fri.klietka.zvierata;

import fri.klietka.potrava.IPotrava;

public class Mys extends Zviera implements IPotrava<Macka> {
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
