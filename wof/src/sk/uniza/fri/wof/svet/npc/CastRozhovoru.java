package sk.uniza.fri.wof.svet.npc;

import java.io.Serializable;
import java.util.Scanner;

public class CastRozhovoru implements Serializable {
    private final String replikaNpc;
    private final ReplikaHraca[] replikyHraca;

    public CastRozhovoru(String replikaNpc, ReplikaHraca... replikyHraca) {
        this.replikaNpc = replikaNpc;
        this.replikyHraca = replikyHraca;
    }

    public CastRozhovoru vykonaj() {
        Scanner vstup = new Scanner(System.in);

        if (this.replikaNpc != null) {
            System.out.println(this.replikaNpc);
        }

        if (this.replikyHraca.length == 0) {
            return null;
        }

        int no = 1;
        for (ReplikaHraca replika : this.replikyHraca) {
            System.out.printf("%d) %s%n", no, replika.getText());
            no++;
        }

        int vyber = 0;
        do {
            System.out.print("Co chces povedat? ");

            Scanner riadok = new Scanner(vstup.nextLine());

            if (riadok.hasNextInt()) {
                vyber = riadok.nextInt();
            }
        } while (vyber <= 0 || vyber > this.replikyHraca.length);

        return this.replikyHraca[vyber - 1].getCielovaCast();
    }
}
