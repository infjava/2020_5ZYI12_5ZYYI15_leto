package sk.uniza.fri.wof.svet.predmety;

public class Predmet implements IPredmet {
    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouziSa() {
        System.out.format("Predmet %s sa neda pouzit%n", this.nazov);
    }
}
