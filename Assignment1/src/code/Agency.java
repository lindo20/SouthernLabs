import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * This Class represents a real estate agency that manages properties.
 * @author Rethabile Sitole
 * @version 1.0
 */
class Agency
{
    private static final int MAX_NAME_LENGTH = 30;
    private static final double INITIAL_VALUE = 0.0;
    private static final String ERROR_NULL_NAME = "Null agency name: ";
    private static final String ERROR_INVALID_NAME = "Invalid agency name: ";

    private final String name;
    private final Map<String, Property> properties;

    /**
     * Constructs an Agency with the specified name.
     *
     * @param name The name of the agency.
     * @throws IllegalArgumentException If the name is null or invalid.
     */
    public Agency(final String name)
    {
        if(name == null)
        {
            throw new IllegalArgumentException(ERROR_NULL_NAME);
        }
        if(name.isEmpty() || name.length() > MAX_NAME_LENGTH)
        {
            throw new IllegalArgumentException(ERROR_INVALID_NAME + name);
        }
        this.name = name;
        this.properties = new HashMap<>();
    }

    public String getName()
    {
        return name;
    }

    public void addProperty(final Property property)
    {
        if (property == null)
        {
            throw new NullPointerException("Cannot add null property");
        }
        properties.put(property.getPropertyId(), property);
        System.out.println("Adding property: " + property.getPropertyId());
    }

    public void removeProperty(final String propertyId)
    {
        properties.remove(propertyId);
    }

    public Property getProperty(final String propertyId)
    {
        return properties.get(propertyId);
    }

    public double getTotalPropertyValues()
    {
        double totalValue = INITIAL_VALUE;
        for(final Property property : properties.values())
        {
            totalValue += property.getPrice();
        }
        return totalValue;
    }

    public ArrayList<Property> getPropertiesWithPools()
    {
        ArrayList<Property> propertiesWithPools;
        propertiesWithPools= new ArrayList<>();

        for(final Property property : properties.values())
        {
            if (property.hasSwimmingPool())
            {
                propertiesWithPools.add(property);
            }
        }
        return propertiesWithPools;
    }

    public Property[] getPropertiesBetween(final double minUsd, final double maxUsd)
    {
        ArrayList<Property> matchingProperties;
        matchingProperties = new ArrayList<>();

        for(final Property property : properties.values())
        {
            double price = property.getPrice();
            if(price >= minUsd && price <= maxUsd)
            {
                matchingProperties.add(property);
            }
        }
        return matchingProperties.toArray(new Property[0]);
    }

    public ArrayList<Address> getPropertiesOn(final String streetName)
    {
        ArrayList<Address> matchingAddresses;
        matchingAddresses = new ArrayList<>();

        for (final Property property : properties.values())
        {
            if (property.getAddress().getStreetName().equalsIgnoreCase(streetName))
            {
                matchingAddresses.add(property.getAddress());
            }
        }
        return matchingAddresses.isEmpty() ? null : matchingAddresses;
    }

    public HashMap<String, Property> getPropertiesWithBedrooms(final int minBedrooms,
                                                               final int maxBedrooms)
    {
        HashMap<String, Property> matchingProperties;
        matchingProperties = new HashMap<>();

        for (final Property property : properties.values())
        {
            int numBedrooms = property.getNumberOfBedrooms();
            if (numBedrooms >= minBedrooms && numBedrooms <= maxBedrooms)
            {
                matchingProperties.put(property.getPropertyId(), property);
            }
        }
        return matchingProperties.isEmpty() ? null : matchingProperties;
    }

    public String titleCase(final String string)
    {
        StringBuilder titleCaseString;
        titleCaseString = new StringBuilder();

        String[] words = string.split(" ");
        for(final String word : words)
        {
            if(!word.isEmpty())
            {
                titleCaseString.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return titleCaseString.toString().trim();
    }

    public ArrayList<String> getPropertiesOfType(final String propertyType)
    {
        ArrayList<String> propertiesOfType;
        propertiesOfType = new ArrayList<>();

        propertiesOfType.add(String.format("Type: %s\n", propertyType.toUpperCase()));

        int i = 1;

        for(final Property property : properties.values())
        {
            if(property.getType().equalsIgnoreCase(propertyType))
            {
                StringBuilder propertyDetails = new StringBuilder(String.format("%d) Property %s: ", i++, property.getPropertyId()));
                Address address = property.getAddress();

                if(address.getUnitNumber() != null)
                {
                    propertyDetails.append("unit #").append(address.getUnitNumber()).append(" at ");
                }

                propertyDetails.append(String.format("%d %s %s in %s (",
                        address.getStreetNumber(),
                        titleCase(address.getStreetName()),
                        address.getPostalCode().toUpperCase(),
                        titleCase(address.getCity())));

                propertyDetails.append(property.getNumberOfBedrooms() == 1 ? "1 bedroom" : property.getNumberOfBedrooms() + " bedrooms");

                if(property.hasSwimmingPool())
                {
                    propertyDetails.append(" plus pool");
                }

                propertyDetails.append(String.format("): $%.0f.\n", property.getPriceUsd()));
                propertiesOfType.add(propertyDetails.toString());
            }
        }

        if(propertiesOfType.size() == 1)
        {
            propertiesOfType.add("<none found>");
        }
        return propertiesOfType;
    }
}
