import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import food.*;
import movie.*;

public class TheaterTicketSystem implements LocationDate {
    static ArrayList<Theater> theaters = new ArrayList<Theater>();
    static ArrayList<Food> foods = new ArrayList<Food>();
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
        Calendar testCal2 = (Calendar)testCal.clone();
        testCal2.set(Calendar.HOUR_OF_DAY, 2);
        testCal2.set(Calendar.MINUTE, 2);
        ArrayList<Boolean> testSeats2 = new ArrayList<Boolean>();
        testSeats2.add(true);
        testTimeSeats.add(new TimeSeat("HALL2", testCal2, testSeats2));
        ArrayList<Movie> testMovies = new ArrayList<Movie>();
        testMovies.add(new Movie("TITLE", 111, AgeRating.G,
                                 testCal, new TicketPrice(1, 2, 3), testTimeSeats));
        Theater testTheater = new Theater("NAME", testMovies);
        theaters.add(testTheater);
        foods.add(new Water("WATER", 'M', 1));
        // viewTicketSaleHistory DATA
        ArrayList<Integer> testTickets = new ArrayList<Integer>();
        testTickets.add(1);
        testTickets.add(2);
        testTickets.add(3);
        ArrayList<Integer> testSelectedSeats = new ArrayList<Integer>();
        testSelectedSeats.add(1);
        testSelectedSeats.add(2);
        testSelectedSeats.add(3);
        ArrayList<Integer> testFoodQuantity = new ArrayList<Integer>();
        testFoodQuantity.add(1);
        Sale testSale = new Sale("HALL", "MOVIE", "CUSTOMERNAME",
                                 testCal, foods, testSelectedSeats,
                                 testTickets, testFoodQuantity);
        sales.add(testSale);
        // TEST DATA END
        Scanner in = new Scanner(System.in);
        boolean continueSession = true;

