package fri.klietka.klietka;

import fri.klietka.potrava.Potrava;
import fri.klietka.zvierata.Zviera;

public class Klietka<E extends Zviera> {
    private E zviera;

    public Klietka() {
        this.zviera = null;
    }

    public void vloz(E zviera) throws VKlietkeUzNiektoJeException {
        if (this.zviera != null) {
            throw new VKlietkeUzNiektoJeException("Uz tu mame zviera");
        }
        this.zviera = zviera;
    }

    public void vypis() {
        if (this.zviera == null) {
            System.out.println("Klietka je prazdna");
        } else {
            System.out.println("V klietke je zviera");
        }
    }

    public void vhodPotravu(Potrava potrava) {
        System.out.println("Zviera zjedlo potravu");
    }
}
