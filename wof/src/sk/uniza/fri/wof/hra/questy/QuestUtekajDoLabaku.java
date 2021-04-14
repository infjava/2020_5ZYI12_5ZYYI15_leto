package sk.uniza.fri.wof.hra.questy;

import sk.uniza.fri.wof.svet.Miestnost;

import java.util.Date;

public class QuestUtekajDoLabaku extends Quest implements IQuestReakciaNaChodenie, IQuestReakciaNaZmenuStavu {
    private Date casPriradenia;

    public QuestUtekajDoLabaku() {
        this.casPriradenia = null;
    }

    @Override
    public String getNazov() {
        return "utekajDoLabaku";
    }

    @Override
    public void hracVosielDoMiestnosti(Miestnost novaMiestnost) {
        if (!novaMiestnost.getPopis().startsWith("RA013")) {
            return;
        }

        Date aktualnyCas = new Date();
        long rozdielVMilisekundach = aktualnyCas.getTime() - this.casPriradenia.getTime();
        if (rozdielVMilisekundach > 20000) {
            System.out.println("Sorry, si pomaly");
        } else {
            this.vyries();
        }
    }

    @Override
    public void priradenyHracovi() {
        this.casPriradenia = new Date();
    }
}
