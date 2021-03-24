package sk.uniza.fri.wof.svet.npc;

public class NpcSRozhovorom extends Npc {
    private final CastRozhovoru uvod;

    public NpcSRozhovorom(String meno, CastRozhovoru uvodRozhovoru) {
        super(meno);
        this.uvod = uvodRozhovoru;
    }

    public void rozhovor() {
        CastRozhovoru aktualna = this.uvod;
        do {
            aktualna = aktualna.vykonaj();
        } while (aktualna != null);
    }
}
