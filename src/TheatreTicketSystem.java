import java.util.ArrayList;
import java.util.Scanner;

public class TheatreTicketSystem {
    static ArrayList<Theatre> theatres;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continueSession = true;

        while (continueSession == true) {
            int choice = mainMenu(in);
            switch (choice) {
                case 1:
                    newTicketPurchase();
                    break;
                case 2:
                    viewTicketPurchaseHistory();
                    break;
                case 3:
                    continueSession = false;
                    System.out.printf(
                                      "%n" +
                                      "Quitting system...%n");
                    break;
                default:
                    System.out.printf(
                                      "%n" +
                                      "Error! Please enter option correctly!%n");
                    break;
            }
        }
        in.close();
    }

    static int mainMenu(Scanner in) {
        System.out.printf(
                          "%n" +
                          "Welcome to MoistCinema!%n" +
                          "%n" +
                          "Location: %s%n" +
                          "Date: %s%n" +
                          "%n" +
                          "Main Menu%n" +
                          "[1] New Ticket Sale%n" +
                          "[2] View Ticket Sale History%n" +
                          "%n" +
                          "Select option [1-2]: ",
                          "TEST", "TEST");
        int choice = in.nextInt();

        return choice;
    }

    static void newTicketPurchase() {
        System.out.printf("printed from newTicketPurchase%n");
    }

    static void viewTicketPurchaseHistory() {
        System.out.printf("printed from viewTicketPurchaseHistory%n");

    }
}
