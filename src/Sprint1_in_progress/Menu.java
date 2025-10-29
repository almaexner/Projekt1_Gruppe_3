package Sprint1_in_progress;


import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {

        //Variabler
        Scanner keyboard = new Scanner(System.in);
        String userInput;
        String index;
        String dato;

        //Menu udprint
            System.out.println("Velkommen til Harry's Salon");
            System.out.println("Oversigt \n"+
                    "1. Opret ny frisørtid \n"+
                    "2. Slet frisørtid \n"+
                    "3. Lav nyt salg \n"+
                    "4. Tidligere salg");
            userInput=keyboard.nextLine();

            //Brugerens input til at navigere i menuen ved brug af switch
            switch (userInput) {
                case "1":
                    //System.out.println("Vælg dato");
                    Booking.readFile();

                    break;

                case "2":
                    System.out.println("Slet frisørtid");
                    break;
                case "3":
                    System.out.println("Lav nyt salg");
                    Salg s = new Salg();
                    s.nytSalg();
                    break;
                case "4":
                    System.out.println("Tidligere salg");
                    break;
                default:
                    System.out.println("Du har valgt et ugyldigt input.");
            }

    }
}
