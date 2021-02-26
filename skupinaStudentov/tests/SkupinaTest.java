import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 24. 2. 2021 - 8:17
 *
 * @author janik
 */
public class SkupinaTest {
    @Test
    void pridanieJednehoStudenta() {
        Student jozo = new Student("345", "Jozef", "Mrkvicka");
        Skupina skupina = new Skupina("111");
        skupina.pridajStudenta(jozo);
        Assertions.assertEquals(1, skupina.getPocetStudentov());
        Student najdeny = skupina.getStudent("345");
        Assertions.assertNotNull(najdeny);
        Assertions.assertSame(jozo, najdeny);
    }
}
