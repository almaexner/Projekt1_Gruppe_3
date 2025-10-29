package Sprint1_in_progress;

import java.util.Scanner;

public class Tidsintervaller {
    String dato;
    String ledigTid;
    int antalTider = 7;
    String[] timelist = {"10","11","12","13","14","15","16","17"};
    public Tidsintervaller(){
        for (int i=0; i<antalTider; i++){
            int n = i+1;
            ledigTid = timelist[i];
            System.out.println("Tast:"+n+" for at vælge en tid kl. "+ledigTid);
        }
    }

    public static Tidsintervaller getLedigeTider(){

        Tidsintervaller LedigeTider = new Tidsintervaller();
        return LedigeTider;
    }
    public String getTid(String dex){
        int index = Integer.parseInt(dex);
        index = index-1;
        return timelist[index];
    }

    public boolean tjekLedigeTider(){
        Boolean ledig = true;
        return ledig;
    }
}
