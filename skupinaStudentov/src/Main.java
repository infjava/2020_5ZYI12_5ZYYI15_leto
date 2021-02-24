/**
 * Created by IntelliJ IDEA.
 * User: janik
 * Date: 24. 2. 2021
 * Time: 8:17
 */
public class Main {

    public static void main(String[] args) {
        Student janko = new Student("1001120", "Jan", "Janech");
        Skupina sk = new Skupina("asdf");
        sk.pridajStudenta(janko);
        System.out.println(sk.getStudent("1001120"));
        sk.vypisStudentov();
        sk.odoberStudenta("1001120");
    }
}
