package Sprint1_in_progress;


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

}