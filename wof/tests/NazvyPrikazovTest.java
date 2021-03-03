import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author janik
 */
public class NazvyPrikazovTest {

    private NazvyPrikazov nazvyPri1;

    @BeforeEach
    public void setUp() {
        this.nazvyPri1 = new NazvyPrikazov();
    }

    @Test
    public void jePrikaz() {
        Assertions.assertTrue(this.nazvyPri1.jePrikaz("chod"));
        Assertions.assertTrue(this.nazvyPri1.jePrikaz("ukonci"));
        Assertions.assertTrue(this.nazvyPri1.jePrikaz("pomoc"));
        Assertions.assertFalse(this.nazvyPri1.jePrikaz("ukaz"));
    }
}
