import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

/**
 * 24. 2. 2021 - 8:17
 *
 * @author janik
 */
class StudentTest {

    @Test
    void getOsobneCislo() {
        Student jozo = new Student("345", "Jozef", "Mrkvicka");
        Assertions.assertEquals("345", jozo.getOsobneCislo());
    }

    @Test
    void getMeno() {
        Student jozo = new Student("345", "Jozef", "Mrkvicka");
        Assertions.assertEquals("Jozef", jozo.getMeno());
    }

    @Test
    void getPriezvisko() {
        Student jozo = new Student("345", "Jozef", "Mrkvicka");
        Assertions.assertEquals("Mrkvicka", jozo.getPriezvisko());
    }
}