        while (continueSession == true) {
            int choice = mainMenu(in);
            switch (choice) {
                case 1:
                    newTicketSale(in);
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

    static void newTicketSale(Scanner in) {
        Movie movieTemp = movieSelection(in);
        Boolean loop = true;
        TimeSeat timeSeatTemp = timeSelection(in, movieTemp);
        while (loop) {
            for (Boolean seat : timeSeatTemp.getSeats()) {
                if (seat) {
                    loop = false;
                    break;
                }
            }
            if (loop) {
                timeSeatTemp = timeSelection(in, movieTemp);
            }
        }
        ArrayList<Integer> ticketsTemp = ticketSelection(in, movieTemp, timeSeatTemp);
        loop = true;
        int ticketTotalTemp = 0;
        while (loop) {
            ticketTotalTemp = 0;
            for (Integer i : ticketsTemp) {
                ticketTotalTemp += i;
            }
            int availableSeat = 0;
            for (Boolean seat : timeSeatTemp.getSeats()) {
                if (seat) {
                    availableSeat++;
                }
            }
            if (ticketTotalTemp > availableSeat) {
                System.out.printf("%n");
            }
        }
        ArrayList<Integer> seatsTemp = seatSelection(in, timeSeatTemp, ticketTotalTemp);
        ArrayList<Food> foodsTemp = new ArrayList<Food>();
        ArrayList<Integer> foodQuantityTemp = new ArrayList<Integer>();
        foodSelection(in, foodsTemp, foodQuantityTemp);
        sales.add(new Sale(timeSeatTemp.getHall(), movieTemp.getTitle(), "CUSTOMERNAME",
                                 timeSeatTemp.getTime(), foodsTemp, seatsTemp,
                                 ticketsTemp, foodQuantityTemp));
    }

    static Movie movieSelection(Scanner in) {
        int no = 0;
        ArrayList<Movie> moviesTemp = new ArrayList<Movie>();
        System.out.printf("%n");
        System.out.printf("Now playing:%n");
        for (Theater theater : theaters) {
            for (Movie movie : theater.getMovies()) {
                no++;
                moviesTemp.add(movie);
                System.out.printf("[%d]: %s%n", no, movie.getTitle());
            }
        }
        System.out.printf("%n");
        System.out.printf("Select movie [1-%d]: ", no);

        return moviesTemp.get(in.nextInt() - 1);
    }

    static TimeSeat timeSelection(Scanner in, Movie movie) {
        int no = 0;
        System.out.printf("%n");
        System.out.printf("Available time:%n");
        for (TimeSeat timeSeat : movie.getTimeSeats()) {
            no++;
            int availableSeat = 0;
            for (Boolean seat : timeSeat.getSeats()) {
                if (seat) {
                    availableSeat++;
                }
            }
            if (availableSeat == 0) {
                System.out.printf("[%d] SOLD OUT%n", no);
            } else {
                System.out.printf("[%d] %tR (Available: %d)%n", no, timeSeat.getTime(), availableSeat);
            }
        }
        System.out.printf("%n");
        System.out.printf("Select time [1-%d]: ", no);

        return movie.getTimeSeats().get(in.nextInt() - 1);
    }

    static ArrayList<Integer> ticketSelection(Scanner in, Movie movie, TimeSeat timeSeat) {
        ArrayList<Integer> ticketsTemp = new ArrayList<Integer>();
        System.out.printf("%n");
        System.out.printf("Select ticket:%n");
        System.out.printf("Adult %d: ", movie.getTicketPrice().getAdult());
        ticketsTemp.add(in.nextInt());
        System.out.printf("Child %d: ", movie.getTicketPrice().getChild());
        ticketsTemp.add(in.nextInt());
        System.out.printf("Senior %d: ", movie.getTicketPrice().getSenior());
        ticketsTemp.add(in.nextInt());

        return ticketsTemp;
    }

    static ArrayList<Integer> seatSelection(Scanner in, TimeSeat timeSeat, int tickets) {
        int no = 0;
        ArrayList<Integer> seatsTemp = new ArrayList<Integer>();
        System.out.printf("%n");
        System.out.printf("[ - SCREEN - ]%n");
        System.out.printf("%n");
        for (Boolean seat : timeSeat.getSeats()) {
            no++;
            if (no % 4 == 0) {
                System.out.printf("%n" +
                                  "%n");
            }
            if (seat) {
                System.out.printf("[%d]  ", no);
            } else {
                System.out.printf("[X]  ");
            }
        }
        System.out.printf("%n");
        System.out.printf("%n");
        System.out.printf("Select seat [1-%d]: ", no);
        System.out.printf("%n");
        for (int i = 0; i < tickets; i++) {
            System.out.printf("- Seat %d: ", i + 1);
            seatsTemp.add(in.nextInt() - 1);
        }
        for (Integer seat : seatsTemp) {
            timeSeat.setSeat(seat, false);
        }

        return seatsTemp;
    }

    static void foodSelection(Scanner in, ArrayList<Food> foodsTemp, ArrayList<Integer> foodQuantityTemp) {
        int no = 0;
        System.out.printf("%n");
        System.out.printf("Add snack:%n");
        for (Food food : foods) {
            no++;
            System.out.printf("[%d] %s(%s)%n", no, food.getName(), food.getSize());
        }
        no++;
        System.out.printf("[%d] Skip%n", no);
        System.out.printf("%n");
        System.out.printf("Select option [1-%d]: ", no);
        int i = in.nextInt() - 1;
        while (i < foods.size()) {
            foodsTemp.add(foods.get(i));
            System.out.printf("Quantity for %s(%s): ", foods.get(i).getName(), foods.get(i).getSize());
            foodQuantityTemp.add(in.nextInt());
            System.out.printf("%n");
            System.out.printf("Add another snack?: ");
            i = in.nextInt() - 1;
        }
    }

    static void viewTicketSaleHistory() {
        System.out.printf("%n");
        System.out.printf("printed from viewTicketSaleHistory%n");

        int no = 0;
        System.out.printf("Ticket Sale History%n");
        for (Sale sale : sales) {
            no++;
            System.out.printf("%n" +
                              "Sale [%d]%n" +
                              "Customer Name: %s%n" +
                              "Movie: %s%n" +
                              "Movie Time: %tR%n" +
                              "Hall: %s%n" +
                              "Ticket: %n" +
                              "- Adult: %d Child: %d Senior: %d%n",
                              no, sale.getCustomerName(), sale.getMovie(),
                              sale.getMovieTime(), sale.getHall(), sale.getTickets().get(0),
                              sale.getTickets().get(1), sale.getTickets().get(2));
            System.out.printf("Seat: ");
            for (int i = 0; i < sale.getSeats().size(); i++) { // print seat
                System.out.printf("%d ", sale.getSeats().get(i) + 1);
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
