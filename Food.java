public abstract class Food {
    private String name;
    private int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract String description(); //abstract method

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
