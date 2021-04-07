package sk.uniza.fri.wof.svet.npc;

import sk.uniza.fri.wof.hra.Hrac;

public abstract class NpcOslovitelne extends Npc {
    public NpcOslovitelne(String meno) {
        super(meno);
    }

    public abstract void oslov(Hrac hrac);
}
