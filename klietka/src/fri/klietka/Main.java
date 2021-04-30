package fri.klietka;

public class Main {

    public static void main(String[] args) throws VKlietkeUzNiektoJeException {
        KlietkaNaLeva klietkaNaLeva = new KlietkaNaLeva();
        klietkaNaLeva.vloz(new Lev());
        //klietkaNaLeva.vloz(new Lev());
        klietkaNaLeva.vypis();
    }
}
