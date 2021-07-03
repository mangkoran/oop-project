import java.time.LocalTime;
import java.util.ArrayList;

import food.*;

public class Sale {
    private String name;
    private String movie;
    private LocalTime time;
    private String hall;
    private int ticket[];
    private ArrayList<Integer> seats;
    private ArrayList<Food> foods;
    private ArrayList<Integer> foodQuantity;

    public Sale(String name, String hall, String movie, int[] ticket, LocalTime time, ArrayList<Food> foods,
            ArrayList<Integer> seats, ArrayList<Integer> foodQuantity) {
        this.name = name;
        this.hall = hall;
        this.movie = movie;
        this.ticket = ticket;
        this.time = time;
        this.foods = foods;
        this.seats = seats;
        this.foodQuantity = foodQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    public ArrayList<Integer> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Integer> seats) {
        this.seats = seats;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public int[] getTicket() {
        return ticket;
    }

    public void setTicket(int[] ticket) {
        this.ticket = ticket;
    }

    public ArrayList<Integer> getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(ArrayList<Integer> foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
