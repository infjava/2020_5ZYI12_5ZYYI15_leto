package sk.uniza.fri.wof.svet;

public class Bufetarka implements INpc {
    @Override
    public String getNazov() {
        return "bufetarka";
    }

    @Override
    public void rozhovor() {
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
    }
}
