import java.util.ArrayList;
import java.util.Calendar;

import food.Food;

public class Sale {
    private int[] price;
    private String hall;
    private String movie;
    private Calendar movieTime;
    private String customerName;
    private ArrayList<Food> foods;
    private ArrayList<Integer> seats;
    private ArrayList<Integer> tickets;
    private ArrayList<Integer> foodQuantity;

    public Sale(int[] price,
                String hall,
                String movie,
                String customerName,
                Calendar movieTime,
                ArrayList<Food> foods,
                ArrayList<Integer> seats,
                ArrayList<Integer> tickets,
                ArrayList<Integer> foodQuantity) {
        this.price = price;
        this.hall = hall;
        this.movie = movie;
        this.customerName = customerName;
        this.movieTime = movieTime;
        this.foods = foods;
        this.seats = seats;
        this.tickets = tickets;
        this.foodQuantity = foodQuantity;
    }

    public int[] getPrice() {
        return price;
    }

    public void setPrice(int[] price) {
        this.price = price;
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

    public ArrayList<Integer> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Integer> tickets) {
        this.tickets = tickets;
    }

    public Calendar getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(Calendar movieTime) {
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
