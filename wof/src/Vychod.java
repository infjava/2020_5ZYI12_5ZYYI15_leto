public class Vychod {
    private final String smer;
    private final Miestnost ciel;

    public Vychod(String smer, Miestnost ciel) {
        this.smer = smer;
        this.ciel = ciel;
    }

    public String getSmer() {
        return this.smer;
    }

    public Miestnost getCiel() {
        return this.ciel;
    }
}
