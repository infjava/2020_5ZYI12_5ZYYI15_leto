package sk.uniza.fri.wof.svet;

public class Bufetarka implements INpc {
    @Override
    public String getNazov() {
        return "bufetarka";
    }

    @Override
    public void rozhovor() {
        CastRozhovoru uvod = new CastRozhovoru(null, "Ako sa mate?", "Dnes je ale krasne pocasie");
        CastRozhovoru aniSaNepytaj = new CastRozhovoru("Joj, ani sa nepytaj, prave ma vykradli", "Utekam chytit zlodeja", "Tak Vam treba");
        CastRozhovoru siKrasny = new CastRozhovoru("Joj, to si krasny, velmi dakujem");
        CastRozhovoru padajPrec1 = new CastRozhovoru("Padaj prec");
        CastRozhovoru vedPrsi = new CastRozhovoru("Krasne? Ved prsi. Daj si navleky!", "Nemam", "Uz na to idem");
        CastRozhovoru tuMas = new CastRozhovoru("Tu mas");
        CastRozhovoru padajPrec2 = new CastRozhovoru("Super, a teraz padaj prec");

        switch (uvod.vykonaj()) {
            case 1:
                switch (aniSaNepytaj.vykonaj()) {
                    case 1:
                        siKrasny.vykonaj();
                        break;
                    case 2:
                        padajPrec1.vykonaj();
                        break;
                }
                break;
            case 2:
                switch (vedPrsi.vykonaj()) {
                    case 1:
                        tuMas.vykonaj();
                        break;
                    case 2:
                        padajPrec2.vykonaj();
                        break;
                }
                break;
        }
    }
}
