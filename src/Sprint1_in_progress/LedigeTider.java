package Sprint1_in_progress;

import java.util.Random;
import java.util.Scanner;

public class LedigeTider {
        public static void main(String[] args) {
            System.out.println("  ");



            Scanner Scan = new Scanner(System.in);
            Random tal = new Random();
            Scanner keybord = new Scanner(System.in);

            System.out.println("Indtast Ønskede Dato");
            int dato = Scan.nextInt();

            System.out.println("Ledige Tider på ønsket dato");

            int[] timelist = {10, 11, 12, 13, 14, 15,16,17,18};

            for (int i = 0; i < timelist.length; i++) {
                System.out.println( "" + timelist[i]);


            }


        }
    }



