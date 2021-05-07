package fri.klietka.klietka;

import fri.klietka.potrava.IPotrava;
import fri.klietka.zvierata.VycviceneZviera;
import fri.klietka.zvierata.Zviera;

import java.util.Iterator;

public class Klietka<E extends Zviera> implements Iterable<E> {
    private class KlietkaIterator implements Iterator<E> {
        private E zviera;

        KlietkaIterator() {
            this.zviera = Klietka.this.zviera;
        }

        @Override
        public boolean hasNext() {
            return this.zviera != null;
        }

        @Override
        public E next() {
            E vysledok = this.zviera;
            this.zviera = null;
            return vysledok;
        }
    }

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
            System.out.format("V klietke je %s%n", this.zviera.getMeno());
        }
    }

    public void vhodPotravu(IPotrava<E> potrava) {
        System.out.format("%s zjedlo potravu%n", this.zviera.getMeno());
    }

    public void predvedZviera() {
        if (this.zviera == null) {
            System.out.println("Zviera v klietke nie je");
        } else if (this.zviera instanceof VycviceneZviera) {
            ((VycviceneZviera)this.zviera).predvedSa();
        } else {
            System.out.format("%s nie je vycvicene%n", this.zviera.getMeno());
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new KlietkaIterator();
    }
}
