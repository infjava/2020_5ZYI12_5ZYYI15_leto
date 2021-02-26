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

    @Test
    void vypisaniePrazdnejSkupiny() {
        Skupina skupina = new Skupina("111");
        skupina.vypisStudentov();
    }

    @Test
    void vypisanieSkupinySJednymStudentom() {
        Skupina skupina = new Skupina("111");
        skupina.pridajStudenta(new Student("123", "Jozko", "Mrkva"));
        skupina.vypisStudentov();
    }

    @Test
    void odstranenieStudenta() {
        Skupina skupina = new Skupina("123");
        skupina.pridajStudenta(new Student("123", "Jozko", "Mrkva"));
        Assertions.assertNotNull(skupina.getStudent("123"));
        skupina.odoberStudenta("123");
        Assertions.assertNull(skupina.getStudent("123"));
    }
}
