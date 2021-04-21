package sk.uniza.fri.wof.hra.questy;

import java.io.Serializable;

public abstract class Quest implements Serializable {
    private boolean hotovo;

    public Quest() {
        this.hotovo = false;
    }

    public abstract String getNazov();

    public boolean getHotovo() {
        return this.hotovo;
    }

    protected void vyries() {
        this.hotovo = true;
    }
}
