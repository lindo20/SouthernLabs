/**
 * The RentalManager class manages the rental listings for an agency, allowing for rental data loading,
 * Providing a user interface for interacting with the rental data.
 * It offers the following functionality:
 * - Load rental data from a file.
 * - Display rentals within a specified price range.
 * - Show a menu for user interaction.
 *
 * @author Lindokuhle Dubazane
 *
 * @version 1.0
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

class RentalManager
{
    private static final int LEASE_DURATION_IN_MONTHS = 1;
    private static final double USER_INPUT_REQUIRED = -1.0;
    private final Agency agency;

    /**
     * Constructs a RentalManager with the specified agency name.
     *
     * @param agencyName the name of the agency
     */
    public RentalManager(final String agencyName)
    {
        agency = new Agency(agencyName);
    }

    /**
     * Loads rental data from a text file and adds rentals to the agency.
     * The file format is assumed to be:
     * rentalPriceUsd, unitNumber, address, city, postalCode, numberBedroomBooked, propertyType, unitCode
     *
     * @param filename the name of the text file containing rental data
     */
    public void loadRentalsFromFile(final String filename)
    {
        try(final Scanner s = new Scanner(new File(filename)))
        {
            while(s.hasNextLine())
            {
                final String line;
                line = s.nextLine();

                String[] data = line.split(", ");

                if(data.length == 8)
                {
                    try
                    {
                        double rentalPriceUsd = Double.parseDouble(data[0]);
                        int unitNumber = Integer.parseInt(data[1]);
                        String address = data[2];
                        String city = data[3];
                        String postalCode = data[4];
                        int numberBedroomBooked = Integer.parseInt(data[5]);
                        String propertyType = data[6];
                        String unitCode = data[7];

                        final Rental rental;
                        rental = new Rental(unitNumber, numberBedroomBooked, address, city, rentalPriceUsd, LEASE_DURATION_IN_MONTHS);

                        agency.addRental(rental);
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("Error parsing rental data: " + e.getMessage());
                    }
                }
                else
                {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Prompts the user for a price range and displays rentals within that range.
     * If the minimum or maximum price is not provided, the user will be prompted to enter the values.
     *
     * @param minUsd the minimum rental price (in USD)
     * @param maxUsd the maximum rental price (in USD)
     */
    public void displayRentalsByPriceRange(double minUsd, double maxUsd)
    {
        final Scanner s;
        s = new Scanner(System.in);

        if(minUsd == USER_INPUT_REQUIRED || maxUsd == USER_INPUT_REQUIRED)
        {
            System.out.print("Enter minimum rental price (USD): ");
            minUsd = s.nextDouble();

            System.out.print("Enter maximum rental price (USD): ");
            maxUsd = s.nextDouble();
        }

        final HashMap<Integer, Rental> rentals;
        rentals = agency.getRentalsBetween(minUsd, maxUsd);

        if(rentals.isEmpty())
        {
            System.out.println("No rentals found in the given price range.");
        }
        else
        {
            System.out.println("Rentals in price range " + minUsd + " - " + maxUsd + " USD:");

            for(final Rental rental : rentals.values())
            {
                System.out.println(rental);
            }
        }
    }

    /**
     * Displays a menu for the user to choose an action.
     * The user can select to display rentals by price range or exit the program.
     */
    public void displayMenu()
    {
        Scanner s;
        s = new Scanner(System.in);

        boolean exit = false;

        while (!exit)
        {
            System.out.println("\n--- Rental Management System ---");
            System.out.println("1. Display Rentals by Price Range");
            System.out.println("2. Exit");
            System.out.print("Please select an option (1 or 2): ");

            int choice = s.nextInt();

            if(choice == 1)
            {
                displayRentalsByPriceRange(USER_INPUT_REQUIRED, USER_INPUT_REQUIRED);
            }
            else if(choice == 2)
            {
                System.out.println("Exiting the program. Goodbye!");
                exit = true;
            }
            else
            {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
