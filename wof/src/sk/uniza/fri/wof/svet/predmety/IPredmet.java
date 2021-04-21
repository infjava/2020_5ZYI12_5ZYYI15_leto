package sk.uniza.fri.wof.svet.predmety;

import sk.uniza.fri.wof.prikazy.HraKonciException;

import java.io.Serializable;

public interface IPredmet extends Serializable {
    String getNazov();

    void pouziSa() throws HraKonciException;
}
