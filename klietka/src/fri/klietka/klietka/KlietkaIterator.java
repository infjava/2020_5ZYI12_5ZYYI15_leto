package fri.klietka.klietka;

import java.util.Iterator;

public class KlietkaIterator<E> implements Iterator<E> {
    private E zviera;

    public KlietkaIterator(E zviera) {
        this.zviera = zviera;
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
