package fri.prvocisla;

import java.util.ArrayList;
import java.util.Iterator;

public class Prvocisla implements Iterable<Integer> {
    private final ArrayList<Integer> prvocisla;

    public Prvocisla(int maximum) {
        this.prvocisla = new ArrayList<>();

        for (int cislo = 2; cislo <= maximum; cislo++) {
            if (this.jePrvocislo(cislo)) {
                this.prvocisla.add(cislo);
            }
        }
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
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < Prvocisla.this.prvocisla.size();
            }

            @Override
            public Integer next() {
                this.index++;
                return Prvocisla.this.prvocisla.get(this.index - 1);
            }
        };
    }
}
