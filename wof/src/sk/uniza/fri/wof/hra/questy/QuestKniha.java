package sk.uniza.fri.wof.hra.questy;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.svet.Miestnost;
import sk.uniza.fri.wof.svet.npc.NpcSQuestami;
import sk.uniza.fri.wof.svet.predmety.Predmet;

public class QuestKniha extends Quest implements IQuestReakciaNaChodenie, IQuestReakciaNaNpc {
    private boolean polozenaKniha;

    public QuestKniha() {
        this.polozenaKniha = false;
    }

    @Override
    public String getNazov() {
        return "kniha";
    }

    @Override
    public void hracVosielDoMiestnosti(Miestnost novaMiestnost) {
        if (novaMiestnost.getPopis().startsWith("Narnia")) {
            if (!this.polozenaKniha) {
                novaMiestnost.polozPredmet(new Predmet("kniha"));
                this.polozenaKniha = true;
            }
        }
    }

    @Override
    public void hracOslovilNpc(Hrac hrac, NpcSQuestami npc) {
        if (npc.getNazov().equals("knihovnicka")) {
            if (hrac.maPredmet("kniha")) {
                this.vyries();
                hrac.odstranPredmet("kniha");
            }
        }
    }
}
