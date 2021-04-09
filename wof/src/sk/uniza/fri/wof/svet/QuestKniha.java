package sk.uniza.fri.wof.svet;

public class QuestKniha implements IQuest {
    @Override
    public String getNazov() {
        return "kniha";
    }

    @Override
    public void hracVosielDoMiestnosti(Miestnost novaMiestnost) {

    }

    @Override
    public boolean getHotovo() {
        return false;
    }

    @Override
    public void priradenyHracovi() {

    }
}
