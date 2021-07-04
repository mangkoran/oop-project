import java.time.LocalTime;
import java.util.ArrayList;

import food.*;

public class Sale {
    private String hall;
    private String movie;
    private int tickets[];
    private LocalTime movieTime;
    private String customerName;
    private ArrayList<Food> foods;
    private ArrayList<Integer> seats;
    private ArrayList<Integer> foodQuantity;

    public Sale(String hall,
                String movie,
                int[] tickets,
                String customerName,
                LocalTime movieTime,
                ArrayList<Food> foods,
                ArrayList<Integer> seats,
                ArrayList<Integer> foodQuantity) {
        this.hall = hall;
        this.movie = movie;
        this.tickets = tickets;
        this.customerName = customerName;
        this.movieTime = movieTime;
        this.foods = foods;
        this.seats = seats;
        this.foodQuantity = foodQuantity;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Integer> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Integer> seats) {
        this.seats = seats;
    }

    public int[] getTickets() {
        return tickets;
    }

    public void setTickets(int[] tickets) {
        this.tickets = tickets;
    }

    public LocalTime getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(LocalTime movieTime) {
        this.movieTime = movieTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Integer> getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(ArrayList<Integer> foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
