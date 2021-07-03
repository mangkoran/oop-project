package movie;

import java.time.LocalTime;
import java.util.ArrayList;

public class TimeSeat {
    private String hall;
    private LocalTime time;
    private ArrayList<Boolean> seat;

    public TimeSeat(ArrayList<Boolean> seat, String hall, LocalTime time) {
        this.seat = seat;
        this.hall = hall;
        this.time = time;
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

    public ArrayList<Boolean> getSeat() {
        return seat;
    }

    public void setSeat(ArrayList<Boolean> seat) {
        this.seat = seat;
    }

    public Boolean getSeatStatus(int i) {
        return seat.get(i);
    }

    public void setSeatStatus(int i, Boolean b) {
        this.seat.set(i, b);
    }
}
