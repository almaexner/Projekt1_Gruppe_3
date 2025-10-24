package Sprint1_in_progress;

import java.util.Date;

public class Kalender {
    // Variabler
    Date idag;

    // constructor
    public Kalender(){
        idag = new Date();
    }

    public static void main(String[] args) {
        Kalender test = new Kalender();
        System.out.println(test);
    }
}
