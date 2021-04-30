package fri.klietka;

import fri.klietka.klietka.Klietka;
import fri.klietka.klietka.VKlietkeUzNiektoJeException;
import fri.klietka.zvierata.Lev;
import fri.klietka.zvierata.Mys;

public class Main {

    public static void main(String[] args) throws VKlietkeUzNiektoJeException {
        Klietka<Lev> klietkaNaLeva = new Klietka<>();
        klietkaNaLeva.vloz(new Lev());
        //klietkaNaLeva.vloz(new Lev());
        klietkaNaLeva.vypis();

        Klietka<Mys> klietkaNaMys = new Klietka<>();
        klietkaNaMys.vloz(new Mys());
        klietkaNaMys.vypis();
    }
}
