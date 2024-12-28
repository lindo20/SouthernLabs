/**
 * Represents a rental property that extends the Property class, adding rental price and lease details.
 *
 * @author Lindokuhle Dubazane
 *
 * @version 1.0
 */
public class Rental extends Property
{
    private static final double INITIAL_RENTAL_PRICE_USD = 0;
    private static final int MINIMUM_LEASE_LENGTH_MONTH = 1;
    private static final int MAXIMUM_LEASE_LENGTH_MONTH = 60;
    private final double rentalPriceUsd;
    private final int leaseLengthMonths;

    /**
     * Constructs a Rental with the specified details.
     *
     * @param unitNumber the unit number of the rental
     * @param numberBedroomBooked the number of bedrooms booked
     * @param address the address of the rental
     * @param city the city where the rental is located
     * @param rentalPriceUsd the rental price in USD
     * @param leaseLengthMonths the lease duration in months
     * @throws IllegalArgumentException if rentalPriceUsd is invalid or leaseLengthMonths is out of range
     */
    public Rental(final int unitNumber,
                  final int numberBedroomBooked,
                  final String address,
                  final String city,
                  final double rentalPriceUsd,
                  final int leaseLengthMonths)
    {
        super(unitNumber, numberBedroomBooked, address, city);

        if(rentalPriceUsd < INITIAL_RENTAL_PRICE_USD)
        {
            throw new IllegalArgumentException("Invalid Rental price!!!");
        }
        this.rentalPriceUsd = rentalPriceUsd;

        if(leaseLengthMonths < MINIMUM_LEASE_LENGTH_MONTH ||
                leaseLengthMonths > MAXIMUM_LEASE_LENGTH_MONTH)
        {
            throw new IllegalArgumentException("Invalid Lease Argument!!!");
        }
        this.leaseLengthMonths = leaseLengthMonths;
    }

    /**
     * Returns the rental price in USD.
     *
     * @return the rental price
     */
    public double getRentalPriceUsd()
    {
        return rentalPriceUsd;
    }

    /**
     * Returns the lease length in months.
     *
     * @return the lease length
     */
    public int getLeaseLengthMonths()
    {
        return leaseLengthMonths;
    }

    /**
     * Returns a string representation of the rental details.
     *
     * @return a string representing the rental
     */
    @Override
    public String toString()
    {
        return "Rental{" +
                "rentalPriceUsd=" + rentalPriceUsd +
                ", leaseLengthMonths=" + leaseLengthMonths +
                '}';
    }
}
