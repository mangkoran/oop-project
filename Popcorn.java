public class Popcorn extends Food {
    private String flavour;
    private char size;

    public Popcorn(String name, String flavour, char size, int price) {
        super(name, price);
        this.flavour = flavour;
        this.size = size;
    }

    public String description() {
        return "Corn kernel which expands and puffs up when heated, comes in different flavours.";
    }

    public String getFlavour() {
        return flavour;
    }

    public char getSize() {
        return size;
    }
}
