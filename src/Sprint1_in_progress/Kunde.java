package Sprint1_in_progress;

import java.util.Scanner;

public class Kunde {
    // Variabler
    private String navn;
    private int kundenr;
    private int tlf;
    // Constructor
    public Kunde(String navn, int kundenr, int tlf) {
        this.navn = navn;
        this.kundenr = kundenr;
        this.tlf = tlf;
    }
    // get+return
    public String getNavn() {
        return navn;
    }
    public int getKundenr() {
        return kundenr;
    }
    public int getTlf() {
        return tlf;
    }
    // set navn+tlf (Kundenr er en fast værdi, derfor er der ikke tilføjet en set)
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public void setTlf(int tlf) {
        this.tlf = tlf;
    }
    // ToString for pæn udskrift
    @Override
    public String toString() {
        return  "\n"+
                "Navn: " + navn + "\n" +
                "Kundenr: " + kundenr + "\n" +
                "TelefonNr: " + tlf;
    }
    // metode for kundeoprettelse
    public static Kunde opretKunde() {
        Scanner input = new Scanner(System.in);
        System.out.print("Indtast KundeNavn:");
        String navn = input.nextLine();
        System.out.print("Indtast KundeNr:");
        int kundenr = input.nextInt();
        System.out.print("Indtast tlfNr:");
        int tlf = input.nextInt();
        Kunde nyKunde = new Kunde(navn, kundenr, tlf);
        System.out.println("Kunde gemt:" + nyKunde);
        return nyKunde;
    }
}



