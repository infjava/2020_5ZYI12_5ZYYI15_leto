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

    public boolean polozPredmet(String nazov) {
        Predmet predmet = this.inventar.remove(nazov);

        if (predmet == null) {
            return false;
        }

        this.aktualnaMiestnost.polozPredmet(predmet);
        return true;
    }

    public boolean zoberPredmet(String nazov) {
        Predmet predmet = this.aktualnaMiestnost.zoberPredmet(nazov);

        if (predmet == null) {
            return false;
        }

        this.inventar.put(nazov, predmet);
        return true;
    }

    public boolean pouziPredmet(String nazov) {
        Predmet predmet = this.inventar.get(nazov);

        if (predmet == null) {
            return false;
        }

        predmet.pouziSa();

        return true;
    }
}
