import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import food.Food;
import food.Fries;
import food.Popcorn;
import food.Water;
import movie.AgeRating;
import movie.Movie;
import movie.TicketPrice;
import movie.TimeSeat;

public class TheaterTicketSystem implements LocationDate {
    static ArrayList<Theater> theaters = new ArrayList<Theater>();
    static ArrayList<Food> foods = new ArrayList<Food>();
    static ArrayList<Sale> sales = new ArrayList<Sale>();

    public static void main(String[] args) {
        foods.add(new Water("DASANI", 'M', 2));
        foods.add(new Fries("Curly Fries", 'L', 5));
        foods.add(new Popcorn("PopSecret Butter", 'L', 10));
        //INPUT FILE
        try {
            ArrayList<Movie> movies = new ArrayList<Movie>();
            Scanner in = new Scanner(new File("input.txt"));
            in.useDelimiter("[,\\n]");
            while (in.hasNext()) {
                String title = in.next();
                int runningTime = in.nextInt();
                AgeRating ageRating = AgeRating.valueOf(in.next());
                Calendar releaseDate = Calendar.getInstance();
                releaseDate.set(Calendar.MONTH, in.nextInt() - 1);
                releaseDate.set(Calendar.DATE, in.nextInt());
                releaseDate.set(Calendar.YEAR, in.nextInt());
                TicketPrice ticketPrice = new TicketPrice(in.nextInt(), in.nextInt(), in.nextInt());
                ArrayList<TimeSeat> timeSeats = new ArrayList<TimeSeat>();
                Boolean loop = true;
                int timeSeatCount = 0;
                while (loop) {
                    timeSeatCount++;
                    String hall = in.next();
                    Calendar time = Calendar.getInstance();
                    time.set(Calendar.HOUR_OF_DAY, in.nextInt());
                    time.set(Calendar.MINUTE, in.nextInt());
                    ArrayList<Boolean> seats = new ArrayList<Boolean>();
                    int seat = in.nextInt();
                    for (int i = 0; i < seat; i++) {
                        seats.add(true);
                    }
                    timeSeats.add(new TimeSeat(hall, time, seats));
                    if (in.hasNext("[;]")) {
                        in.skip("[,][;]");
                        loop = false;
                    }
                }
                Movie movie = new Movie(title, runningTime, ageRating, releaseDate, ticketPrice, timeSeats);
                movies.add(movie);
            }
            theaters.add(new Theater("MoistCinema", movies));
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        // INPUT FILE END
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
                                      "Error!%n");
                    System.out.printf("Insert Y to continue: ");
                    in.next();
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
                          "[3] Quit%n" +
                          "%n" +
                          "Select option [1-3]: ",
                          location, dateTime, dateTime, dateTime);

        return in.nextInt();
    }

    static void newTicketSale(Scanner in) {
        System.out.printf("%n");
        System.out.printf("Enter customer name: ");
        String customerName = in.next();
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
                    System.out.printf("Error!%n");
                    System.out.printf("Insert Y to continue: ");
                    in.next();
                    selectedMovie = movieSelection(in, moviesTemp);
                }
            } else if (selectedMovie == moviesTemp.size()) {
                loop = false;
            } else {
                System.out.printf("Error!%n");
                System.out.printf("Insert Y to continue: ");
                in.next();
                selectedMovie = movieSelection(in, moviesTemp);
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
                    System.out.printf("Insert Y to continue: ");
                    in.next();
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
                    System.out.printf("Insert Y to continue: ");
                    in.next();
                    ticketsTemp = ticketSelection(in, movieTemp, timeSeatTemp, priceTemp);
                }
            }
            ArrayList<Integer> seatsTemp = seatSelection(in, timeSeatTemp, ticketTotalTemp);
            ArrayList<Food> foodsTemp = new ArrayList<Food>();
            ArrayList<Integer> foodQuantityTemp = new ArrayList<Integer>();
            foodSelection(in, foodsTemp, foodQuantityTemp, priceTemp);
            sales.add(new Sale(priceTemp, timeSeatTemp.getHall(), movieTemp.getTitle(),
                            customerName, timeSeatTemp.getTime(), foodsTemp,
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
        System.out.printf("- $%d Adult: ", movie.getTicketPrice().getAdult());
        int adult = in.nextInt();
        ticketPriceTemp += adult * movie.getTicketPrice().getAdult();
        ticketsTemp.add(adult);
        System.out.printf("- $%d Child: ", movie.getTicketPrice().getChild());
        int child = in.nextInt();
        ticketPriceTemp += child * movie.getTicketPrice().getChild();
        ticketsTemp.add(child);
        System.out.printf("- $%d Senior: ", movie.getTicketPrice().getSenior());
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
            if (no % 3 == 0 && no != timeSeat.getSeats().size()) {
                if (seat) {
                    System.out.printf("[%d]  ", no);
                } else {
                    System.out.printf("[X]  ");
                }
                System.out.printf("%n" +
                                  "%n");
            } else if (seat) {
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
                System.out.printf("Insert Y to continue: ");
                in.next();
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
            System.out.printf("[%d] $%d %s(%s)%n" +
                              "     %s%n", no, food.getPrice(), food.getName(), food.getSize(), food.description());
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
        int no = 0;
        System.out.printf("Ticket Sale History%n");
        for (Sale sale : sales) {
            no++;
            System.out.printf("%n" +
                              "Sale [%d]%n" +
                              "Customer name: %s%n" +
                              "Movie: %s%n" +
                              "Movie time: %tR%n" +
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
            System.out.printf("Total price: $%d%n", sale.getPrice()[0]);
        }
    }
}

interface LocationDate {
    String location = "Johor, Malaysia";
    Calendar dateTime = Calendar.getInstance();
}
