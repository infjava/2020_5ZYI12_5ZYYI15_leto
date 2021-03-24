package sk.uniza.fri.wof.svet.predmety;

public class Navleky implements IPredmet, IKontrolaPolozenia {
    private boolean suObute;

    public Navleky() {
        this.suObute = false;
    }

    @Override
    public String getNazov() {
        return "navleky";
    }

    @Override
    public void pouziSa() {
        if (this.suObute) {
            System.out.println("Vyzul si si navleky");
            this.suObute = false;
        } else {
            System.out.println("Obul si si navleky");
            this.suObute = true;
        }
    }

    @Override
    public boolean getDaSaPolozit() {
        return !this.suObute;
    }
}
