package fri.klietka;

public class Klietka<E> {
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
}
