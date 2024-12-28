/**
 * This class represents a physical address with components such as unit number, street number,
 * street name, postal code, and city.
 *
 * @author Rethabile Sitole
 * @version 1.0
 *
 */
class Address
{
    private static final int maxUnitNumberLength = 4;
    private static final int maxStreetNumber = 999999;
    private static final int maxStreetNameLength = 20;
    private static final int minPostalCodeLength = 5;
    private static final int maxPostalCodeLength = 6;
    private static final int maxCityNameLength = 30;

    private final String unitNumber;
    private final int streetNumber;
    private final String streetName;
    private final String postalCode;
    private final String city;

    /**
     * Constructs an Address instance with specified components.
     *
     * @param unitNumber   the unit number of the address, may be null; if provided,
     *                     it must not be empty and its length must not exceed maxUnitNumberLength.
     * @param streetNumber  the street number, must be between 1 and maxStreetNumber.
     * @param streetName    the name of the street, must not be null,
     *                      not empty, and must not exceed maxStreetNameLength.
     * @param postalCode    the postal code, must not be null and must have a length
     *                      of either minPostalCodeLength or maxPostalCodeLength.
     * @param city          the name of the city, must not be null,
     *                      not empty, and must not exceed maxCityNameLength.
     * @throws IllegalArgumentException if unit number is invalid, street number is out of range,
     *                                  street name is invalid, postal code is invalid,
     *                                  or city name is invalid.
     * @throws NullPointerException if street name, postal code, or city is null.
     */
    public Address(final String unitNumber,
                   final int streetNumber,
                   final String streetName,
                   final String postalCode,
                   final String city)
    {
        if(unitNumber != null)
        {
            if (unitNumber.isEmpty() || unitNumber.length() > maxUnitNumberLength)
            {
                throw new IllegalArgumentException("Invalid unit number: " + unitNumber);
            }
            this.unitNumber = unitNumber;
        }
        else
        {
            this.unitNumber = null;
        }

        if(streetNumber < 1 || streetNumber > maxStreetNumber)
        {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        }
        this.streetNumber = streetNumber;


        if(streetName == null)
        {
            throw new NullPointerException("Invalid street name: null");
        }
        if(streetName.isEmpty() || streetName.length() > maxStreetNameLength)
        {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        }
        this.streetName = streetName;


        if(postalCode == null)
        {
            throw new NullPointerException("Invalid postal code: null");
        }
        if(postalCode.length() != minPostalCodeLength && postalCode.length() != maxPostalCodeLength)
        {
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);
        }
        this.postalCode = postalCode;


        if(city == null)
        {
            throw new NullPointerException("Invalid city: null");
        }
        if(city.isEmpty() || city.length() > maxCityNameLength)
        {
            throw new IllegalArgumentException("Invalid city: " + city);
        }
        this.city = city;
    }

    /**
     * Returns the unit number of the address.
     *
     * @return the unit number, or null if not specified.
     */
    public String getUnitNumber()
    {
        return unitNumber;
    }

    /**
     * Returns the street number of the address.
     *
     * @return the street number.
     */
    public int getStreetNumber()
    {
        return streetNumber;
    }

    /**
     * Returns the street name of the address.
     *
     * @return the street name.
     */
    public String getStreetName()
    {
        return streetName;
    }

    /**
     * Returns the postal code of the address.
     *
     * @return the postal code.
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /**
     * Returns the city of the address.
     *
     * @return the city name.
     */
    public String getCity()
    {
        return city;
    }
}
