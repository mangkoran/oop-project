package movie;

import java.util.ArrayList;
import java.util.Calendar;

public class TimeSeat {
    private String hall;
    private Calendar time;
    private ArrayList<Boolean> seats;

    public TimeSeat(String hall, Calendar time, ArrayList<Boolean> seats) {
        this.hall = hall;
        this.time = time;
        this.seats = seats;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public ArrayList<Boolean> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Boolean> seats) {
        this.seats = seats;
    }

    public Boolean getSeat(int i) {
        return seats.get(i);
    }

    public void setSeat(int i, Boolean b) {
        this.seats.set(i, b);
    }
}
