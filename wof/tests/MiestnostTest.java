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
        Assertions.assertNull(this.nemaVychody.vychodnyVychod);
        Assertions.assertNull(this.nemaVychody.zapadnyVychod);
        Assertions.assertNull(this.nemaVychody.severnyVychod);
        Assertions.assertNull(this.nemaVychody.juznyVychod);
    }

    @Test
    public void sever() {
        Assertions.assertEquals("sever", this.sever.getPopis());
        Assertions.assertSame(this.vychod, this.sever.vychodnyVychod);
        Assertions.assertSame(this.zapad, this.sever.zapadnyVychod);
        Assertions.assertNull(this.sever.severnyVychod);
        Assertions.assertSame(this.juh, this.sever.juznyVychod);
    }

    @Test
    public void juh() {
        Assertions.assertEquals("juh", this.juh.getPopis());
        Assertions.assertSame(this.vychod, this.juh.vychodnyVychod);
        Assertions.assertSame(this.zapad, this.juh.zapadnyVychod);
        Assertions.assertSame(this.sever, this.juh.severnyVychod);
        Assertions.assertNull(this.juh.juznyVychod);
    }
}
