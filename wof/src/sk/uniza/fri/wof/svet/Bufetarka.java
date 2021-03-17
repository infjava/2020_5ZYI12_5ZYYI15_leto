package sk.uniza.fri.wof.svet;

public class Bufetarka implements INpc {

    private final String meno;
    private final CastRozhovoru uvod;

    public Bufetarka(String meno, CastRozhovoru uvodRozhovoru) {
        this.meno = meno;
        this.uvod = uvodRozhovoru;
    }

    @Override
    public String getNazov() {
        return this.meno;
    }

    @Override
    public void rozhovor() {
        CastRozhovoru aktualna = this.uvod;
        do {
            aktualna = aktualna.vykonaj();
        } while (aktualna != null);
    }
}
