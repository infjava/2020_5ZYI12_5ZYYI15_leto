package sk.uniza.fri.wof.svet.npc;

import sk.uniza.fri.wof.hra.Hrac;

public class NpcSRozhovorom extends NpcOslovitelne {
    private final CastRozhovoru uvod;

    public NpcSRozhovorom(String meno, CastRozhovoru uvodRozhovoru) {
        super(meno);
        this.uvod = uvodRozhovoru;
    }

    @Override
    public void oslov(Hrac hrac) {
        CastRozhovoru aktualna = this.uvod;
        do {
            aktualna = aktualna.vykonaj();
        } while (aktualna != null);
    }
}
