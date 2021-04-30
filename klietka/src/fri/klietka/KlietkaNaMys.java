package fri.klietka;

public class KlietkaNaMys {
    private Mys mys;

    public KlietkaNaMys() {
        this.mys = null;
    }

    public void vloz(Mys mys) throws VKlietkeUzNiektoJeException {
        if (this.mys != null) {
            throw new VKlietkeUzNiektoJeException("Uz tu mame mys");
        }
        this.mys = mys;
    }

    public void vypis() {
        if (this.mys == null) {
            System.out.println("Klietka je prazdna");
        } else {
            System.out.println("V klietke je mys");
        }
    }
}
