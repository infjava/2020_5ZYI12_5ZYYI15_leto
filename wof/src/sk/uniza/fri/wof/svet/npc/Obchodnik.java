package sk.uniza.fri.wof.svet.npc;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.svet.predmety.IPredmet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Obchodnik extends Npc {
    private final ArrayList<IPredmet> inventar;

    public Obchodnik(String meno, IPredmet... inventar) {
        super(meno);

        this.inventar = new ArrayList<IPredmet>();

//      for (IPredmet predmet : inventar) {
//          this.inventar.add(predmet);
//      }
        Collections.addAll(this.inventar, inventar);
    }

    public void nakupuj(Hrac hrac) {
        Scanner vstup = new Scanner(System.in);

        int no = 1;
        for (IPredmet predmet : this.inventar) {
            System.out.printf("%d) %s%n", no, predmet.getNazov());
            no++;
        }

        int vyber = 0;
        do {
            System.out.print("Co chces kupit? ");

            Scanner riadok = new Scanner(vstup.nextLine());

            if (riadok.hasNextInt()) {
                vyber = riadok.nextInt();
            }
        } while (vyber <= 0 || vyber > this.inventar.size());

        IPredmet kupovanyPredmet = this.inventar.remove(vyber - 1);

        hrac.prijmiPredmet(kupovanyPredmet);
    }
}
