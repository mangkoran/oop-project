public class Water extends Food {
    private char size;

    public Water(String name, char size, int price) {
        super(name, price);
        this.size = size;
    }

    public String description() {
        return "Your usual mineral water.";
    }

    public char getSize() {
        return size;
    }
}
