package sk.uniza.fri.wof.svet;

public class Knihovnicka implements INpc {
    @Override
    public String getNazov() {
        return "knihovnicka";
    }

    @Override
    public void rozhovor() {
        CastRozhovoru nicNehovori = new CastRozhovoru(
                "Knihovnicka dalej mlci"
        );
        CastRozhovoru uvod = new CastRozhovoru(
                "Knihovnicka sa s tebou nechce rozpravat",
                new ReplikaHraca("A preco?", nicNehovori)
        );

        CastRozhovoru aktualna = uvod;
        do {
            aktualna = aktualna.vykonaj();
        } while (aktualna != null);
    }
}
