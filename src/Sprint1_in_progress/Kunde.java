package Sprint1_in_progress;


import java.io.FileWriter;
import java.io.IOException;

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

// ToString m. @Override skal tilføjes (Ikke nødvendigt, men gør udskriften pæn)

//1.1.1 Metode til at gemme oprettert kunde objekt på fil

    public void saveToFile(String kunde) throws IOException {
        try (FileWriter fil = new FileWriter("kunde fil.txt")) {
            fil.write(navn+";" + kundenr+";" + tlf);
        System.out.println("Kunde er gemt i fil.");} catch (IOException e) {
            System.out.println("Kunde kan ikke gemmes.");
        }
    }

}