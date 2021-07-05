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

    public Movie() {}

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }

    public ArrayList<TimeSeat> getTimeSeats() {
        return timeSeats;
    }

    public void setTimeSeats(ArrayList<TimeSeat> timeSeats) {
        this.timeSeats = timeSeats;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public TicketPrice getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(TicketPrice ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void printTime() {

    }

    public void printTicket() {

    }

    public void printSeat() {

    }
}
