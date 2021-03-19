package sk.uniza.fri.wof.svet;

public class Predmet {
    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

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
