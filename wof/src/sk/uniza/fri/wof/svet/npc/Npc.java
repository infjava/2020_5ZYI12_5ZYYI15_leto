package sk.uniza.fri.wof.svet.npc;

import java.io.Serializable;

public abstract class Npc implements Serializable {

    private final String meno;

    public Npc(String meno) {
        this.meno = meno;
    }

    public String getNazov() {
        return this.meno;
    }
}
