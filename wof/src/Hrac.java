public class Hrac {
    private Miestnost aktualnaMiestnost;

    public Hrac(Miestnost pociatocnaMiestnost) {
        this.aktualnaMiestnost = pociatocnaMiestnost;
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public boolean chodSmerom(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost != null) {
            this.aktualnaMiestnost = novaMiestnost;
            return true;
        }

        return false;
    }
}
