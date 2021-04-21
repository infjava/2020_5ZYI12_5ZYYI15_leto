package sk.uniza.fri.wof.svet.npc;

import java.io.Serializable;

public class ReplikaHraca implements Serializable {
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
