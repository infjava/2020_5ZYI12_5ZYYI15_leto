package sk.uniza.fri.wof.svet;

import java.util.Date;

public class Quest {
    private final String nazov;
    private Date casPriradenia;

    public Quest(String nazov) {
        this.nazov = nazov;
        this.casPriradenia = null;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void hracVosielDoLabaku() {
        Date aktualnyCas = new Date();
        long rozdielVMilisekundach = aktualnyCas.getTime() - this.casPriradenia.getTime();
        System.out.format("Od vytvorenia uplynulo %d sekund%n", rozdielVMilisekundach / 1000);
    }

    public void priradenyHracovi() {
        this.casPriradenia = new Date();
    }
}
