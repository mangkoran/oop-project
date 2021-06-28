import java.util.ArrayList;

public class Seat {
    private ArrayList<Boolean> seat;

    public Seat(ArrayList<Boolean> seat) {
        this.seat = seat;
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
