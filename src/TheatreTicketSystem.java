import movie.*;

public class TheatreTicketSystem {
    public static void main(String[] args) {
        mainMenu();
    }

    static void mainMenu() {
        System.out.printf(
                          "Welcome to MoistCinema!%n" +
                          "%n" +
                          "Location: %n%n" +
                          "Date: %s%n" +
                          "%n" +
                          "Main Menu" +
                          "[1] New Ticket Sale" +
                          "[2] View Ticket Sale History" +
                          "%n" +
                          "Select option [1-2]: ",
                          "TEST", "TEST"
                          );
    }
}
