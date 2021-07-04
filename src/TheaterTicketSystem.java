import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import food.*;
import movie.*;

public class TheaterTicketSystem implements LocationDate {
    static ArrayList<Theater> theaters = new ArrayList<Theater>();
    static ArrayList<Sale> sales = new ArrayList<Sale>();

    public static void main(String[] args) {
        // TEST DATA
        // newTicketSale DATA
        Calendar testCal = (Calendar)dateTime.clone();
        testCal.set(Calendar.HOUR_OF_DAY, 1);
        testCal.set(Calendar.MINUTE, 1);
        ArrayList<Boolean> testSeats = new ArrayList<Boolean>();
        testSeats.add(true);
        testSeats.add(true);
        testSeats.add(true);
        ArrayList<TimeSeat> testTimeSeats = new ArrayList<TimeSeat>();
        testTimeSeats.add(new TimeSeat("HALL", testCal, testSeats));
        testCal.set(Calendar.HOUR_OF_DAY, 2);
        testCal.set(Calendar.MINUTE, 2);
        testSeats.add(true);
        testTimeSeats.add(new TimeSeat("HALL2", testCal, testSeats));
        ArrayList<Movie> testMovies = new ArrayList<Movie>();
        testMovies.add(new Movie("TITLE", 111, AgeRating.G, testCal, new TicketPrice(1, 2, 3), testTimeSeats));
        Theater testTheater = new Theater("NAME", testMovies);
        theaters.add(testTheater);
        // viewTicketSaleHistory DATA
        ArrayList<Food> testFoods = new ArrayList<Food>();
        testFoods.add(new Water("WATER", 'M', 1));
        ArrayList<Integer> testSeats2 = new ArrayList<Integer>();
        testSeats2.add(1);
        testSeats2.add(2);
        testSeats2.add(3);
        ArrayList<Integer> testFoodQuantity = new ArrayList<Integer>();
        testFoodQuantity.add(1);
        Sale testSale = new Sale("HALL", "MOVIE", 1,
                           2, 3, "CUSTOMERNAME",
                           testCal, testFoods, testSeats2,
                           testFoodQuantity);
        sales.add(testSale);
        // TEST DATA END
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
                          "[3] Quit System%n" +
                          "%n" +
                          "Select option [1-3]: ",
                          location, dateTime, dateTime, dateTime);

        return in.nextInt();
    }

    static void newTicketSale() {
        System.out.printf("printed from newTicketSale%n");

    }

    static void movieSelection() {
        System.out.printf("Now Playing:%n" +
                          "%n");

    }
    static void viewTicketSaleHistory() {
        System.out.printf("printed from viewTicketSaleHistory%n");

        int no = 0;
        for (Sale sale : sales) {
            no++;
            System.out.printf("%n" +
                              "Ticket Sale History%n" +
                              "%n" +
                              "Sale [%d]%n" +
                              "Customer Name: %s%n" +
                              "Movie: %s%n" +
                              "Movie Time: %tR%n" +
                              "Hall: %s%n" +
                              "Ticket: %n" +
                              "- Adult: %d Child: %d Senior: %d%n",
                              no, sale.getCustomerName(), sale.getMovie(),
                              sale.getMovieTime(), sale.getHall(), sale.getAdultTicket(),
                              sale.getChildTicket(), sale.getSeniorTicket());
            System.out.printf("Seats: ");
            for (int i = 0; i < sale.getSeats().size(); i++) { // print seat
                System.out.printf("%d ", sale.getSeats().get(i));
            }
            System.out.printf("%n");
            System.out.printf("Food: %n");
            for (int i = 0; i < sale.getFoods().size(); i++) { // print food with quantity
                System.out.printf("- %s(%s): %d%n", sale.getFoods().get(i).getName(), sale.getFoods().get(i).getSize(), sale.getFoodQuantity().get(i));
            }
        }
    }
}

interface LocationDate {
    String location = "Johor, Malaysia";
    Calendar dateTime = Calendar.getInstance();
}
