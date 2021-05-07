package fri.klietka;

import fri.klietka.klietka.Klietka;
import fri.klietka.klietka.VKlietkeUzNiektoJeException;
import fri.klietka.potrava.KusMasa;
import fri.klietka.potrava.Syr;
import fri.klietka.zvierata.Lev;
import fri.klietka.zvierata.Macka;
import fri.klietka.zvierata.Mys;
import fri.klietka.zvierata.Slon;

public class Main {

    public static void main(String[] args) throws VKlietkeUzNiektoJeException {
        Klietka<Lev> klietkaNaLeva = new Klietka<>();
        klietkaNaLeva.vloz(new Lev("Alex"));
        klietkaNaLeva.vhodPotravu(new KusMasa());
        //klietkaNaLeva.vloz(new Lev());
        klietkaNaLeva.vypis();
        klietkaNaLeva.predvedZviera();

        Klietka<Mys> klietkaNaMys = new Klietka<>();
        klietkaNaMys.vloz(new Mys(true));
        klietkaNaMys.vhodPotravu(new Syr());
        klietkaNaMys.vypis();
        klietkaNaMys.predvedZviera();

        Klietka<Slon> klietkaNaSlona = new Klietka<>();
        klietkaNaSlona.vloz(new Slon());
        klietkaNaSlona.vypis();
        klietkaNaSlona.predvedZviera();

        Klietka<Macka> klietkaNaMacku = new Klietka<>();
        klietkaNaMacku.vloz(new Macka());
        klietkaNaMacku.vhodPotravu(new Mys(true));
        klietkaNaMacku.vypis();
    }
}
