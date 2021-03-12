package sk.uniza.fri.wof.svet;

import java.util.Scanner;

public class CastRozhovoru {
    private final String replikaNpc;
    private final String[] replikyHraca;

    public CastRozhovoru(String replikaNpc, String[] replikyHraca) {
        this.replikaNpc = replikaNpc;
        this.replikyHraca = replikyHraca;
    }

    public int vykonaj() {
        Scanner vstup = new Scanner(System.in);

        if (this.replikaNpc != null) {
            System.out.println(this.replikaNpc);
        }

        int no = 1;
        for (String replika : this.replikyHraca) {
            System.out.printf("%d) %s%n", no, replika);
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

        return vyber;
    }
}
