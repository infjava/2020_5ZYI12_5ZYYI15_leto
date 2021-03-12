package sk.uniza.fri.wof.svet;

import java.util.Scanner;

public class Npc {
    private final String nazov;

    public Npc(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void rozhovor() {
        Scanner vstup = new Scanner(System.in);
        switch (this.nazov) {
            case "bufetarka":
                CastRozhovoru uvod = new CastRozhovoru(null, "Ako sa mate?", "Dnes je ale krasne pocasie");
                switch (uvod.vykonaj()) {
                    case 1:
                        CastRozhovoru aniSaNepytaj = new CastRozhovoru("Joj, ani sa nepytaj, prave ma vykradli", "Utekam chytit zlodeja", "Tak Vam treba");
                        switch (aniSaNepytaj.vykonaj()) {
                            case 1:
                                CastRozhovoru siKrasny = new CastRozhovoru("Joj, to si krasny, velmi dakujem");
                                siKrasny.vykonaj();
                                break;
                            case 2:
                                CastRozhovoru padajPrec = new CastRozhovoru("Padaj prec");
                                padajPrec.vykonaj();
                                break;
                        }
                        break;
                    case 2:
                        CastRozhovoru vedPrsi = new CastRozhovoru("Krasne? Ved prsi. Daj si navleky!", "Nemam", "Uz na to idem");
                        switch (vedPrsi.vykonaj()) {
                            case 1:
                                CastRozhovoru tuMas = new CastRozhovoru("Tu mas");
                                tuMas.vykonaj();
                                break;
                            case 2:
                                CastRozhovoru padajPrec = new CastRozhovoru("Super, a teraz padaj prec");
                                padajPrec.vykonaj();
                                break;
                        }
                        break;
                }
                break;
            case "knihovnicka":
                System.out.println("Knihovnicka sa s tebou nechce rozpravat");
                break;
        }
    }
}
