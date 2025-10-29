package Sprint1_in_progress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Booking {

    //Variable
    private int bookingNo;
    private String dato;
    static private int noOfBookings = 0;
    private static String navn;   // NY
    private String tlf;
    private String tid;
    ArrayList<String> optagetTider = new ArrayList<>();

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
        String dex = "2";
        String dex2 = "1";
        gennemkigFil(dex,dex2,dato);
        Tidsintervaller t = new Tidsintervaller();
        String tid = userInput.nextLine();
        tid = t.getTid(tid);
        //oprettelse
        Booking b = new Booking(tid, dato, navn, tlf);
        b.bookingFile();
        System.out.println("Booking oprettet: " + dato);
        return b;
    }
    //
    public static String gennemkigFil(String dex1, String dex2, String dexName) throws IOException {
        int indexDato = Integer.parseInt(dex1); // index 2
        int indexTid = Integer.parseInt(dex2);  // index 1
        // hent tidspunkter
        Tidsintervaller tidspunkt = new Tidsintervaller();
        ArrayList<String> ledigeTider = new ArrayList<>(tidspunkt.getAlleTider());
        FileReader bookingFil = new FileReader("booking_fil.txt");
        BufferedReader ind = new BufferedReader(bookingFil);

        String linje = ind.readLine();
        while (linje != null) {
            String[] bidder = linje.split(";");
            // Spring tom linje over (ArrayIndexOutOfBoundsE fejl)
            // Index 2 out of bounds for length 1
            if (bidder.length <= Math.max(indexDato, indexTid)) {
                linje = ind.readLine();
                continue;
            }
            // index2 checker=dato
            String tjekindex = bidder[indexDato].trim();
            if (tjekindex.equals(dexName)) {
                //index2 match=fjern dato
                String tjekindex2 = bidder[indexTid].trim();
                ledigeTider.remove(tjekindex2); //fjerner fra list
            }

            linje = ind.readLine();
        }
        ind.close();
        // ledige tider udskrift
        System.out.println("Ledige tider:");
        int tast = 0;
        for (String tid : ledigeTider) {
            tast = tast+1;
            System.out.println("Tast "+tast+" for at vælge en ledig tid "+tid);
        }

        return "OK";
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

            if (bidder.length >= 5) {//Tjekker at linjen i filen har 5 bidder.
                String navnFraLinje = bidder[0].trim();
                String tlfFraFil = bidder[4].trim();
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
                    "("+bookingNo+");"+tid+";" + dato + ";" + navn + ";" + tlf + "\n");
            System.out.println("Booking er gemt.");
        }
        catch (IOException e){
            System.out.println("Booking kan ikke gemmes.");
            e.printStackTrace();
        }
    }
}