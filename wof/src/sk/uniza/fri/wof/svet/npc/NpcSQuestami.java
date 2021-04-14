package sk.uniza.fri.wof.svet.npc;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.hra.questy.IQuest;

public class NpcSQuestami extends NpcOslovitelne {
    private IQuest quest;

    public NpcSQuestami(String meno, IQuest quest) {
        super(meno);
        this.quest = quest;
    }

    @Override
    public void oslov(Hrac hrac) {
        if (this.quest != null) {
            hrac.prijmiQuest(this.quest);
            this.quest = null;
            System.out.println("Dostal si quest, tak makaj");
        } else {
            hrac.oslovilNpc(this);
            System.out.println("Uz pre teba nemam ziaden quest");
        }
    }
}
