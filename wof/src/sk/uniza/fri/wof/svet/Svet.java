package sk.uniza.fri.wof.svet;

import sk.uniza.fri.wof.svet.npc.CastRozhovoru;
import sk.uniza.fri.wof.svet.npc.NpcSRozhovorom;
import sk.uniza.fri.wof.svet.npc.ReplikaHraca;
import sk.uniza.fri.wof.svet.predmety.Navleky;
import sk.uniza.fri.wof.svet.predmety.Predmet;

public class Svet {
    private final Miestnost startovaciaMiestnost;

    public Svet() {
        Miestnost ra13 = new Miestnost("RA013 - laboratorium plne pocitacov");
        Miestnost chodbaA = new Miestnost("Chodba A - dlhocizna chodba v budove A");
        Miestnost jedalen = new Miestnost("Jedalen - hmmm... tu to krasne vonia...");
        Miestnost chodbaC = new Miestnost("Chodba C - temna chodba v podzemi");
        Miestnost vchod = new Miestnost("Vchod - pani vratnicka kazdemu mera teplotu");
        Miestnost ic = new Miestnost("IC - vidis plno mudrych knih");
        Miestnost ciscoLaboratorium = new Miestnost("Cisco laboratorium - pocuvas a nic nepocujes - huciace switche vsetko prehlusia");
        Miestnost chodbaB = new Miestnost("Chodba B - tmava chodba so svetlou chill zonou");
        Miestnost skusobnaMiestnost = new Miestnost("Skusobna miestnost - tu ta caka skuska ohnom - teda prakticka skuska z Informatiky");
        Miestnost skrina = new Miestnost("Skrina - je tu trochu tesno; ale citis prievan");
        Miestnost narnia = new Miestnost("Narnia - si sa mal teplejsie obliect; asi zabudli vypnut klimatizaciu");

        ra13.nastavVychod("juh", chodbaA);

        chodbaA.nastavVychod("dole", chodbaC);
        chodbaA.nastavVychod("sever", ra13);
        chodbaA.nastavVychod("juh", vchod);

        jedalen.nastavVychod("vychod", chodbaC);

        chodbaC.nastavVychod("zapad", jedalen);
        chodbaC.nastavVychod("hore", chodbaA);

        vchod.nastavVychod("sever", chodbaA);
        vchod.nastavVychod("vychod", ic);
        vchod.nastavVychod("juh", chodbaB);

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
        CastRozhovoru uvodBufetarky = new CastRozhovoru(
                null,
                new ReplikaHraca("Ako sa mate?", aniSaNepytaj),
                new ReplikaHraca("Dnes je ale krasne pocasie", vedPrsi)
        );

        vchod.postavNpc(new NpcSRozhovorom("bufetarka", uvodBufetarky));

        vchod.polozPredmet(new Predmet("pocitac"));
        vchod.polozPredmet(new Navleky());

        ic.nastavVychod("zapad", vchod);

        CastRozhovoru nicNehovori = new CastRozhovoru(
                "Knihovnicka dalej mlci"
        );
        CastRozhovoru uvodKnihovnicky = new CastRozhovoru(
                "Knihovnicka sa s tebou nechce rozpravat",
                new ReplikaHraca("A preco?", nicNehovori)
        );

        ic.postavNpc(new NpcSRozhovorom("knihovnicka", uvodKnihovnicky));

        ciscoLaboratorium.nastavVychod("dole", chodbaB);

        chodbaB.nastavVychod("hore", ciscoLaboratorium);
        chodbaB.nastavVychod("sever", vchod);
        chodbaB.nastavVychod("vychod", skusobnaMiestnost);

        skusobnaMiestnost.nastavVychod("zapad", chodbaB);
        skusobnaMiestnost.nastavVychod("skrina", skrina);

        skrina.nastavVychod("von", skusobnaMiestnost);
        skrina.nastavVychod("narnia", narnia);

        narnia.nastavVychod("skrina", skrina);

        this.startovaciaMiestnost = vchod;
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
