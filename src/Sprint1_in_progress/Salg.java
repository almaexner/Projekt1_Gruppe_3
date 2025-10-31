package Sprint1_in_progress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Salg {

    //Salgs variabler.
    private double prisForKlip;
    private double prisForProdukt;
    private double totalPris;
    private LocalDate købsDato;

    //Metode til at lave et nyt salg.
    public void nytSalg() {
        Scanner userInput = new Scanner(System.in);
        købsDato = LocalDate.now(); //laver købet for dagsdato.

        //Tilføjer pris for klipning.
        System.out.println("Indtast pris for klipning: ");

        //Vi laver en do-while løkke for at programmet fortsætter med at køre indtil
        //brugeren har indtastet et beløb som er højere end 0 DKK.
        do {
            prisForKlip = userInput.nextDouble();
            if (prisForKlip <= 0.0){ //Kører hvis brugeren indtaster et tal lavere eller ligmed 0.
                System.out.println("Prisen for en klipning skal være større end 0 DKK.");
            }
        } while (prisForKlip <= 0.0);

        System.out.println("Vil du tilføje produkt til salget? ja/nej: ");
        String brugerSvar = userInput.next().toLowerCase(); //registrerer både store og små bogstaver.
        if (brugerSvar.equals("ja")) {  //if-else statement til at kunne vælge tilkøb af produkter eller ej.
            System.out.println("Indtast pris for produkter: ");
            prisForProdukt = userInput.nextDouble();
        } else { //Hvis brugeren indtaster nej til tilkøb af produkter, bliver prisForProdukt til 0kr.
            prisForProdukt = 0.00;
        }

        totalPris = prisForKlip + prisForProdukt;

        System.out.println("Total pris for salg: " + totalPris + " DKK");

        saveToFile(); //Gemmer salget i salgfil.
        System.out.println("Salget er nu gemt.");
       // userInput.close();
    }

    //Metode til at lave en salgsfil, vi kan gemme nye salg i.
    private void saveToFile() {
        try (FileWriter salg = new FileWriter("Salgs_fil.txt", true)) {
            salg.write("Dato: " + købsDato + ";"+" Beløb " + totalPris + " DKK.\n");
        } catch (IOException e) {
            System.out.println("Salget kan ikke gemmes.");
            e.printStackTrace();
        }
    }

    public static void beløb() throws IOException {//fordi det er et tal

        Scanner keyboard = new Scanner(System.in);
        while (true) {

            FileReader fil = new FileReader("Salgs_fil.txt");
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
                if (bidder.length >= 0) { //Tjekker at linjen i filen har 2 bidder.
                    String dato = bidder[0];
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
                System.out.println("Salget findes " + matchedLinje);
                break;

            } else {
                System.out.println("Datoen er ikke oprettet, prøv igen\n");

                //fortsætter indtil datoen findes
            }
        }
    }
}
    // main til test
    /*public static void main(String[] args) {
        Salg s = new Salg();
        s.nytSalg();
    }*/
