import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import movie.*;

public class Test {
    public static void main(String[] args) {
        // ArrayList<Theater> theaters = new ArrayList<Theater>();
        // ArrayList<Movie> movies = new ArrayList<Movie>();
        // try {
        //     Scanner in = new Scanner(new File("input.txt"));
        //     in.useDelimiter("[,\\n]");
        //     // ArrayList<TimeSeat> timeSeats = new ArrayList<TimeSeat>();

        //     // while (in.hasNext()) {
        //     //     if (in.hasNext("[A]")) {
        //     //         in.skip("[,][A]");
        //     //         System.out.printf("regex found%n");
        //     //     }
        //     //     System.out.printf("%s ", in.next());
        //     // }
        //     int movieCount = 0;
        //     while (in.hasNext()) {
        //         movieCount++;
        //         System.out.printf("movie%d%n", movieCount);
        //         String title = in.next();
        //         System.out.printf("%s entered%n", title);
        //         int runningTime = in.nextInt();
        //         System.out.printf("%d entered%n", runningTime);
        //         AgeRating ageRating = AgeRating.valueOf(in.next());
        //         System.out.printf("%s entered%n", ageRating);
        //         Calendar releaseDate = Calendar.getInstance();
        //         releaseDate.set(Calendar.MONTH, in.nextInt() - 1);
        //         releaseDate.set(Calendar.DATE, in.nextInt());
        //         releaseDate.set(Calendar.YEAR, in.nextInt());
        //         System.out.printf("%tD entered%n", releaseDate);
        //         TicketPrice ticketPrice = new TicketPrice(in.nextInt(), in.nextInt(), in.nextInt());
        //         System.out.printf("adult: %d child: %d senior: %d entered%n", ticketPrice.getAdult(),
        //                           ticketPrice.getChild(), ticketPrice.getSenior());
        //         ArrayList<TimeSeat> timeSeats = new ArrayList<TimeSeat>();
        //         Boolean loop = true;
        //         int timeSeatCount = 0;
        //         while (loop) {
        //             timeSeatCount++;
        //             System.out.printf("timeseat%d%n", timeSeatCount);
        //             String hall = in.next();
        //             System.out.printf("%s entered%n", hall);
        //             Calendar time = Calendar.getInstance();
        //             time.set(Calendar.HOUR_OF_DAY, in.nextInt());
        //             time.set(Calendar.MINUTE, in.nextInt());
        //             System.out.printf("%tR entered%n", time);
        //             ArrayList<Boolean> seats = new ArrayList<Boolean>();
        //             int seat = in.nextInt();
        //             for (int i = 0; i < seat; i++) {
        //                 seats.add(false);
        //                 System.out.printf("%s entered%n", seats.get(i));
        //             }
        //             timeSeats.add(new TimeSeat(hall, time, seats));
        //             if (in.hasNext("[;]")) {
        //                 in.skip("[,][;]");
        //                 loop = false;
        //             }
        //             System.out.printf("%n");
        //         }
        //         Movie movie = new Movie(title, runningTime, ageRating, releaseDate, ticketPrice, timeSeats);
        //         movies.add(movie);
        //         System.out.printf("movie added%n");
        //         System.out.printf("%n");
        //     }
        // } catch (Exception e) {
        //     System.out.println("Error " + e.getMessage());
        //     e.printStackTrace();
        // }
        Scanner in = new Scanner(System.in);
        System.out.printf("PRESS ENTER TO CONTINUE");
        in.next();
    }
}
