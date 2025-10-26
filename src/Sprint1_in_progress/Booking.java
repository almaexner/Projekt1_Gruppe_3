package Sprint1_in_progress;

public class Booking {

    private int bookingNo;
    private String dato;
    static private int noOfBookings = 0;

    public Booking(String dato) {
        noOfBookings++;
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
}