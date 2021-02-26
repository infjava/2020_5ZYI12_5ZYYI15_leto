import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

/**
 * 24. 2. 2021 - 8:17
 *
 * @author janik
 */
class StudentTest {

    private Student jozo;

    @BeforeEach
    void setUp() {
        this.jozo = new Student("345", "Jozef", "Mrkvicka");
    }

    @Test
    void getOsobneCislo() {
        Assertions.assertEquals("345", this.jozo.getOsobneCislo());
    }

    @Test
    void getMeno() {
        Assertions.assertEquals("Jozef", this.jozo.getMeno());
    }

    @Test
    void getPriezvisko() {
        Assertions.assertEquals("Mrkvicka", this.jozo.getPriezvisko());
    }
}