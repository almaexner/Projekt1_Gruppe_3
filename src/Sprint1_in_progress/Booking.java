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
    private static String navn;   // NY
    private String tlf;
    private String tid;

    public Booking(String tid, String dato, String navn, String tlf) {
        noOfBookings++; //Bookingnr tæller op pr. ny bookning.
        bookingNo = noOfBookings;
        this.tid = tid;
        this.dato = dato;
        this.navn = navn;
        this.tlf = tlf;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public String getDatoen() {
        return dato;
    }

    public String toString() {
        return "Booking nr: " + bookingNo + " Dato: " + dato;
    }
    public static Booking nyBooking(String navn, String tlf) throws IOException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Indtast ønsket dato");
        Kalender k = new Kalender(5);
        String dato = userInput.nextLine();
        dato = k.getDato(dato);
        Tidsintervaller t = new Tidsintervaller();
        String tid = userInput.nextLine();
        tid = t.getTid(tid);

        //oprettelse
        Booking b = new Booking(tid, dato, navn, tlf);
        b.bookingFile();
        System.out.println("Booking oprettet: " + dato);
        return b;
    }
    public static void readFile () throws IOException{ //Metode til at læse fil igennem for at sammenligne brugerens input for tlf.nr for at se om kunden er oprettet eller ej.
        FileReader kundeFil = new FileReader("kunde_fil.txt"); //Her skal fil over registreret kunder indsættes
        BufferedReader ind = new BufferedReader(kundeFil);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Indtast telefonnummer: ");
        String userInput=keyboard.nextLine();
        String tlf = userInput;
        boolean match = false;
        String navnFraFil = null;
        String linje =ind.readLine();

        while (linje!=null) {
            String[] bidder = linje.split(";");

            if (bidder.length >= 4) {//Tjekker at linjen i filen har 3 bidder.
                String navnFraLinje = bidder[0].trim();
                String tlfFraFil = bidder[2].trim();
                if (tlfFraFil.equals(userInput)){
                    navnFraFil = navnFraLinje; //Sammenligner fra kundefil med brugeren input i konsolvinduet.
                    match = true;
                    // matchedLinje = linje;
                    break; //Vi stopper løkken når vi har fundet et match.
                }
            }
            linje=ind.readLine(); //Den stopper med at læse filen.
        }

        ind.close();

        if(match) {
            System.out.println("Kunden er oprettet");
            nyBooking(navnFraFil, tlf);

        } else {
            System.out.println("Kunden er ikke oprettet");
            Kunde k = Kunde.opretKunde();
            k.kundeFil(); //Gem kunde
            nyBooking(k.getNavn(), String.valueOf(k.getTlf()));
        }
    }

    // Metode til at gemme booking-objekt på fil
    public void bookingFile() throws IOException {
        try (FileWriter booking= new FileWriter("booking_fil.txt", true))
        {
            booking.write(
                    "("+bookingNo+");"+"kl. "+tid+";" + dato + ";" + navn + ";" + tlf + "\n");
            System.out.println("Booking er gemt.");
        }
        catch (IOException e){
            System.out.println("Booking kan ikke gemmes.");
            e.printStackTrace();
        }
    }

    /*TestMain
    public static void main(String[] args) throws IOException {
        Booking.readFile();
    }
     */
}