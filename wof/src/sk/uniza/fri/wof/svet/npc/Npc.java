package sk.uniza.fri.wof.svet.npc;

public abstract class Npc {

    private final String meno;

    public Npc(String meno) {
        this.meno = meno;
    }

    public String getNazov() {
        return this.meno;
    }
}
