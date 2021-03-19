package sk.uniza.fri.wof.hra;

import sk.uniza.fri.wof.svet.Miestnost;
import sk.uniza.fri.wof.svet.Predmet;

import java.util.HashMap;

public class Hrac {
    private Miestnost aktualnaMiestnost;
    private final HashMap<String, Predmet> inventar;

    public Hrac(Miestnost pociatocnaMiestnost) {
        this.aktualnaMiestnost = pociatocnaMiestnost;
        this.inventar = new HashMap<>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public boolean chodSmerom(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost != null) {
            this.aktualnaMiestnost = novaMiestnost;
            return true;
        }

        return false;
    }

    public void polozPredmet(String nazov) {
        Predmet predmet = this.inventar.remove(nazov);
        if (predmet != null) {
            this.aktualnaMiestnost.polozPredmet(predmet);
        }
    }

    public void zoberPredmet(String nazov) {
        Predmet predmet = this.aktualnaMiestnost.zoberPredmet(nazov);
        if (predmet != null) {
            this.inventar.put(nazov, predmet);
        }
    }
}
