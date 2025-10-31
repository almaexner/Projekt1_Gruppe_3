package Sprint1_in_progress;//package Sprint1_in_progress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Kunde {

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
            kunde.write("\n" +navn+";" + kundenr+";" + tlf +";"+ "0");
            System.out.println("Kunde er gemt i fil.");
            }
            catch (IOException e) {
            System.out.println("Kunde kan ikke gemmes.");
            e.printStackTrace();
        }
    }

    // når man tjekker index 3 skal man se om kunde har kredit eller nej og hvor meget
   //hvis kunde har kredit lav metode til at ændre kredit
    // scan tlf nr for at finde kunde og deres kredit

    // når man tjekker index 3 skal man se om kunde har kredit eller nej og hvor meget
//hvis kunde har kredit lav metode til at ændre kredit
    // scan tlf nr for at finde kunde og deres kredit


    public static void nyKredit() throws IOException{
        // Opretning af objekter der skal bruges
        System.out.println("Indtast tlfnr.");
        ArrayList<String> kunder = new ArrayList<>();
        FileReader KundeFil = new FileReader("Kunde_fil.txt");
        BufferedReader ind = new BufferedReader(KundeFil);
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine();
        String linje = ind.readLine();
        while(linje!=null){     // læser filen igennem, og tilføjer hver linje i en ArrayList
            kunder.add(linje);
            linje=ind.readLine();

        }
        int size = kunder.size(); // Køres så mange gange som der er pladser i listen
        FileWriter nyKundeFil = new FileWriter("kunde_fil.txt", false);
        for (int i=0; i<size; i++){
            // finder linjen for det angivne tlfnummer, og fjerner den linje fra listen
            linje = kunder.get(i);
            String[] bidder = linje.split(";");
            String tjektlf = bidder[2].trim();
            //String kredit = bidder[3];
            if (tjektlf.equals(userInput)){
                System.out.println("Kunden med dette telefonnummer "+tjektlf+" har "+bidder[3].trim()+" kredit");
                System.out.println("Indtast kreditbeløb der skal ændres: ");
                Scanner beløbscanner=new Scanner(System.in);
                double beløb=beløbscanner.nextDouble();
                double kreditValue = Double.parseDouble(bidder[3]);
                double kValue = beløb+kreditValue;
                String nyKredit = bidder[0]+";"+bidder[1]+";"+bidder[2]+";"+kValue;
                kunder.remove(i);
                kunder.add(nyKredit);
                break;
            }
        }
        size = kunder.size();

        try{
            nyKundeFil.write("");
        }
        catch (IOException e) {
            System.out.println("error"); // sletter alt på filen
            e.printStackTrace();
        }
        for(int t=0; t<size; t++){
            try (FileWriter nyBookingFil2= new FileWriter("Kunde_fil.txt", true)) //
            {   // skriver de resterende linjer fra listen tilbage i filen
                linje = kunder.get(t);
                nyBookingFil2.write(linje+"\n");
            }
            catch (IOException e){
                System.out.println("Error");
                e.printStackTrace();
            }

        }

    }

}