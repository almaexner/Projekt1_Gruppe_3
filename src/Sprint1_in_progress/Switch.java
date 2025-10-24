package Sprint1_in_progress;


import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String userInput="";

            System.out.println("Velkommen til Harry's Salon");
            System.out.println("Oversigt \n"+
                    "1. Opret ny frisørtid \n"+
                    "2. Slet frisørtid \n"+
                    "3. Tidligere salg");
            userInput=keyboard.nextLine();

            switch (userInput) {
                case "1":
                    System.out.println("Opret ny frisørtid");
                    break;
                case "2":
                    System.out.println("Slet frisørtid");
                    break;
                case "3":
                    System.out.println("Tidligere salg");
                    break;
                default:
                    System.out.println("Du har valgt et ugyldigt input.");
            }

    }
}
