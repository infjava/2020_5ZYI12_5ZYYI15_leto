package sk.uniza.fri.wof.svet;

import java.util.Date;

public class Quest {
    private final String nazov;
    private Date casPriradenia;
    private boolean hotovo;

    public Quest(String nazov) {
        this.nazov = nazov;
        this.casPriradenia = null;
        this.hotovo = false;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void hracVosielDoMiestnosti(Miestnost novaMiestnost) {
        if (!novaMiestnost.getPopis().startsWith("RA013")) {
            return;
        }

        Date aktualnyCas = new Date();
        long rozdielVMilisekundach = aktualnyCas.getTime() - this.casPriradenia.getTime();
        System.out.format("Od vytvorenia uplynulo %d sekund%n", rozdielVMilisekundach / 1000);
        this.hotovo = true;
    }

    public boolean getHotovo() {
        return this.hotovo;
    }

    public void priradenyHracovi() {
        this.casPriradenia = new Date();
    }
}
