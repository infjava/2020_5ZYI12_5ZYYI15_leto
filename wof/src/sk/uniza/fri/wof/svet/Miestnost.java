package sk.uniza.fri.wof.svet;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * Trieda sk.uniza.fri.wof.svet.Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private final String popisMiestnosti;
    private final TreeMap<String, Miestnost> vychody;
    private final HashMap<String, Npc> npccka;
    private final HashMap<String, Predmet> predmety;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.vychody = new TreeMap<>();
        this.npccka = new HashMap<>();
        this.predmety = new HashMap<>();
    }

    public void nastavVychod(String smer, Miestnost ciel) {
        this.vychody.put(smer, ciel);
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    public void vypisInfoOMiestnosti() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        this.vypisZoznam("Vychody", this.vychody.keySet());
        this.vypisZoznam("NPC", this.npccka.keySet());
        this.vypisZoznam("Predmety", this.predmety.keySet());
    }

    private void vypisZoznam(String nadpis, Set<String> polozky) {
        if (!polozky.isEmpty()) {
            System.out.format("%s: ", nadpis);
            for (String nazov : polozky) {
                System.out.format("%s ", nazov);
            }
            System.out.println();
        }
    }

    public Miestnost getMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
    }

    public void postavNpc(Npc npc) {
        this.npccka.put(npc.getNazov(), npc);
    }

    public Npc getNpc(String nazov) {
        return this.npccka.get(nazov);
    }

    public void polozPredmet(Predmet predmet) {
        this.predmety.put(predmet.getNazov(), predmet);
    }
}
