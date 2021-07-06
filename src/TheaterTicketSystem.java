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
        int testPrice[] = { 727 };
        Sale testSale = new Sale(testPrice, "HALL", "MOVIE", "CUSTOMERNAME",
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
        Boolean loop = true;
        int[] priceTemp = { 0 };
        ArrayList<Movie> moviesTemp = new ArrayList<Movie>();
        int selectedMovie = movieSelection(in, moviesTemp);
        while (loop) {
            if (selectedMovie < moviesTemp.size()) {
                for (TimeSeat timeSeat : moviesTemp.get(selectedMovie).getTimeSeats()) {
                    for (Boolean seat : timeSeat.getSeats()) {
                        if (seat) {
                            loop = false;
                            break;
                        }
                    }
                    if (!loop) {
                        break;
                    }
                }
                if (loop) {
                    selectedMovie = movieSelection(in, moviesTemp);
                }
            } else {
                loop = false;
            }
        }
        if (selectedMovie < moviesTemp.size()) {
            loop = true;
            Movie movieTemp = moviesTemp.get(selectedMovie);
            TimeSeat timeSeatTemp = timeSelection(in, movieTemp);
            while (loop) {
                for (Boolean seat : timeSeatTemp.getSeats()) {
                    if (seat) {
                        loop = false;
                        break;
                    }
                }
                if (loop) {
                    System.out.printf("Error!%n");
                    timeSeatTemp = timeSelection(in, movieTemp);
                }
            }
            ArrayList<Integer> ticketsTemp = ticketSelection(in, movieTemp, timeSeatTemp, priceTemp);
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
                if (ticketTotalTemp <= availableSeat) {
                    loop = false;
                }
                if (loop) {
                    priceTemp[0] = 0;
                    System.out.printf("Error!%n");
                    ticketsTemp = ticketSelection(in, movieTemp, timeSeatTemp, priceTemp);
                }
            }
            ArrayList<Integer> seatsTemp = seatSelection(in, timeSeatTemp, ticketTotalTemp);
            ArrayList<Food> foodsTemp = new ArrayList<Food>();
            ArrayList<Integer> foodQuantityTemp = new ArrayList<Integer>();
            foodSelection(in, foodsTemp, foodQuantityTemp, priceTemp);
            sales.add(new Sale(priceTemp, timeSeatTemp.getHall(), movieTemp.getTitle(),
                            "CUSTOMERNAME", timeSeatTemp.getTime(), foodsTemp,
                            seatsTemp, ticketsTemp, foodQuantityTemp));
            summaryScreen();
        }
    }

    static int movieSelection(Scanner in, ArrayList<Movie> moviesTemp) {
        int no = 0;
        moviesTemp.clear();
        System.out.printf("%n");
        System.out.printf("Now playing:%n");
        for (Theater theater : theaters) {
            for (Movie movie : theater.getMovies()) {
                no++;
                int availableSeat = 0;
                for (TimeSeat timeSeat : movie.getTimeSeats()) {
                    for (Boolean seat : timeSeat.getSeats()) {
                        if (seat) {
                            availableSeat++;
                        }
                    }
                }
                moviesTemp.add(movie);
                if (availableSeat == 0) {
                    System.out.printf("[%d] SOLD OUT%n", no);
                } else {
                    System.out.printf("[%d] %s%n", no, movie.getTitle());
                }
            }
        }
        no++;
        System.out.printf("[%d] Quit%n", no);
        System.out.printf("%n");
        System.out.printf("Select movie [1-%d]: ", no);

        return in.nextInt() - 1;
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

    static ArrayList<Integer> ticketSelection(Scanner in, Movie movie, TimeSeat timeSeat, int[] priceTemp) {
        ArrayList<Integer> ticketsTemp = new ArrayList<Integer>();
        int ticketPriceTemp = 0;
        System.out.printf("%n");
        System.out.printf("Select ticket:%n");
        System.out.printf("Adult $%d: ", movie.getTicketPrice().getAdult());
        int adult = in.nextInt();
        ticketPriceTemp += adult * movie.getTicketPrice().getAdult();
        ticketsTemp.add(adult);
        System.out.printf("Child $%d: ", movie.getTicketPrice().getChild());
        int child = in.nextInt();
        ticketPriceTemp += child * movie.getTicketPrice().getChild();
        ticketsTemp.add(child);
        System.out.printf("Senior $%d: ", movie.getTicketPrice().getSenior());
        int senior = in.nextInt();
        ticketPriceTemp += senior * movie.getTicketPrice().getSenior();
        ticketsTemp.add(senior);
        System.out.printf("Ticket total price: %d%n", ticketPriceTemp);
        priceTemp[0] += ticketPriceTemp;

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
            int selectedSeat = in.nextInt() - 1;
            if (timeSeat.getSeat(selectedSeat)) {
                timeSeat.setSeat(selectedSeat, false);
                seatsTemp.add(selectedSeat);
            } else {
                i--;
                System.out.printf("Error!%n");
            }
        }

        return seatsTemp;
    }

    static void foodSelection(Scanner in, ArrayList<Food> foodsTemp, ArrayList<Integer> foodQuantityTemp,
                              int[] priceTemp) {
        int no = 0;
        int foodPriceTemp = 0;
        System.out.printf("%n");
        System.out.printf("Add snack:%n");
        for (Food food : foods) {
            no++;
            System.out.printf("[%d] %s(%s) $%d%n", no, food.getName(), food.getSize(), food.getPrice());
        }
        no++;
        System.out.printf("[%d] Skip%n", no);
        System.out.printf("%n");
        System.out.printf("Select option [1-%d]: ", no);
        int i = in.nextInt() - 1;
        while (i < foods.size()) {
            foodsTemp.add(foods.get(i));
            System.out.printf("Quantity for %s(%s): ", foods.get(i).getName(), foods.get(i).getSize());
            int foodQuantity = in.nextInt();
            foodQuantityTemp.add(foodQuantity);
            foodPriceTemp += foodQuantity * foods.get(i).getPrice();
            System.out.printf("%n");
            System.out.printf("Add another snack? [1-%d]: ", no);
            i = in.nextInt() - 1;
        }
        System.out.printf("Snack total price: %d%n", foodPriceTemp);
        priceTemp[0] += foodPriceTemp;
    }

    static void summaryScreen() {
        System.out.printf("%n");
            System.out.printf("%n" +
                              "Customer Name: %s%n" +
                              "Movie: %s%n" +
                              "Movie Time: %tR%n" +
                              "Hall: %s%n" +
                              "Ticket: %n" +
                              "- Adult: %d Child: %d Senior: %d%n",
                              sales.get(sales.size() - 1).getCustomerName(), sales.get(sales.size() - 1).getMovie(),
                              sales.get(sales.size() - 1).getMovieTime(), sales.get(sales.size() - 1).getHall(),
                              sales.get(sales.size() - 1).getTickets().get(0),
                              sales.get(sales.size() - 1).getTickets().get(1),
                              sales.get(sales.size() - 1).getTickets().get(2));
            System.out.printf("Seat: ");
            for (int i = 0; i < sales.get(sales.size() - 1).getSeats().size(); i++) { // print seat
                System.out.printf("%d ", sales.get(sales.size() - 1).getSeats().get(i) + 1);
            }
            System.out.printf("%n");
            System.out.printf("Food: %n");
            for (int i = 0; i < sales.get(sales.size() - 1).getFoods().size(); i++) { // print food with quantity
                System.out.printf("- %s(%s): %d%n", sales.get(sales.size() - 1).getFoods().get(i).getName(),
                                  sales.get(sales.size() - 1).getFoods().get(i).getSize(),
                                  sales.get(sales.size() - 1).getFoodQuantity().get(i));
            }
            System.out.printf("Price: %d%n", sales.get(sales.size() - 1).getPrice()[0]);
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
