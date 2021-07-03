package movie;

public class TicketPrice {
    private int adult;
    private int child;
    private int senior;

    public TicketPrice(int adult, int child, int senior) {
        this.adult = adult;
        this.child = child;
        this.senior = senior;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {
        this.senior = senior;
    }
}
