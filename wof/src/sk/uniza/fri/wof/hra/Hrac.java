package sk.uniza.fri.wof.hra;

import sk.uniza.fri.wof.hra.questy.IQuestReakciaNaChodenie;
import sk.uniza.fri.wof.hra.questy.IQuestReakciaNaNpc;
import sk.uniza.fri.wof.hra.questy.IQuestReakciaNaZmenuStavu;
import sk.uniza.fri.wof.hra.questy.Quest;
import sk.uniza.fri.wof.svet.npc.NpcSQuestami;
import sk.uniza.fri.wof.svet.predmety.IKontrolaPolozenia;
import sk.uniza.fri.wof.svet.predmety.IPredmet;
import sk.uniza.fri.wof.svet.Miestnost;

import java.util.ArrayList;
import java.util.HashMap;

public class Hrac {
    private Miestnost aktualnaMiestnost;
    private final HashMap<String, IPredmet> inventar;
    private final ArrayList<Quest> questy;

    public Hrac(Miestnost pociatocnaMiestnost) {
        this.aktualnaMiestnost = pociatocnaMiestnost;
        this.inventar = new HashMap<>();
        this.questy = new ArrayList<>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void chodSmerom(String smer) throws NeexistujuciVychodException {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost == null) {
            throw new NeexistujuciVychodException(smer);
        }

        this.aktualnaMiestnost = novaMiestnost;

        for (Quest quest : this.questy) {
            if (quest instanceof IQuestReakciaNaChodenie) {
                ((IQuestReakciaNaChodenie)quest).hracVosielDoMiestnosti(novaMiestnost);
            }
        }

        this.zistiHotoveQuesty();
    }

    private void zistiHotoveQuesty() {
        ArrayList<Quest> naOdstranenie = new ArrayList<>();
        for (Quest quest : this.questy) {
            if (quest.getHotovo()) {
                System.out.printf("Splnil si quest %s%n", quest.getNazov());
                naOdstranenie.add(quest);
            }
        }
        this.questy.removeAll(naOdstranenie);
    }

    public void polozPredmet(String nazov) throws PredmetNieJeVInventariException, PredmetNieJeMoznePolozitException {
        IPredmet predmet = this.inventar.get(nazov);

        if (predmet == null) {
            throw new PredmetNieJeVInventariException("Predmet sa nenasiel");
        }

        if (predmet instanceof IKontrolaPolozenia) {
            IKontrolaPolozenia kontrola = (IKontrolaPolozenia)predmet;
            if (!kontrola.getDaSaPolozit()) {
                throw new PredmetNieJeMoznePolozitException("Predmet sa neda polozit");
            }
        }

        this.inventar.remove(nazov);

        this.aktualnaMiestnost.polozPredmet(predmet);
    }

    public void zoberPredmet(String nazov) throws PredmetNieJeVMiestnostiException {
        IPredmet predmet = this.aktualnaMiestnost.zoberPredmet(nazov);

        if (predmet == null) {
            throw new PredmetNieJeVMiestnostiException("Predmet sa nenasiel");
        }

        this.inventar.put(nazov, predmet);
    }

    public void pouziPredmet(String nazov) throws PredmetNieJeVInventariException {
        IPredmet predmet = this.inventar.get(nazov);

        if (predmet == null) {
            throw new PredmetNieJeVInventariException("Predmet nemas v inventari");
        }

        predmet.pouziSa();
    }

    public void prijmiPredmet(IPredmet predmet) {
        this.inventar.put(predmet.getNazov(), predmet);
    }

    public void prijmiQuest(Quest quest) {
        this.questy.add(quest);
        if (quest instanceof IQuestReakciaNaZmenuStavu) {
            ((IQuestReakciaNaZmenuStavu)quest).priradenyHracovi();
        }
    }

    public void zobrazQuestbook() {
        for (Quest quest : this.questy) {
            System.out.println(quest.getNazov());
        }
    }

    public void oslovilNpc(NpcSQuestami npc) {
        for (Quest quest : this.questy) {
            if (quest instanceof IQuestReakciaNaNpc) {
                ((IQuestReakciaNaNpc)quest).hracOslovilNpc(this, npc);
            }
        }

        this.zistiHotoveQuesty();
    }

    public boolean maPredmet(String nazov) {
        return this.inventar.containsKey(nazov);
    }

    public void odstranPredmet(String nazov) {
        this.inventar.remove(nazov);
    }
}
