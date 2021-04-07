package sk.uniza.fri.wof.svet.npc;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.svet.Quest;

public class NpcSQuestami extends NpcOslovitelne {
    private final Quest quest;

    public NpcSQuestami(String meno, Quest quest) {
        super(meno);
        this.quest = quest;
    }

    @Override
    public void oslov(Hrac hrac) {
        System.out.println("Davam ti quest");
    }
}
