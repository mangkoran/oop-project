public class Fries extends Food {
    private char size;

    public Fries(String name, char size, int price) {
        super(name, price);
        this.size = size;
    }

    public String description() {
        return "Thinly sliced potatoes that are deep-fried till they're crisp on all sides and then sprinkled with salt";
    }

    public char getSize() {
        return size;
    }
}
