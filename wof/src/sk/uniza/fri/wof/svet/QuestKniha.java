package sk.uniza.fri.wof.svet;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.svet.npc.NpcSQuestami;

public class QuestKniha implements IQuest {
    private boolean hotovo;

    public QuestKniha() {
        this.hotovo = false;
    }

    @Override
    public String getNazov() {
        return "kniha";
    }

    @Override
    public void hracVosielDoMiestnosti(Miestnost novaMiestnost) {

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
