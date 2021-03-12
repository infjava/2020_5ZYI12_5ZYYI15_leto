package sk.uniza.fri.wof.svet;

import java.util.HashMap;
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
    private final HashMap<String, INpc> npccka;

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
        System.out.print("Vychody: ");
        for (String smer : this.vychody.keySet()) {
            System.out.format("%s ", smer);
        }
        System.out.println();
        if (!this.npccka.isEmpty()) {
            System.out.print("NPC: ");
            for (String nazov : this.npccka.keySet()) {
                System.out.format("%s ", nazov);
            }
            System.out.println();
        }
    }

    public Miestnost getMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
    }

    public void postavNpc(INpc npc) {
        this.npccka.put(npc.getNazov(), npc);
    }

    public INpc getNpc(String nazov) {
        return this.npccka.get(nazov);
    }
}
