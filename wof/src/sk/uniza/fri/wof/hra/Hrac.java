package sk.uniza.fri.wof.hra;

import sk.uniza.fri.wof.svet.IQuest;
import sk.uniza.fri.wof.svet.predmety.IKontrolaPolozenia;
import sk.uniza.fri.wof.svet.predmety.IPredmet;
import sk.uniza.fri.wof.svet.Miestnost;

import java.util.ArrayList;
import java.util.HashMap;

public class Hrac {
    private Miestnost aktualnaMiestnost;
    private final HashMap<String, IPredmet> inventar;
    private final ArrayList<IQuest> questy;

    public Hrac(Miestnost pociatocnaMiestnost) {
        this.aktualnaMiestnost = pociatocnaMiestnost;
        this.inventar = new HashMap<>();
        this.questy = new ArrayList<>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public boolean chodSmerom(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost != null) {
            this.aktualnaMiestnost = novaMiestnost;

            for (IQuest quest : this.questy) {
                quest.hracVosielDoMiestnosti(novaMiestnost);
            }

            ArrayList<IQuest> naOdstranenie = new ArrayList<>();
            for (IQuest quest : this.questy) {
                if (quest.getHotovo()) {
                    System.out.printf("Splnil si quest %s%n", quest.getNazov());
                    naOdstranenie.add(quest);
                }
            }
            this.questy.removeAll(naOdstranenie);
            return true;
        }

        return false;
    }

    public boolean polozPredmet(String nazov) {
        IPredmet predmet = this.inventar.get(nazov);

        if (predmet == null) {
            return false;
        }

        if (predmet instanceof IKontrolaPolozenia) {
            IKontrolaPolozenia kontrola = (IKontrolaPolozenia)predmet;
            if (!kontrola.getDaSaPolozit()) {
                return false;
            }
        }

        this.inventar.remove(nazov);

        this.aktualnaMiestnost.polozPredmet(predmet);
        return true;
    }

    public boolean zoberPredmet(String nazov) {
        IPredmet predmet = this.aktualnaMiestnost.zoberPredmet(nazov);

        if (predmet == null) {
            return false;
        }

        this.inventar.put(nazov, predmet);
        return true;
    }

    public boolean pouziPredmet(String nazov) {
        IPredmet predmet = this.inventar.get(nazov);

        if (predmet == null) {
            return false;
        }

        predmet.pouziSa();

        return true;
    }

    public void prijmiPredmet(IPredmet predmet) {
        this.inventar.put(predmet.getNazov(), predmet);
    }

    public void prijmiQuest(IQuest quest) {
        this.questy.add(quest);
        quest.priradenyHracovi();
    }

    public void zobrazQuestbook() {
        for (IQuest quest : this.questy) {
            System.out.println(quest.getNazov());
        }
    }
}
