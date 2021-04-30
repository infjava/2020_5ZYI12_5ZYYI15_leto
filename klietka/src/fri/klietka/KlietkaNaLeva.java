package fri.klietka;

public class KlietkaNaLeva {
    private Lev lev;

    public KlietkaNaLeva() {
        this.lev = null;
    }

    public void vloz(Lev lev) {
        this.lev = lev;
    }

    public void vypis() {
        if (this.lev == null) {
            System.out.println("Klietka je prazdna");
        } else {
            System.out.println("V klietke je lev");
        }
    }
}
