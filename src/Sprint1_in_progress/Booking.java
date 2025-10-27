package Sprint1_in_progress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Booking {

    //Variable
    private int bookingNo;
    private String dato;
    static private int noOfBookings = 0;

    public Booking(String dato) {
        noOfBookings++; //Bookingnr tæller op pr. ny bookning.
        bookingNo = noOfBookings;
        this.dato = dato;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public String getDato() {
        return dato;
    }

    public String toString() {
        return "Booking nr: " + bookingNo + " Dato: " + dato;
    }
    public static Booking nyBooking() throws IOException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Indtast ønsket dato");
        String dato = userInput.nextLine();

        Booking b = new Booking("");
        System.out.println("Booking oprettet: " + dato);
        b.bookingFile();
        return b;
    }
    public void readFile () throws IOException{ //Metode til at læse fil igennem for at sammenligne brugerens input for tlf.nr for at se om kunden er oprettet eller ej.
        FileReader kundeFil = new FileReader("src//kunde fil.txt"); //Her skal fil over registreret kunder indsættes
        BufferedReader ind = new BufferedReader(kundeFil);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Indtast telefonnummer: ");
        String userInput=keyboard.nextLine();

        boolean match = false;
        String matchedLinje = null;

        String linje =ind.readLine();
        while (linje!=null) {
            String[] bidder = linje.split(";");
            String tlfFraFil = null;
            if (bidder.length >= 3) //Tjekker at linjen i filen har 3 bidder.
                tlfFraFil = bidder[2];
            if (tlfFraFil != null && tlfFraFil.equals(userInput)) { //Sammenligner tlfnr fra kundefil med brugeren input i konsolvinduet.
                match = true;
                matchedLinje = linje;
                break; //Vi stopper løkken når vi har fundet et tlf match.
            }
            linje=ind.readLine(); //Den stopper med at læse filen.
        }

        ind.close();

        if(match) {
            System.out.println("Kunden er oprettet");
            Booking.nyBooking();
            return;

        } else {
            System.out.println("Kunden er ikke oprettet");
            Kunde k=Kunde.opretKunde();
            k.kundeFil();
            Booking.nyBooking();
            return;
        }
    }

    // Metode til at gemme booking-objekt på fil
    public void bookingFile() throws IOException {
        try (FileWriter booking= new FileWriter("booking_fil.txt", true))
        {
            booking.write("\n"+bookingNo+"; "+ dato);
            System.out.println("Booking er gemt.");
        }
            catch (IOException e){
            System.out.println("Booking kan ikke gemmes.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        Booking test = new Booking("");
        test.readFile();
    }
}