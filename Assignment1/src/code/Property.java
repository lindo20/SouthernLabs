/**
 * This class represents a property with attributes such as price, address, number of bedrooms,
 * property type, property ID, and whether it has a swimming pool.
 *
 * @author Rethabile Sitole
 * @version 1.0
 *
 */
class Property
{
    private static final int MAX_NUM_BEDROOMS = 20;
    private static final int MAX_PROPERTY_ID_LENGTH = 6;
    private double price;
    private final Address address;
    private final int numBedrooms;
    private final String propertyType;
    private final String propertyId;
    private boolean swimmingPool;

    /**
     * Constructs a Property instance with specified attributes.
     *
     * @param price         the price of the property, must be greater than zero.
     * @param address       the address of the property, must not be null.
     * @param numBedrooms   the number of bedrooms, must be between 1 and MAX_NUM_BEDROOMS.
     * @param swimmingPool  true if the property has a swimming pool, false otherwise.
     * @param propertyType  the type of property (residence, commercial, or retail), must not be null.
     * @param propertyId    the unique identifier for the property, must not be null or empty, and must have a length not greater than MAX_PROPERTY_ID_LENGTH.
     * @throws IllegalArgumentException if price is less than or equal to zero,
     *                                  number of bedrooms is out of range,
     *                                  or the property type is invalid.
     * @throws NullPointerException if address or property type is null.
     */
    public Property(final double price,
                    final Address address,
                    final int numBedrooms,
                    final boolean swimmingPool,
                    final String propertyType,
                    final String propertyId)
    {

        this.price = validatePrice(price);
        this.address = validateNotNull(address, "address");
        this.numBedrooms = validateBedrooms(numBedrooms);
        this.propertyType = validatePropertyType(propertyType);
        this.propertyId = validatePropertyId(propertyId);
        this.swimmingPool = swimmingPool;
    }

    private double validatePrice(final double price)
    {
        if(price <= 0)
        {
            throw new IllegalArgumentException("Invalid price: " + price);
        }
        return price;
    }

    public Address validateNotNull(final Address address,
                                   final String attributeName)
    {
        if(address == null)
        {
            throw new NullPointerException("Invalid " + attributeName + ": null");
        }
        return address;
    }

    public int validateBedrooms(final int numBedrooms)
    {
        if(numBedrooms < 1 || numBedrooms > MAX_NUM_BEDROOMS)
        {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numBedrooms);
        }
        return numBedrooms;
    }

    public String validatePropertyType(final String propertyType)
    {
        if(propertyType == null)
        {
            throw new NullPointerException("Invalid property type: null");
        }
        if(!propertyType.equalsIgnoreCase("residence") &&
                !propertyType.equalsIgnoreCase("commercial") &&
                !propertyType.equalsIgnoreCase("retail")) {
            throw new IllegalArgumentException("Invalid property type: " + propertyType);
        }
        return propertyType;
    }

    public String validatePropertyId(final String propertyId)
    {
        if(propertyId == null)
        {
            throw new NullPointerException("Invalid property id: null");
        }
        if(propertyId.isEmpty() || propertyId.length() > MAX_PROPERTY_ID_LENGTH)
        {
            throw new IllegalArgumentException("Invalid property id: " + propertyId);
        }
        return propertyId;
    }

    public double getPrice()
    {
        return price;
    }

    public Address getAddress()
    {
        return address;
    }

    public int getNumberOfBedrooms()
    {
        return numBedrooms;
    }

    public String getType()
    {
        return propertyType;
    }

    public String getPropertyId()
    {
        return propertyId;
    }

    public boolean hasSwimmingPool()
    {
        return swimmingPool;
    }

    public void setSwimmingPool(final boolean swimmingPool)
    {
        this.swimmingPool = swimmingPool;
    }

    public void setPriceUsd(final double price)
    {
        this.price = validatePrice(price);
    }

    public double getPriceUsd()
    {
        return this.price;
    }
}
