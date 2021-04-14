package sk.uniza.fri.wof.hra.questy;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.svet.Miestnost;
import sk.uniza.fri.wof.svet.npc.NpcSQuestami;
import sk.uniza.fri.wof.svet.predmety.Predmet;

public class QuestKniha implements IQuest {
    private boolean polozenaKniha;
    private boolean hotovo;

    public QuestKniha() {
        this.hotovo = false;
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
    public boolean getHotovo() {
        return this.hotovo;
    }

    @Override
    public void priradenyHracovi() {

    }

    @Override
    public void hracOslovilNpc(Hrac hrac, NpcSQuestami npc) {
        if (npc.getNazov().equals("knihovnicka")) {
            if (hrac.maPredmet("kniha")) {
                this.hotovo = true;
                hrac.odstranPredmet("kniha");
            }
        }
    }
}
