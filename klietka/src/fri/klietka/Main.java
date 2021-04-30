package fri.klietka;

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
