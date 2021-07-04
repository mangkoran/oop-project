import java.util.ArrayList;
import java.util.Calendar;

import food.Food;

public class Sale {
    private String hall;
    private String movie;
    private int adultTicket;
    private int childTicket;
    private int seniorTicket;
    private Calendar movieTime;
    private String customerName;
    private ArrayList<Food> foods;
    private ArrayList<Integer> seats;
    private ArrayList<Integer> foodQuantity;

    public Sale(String hall,
                String movie,
                int adultTicket,
                int childTicket,
                int seniorTicket,
                String customerName,
                Calendar movieTime,
                ArrayList<Food> foods,
                ArrayList<Integer> seats,
                ArrayList<Integer> foodQuantity) {
        this.hall = hall;
        this.movie = movie;
        this.adultTicket = adultTicket;
        this.childTicket = childTicket;
        this.seniorTicket = seniorTicket;
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

    public int getAdultTicket() {
        return adultTicket;
    }

    public void setAdultTicket(int adultTicket) {
        this.adultTicket = adultTicket;
    }

    public int getChildTicket() {
        return childTicket;
    }

    public void setChildTicket(int childTicket) {
        this.childTicket = childTicket;
    }

    public int getSeniorTicket() {
        return seniorTicket;
    }

    public void setSeniorTicket(int seniorTicket) {
        this.seniorTicket = seniorTicket;
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

    public void printSale() {

    }
}
