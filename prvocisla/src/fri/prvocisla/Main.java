package fri.prvocisla;

public class Main {

    public static void main(String[] args) {
        Prvocisla p = new Prvocisla(100000000);
        for (Integer cislo : p) {
            System.out.println(cislo);
        }
    }
}
