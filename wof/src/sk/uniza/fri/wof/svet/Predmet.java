package sk.uniza.fri.wof.svet;

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
        switch (this.nazov) {
            case "navleky":
                System.out.println("Pouzil si navleky");
                break;
            default:
                System.out.format("Predmet %s sa neda pouzit%n", this.nazov);
        }
    }
}
