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

    public boolean chodSmerom(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost != null) {
            this.aktualnaMiestnost = novaMiestnost;

            for (Quest quest : this.questy) {
                if (quest instanceof IQuestReakciaNaChodenie) {
                    ((IQuestReakciaNaChodenie)quest).hracVosielDoMiestnosti(novaMiestnost);
                }
            }

            this.zistiHotoveQuesty();
            return true;
        }

        return false;
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
