package sk.uniza.fri.wof.svet.predmety;

import sk.uniza.fri.wof.prikazy.HraKonciException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Random;

public class Granat implements IPredmet {
    private final Random nahoda;

    public Granat() {
        this.nahoda = new Random();
    }

    @Override
    public String getNazov() {
        return "granat";
    }

    @Override
    public void pouziSa() throws HraKonciException {
        if (this.nahoda.nextBoolean()) {
            System.out.println("Granat ti vybuchol v ruke. Pozdravuj Vinetoua!");
            throw new HraKonciException("Vybuchol granat");
        }
        System.out.println("Tento krat si mal stastie, ale s granatom sa nehraj.");
    }

    @Override
    public void ulozPoziciu(DataOutputStream vystup) {

    }

    @Override
    public void nacitajPoziciu(DataInputStream vstup, int saveVerzia) {

    }
}
