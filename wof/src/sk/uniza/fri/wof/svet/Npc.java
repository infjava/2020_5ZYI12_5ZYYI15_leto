package sk.uniza.fri.wof.svet;

public class Npc {
    private final String nazov;

    public Npc(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void rozhovor() {
        System.out.printf("Rozpravas sa s %s%n", this.nazov);
    }
}
