/**
 * Main class that represents the entry point for the rental management application.
 * It initializes a RentalManager to manage rental properties and loads data from a file.
 * The application then displays a menu for user interaction.
 *
 * @author Lindokuhle Dubazane
 *
 * @version 1.0
 *
 */
class Main
{

    public static void main(final String[] args)
    {

        final RentalManager manager;
        manager = new RentalManager("Rental Agency");

        manager.loadRentalsFromFile("rentals.txt");

        manager.displayMenu();
    }
}
