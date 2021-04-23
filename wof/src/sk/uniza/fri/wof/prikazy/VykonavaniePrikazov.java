package sk.uniza.fri.wof.prikazy;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.hra.NeexistujuciVychodException;
import sk.uniza.fri.wof.hra.PredmetNieJeMoznePolozitException;
import sk.uniza.fri.wof.hra.PredmetNieJeVInventariException;
import sk.uniza.fri.wof.hra.PredmetNieJeVMiestnostiException;
import sk.uniza.fri.wof.svet.Miestnost;
import sk.uniza.fri.wof.svet.NpcNenajdeneException;
import sk.uniza.fri.wof.svet.npc.Npc;
import sk.uniza.fri.wof.svet.npc.NpcOslovitelne;
import sk.uniza.fri.wof.svet.npc.Obchodnik;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        "chod", "ukonci", "pomoc", "oslov", "poloz", "zober", "pouzi",
        "nakupuj", "questbook", "save", "load"
    };

    private static final int SAVE_MAGIC_NUMBER = 0x72951413;
    private static final int SAVE_VERZIA = 1;

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
     */
    public void vykonajPrikaz(Prikaz prikaz, Hrac hrac) throws HraKonciException {
        if (prikaz.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return;
        }

        String nazovPrikazu = prikaz.getNazov();

        switch (nazovPrikazu) {
            case "pomoc":
                this.vypisNapovedu();
                break;
            case "chod":
                this.chodDoMiestnosti(prikaz, hrac);
                break;
            case "ukonci":
                this.ukonciHru(prikaz);
                break;
            case "oslov":
                this.oslovNpc(prikaz, hrac);
                break;
            case "zober":
                this.zoberPredmet(prikaz, hrac);
                break;
            case "poloz":
                this.polozPredmet(prikaz, hrac);
                break;
            case "pouzi":
                this.pouziPredmet(prikaz, hrac);
                break;
            case "nakupuj":
                this.nakupujOdNpc(prikaz, hrac);
                break;
            case "questbook":
                this.zobrazQuestbook(hrac);
                break;
            case "save":
                this.ulozPoziciu(prikaz, hrac);
                break;
            case "load":
                this.nacitajPoziciu(prikaz, hrac);
                break;
        }
    }

    private void nacitajPoziciu(Prikaz prikaz, Hrac hrac) {
        File suborPozicie = new File(prikaz.getParameter() + ".wofsave");

        if (!suborPozicie.exists()) {
            System.out.println("Taky save nemas");
            return;
        }

        try (DataInputStream vstup = new DataInputStream(new FileInputStream(suborPozicie))) {
            int magicNumber = vstup.readInt();
            if (magicNumber != VykonavaniePrikazov.SAVE_MAGIC_NUMBER) {
                System.out.println("Tento subor nie je platnou poziciou hry WOF");
                return;
            }
            int saveVerzia = vstup.readInt();
            if (saveVerzia > VykonavaniePrikazov.SAVE_VERZIA) {
                System.out.println("Tento save bol vyprodukovany v novsej verzii hry");
                return;
            }
            hrac.nacitajPoziciu(vstup, saveVerzia);
            hrac.getAktualnaMiestnost().vypisInfoOMiestnosti();
        } catch (IOException e) {
            System.out.println("Nepodarilo sa nacitat poziciu");
            e.printStackTrace();
        }
    }

    private void ulozPoziciu(Prikaz prikaz, Hrac hrac) {
        File suborPozicie = new File(prikaz.getParameter() + ".wofsave");
        try (DataOutputStream vystup = new DataOutputStream(new FileOutputStream(suborPozicie))) {
            vystup.writeInt(VykonavaniePrikazov.SAVE_MAGIC_NUMBER);
            vystup.writeInt(VykonavaniePrikazov.SAVE_VERZIA);
            hrac.ulozPoziciu(vystup);
        } catch (FileNotFoundException e) {
            System.out.println("Nepodarilo sa ulozit poziciu, asi zly nazov saveu");
        } catch (IOException e) {
            System.out.println("Nepodarilo sa ulozit poziciu");
            e.printStackTrace();
        }
    }

    private void zobrazQuestbook(Hrac hrac) {
        hrac.zobrazQuestbook();
    }

    private void nakupujOdNpc(Prikaz prikaz, Hrac hrac) {
        Miestnost miestnost = hrac.getAktualnaMiestnost();
        try {
            Npc npc = miestnost.getNpc(prikaz.getParameter());
            if (npc instanceof Obchodnik) {
                Obchodnik obchodnik = (Obchodnik)npc;
                obchodnik.nakupuj(hrac);
            } else {
                System.out.printf("NPC %s nie je obchodnik!%n", prikaz.getParameter());
            }
        } catch (NpcNenajdeneException e) {
            System.out.printf("NPC %s sa v miestnosti nenachadza!%n", prikaz.getParameter());
        }
    }

    private void pouziPredmet(Prikaz prikaz, Hrac hrac) throws HraKonciException {
        try {
            hrac.pouziPredmet(prikaz.getParameter());
        } catch (PredmetNieJeVInventariException e) {
            System.out.format("Predmet %s nemas%n", prikaz.getParameter());
        }
    }

    private void polozPredmet(Prikaz prikaz, Hrac hrac) {
        try {
            hrac.polozPredmet(prikaz.getParameter());
            System.out.format("Polozil si predmet %s%n", prikaz.getParameter());
        } catch (PredmetNieJeVInventariException e) {
            System.out.format("Predmet %s nemas v inventari%n", prikaz.getParameter());
        } catch (PredmetNieJeMoznePolozitException e) {
            System.out.format("Predmet %s sa neda v momentalnej situacii polozit%n", prikaz.getParameter());
        }
    }

    private void zoberPredmet(Prikaz prikaz, Hrac hrac) {
        try {
            hrac.zoberPredmet(prikaz.getParameter());
            System.out.format("Zdvihol si predmet %s%n", prikaz.getParameter());
        } catch (PredmetNieJeVMiestnostiException e) {
            System.out.println("Taky predmet v miestnosti nevidis");
        }
    }

    private void oslovNpc(Prikaz prikaz, Hrac hrac) {
        Miestnost miestnost = hrac.getAktualnaMiestnost();
        try {
            Npc npc = miestnost.getNpc(prikaz.getParameter());
            if (npc instanceof NpcOslovitelne) {
                NpcOslovitelne npcOslovitelne = (NpcOslovitelne)npc;
                npcOslovitelne.oslov(hrac);
            } else {
                System.out.printf("NPC %s sa s tebou nechce rozpravat!%n", prikaz.getParameter());
            }
        } catch (NpcNenajdeneException e) {
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

        try {
            hrac.chodSmerom(smer);
            hrac.getAktualnaMiestnost().vypisInfoOMiestnosti();
        } catch (NeexistujuciVychodException e) {
            System.out.println("Tam nie je vychod!");
        }
    }

    /**
     * Ukonci hru.
     * Skotroluje cely prikaz a zisti, ci je naozaj koniec hry.
     * sk.uniza.fri.wof.prikazy.Prikaz ukoncenia nema parameter.
     *
     * @param prikaz prikaz, ktory sa aktualne vykonava
     */
    private void ukonciHru(Prikaz prikaz) throws HraKonciException {
        if (prikaz.maParameter()) {
            System.out.println("Ukonci, co?");
        } else {
            throw new HraKonciException("Hra bola ukoncena prikazom ukonci");
        }
    }
}
