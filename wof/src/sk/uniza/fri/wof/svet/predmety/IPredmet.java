package sk.uniza.fri.wof.svet.predmety;

import sk.uniza.fri.wof.prikazy.HraKonciException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface IPredmet {
    String getNazov();

    void pouziSa() throws HraKonciException;

    void ulozPoziciu(DataOutputStream vystup) throws IOException;
    void nacitajPoziciu(DataInputStream vstup, int saveVerzia) throws IOException;
}
