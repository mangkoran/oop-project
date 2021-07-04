package movie;

import java.time.LocalTime;
import java.util.ArrayList;

public class TimeSeat {
    private String hall;
    private LocalTime time;
    private ArrayList<Boolean> seats;

    public TimeSeat(String hall, LocalTime time, ArrayList<Boolean> seats) {
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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
