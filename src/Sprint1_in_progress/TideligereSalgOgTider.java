package Sprint1_in_progress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TideligereSalgOgTider {


    public TideligereSalgOgTider() throws IOException {


        Scanner keyboard = new Scanner(System.in);
        while (true) {

            FileReader fil = new FileReader("src/SalonProject/Booking.txt");
            BufferedReader ind = new BufferedReader(fil);
            ArrayList<String> list = new ArrayList<>();
            System.out.println("Søg efter dato");
            String userInput = keyboard.nextLine();

            boolean match = false;
            String matchedLinje = null;
            // Dato og hvor mange penge der er blevet betalt

            String linje = ind.readLine();
            while (linje != null) {
                String[] bidder = linje.split(";");
                if (bidder.length >= 3) { //Tjekker at linjen i filen har 2 bidder.
                    String dato = bidder[1];
                    if (dato.contains(userInput)) { //Sammenligner dato fra Bookingfilen med brugeren input i konsolvinduet.
                        match = true;
                        matchedLinje = linje;
                      //  break; //Vi stopper løkken når vi har fundet dato match.

                    }
                    linje = ind.readLine(); //Den stopper med at læse filen.
                }

            }

            ind.close();


            if (match) {
                System.out.println("Datoen findes " + matchedLinje);
                break;

            } else {
                System.out.println("Datoen er ikke oprettet, prøv igen\n");

                //fortsætter indtil datoen findes
            }
        }

        beløb();
        System.out.println("Den valgte datos salg");

    }

    static void beløb() throws IOException {//Dordi det er et tal
        FileReader fil = new FileReader("src/SalonProject/SalgTest.txt");
        BufferedReader ind = new BufferedReader(fil);
        ArrayList<Integer> list = new ArrayList<>();

        String linje = ind.readLine();
        //while(ind.readLine() != null){
            String[] bidder = linje.split(";");
            String beløb =bidder [1];

            System.out.println(beløb);



        }


    }








