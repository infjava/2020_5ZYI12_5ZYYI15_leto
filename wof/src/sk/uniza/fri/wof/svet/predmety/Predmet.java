package sk.uniza.fri.wof.svet.predmety;

import java.io.DataInputStream;
import java.io.DataOutputStream;

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

    @Override
    public void ulozPoziciu(DataOutputStream vystup) {

    }

    @Override
    public void nacitajPoziciu(DataInputStream vstup, int saveVerzia) {

    }
}
