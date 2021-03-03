import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author janik
 */
public class MiestnostTest {

    private Miestnost nemaVychody;
    private Miestnost zapad;
    private Miestnost vychod;
    private Miestnost sever;
    private Miestnost juh;

    @BeforeEach
    public void setUp() {
        this.nemaVychody = new Miestnost("nema vychody");
        this.nemaVychody.nastavVychody(null, null, null, null);
        this.zapad = new Miestnost("zapad");
        this.vychod = new Miestnost("vychod");
        this.sever = new Miestnost("sever");
        this.juh = new Miestnost("juh");
        this.zapad.nastavVychody(this.sever, this.vychod, this.juh, null);
        this.vychod.nastavVychody(this.sever, null, this.juh, this.zapad);
        this.sever.nastavVychody(null, this.vychod, this.juh, this.zapad);
        this.juh.nastavVychody(this.sever, this.vychod, null, this.zapad);
    }

    @Test
    public void nemaVychody() {
        Assertions.assertEquals("nema vychody", this.nemaVychody.getPopis());
        Assertions.assertNull(this.nemaVychody.getMiestnostVSmere("vychod"));
        Assertions.assertNull(this.nemaVychody.getMiestnostVSmere("zapad"));
        Assertions.assertNull(this.nemaVychody.getMiestnostVSmere("sever"));
        Assertions.assertNull(this.nemaVychody.getMiestnostVSmere("juh"));
    }

    @Test
    public void sever() {
        Assertions.assertEquals("sever", this.sever.getPopis());
        Assertions.assertSame(this.vychod, this.sever.getMiestnostVSmere("vychod"));
        Assertions.assertSame(this.zapad, this.sever.getMiestnostVSmere("zapad"));
        Assertions.assertNull(this.sever.getMiestnostVSmere("sever"));
        Assertions.assertSame(this.juh, this.sever.getMiestnostVSmere("juh"));
    }

    @Test
    public void juh() {
        Assertions.assertEquals("juh", this.juh.getPopis());
        Assertions.assertSame(this.vychod, this.juh.getMiestnostVSmere("vychod"));
        Assertions.assertSame(this.zapad, this.juh.getMiestnostVSmere("zapad"));
        Assertions.assertSame(this.sever, this.juh.getMiestnostVSmere("sever"));
        Assertions.assertNull(this.juh.getMiestnostVSmere("juh"));
    }
}
