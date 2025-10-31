package Sprint1_in_progress;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class  Kalender  {
    // Oprettelse af Gregoriansk kalenderobjekt
    GregorianCalendar uge;
    // Variabler
    int antalDage;
    int day;
    int month;
    String[] fremskrivning;
    // constructor
     public Kalender(int aD) {
         uge = new GregorianCalendar();
         month = uge.get(Calendar.MONTH);       //  Her defineres variablen for den nuværende måned plus 1,
         month = month+1;                           //  da der ellers tælles fra nul
         day = uge.get(Calendar.DAY_OF_MONTH);  //  Her defineres variablen for den nuværende dag i måneden
         uge.getMaximum(Calendar.DAY_OF_MONTH);
         int maxDays = uge.getMaximum(Calendar.DAY_OF_MONTH);   // Her defineres variablen for det maksimale
                                                                // antal dage i netop den måned objektet bliver oprettet
         String dato;
         antalDage = aD;
         fremskrivning = new String[antalDage];
         // Her bliver der udregnet og udskrevet datoer for det angivne antal dage
         for (int i=0; i<antalDage; i++){
             int n = i+1;
             dato = day+"/"+month;
             fremskrivning[i] = dato;
             System.out.println("Tast: "+n+" for at vælge: "+day+"/"+month);
             if (day < maxDays){   // Næste dag i samme måned
                 day = day + 1;
             }
             else {         // Hvis det var den sidste dag i måneden, startes der fra den første i næste måned
                 day=1;
                 if (month < 12){   // Efter den tolvte måned tælles der om fra den første måned
                     month = month+1;
                 }
                 else {
                     month = 1;
                 }
             }
        }
    }
    public String getDato(String dex){
         int index = Integer.parseInt(dex);
         index = index-1;
         return fremskrivning[index];
    }
}
