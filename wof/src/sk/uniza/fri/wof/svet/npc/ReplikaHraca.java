package sk.uniza.fri.wof.svet.npc;

public class ReplikaHraca {
    private final String text;
    private final CastRozhovoru cielovaCast;

    public ReplikaHraca(String text, CastRozhovoru cielovaCast) {
        this.text = text;
        this.cielovaCast = cielovaCast;
    }

    public String getText() {
        return this.text;
    }

    public CastRozhovoru getCielovaCast() {
        return this.cielovaCast;
    }
}
