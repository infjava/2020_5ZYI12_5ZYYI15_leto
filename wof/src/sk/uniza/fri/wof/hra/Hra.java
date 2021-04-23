package sk.uniza.fri.wof.hra;

import sk.uniza.fri.wof.prikazy.HraKonciException;
import sk.uniza.fri.wof.prikazy.Parser;
import sk.uniza.fri.wof.prikazy.Prikaz;
import sk.uniza.fri.wof.svet.Svet;
import sk.uniza.fri.wof.prikazy.VykonavaniePrikazov;

/**
 * Trieda sk.uniza.fri.wof.hra.Hra je hlavna trieda aplikacie "World of FRI".
 * "World of FRI" je velmi jednoducha textova hra - adventura. 
 * sk.uniza.fri.wof.hra.Hrac sa moze prechadzat po niektorych priestoroch - miestnostiach fakulty.
 * To je v tejto verzii vsetko. Hru treba skutocne zancne rozsirit,
 * aby bola zaujimava.
 * 
 * Ak chcete hrat "World of FRI", vytvorte instanciu triedy sk.uniza.fri.wof.hra.Hra (hra)
 * a poslite jej spravu hraj.
 * 
 * sk.uniza.fri.wof.hra.Hra vytvori a inicializuje vsetky potebne objekty:
 * vytvori vsetky miestnosti, vytvori parser a zacne hru. sk.uniza.fri.wof.hra.Hra tiez vyhodnocuje
 * a vykonava prikazy, ktore vrati parser.
 * 
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
*/
 
public class Hra  {
    private final Parser parser;
    private final Hrac hrac;
    private final VykonavaniePrikazov vykonavaniePrikazov;

    /**
     * Vytvori a inicializuje hru.
     */
    public Hra() {
        Svet svet = new Svet();
        this.hrac = new Hrac(svet);
        this.vykonavaniePrikazov = new VykonavaniePrikazov();
        this.parser = new Parser(this.vykonavaniePrikazov);
    }

    /**
     *  Hlavna metoda hry.
     *  Cyklicky opakuje kroky hry, kym hrac hru neukonci.
     */
    public void hraj() {            
        this.vypisPrivitanie();

        // Vstupny bod hlavneho cyklu.
        // Opakovane nacitava prikazy hraca
        // vykonava ich kym hrac nezada prikaz na ukoncenie hry.

        try {
            //noinspection InfiniteLoopStatement
            for (;;) {
                Prikaz prikaz = this.parser.nacitajPrikaz();
                this.vykonavaniePrikazov.vykonajPrikaz(prikaz, this.hrac);
            }
        } catch (HraKonciException e) {
            System.out.println("Maj sa fajn!");
        }
    }

    /**
     * Vypise privitanie hraca do terminaloveho okna.
     */
    private void vypisPrivitanie() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI je nova, neuveritelne nudna adventura.");
        System.out.println("Zadaj 'pomoc' ak potrebujes pomoc.");
        System.out.println();
        this.hrac.getAktualnaMiestnost().vypisInfoOMiestnosti();
    }
}
