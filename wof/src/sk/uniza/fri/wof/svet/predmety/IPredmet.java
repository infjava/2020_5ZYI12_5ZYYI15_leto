package sk.uniza.fri.wof.svet.predmety;

import sk.uniza.fri.wof.prikazy.HraKonciException;

public interface IPredmet {
    String getNazov();

    void pouziSa() throws HraKonciException;
}
