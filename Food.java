public abstract class Food {
    private String name;
    private char size;
    private int price;

    public Food(String name, char size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public abstract String description(); //abstract method

    public String getName() {
        return name;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
