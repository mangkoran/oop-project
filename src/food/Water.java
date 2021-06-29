package src.food;
public class Water extends Food {

    public Water(String name, char size, int price) {
        super(name, size, price);
    }

    public String description() {
        return "Your usual mineral water";
    }
}
