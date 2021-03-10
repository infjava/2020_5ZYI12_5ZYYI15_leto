package sk.uniza.fri.wof.svet;

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

        vchod.postavNpc(new Npc("bufetarka"));

        ic.nastavVychod("zapad", vchod);

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
