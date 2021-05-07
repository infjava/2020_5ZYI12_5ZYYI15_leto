package fri.prvocisla;

import java.util.Iterator;

public class Prvocisla implements Iterable<Integer> {
    private final int maximum;

    public Prvocisla(int maximum) {
        this.maximum = maximum;
    }

    private boolean jePrvocislo(int cislo) {
        for (int i = 2; i < cislo; i++) {
            if (cislo % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int cislo = 1;

            @Override
            public boolean hasNext() {
                return this.cislo < Prvocisla.this.maximum;
            }

            @Override
            public Integer next() {
                do {
                    this.cislo++;
                } while (!Prvocisla.this.jePrvocislo(this.cislo));
                return this.cislo;
            }
        };
    }
}
