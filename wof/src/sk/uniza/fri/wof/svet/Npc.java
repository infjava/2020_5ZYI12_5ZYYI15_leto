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
        System.out.println("1) Ako sa mate?");
        System.out.println("2) Dnes je ale krasne pocasie");
        System.out.print("Co chces povedat? ");
        switch (vstup.nextLine()) {
            case "1":
                System.out.println("Joj, ani sa nepytaj, prave ma vykradli");
                System.out.println("1) Utekam chytit zlodeja");
                System.out.println("2) Tak Vam treba");
                System.out.print("Co chces povedat? ");
                switch (vstup.nextLine()) {
                    case "1":
                        System.out.println("Joj, to si krasny, velmi dakujem");
                        break;
                    case "2":
                        System.out.println("Padaj prec");
                        break;
                }
                break;
            case "2":
                System.out.println("Krasne? Ved prsi. Daj si navleky!");
                System.out.println("1) Nemam");
                System.out.println("2) Uz na to idem");
                System.out.print("Co chces povedat? ");
                switch (vstup.nextLine()) {
                    case "1":
                        System.out.println("Tu mas");
                        break;
                    case "2":
                        System.out.println("Super, a teraz padaj prec");
                        break;
                }
                break;
        }
    }
}
