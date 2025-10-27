package Sprint1_in_progress;

import java.io.FileWriter;
import java.io.IOException;

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

    public void bookingFile (String dato, int getBookingNo, String getDato) throws IOException {
        try (FileWriter booking= new FileWriter("booking fil.txt")){
            booking.write(bookingNo+"; "+ dato);
            System.out.println("Booking er gemt.");} catch (IOException e){
            System.out.println("Booking kan ikke gemmes.");
        }
    }
}