package movie;

import java.util.ArrayList;
import java.util.Calendar;

public class Movie {
    private String title;
    private int runningTime;
    private AgeRating ageRating;
    private Calendar releaseDate;
    private TicketPrice ticketPrice;
    private ArrayList<TimeSeat> timeSeats;

    public Movie(String title,
                 int runningTime,
                 AgeRating ageRating,
                 Calendar releaseDate,
                 TicketPrice ticketPrice,
                 ArrayList<TimeSeat> timeSeats) {
        this.title = title;
        this.runningTime = runningTime;
        this.ageRating = ageRating;
        this.releaseDate = releaseDate;
        this.ticketPrice = ticketPrice;
        this.timeSeats = timeSeats;
    }

    public void printTime() {

    }

    public void printTicket() {

    }

    public void printSeat() {

    }
}
