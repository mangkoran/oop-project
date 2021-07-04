import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class TheatreTicketSystem implements LocationDate {
    static ArrayList<Theatre> theatres = new ArrayList<Theatre>();
    static ArrayList<Sale> sales = new ArrayList<Sale>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean continueSession = true;

        while (continueSession == true) {
            int choice = mainMenu(in);
            switch (choice) {
                case 1:
                    newTicketSale();
                    break;
                case 2:
                    viewTicketSaleHistory();
                    break;
                case 3:
                    continueSession = false;
                    System.out.printf("%n" +
                                      "Quitting system...%n");
                    break;
                default:
                    System.out.printf("%n" +
                                      "Error! Please enter option correctly!%n");
                    break;
            }
        }
        in.close();
    }

    static int mainMenu(Scanner in) {
        System.out.printf("%n" +
                          "Welcome to MoistCinema!%n" +
                          "%n" +
                          "Location: %s%n" +
                          "Date: %tA %tD Time: %tT%n" +
                          "%n" +
                          "Main Menu%n" +
                          "[1] New Ticket Sale%n" +
                          "[2] View Ticket Sale History%n" +
                          "%n" +
                          "Select option [1-2]: ",
                          location, dateTime, dateTime, dateTime);
        int choice = in.nextInt();

        return choice;
    }

    static void newTicketSale() {
        System.out.printf("printed from newTicketSale%n");
    }

    static void viewTicketSaleHistory() {
        }

        System.out.printf("printed from viewTicketSaleHistory%n");

    }
}

interface LocationDate {
    String location = "Johor, Malaysia";
    Calendar dateTime = Calendar.getInstance();
}
