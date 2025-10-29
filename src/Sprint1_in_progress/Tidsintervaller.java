package Sprint1_in_progress;

import java.util.Scanner;


import java.util.ArrayList;
import java.util.Scanner;

public class Tidsintervaller {
    String dato;
    String ledigTid;
    int antalTider = 7;
    String[] timelist = {"10","11","12","13","14","15","16","17","18"};
    public Tidsintervaller(){
        for (int i=0; i<antalTider; i++){
            int n = i+1;
            ledigTid = timelist[i];
            // System.out.println("Tast:"+n+" for at vælge en tid kl. "+ledigTid);
        }
    }

    public ArrayList<String> getAlleTider(){
        ArrayList<String> alle = new ArrayList<>();
        int tast = 1;
        for (String t : timelist){
            // System.out.println("Tast: "+tast+" for at vælge en ledig tid kl." + t + ":00");
            alle.add("kl." + t + ":00");
            tast = tast+1;
        }
        return alle;
    }

    public static Tidsintervaller getLedigeTider(){
        Tidsintervaller LedigeTider = new Tidsintervaller();
        return LedigeTider;
    }
    public String getTid(String dex){
        int index = Integer.parseInt(dex);
        index = index-1;
        return getAlleTider().get(index);
    }


    public boolean tjekLedigeTider(){
        Boolean ledig = true;
        return ledig;
    }
}



