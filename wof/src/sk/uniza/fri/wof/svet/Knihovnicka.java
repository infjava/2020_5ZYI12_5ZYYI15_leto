package sk.uniza.fri.wof.svet;

public class Knihovnicka implements INpc {
    @Override
    public String getNazov() {
        return "knihovnicka";
    }

    @Override
    public void rozhovor() {
        System.out.println("Knihovnicka sa s tebou nechce rozpravat");
    }
}
