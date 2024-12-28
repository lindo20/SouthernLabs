/**
 * Represents a real estate agency that manages rental properties.
 *
 * @author Lindokuhle Dubazane
 *
 * @version 1.0
 */
import java.util.HashMap;
import java.util.Map;

public class Agency
{
    private final String agencyName;
    private final Map<Integer, Rental> rentals;

    /**
     * Constructs an Agency with the specified name.
     *
     * @param agencyName the name of the agency
     */
    public Agency(final String agencyName)
    {
        this.agencyName = agencyName;
        this.rentals = new HashMap<>();
    }

    /**
     * Adds a Rental object to the agency's collection of rentals.
     *
     * @param rental the Rental object to add
     * @throws IllegalArgumentException if a rental with the same unit number already exists
     */
    public void addRental(final Rental rental)
    {
        if(rentals.containsKey(rental.getUnitNumber()))
        {
            throw new IllegalArgumentException("A rental with this unit number already exists in the agency.");
        }
        rentals.put(rental.getUnitNumber(), rental);
    }

    /**
     * Returns a HashMap of rentals with rentalPriceUsd between minUsd and maxUsd.
     *
     * @param minUsd the minimum rental price
     * @param maxUsd the maximum rental price
     * @return a HashMap of Rental objects within the specified price range
     */
    public HashMap<Integer, Rental> getRentalsBetween(final double minUsd, final double maxUsd)
    {
        final HashMap<Integer, Rental> result = new HashMap<>();

        for(Map.Entry<Integer, Rental> entry : rentals.entrySet())
        {
            final Rental rental = entry.getValue();

            if(rental.getRentalPriceUsd() >= minUsd && rental.getRentalPriceUsd() <= maxUsd)
            {
                result.put(entry.getKey(), rental);
            }
        }
        return result;
    }

    /**
     * Calculates the total income from all rentals based on rentalPriceUsd and leaseLengthMonths.
     *
     * @return the total rental income
     */
    public double getTotalRentalIncome()
    {
        double totalIncome = 0;
        for(final Rental rental : rentals.values())
        {
            totalIncome += rental.getRentalPriceUsd() * rental.getLeaseLengthMonths();
        }
        return totalIncome;
    }

    /**
     * Returns the name of the agency.
     *
     * @return the agency name
     */
    public String getAgencyName()
    {
        return agencyName.toLowerCase();
    }
}
