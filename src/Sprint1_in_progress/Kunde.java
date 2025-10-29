package Sprint1_in_progress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kunde {

    /*Main for testing purposes
    public static void main(String[] args) throws Exception{
        Kunde k = new Kunde("Mikkel", 2, 2);
        k.kundeFil("navn");
    } */

    // Variabler
    private String navn;
    private int kundenr;
    private int tlf;
    private String kreditkunde;
    double beløb;

    // Constructor
    public Kunde(String navn, int kundenr, int tlf, String kreditkunde) {
        this.navn = navn;
        this.kundenr = kundenr;
        this.tlf = tlf;
        this.kreditkunde= kreditkunde;
        this.beløb=beløb;
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
        System.out.print("Indtast kredit: ");
        String kreditkunde="0";
        Kunde nyKunde = new Kunde(navn, kundenr, tlf, kreditkunde);
        System.out.println("Kunde gemt:" + nyKunde);
        return nyKunde;
    }

    // Metode til at gemme oprettert kunde objekt på fil
    public void kundeFil() throws IOException {
        try (FileWriter kunde = new FileWriter("kunde_fil.txt", true))
            {
            kunde.write("\n" +navn+"; " + kundenr+"; " + tlf +"; "+ "0");
            System.out.println("Kunde er gemt i fil.");
            }
            catch (IOException e) {
            System.out.println("Kunde kan ikke gemmes.");
            e.printStackTrace();
        }
    }

    // når man tjekker index 3 skal man se om kunde har kredit eller nej og hvor meget
   //hvis kunde har kredit lav metode til at ændre kredit

    public void kreditKunde() throws IOException {
        FileReader kunde_fil = new FileReader("src//kunde_fil.txt");
        BufferedReader ind = new BufferedReader(kunde_fil);
        String linje = ind.readLine();
        while (linje!=null){
            String [] bidder= linje.split(";");
            Kunde k= Kunde.opretKunde();
            k.kreditkunde=bidder[3];
            linje=ind.readLine();
        }
        ind.close();

        kreditkunde=kreditkunde+beløb;
        System.out.println("Kunde " +navn +" har "+ kreditkunde +" kredit.");
    }

}