package sk.uniza.fri.wof.svet;

public class Knihovnicka implements INpc {

    private final String meno;
    private final CastRozhovoru uvod;

    public Knihovnicka(String meno, CastRozhovoru uvodKnihovnicky) {
        this.meno = meno;
        this.uvod = uvodKnihovnicky;
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
