package fri.klietka.zvierata;

public class Slon extends VycviceneZviera {
    @Override
    public String getMeno() {
        return "Jumbo";
    }

    @Override
    public void predvedSa() {
        System.out.println("Slon zatancoval polku");
    }
}
