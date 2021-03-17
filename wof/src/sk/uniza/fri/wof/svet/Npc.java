package sk.uniza.fri.wof.svet;

public class Npc {

    private final String meno;
    private final CastRozhovoru uvod;

    public Npc(String meno, CastRozhovoru uvodRozhovoru) {
        this.meno = meno;
        this.uvod = uvodRozhovoru;
    }

    public String getNazov() {
        return this.meno;
    }

    public void rozhovor() {
        CastRozhovoru aktualna = this.uvod;
        do {
            aktualna = aktualna.vykonaj();
        } while (aktualna != null);
    }
}
