package sk.uniza.fri.wof.svet.predmety;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Navleky implements IPredmet, IKontrolaPolozenia {
    private boolean suObute;

    public Navleky() {
        this.suObute = false;
    }

    @Override
    public String getNazov() {
        return "navleky";
    }

    @Override
    public void pouziSa() {
        if (this.suObute) {
            System.out.println("Vyzul si si navleky");
            this.suObute = false;
        } else {
            System.out.println("Obul si si navleky");
            this.suObute = true;
        }
    }

    @Override
    public void ulozPoziciu(DataOutputStream vystup) throws IOException {
        vystup.writeBoolean(this.suObute);
    }

    @Override
    public void nacitajPoziciu(DataInputStream vstup, int saveVerzia) throws IOException {
        this.suObute = vstup.readBoolean();
    }

    @Override
    public boolean getDaSaPolozit() {
        return !this.suObute;
    }
}
