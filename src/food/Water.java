package food;
public class Water extends Food {

    public Water(String name, char size, int price) {
        super(name, size, price);
    }

    public String description() {
        return "Get the most out of every day with the pure, crisp taste of DASANI water";
    }
}
