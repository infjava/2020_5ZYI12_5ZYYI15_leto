package sk.uniza.fri.wof.svet.npc;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.svet.Quest;

public class NpcSQuestami extends NpcOslovitelne {
    private Quest quest;

    public NpcSQuestami(String meno, Quest quest) {
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
            System.out.println("Uz pre teba nemam ziaden quest");
        }
    }
}
