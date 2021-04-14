package sk.uniza.fri.wof.hra.questy;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.svet.Miestnost;
import sk.uniza.fri.wof.svet.npc.NpcSQuestami;

public interface IQuest {
    String getNazov();
    void hracVosielDoMiestnosti(Miestnost novaMiestnost);
    boolean getHotovo();
    void priradenyHracovi();
    void hracOslovilNpc(Hrac hrac, NpcSQuestami npc);
}
