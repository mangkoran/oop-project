package food;
public class Popcorn extends Food {

    public Popcorn(String name, char size, int price) {
        super(name, size, price);
    }

    public String description() {
        return "Premium jumbo size popcorn tastes like the movie theater butter flavor you love";
    }
}
