package src.food;
public class Fries extends Food {

    public Fries(String name, char size, int price) {
        super(name, size, price);
    }

    public String description() {
        return "Thinly sliced potatoes that are deep-fried till they're crisp on all sides and then sprinkled with salt";
    }
}
