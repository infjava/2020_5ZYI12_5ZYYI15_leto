import java.util.ArrayList;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
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
    private final ArrayList<Vychod> vychody;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.vychody = new ArrayList<>();
    }

    public void nastavVychod(String smer, Miestnost ciel) {
        this.vychody.add(new Vychod(smer, ciel));
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    void vypisInfoOMiestnosti() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        System.out.print("Vychody: ");
        for (Vychod vychod : this.vychody) {
            System.out.format("%s ", vychod.getSmer());
        }
        System.out.println();
    }

    Miestnost getMiestnostVSmere(String smer) {
        for (Vychod vychod : this.vychody) {
            if (vychod.getSmer().equals(smer)) {
                return vychod.getCiel();
            }
        }

        return null;
    }
}