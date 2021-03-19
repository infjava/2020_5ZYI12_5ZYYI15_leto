package sk.uniza.fri.wof.svet;

public class Navleky implements IPredmet {
    @Override
    public String getNazov() {
        return "navleky";
    }

    @Override
    public void pouziSa() {
        System.out.println("Pouzil si navleky");
    }
}
