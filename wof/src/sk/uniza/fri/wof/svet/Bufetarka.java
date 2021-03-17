package sk.uniza.fri.wof.svet;

public class Bufetarka implements INpc {
    @Override
    public String getNazov() {
        return "bufetarka";
    }

    @Override
    public void rozhovor() {
        CastRozhovoru siKrasny = new CastRozhovoru("Joj, to si krasny, velmi dakujem");
        CastRozhovoru padajPrec1 = new CastRozhovoru("Padaj prec");
        CastRozhovoru aniSaNepytaj = new CastRozhovoru(
            "Joj, ani sa nepytaj, prave ma vykradli",
            new ReplikaHraca("Utekam chytit zlodeja", siKrasny),
            new ReplikaHraca("Tak Vam treba", padajPrec1)
        );
        CastRozhovoru tuMas = new CastRozhovoru("Tu mas");
        CastRozhovoru padajPrec2 = new CastRozhovoru("Super, a teraz padaj prec");
        CastRozhovoru vedPrsi = new CastRozhovoru(
            "Krasne? Ved prsi. Daj si navleky!",
            new ReplikaHraca("Nemam", tuMas),
            new ReplikaHraca("Uz na to idem", padajPrec2)
        );
        CastRozhovoru uvod = new CastRozhovoru(
            null,
            new ReplikaHraca("Ako sa mate?", aniSaNepytaj),
            new ReplikaHraca("Dnes je ale krasne pocasie", vedPrsi)
        );

        CastRozhovoru aktualna = uvod;
        do {
            aktualna = aktualna.vykonaj();
        } while (aktualna != null);
    }
}
