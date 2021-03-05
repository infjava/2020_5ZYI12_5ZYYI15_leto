public class Svet {
    private final Miestnost startovaciaMiestnost;

    public Svet() {
        // vytvorenie miestnosti
        Miestnost terasa = new Miestnost("terasa - hlavny vstup na fakultu");
        Miestnost aula = new Miestnost("aula");
        Miestnost bufet = new Miestnost("bufet");
        Miestnost labak = new Miestnost("pocitacove laboratorium");
        Miestnost kancelaria = new Miestnost("kancelaria spravcu pocitacoveho laboratoria");
        Miestnost skrina = new Miestnost("skrina na vybavenie laboratoria");

        // inicializacia miestnosti = nastavenie vychodov
        terasa.nastavVychod("vychod", aula);
        terasa.nastavVychod("juh", labak);
        terasa.nastavVychod("zapad", bufet);
        aula.nastavVychod("zapad", terasa);
        bufet.nastavVychod("vychod", terasa);
        labak.nastavVychod("sever", terasa);
        labak.nastavVychod("vychod", kancelaria);
        kancelaria.nastavVychod("zapad", labak);

        labak.nastavVychod("skrina", skrina);
        skrina.nastavVychod("von", labak);

        aula.nastavVychod("dole", bufet);
        bufet.nastavVychod("hore", aula);

        this.startovaciaMiestnost = terasa;
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
