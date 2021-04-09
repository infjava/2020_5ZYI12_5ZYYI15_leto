package sk.uniza.fri.wof.svet;

public interface IQuest {
    String getNazov();
    void hracVosielDoMiestnosti(Miestnost novaMiestnost);
    boolean getHotovo();
    void priradenyHracovi();
}
