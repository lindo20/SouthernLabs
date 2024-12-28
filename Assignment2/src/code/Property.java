/**
 * Represents a property with details such as unit number, address, and number of bedrooms.
 *
 * @author Lindokuhle Dubazane
 * @version 1.0
 */
public class Property
{
    private final int unitNumber;
    private final int numberBedroomBooked;
    private final String address;
    private final String city;

    /**
     * Constructs a Property with the specified details.
     *
     * @param unitNumber the unit number of the property
     * @param numberBedroomBooked the number of bedrooms booked
     * @param address the address of the property
     * @param city the city where the property is located
     */
    public Property(final int unitNumber,
                    final int numberBedroomBooked,
                    final String address,
                    final String city)
    {
        this.unitNumber = unitNumber;
        this.numberBedroomBooked = numberBedroomBooked;
        this.address = address;
        this.city = city;
    }

    /**
     * Returns the unit number of the property.
     *
     * @return the unit number
     */
    public int getUnitNumber()
    {
        return unitNumber;
    }

    /**
     * Returns the number of bedrooms booked for the property.
     *
     * @return the number of bedrooms booked
     */
    public int getNumberBedroomBooked()
    {
        return numberBedroomBooked;
    }

    /**
     * Returns the address of the property in lowercase.
     *
     * @return the address
     */
    public String getAddress()
    {
        return address.toLowerCase();
    }

    /**
     * Returns the city where the property is located in lowercase.
     *
     * @return the city
     */
    public String getCity()
    {
        return city.toLowerCase();
    }
}
