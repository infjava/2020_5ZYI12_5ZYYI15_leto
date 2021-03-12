package sk.uniza.fri.wof.prikazy;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.svet.INpc;
import sk.uniza.fri.wof.svet.Miestnost;

/**
 * Trieda NazvyPrikazov udrzuje zoznam nazvov platnych prikazov hry. 
 * Za ulohu ma rozpoznavat platne prikazy.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */

public class VykonavaniePrikazov {
    // konstantne pole nazvov prikazov
    private static final String[] PLATNE_PRIKAZY = {
        "chod", "ukonci", "pomoc", "oslov"
    };

    /**
     * Kontroluje, ci nazov v parametri je platny prikaz.
     *  
     * @return true ak je parameter platny prikaz,
     * false inak.
     */
    public boolean jePrikaz(String nazov) {
        for (int i = 0; i < VykonavaniePrikazov.PLATNE_PRIKAZY.length; i++) {
            if (VykonavaniePrikazov.PLATNE_PRIKAZY[i].equals(nazov)) {
                return true;
            }
        }
        // ak algoritmus dosiahne tento bod, parameter nie je platny prikaz
        return false;
    }

    /**
     * Prevezne prikaz a vykona ho.
     *
     * @param prikaz prikaz, ktory ma byt vykonany.
     * @param hrac hrac, ktory ma vykonat prikaz
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    public boolean vykonajPrikaz(Prikaz prikaz, Hrac hrac) {
        if (prikaz.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }

        String nazovPrikazu = prikaz.getNazov();

        switch (nazovPrikazu) {
            case "pomoc":
                this.vypisNapovedu();
                return false;
            case "chod":
                this.chodDoMiestnosti(prikaz, hrac);
                return false;
            case "ukonci":
                return this.ukonciHru(prikaz);
            case "oslov":
                this.oslovNpc(prikaz, hrac);
                return false;
            default:
                return false;
        }
    }

    private void oslovNpc(Prikaz prikaz, Hrac hrac) {
        Miestnost miestnost = hrac.getAktualnaMiestnost();
        INpc npc = miestnost.getNpc(prikaz.getParameter());
        if (npc != null) {
            npc.rozhovor();
        } else {
            System.out.printf("NPC %s sa v miestnosti nenachadza!%n", prikaz.getParameter());
        }
    }

    /**
     * Vypise text pomocnika do terminaloveho okna.
     * Text obsahuje zoznam moznych prikazov.
     */
    private void vypisNapovedu() {
        System.out.println("Zabludil si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc");
    }

    /**
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     * @param prikaz prikaz, ktory sa aktualne vykonava
     * @param hrac hrac, ktory ma vykonat prikaz
     */
    private void chodDoMiestnosti(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();

        if (hrac.chodSmerom(smer)) {
            hrac.getAktualnaMiestnost().vypisInfoOMiestnosti();
        } else {
            System.out.println("Tam nie je vychod!");
        }
    }

    /**
     * Ukonci hru.
     * Skotroluje cely prikaz a zisti, ci je naozaj koniec hry.
     * sk.uniza.fri.wof.prikazy.Prikaz ukoncenia nema parameter.
     *
     * @return true, ak prikaz konci hru, inak false.
     * @param prikaz prikaz, ktory sa aktualne vykonava
     */
    private boolean ukonciHru(Prikaz prikaz) {
        if (prikaz.maParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }
}
