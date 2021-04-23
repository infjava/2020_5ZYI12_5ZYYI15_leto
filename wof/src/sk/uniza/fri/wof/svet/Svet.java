package sk.uniza.fri.wof.svet;

import sk.uniza.fri.wof.hra.questy.QuestKniha;
import sk.uniza.fri.wof.hra.questy.QuestUtekajDoLabaku;
import sk.uniza.fri.wof.svet.npc.CastRozhovoru;
import sk.uniza.fri.wof.svet.npc.NpcSQuestami;
import sk.uniza.fri.wof.svet.npc.NpcSRozhovorom;
import sk.uniza.fri.wof.svet.npc.Obchodnik;
import sk.uniza.fri.wof.svet.npc.ReplikaHraca;
import sk.uniza.fri.wof.svet.predmety.Granat;
import sk.uniza.fri.wof.svet.predmety.IPredmet;
import sk.uniza.fri.wof.svet.predmety.Navleky;
import sk.uniza.fri.wof.svet.predmety.Predmet;

import java.util.HashMap;

public class Svet {
    private final Miestnost startovaciaMiestnost;
    private final HashMap<String, Miestnost> miestnosti;

    public Svet() {
        this.miestnosti = new HashMap<String, Miestnost>();

        Miestnost ra13 = this.newMiestnost("RA013", "laboratorium plne pocitacov");
        Miestnost chodbaA = this.newMiestnost("Chodba A", "dlhocizna chodba v budove A");
        Miestnost jedalen = this.newMiestnost("Jedalen", "hmmm... tu to krasne vonia...");
        Miestnost chodbaC = this.newMiestnost("Chodba C", "temna chodba v podzemi");
        Miestnost vchod = this.newMiestnost("Vchod", "pani vratnicka kazdemu mera teplotu");
        Miestnost ic = this.newMiestnost("IC", "vidis plno mudrych knih");
        Miestnost ciscoLaboratorium = this.newMiestnost("Cisco laboratorium", "pocuvas a nic nepocujes - huciace switche vsetko prehlusia");
        Miestnost chodbaB = this.newMiestnost("Chodba B", "tmava chodba so svetlou chill zonou");
        Miestnost skusobnaMiestnost = this.newMiestnost("Skusobna miestnost", "tu ta caka skuska ohnom - teda prakticka skuska z Informatiky");
        Miestnost skrina = this.newMiestnost("Skrina", "je tu trochu tesno; ale citis prievan");
        Miestnost narnia = this.newMiestnost("Narnia", "si sa mal teplejsie obliect; asi zabudli vypnut klimatizaciu");

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
        CastRozhovoru uvodUpratovacky = new CastRozhovoru(
                null,
                new ReplikaHraca("Ako sa mate?", aniSaNepytaj),
                new ReplikaHraca("Dnes je ale krasne pocasie", vedPrsi)
        );

        vchod.polozPredmet(this.newPredmet("granat"));

        vchod.postavNpc(new NpcSRozhovorom("upratovacka", uvodUpratovacky));

        vchod.postavNpc(new Obchodnik("bufetarka", this.newPredmet("navleky")));

        vchod.polozPredmet(this.newPredmet("pocitac"));

        vchod.postavNpc(new NpcSQuestami("rektor", new QuestUtekajDoLabaku()));

        ic.nastavVychod("zapad", vchod);

        ic.postavNpc(new NpcSQuestami("knihovnicka", new QuestKniha()));

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

    public IPredmet newPredmet(String nazov) {
        switch (nazov) {
            case "navleky":
                return new Navleky();
            case "granat":
                return new Granat();
            default:
                return new Predmet(nazov);
        }
    }

    private Miestnost newMiestnost(String nazov, String popis) {
        Miestnost miestnost = new Miestnost(nazov, popis);
        this.miestnosti.put(nazov, miestnost);
        return miestnost;
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }

    public Miestnost getMiestnost(String nazov) {
        return this.miestnosti.get(nazov);
    }
}
