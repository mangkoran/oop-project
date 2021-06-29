public class Popcorn extends Food {
    private String flavour;

    public Popcorn(String name, String flavour, char size, int price) {
        super(name, size, price);
        this.flavour = flavour;
    }

    public String description() {
        return "Corn kernel which expands and puffs up when heated, comes in different flavours";
    }

    public String getFlavour() {
        return flavour;
    }
}
