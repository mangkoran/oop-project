import java.time.LocalDate;
import java.util.ArrayList;

public class Movie {
    private String title;
    private LocalDate releaseDate;
    private int runningTime;
    private AgeRating ageRating;
    private TicketPrice ticketPrice;
    private ArrayList<TimeSeat> timeSeats;

    public Movie(String title, int runningTime, AgeRating ageRating, LocalDate releaseDate, ArrayList<TimeSeat> timeSeats,
            TicketPrice ticketPrice) {
        this.title = title;
        this.runningTime = runningTime;
        this.ageRating = ageRating;
        this.releaseDate = releaseDate;
        this.timeSeats = timeSeats;
        this.ticketPrice = ticketPrice;
    }

    public void printTime() {

    }

    public void printTicket() {

    }

    public void printSeat() {

    }
}
